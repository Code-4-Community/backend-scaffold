package com.codeforcommunity.test;

import com.codeforcommunity.rest.ApiRouter;

import java.lang.ProcessBuilder;
import java.io.File;
import java.util.Arrays;
import java.net.HttpURLConnection;
import java.io.IOException;

import io.vertx.core.Vertx;
import io.vertx.core.http.*;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.VertxOptions;
import io.vertx.core.json.*;

import io.vertx.ext.web.*;
import io.vertx.ext.unit.TestSuite;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.RoutingContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@RunWith(VertxUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class ApiRouterTest {
  Vertx vertx;
  HttpServer server;
  Router router;

  @Mock
  RoutingContext event;

  @Mock
  HttpServerRequest request;

  @Mock
  HttpServerResponse response;

  /*
  @Before
  // Do some initialization "before" we start running tests
  public void before(TestContext context) {
    vertx = Vertx.vertx();
    router = Router.router(vertx);
  }

  @After
  // Tear down resources used by vertx testing
  public void after(TestContext context) {
    // p.destroy();
    vertx.close(context.asyncAssertSuccess());
  }
  */

  @Test
  // Just as a sanity check with Vert.x unit testing
  public void testSomething(TestContext context) {
    context.assertFalse(false);
  }

  /*
  @Test
  public void testDefaultIndex() {
    HttpServerResponse res = mock(HttpServerResponse.class);
    // Gives a NullPointerException
    // Even though res isn't null...

    ApiRouter.end(res, 200, null);

    HttpServerRequest myHttpServerRequest = routingContext.request();
    HttpServerResponse myHttpServerResponse = myHttpServerRequest.response();

    ApiRouter.end(myHttpServerRequest.response(), 200);
    System.out.println(myHttpServerRequest.response().getStatusCode());

    RoutingContext routingContext = mock(RoutingContext.class);

    when(routingContext.normalisedPath()).thenReturn("/");
    Route currentRoute = mock(Route.class);
    when(currentRoute.getPath()).thenReturn("/");
    when(routingContext.currentRoute()).thenReturn(currentRoute);
  }
  */

  // INTEGRATION TESTS FOLLOW
  // PLEASE UNCOMMENT TO USE, BUT MAKE SURE YOU HAVE THE LIVE API RUNNING

  /*
  @Test
  // Are all the keys we want are returned in the JSON response?
  public void emptyTestParameters(TestContext context) {
    HttpClient client = vertx.createHttpClient();
    Async async = context.async();

    client.getNow(8081, "localhost", "/api/v1/notes", resp -> {
      resp.bodyHandler(body -> {
        JsonObject b = new JsonObject(body);
        context.assertEquals(resp.statusCode(), 200);

        context.assertEquals(b.containsKey("status"), true);
        context.assertEquals(b.containsKey("notes"), true);
        context.assertEquals(b.containsKey("not-here"), false);

        client.close();
        async.complete();
      });
    });
  }

  @Test
  // Are all the definitions we want are returned in the JSON response?
  public void emptyTest(TestContext context) {
    HttpClient client = vertx.createHttpClient();
    Async async = context.async();

    client.getNow(8081, "localhost", "/api/v1/notes", resp -> {
      resp.bodyHandler(body -> {
        JsonObject b = new JsonObject(body);

        context.assertEquals(b.getString("status"), "OK");
        context.assertEquals(b.getJsonArray("notes").size(), 0);

        client.close();
        async.complete();
      });
    });
  }
  */
}