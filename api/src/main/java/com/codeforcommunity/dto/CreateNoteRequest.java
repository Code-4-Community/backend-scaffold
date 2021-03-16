package com.codeforcommunity.dto;

import com.codeforcommunity.exceptions.HandledException;
import java.util.ArrayList;
import java.util.List;

public class CreateNoteRequest extends ApiDto {
  private String title;
  private String body;

  private CreateNoteRequest() {}

  public CreateNoteRequest(String title, String body) {
    this.title = title;
    this.body = body;
  }

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }

  @Override
  public List<String> validateFields(String s) throws HandledException {
    List<String> fields = new ArrayList<>();
    if (title == null) {
      fields.add(s + ".title");
    }
    if (body == null) {
      fields.add(s + ".body");
    }
    return fields;
  }
}
