package com.codeforcommunity.rest;

import org.mockito.Mockito;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import io.vertx.core.http.HttpServerRequest;

import com.codeforcommunity.dto.auth.*;
import com.codeforcommunity.exceptions.*;

// Contains tests for RestFunctions.java in main
public class RestFunctionsTest {
    HttpServerRequest mockRequest = Mockito.mock(HttpServerRequest.class);
    RoutingContext mockRoutingContext = Mockito.mock(RoutingContext.class);

    // Test for empty JSON response
    @Test
    public void testGetJsonBodyAsClass1() {
        String emptyJSONString = "{}";
        JsonObject emptyJSONObject = new JsonObject(emptyJSONString);

        when(mockRoutingContext.getBodyAsJson())
        .thenReturn(emptyJSONObject);

        LoginRequest result = RestFunctions.getJsonBodyAsClass(mockRoutingContext, LoginRequest.class);

        assertEquals(result.getUsername(), null);
        assertEquals(result.getPassword(), null);
    }

    // Test for JSON response for login request
    @Test
    public void testGetJsonBodyAsClass2() {
        String loginRequestJSONString = "{\"username\":\"testdata\",\"password\":\"testdata\"}";
        JsonObject loginRequestJSONObject = new JsonObject(loginRequestJSONString);

        when(mockRoutingContext.getBodyAsJson())
        .thenReturn(loginRequestJSONObject);

        LoginRequest result = RestFunctions.getJsonBodyAsClass(mockRoutingContext, LoginRequest.class);

        assertEquals(result.getUsername(), "testdata");
        assertEquals(result.getPassword(), "testdata");
    }

    // Test for JSON response for new user request
    @Test
    public void testGetJsonBodyAsClass3() {
        String loginRequestJSONString = "{\"email\":\"brandon@example.com\","
        + "\"username\":\"username\",\"password\":\"password\","
        + "\"firstName\":\"brandon\",\"lastName\":\"liang\"}";
        JsonObject loginRequestJSONObject = new JsonObject(loginRequestJSONString);

        when(mockRoutingContext.getBodyAsJson())
        .thenReturn(loginRequestJSONObject);

        NewUserRequest result = RestFunctions.getJsonBodyAsClass(mockRoutingContext, NewUserRequest.class);

        assertEquals(result.getEmail(), "brandon@example.com");
        assertEquals(result.getUsername(), "username");
        assertEquals(result.getPassword(), "password");
        assertEquals(result.getFirstName(), "brandon");
        assertEquals(result.getLastName(), "liang");
    }

    // test request header for existence
    @Test
    public void testGetRequestHeader1() {
        String myVal = "test";
        
        when(mockRequest.getHeader(any()))
        .thenReturn(myVal);

        String result = RestFunctions.getRequestHeader(mockRequest, myVal);

        assertEquals(result, myVal);
    }

    // test request header for exception thrown
    @Test(expected = MissingHeaderException.class)
    public void testGetRequestHeader2() {
        String name = "name";

        when(mockRequest.getHeader(null))
        .thenReturn(name);

        when(RestFunctions.getRequestHeader(mockRequest, name))
        .thenThrow(new MissingHeaderException(name));
    }

    // test request parameter as int when given nat
    @Test
    public void testGetRequestParameterAsInt1() {
        String myInt = "200";
        
        when(mockRequest.getParam(any()))
        .thenReturn(myInt);

        int result = RestFunctions.getRequestParameterAsInt(mockRequest, myInt);

        assertEquals(result, 200);
    }

    // test request parameter as int when given negative int
    @Test
    public void testGetRequestParameterAsInt2() {
        String myInt = "-200";
        
        when(mockRequest.getParam(any()))
        .thenReturn(myInt);

        int result = RestFunctions.getRequestParameterAsInt(mockRequest, myInt);

        assertEquals(result, -200);
    }

    // test request parameter exception when given malformed int
    @Test(expected = MalformedParameterException.class)
    public void testGetRequestParameterAsInt3() {
        String myInt = "hello";
        
        when(mockRequest.getParam(any()))
        .thenReturn(myInt);

        when(RestFunctions.getRequestParameterAsInt(mockRequest, myInt))
        .thenThrow(new MissingHeaderException(myInt));
    }

    // test request parameter as string when given number
    @Test
    public void testGetRequestParameterAsString1() {
        String myInt = "200";
        
        when(mockRequest.getParam(any()))
        .thenReturn(myInt);

        String result = RestFunctions.getRequestParameterAsString(mockRequest, myInt);

        assertEquals(result, "200");
    }

    // test request parameter as string when given all letters
    @Test
    public void testGetRequestParameterAsString2() {
        String myString = "foobar";
        
        when(mockRequest.getParam(any()))
        .thenReturn(myString);

        String result = RestFunctions.getRequestParameterAsString(mockRequest, myString);

        assertEquals(result, myString);
    }

    // test request parameter exception when parameter is missing
    @Test(expected = MissingParameterException.class)
    public void testGetRequestParameterAsString3() {
        String name = "name";

        when(mockRequest.getParam(null))
        .thenReturn(name);

        when(RestFunctions.getRequestParameterAsString(mockRequest, name))
        .thenThrow(new MissingParameterException(name));
    }
}