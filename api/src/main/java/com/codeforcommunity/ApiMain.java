package com.codeforcommunity;

import com.codeforcommunity.rest.ApiRouter;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory;

/** The main point for the API. */
public class ApiMain {
  private final ApiRouter apiRouter;

  public ApiMain(ApiRouter apiRouter) {
    this.apiRouter = apiRouter;
  }

  /** Start the API to start listening on a port. */
  public void startApi() {
    Vertx vertx = Vertx.vertx();
    HttpServer server = vertx.createHttpServer();

    OpenAPI3RouterFactory.create(
        vertx,
        "openapi/note-api.v1.yaml",
        ar -> {
          if (ar.succeeded()) {
            OpenAPI3RouterFactory routerFactory = ar.result(); // (1)
          } else {
            // Something went wrong during router factory initialization
            throw new IllegalStateException(ar.cause());
          }
        });

    Router router = Router.router(vertx);
    router.mountSubRouter("/api/v1", apiRouter.initializeRouter(vertx));

    server.requestHandler(router).listen(8081);
  }
}
