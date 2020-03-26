package com.codeforcommunity.rest;

import com.codeforcommunity.rest.subrouter.*;
import org.mockito.Mockito;

// contains examples objects for IRouter in main
public class IRouterTest {
    IRouter authRouter = Mockito.mock(AuthRouter.class);
    IRouter commonRouter = Mockito.mock(CommonRouter.class);
    IRouter notesRouter = Mockito.mock(NotesRouter.class);

    // TODO: figure out how to mock that one initializeRouter() method
}
