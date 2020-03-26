import org.mockito.Mockito;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.codeforcommunity.rest.RestFunctions;
import io.vertx.core.http.HttpServerRequest;

import com.codeforcommunity.dto.auth.LoginRequest;

public class RestFunctionsTest {
    /**
        static String getRequestHeader(HttpServerRequest req, String name) {
            String headerValue = req.getHeader(name);
            if (headerValue != null) {
            return headerValue;
            }
            throw new MissingHeaderException(name);
        } 
    */

    HttpServerRequest mockRequest = Mockito.mock(HttpServerRequest.class);
    RoutingContext mockRoutingContext = Mockito.mock(RoutingContext.class);

    // test request header for existence
    @Test
    public void testGetRequestHeader() {
        String myVal = "test";
        
        when(mockRequest.getHeader(any()))
        .thenReturn(myVal);

        String result = RestFunctions.getRequestHeader(mockRequest, myVal);

        assertEquals(result, myVal);
    }
    
    // TODO: test request header for exception thrown
    // ...

    /**
        static <T> T getJsonBodyAsClass(RoutingContext ctx, Class<T> clazz) {
            Optional<JsonObject> body = Optional.ofNullable(ctx.getBodyAsJson());
            if (body.isPresent()) {
                try {
                    return body.get().mapTo(clazz);
                } catch (IllegalArgumentException e) {
                    throw new RequestBodyMappingException();
                }
            } else {
                throw new RequestBodyMappingException();
            }
        }
     */
    
    // 
    @Test
    public void testGetJsonBodyAsClass() {
        String loginRequestJSONString = "{\"username\":\"testdata\",\"password\":\"testdata\"}";
        JsonObject loginRequestJSONObject = new JsonObject(loginRequestJSONString);

        when(mockRoutingContext.getBodyAsJson())
        .thenReturn(loginRequestJSONObject);

        LoginRequest result = RestFunctions.getJsonBodyAsClass(mockRoutingContext, LoginRequest.class);

        assertEquals(result.getUsername(), "testdata");
        assertEquals(result.getPassword(), "testdata");
    }
}