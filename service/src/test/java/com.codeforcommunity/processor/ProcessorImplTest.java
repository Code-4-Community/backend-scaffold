package java.com.codeforcommunity.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codeforcommunity.processor.ProcessorImpl;
import java.com.codeforcommunity.JooqMock;
import org.jooq.generated.tables.records.NoteRecord;
import org.junit.jupiter.api.Test;

public class ProcessorImplTest {


  @Test
  public void testGetNoteStuff() {
    JooqMock mockDb = new JooqMock();
    ProcessorImpl p = new ProcessorImpl(mockDb.getContext());

    NoteRecord n = new NoteRecord();
    n.setBody("hello");
    n.setTitle("Yellow");

    mockDb.addReturn("SELECT", n);

    String val = p.getNoteStuff(n.getId());

    assertEquals("1223", val);

    assertEquals(2, mockDb.timeCalled("SELECT"));
    assertEquals(1, mockDb.timeCalled("INSERT"));
  }
}