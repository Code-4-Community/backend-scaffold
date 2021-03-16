package com.codeforcommunity.rest.subrouter;

import static com.codeforcommunity.rest.ApiRouter.end;

import com.codeforcommunity.api.INotesProcessor;
import com.codeforcommunity.auth.JWTData;
import com.codeforcommunity.auth.enums.PrivilegeLevel;
import com.codeforcommunity.dto.CreateNoteRequest;
import com.codeforcommunity.rest.IRouter;
import com.codeforcommunity.rest.RestFunctions;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class NotesRouter implements IRouter {
  private final INotesProcessor processor;

  public NotesRouter(INotesProcessor processor) {
    this.processor = processor;
  }

  @Override
  public Router initializeRouter(Vertx vertx) {
    Router router = Router.router(vertx);

    registerCreateNote(router);

    return router;
  }

  private void registerCreateNote(Router router) {
    Route createNoteRoute = router.post("/create");
    createNoteRoute.handler(this::handleCreateNote);
  }

  private void handleCreateNote(RoutingContext ctx) {
    CreateNoteRequest req = RestFunctions.getJsonBodyAsClass(ctx, CreateNoteRequest.class);
    JWTData<PrivilegeLevel> userData = ctx.get("jwt_data");

    processor.createNote(req, userData.getUserId());
    end(ctx.response(), 200, "Created");
  }
}
