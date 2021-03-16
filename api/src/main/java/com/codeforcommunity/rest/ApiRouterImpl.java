package com.codeforcommunity.rest;

import com.codeforcommunity.api.IAuthProcessor;
import com.codeforcommunity.api.INotesProcessor;
import com.codeforcommunity.api.IProtectedUserProcessor;
import com.codeforcommunity.auth.JWTAuthorizer;
import com.codeforcommunity.auth.enums.PrivilegeLevel;
import com.codeforcommunity.rest.subrouter.NotesRouter;
import java.util.HashMap;
import java.util.Map;

public class ApiRouterImpl extends ApiRouter<PrivilegeLevel> {
  private final INotesProcessor notesProcessor;

  public ApiRouterImpl(
      IAuthProcessor authProcessor,
      IProtectedUserProcessor<PrivilegeLevel> protectedUserProcessor,
      JWTAuthorizer<PrivilegeLevel> jwtAuthorizer,
      INotesProcessor notesProcessor) {
    super(authProcessor, protectedUserProcessor, jwtAuthorizer);
    this.notesProcessor = notesProcessor;
  }

  @Override
  public Map<String, IRouter> createPublicSubRouters() {
    return new HashMap<>();
  }

  @Override
  public Map<String, IRouter> createProtectedSubRouters() {
    Map<String, IRouter> routers = new HashMap<>();
    routers.put("/notes", new NotesRouter(notesProcessor));
    return routers;
  }
}
