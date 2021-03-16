package com.codeforcommunity.exceptions;

import com.codeforcommunity.rest.FailureHandler;
import io.vertx.ext.web.RoutingContext;

public class NoteAlreadyExistsException extends HandledException {
  private final String title;

  public NoteAlreadyExistsException(String title) {
    this.title = title;
  }

  @Override
  public void callHandler(FailureHandler failureHandler, RoutingContext routingContext) {
    failureHandler.end(routingContext, "Note with title " + title + " already exists", 400);
  }
}
