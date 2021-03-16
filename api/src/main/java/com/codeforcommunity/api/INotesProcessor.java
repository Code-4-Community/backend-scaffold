package com.codeforcommunity.api;

import com.codeforcommunity.dto.CreateNoteRequest;

public interface INotesProcessor {

  void createNote(CreateNoteRequest note, int userId);
}
