package com.codeforcommunity.processor;

import com.codeforcommunity.api.INotesProcessor;
import com.codeforcommunity.dto.CreateNoteRequest;
import com.codeforcommunity.exceptions.NoteAlreadyExistsException;
import org.jooq.DSLContext;
import org.jooq.generated.Tables;
import org.jooq.generated.tables.records.NotesRecord;

public class NotesProcessor implements INotesProcessor {
  private final DSLContext db;

  public NotesProcessor(DSLContext db) {
    this.db = db;
  }

  @Override
  public void createNote(CreateNoteRequest note, int userId) {
    if (db.fetchExists(db.selectFrom(Tables.NOTES).where(Tables.NOTES.TITLE.eq(note.getTitle())))) {
      throw new NoteAlreadyExistsException(note.getTitle());
    }

    NotesRecord rec = db.newRecord(Tables.NOTES);
    rec.setTitle(note.getTitle());
    rec.setBody(note.getBody());
    rec.setUserId(userId);
    rec.store();
  }
}
