package com.codeforcommunity.rest;

import io.vertx.core.Vertx;
import io.vertx.core.http.*;
import io.vertx.ext.unit.junit.VertxUnitRunner;

import static org.junit.Assert.assertEquals;

import com.codeforcommunity.api.IAuthProcessor;
import com.codeforcommunity.api.INotesProcessor;
import com.codeforcommunity.auth.JWTAuthorizer;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.mock;

@RunWith(VertxUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class ApiRouterTest {
  INotesProcessor myINotesProcessor = mock(INotesProcessor.class);
  IAuthProcessor myIAuthProcessor = mock(IAuthProcessor.class);
  JWTAuthorizer myJWTAuthorizer = mock(JWTAuthorizer.class);

  @Test
  // example unit test for the main api router
  public void testApiRouter1() {
    ApiRouter router = new ApiRouter(myINotesProcessor, myIAuthProcessor, myJWTAuthorizer);
    Vertx vertx = Vertx.vertx();

    vertx.createHttpServer().requestHandler(router.initializeRouter(vertx)).listen(8080);

    HttpClient client = vertx.createHttpClient();

    HttpClientRequest requestNotes = client.get(8080, "localhost", "/api/v1/notes");

    requestNotes.handler(res -> {
      assertEquals(res.statusCode(), 200);
    });
  }

  /*
   * @Before // Do some initialization "before" we start running tests public void
   * before(TestContext context) { vertx = Vertx.vertx(); router =
   * Router.router(vertx); }
   * 
   * @After // Tear down resources used by vertx testing public void
   * after(TestContext context) { // p.destroy();
   * vertx.close(context.asyncAssertSuccess()); }
   * 
   * @Test public void testDefaultIndex() { HttpServerResponse res =
   * mock(HttpServerResponse.class); // Gives a NullPointerException // Even
   * though res isn't null...
   * 
   * ApiRouter.end(res, 200, null);
   * 
   * HttpServerRequest myHttpServerRequest = routingContext.request();
   * HttpServerResponse myHttpServerResponse = myHttpServerRequest.response();
   * 
   * ApiRouter.end(myHttpServerRequest.response(), 200);
   * System.out.println(myHttpServerRequest.response().getStatusCode());
   * 
   * RoutingContext routingContext = mock(RoutingContext.class);
   * 
   * when(routingContext.normalisedPath()).thenReturn("/"); Route currentRoute =
   * mock(Route.class); when(currentRoute.getPath()).thenReturn("/");
   * when(routingContext.currentRoute()).thenReturn(currentRoute); }
   */

  // INTEGRATION TESTS FOLLOW
  // PLEASE UNCOMMENT TO USE, BUT MAKE SURE YOU HAVE THE LIVE API RUNNING

  /*
   * @Test // Are all the keys we want are returned in the JSON response? public
   * void emptyTestParameters(TestContext context) { HttpClient client =
   * vertx.createHttpClient(); Async async = context.async();
   * 
   * client.getNow(8081, "localhost", "/api/v1/notes", resp -> {
   * resp.bodyHandler(body -> { JsonObject b = new JsonObject(body);
   * context.assertEquals(resp.statusCode(), 200);
   * 
   * context.assertEquals(b.containsKey("status"), true);
   * context.assertEquals(b.containsKey("notes"), true);
   * context.assertEquals(b.containsKey("not-here"), false);
   * 
   * client.close(); async.complete(); }); }); }
   * 
   * @Test // Are all the definitions we want are returned in the JSON response?
   * public void emptyTest(TestContext context) { HttpClient client =
   * vertx.createHttpClient(); Async async = context.async();
   * 
   * client.getNow(8081, "localhost", "/api/v1/notes", resp -> {
   * resp.bodyHandler(body -> { JsonObject b = new JsonObject(body);
   * 
   * context.assertEquals(b.getString("status"), "OK");
   * context.assertEquals(b.getJsonArray("notes").size(), 0);
   * 
   * client.close(); async.complete(); }); }); }
   */
}