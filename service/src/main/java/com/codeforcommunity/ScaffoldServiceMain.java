package com.codeforcommunity;

import com.codeforcommunity.api.IAuthProcessor;
import com.codeforcommunity.api.IProtectedUserProcessor;
import com.codeforcommunity.auth.enums.IPrivilegeLevelFactory;
import com.codeforcommunity.auth.enums.PrivilegeLevel;
import com.codeforcommunity.dataaccess.AAuthDatabaseOperations;
import com.codeforcommunity.dataaccess.AuthDatabaseOperations;
import com.codeforcommunity.processor.NotesProcessor;
import com.codeforcommunity.rest.ApiRouter;
import com.codeforcommunity.rest.ApiRouterImpl;

public class ScaffoldServiceMain extends ServiceMain<PrivilegeLevel> {

  public static void main(String[] args) {
    try {
      ServiceMain<PrivilegeLevel> serviceMain = new ScaffoldServiceMain();
      serviceMain.initializeServer();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public ScaffoldServiceMain() throws ClassNotFoundException {
    super();
  }

  @Override
  protected String getDefaultProperties() {
    return "properties/server.properties";
  }

  @Override
  protected IPrivilegeLevelFactory<PrivilegeLevel> createPrivilegeLevelFactory() {
    return new PrivilegeLevel.Factory();
  }

  @Override
  protected AAuthDatabaseOperations<PrivilegeLevel> createAuthDBOps() {
    return new AuthDatabaseOperations(this.db);
  }

  @Override
  protected ApiRouter<PrivilegeLevel> initializeMainAndCreateApiRouter(
      IAuthProcessor iAuthProcessor,
      IProtectedUserProcessor<PrivilegeLevel> iProtectedUserProcessor) {
    NotesProcessor processor = new NotesProcessor(this.db);

    return new ApiRouterImpl(iAuthProcessor, iProtectedUserProcessor, jwtAuth, processor);
  }
}
