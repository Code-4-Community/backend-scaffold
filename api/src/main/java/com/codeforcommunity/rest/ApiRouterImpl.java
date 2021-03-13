package com.codeforcommunity.rest;

import com.codeforcommunity.api.IAuthProcessor;
import com.codeforcommunity.api.IProtectedUserProcessor;
import com.codeforcommunity.auth.JWTAuthorizer;
import com.codeforcommunity.auth.enums.PrivilegeLevel;
import java.util.HashMap;
import java.util.Map;

public class ApiRouterImpl extends ApiRouter<PrivilegeLevel> {

  public ApiRouterImpl(
      IAuthProcessor authProcessor,
      IProtectedUserProcessor<PrivilegeLevel> protectedUserProcessor,
      JWTAuthorizer<PrivilegeLevel> jwtAuthorizer) {
    super(authProcessor, protectedUserProcessor, jwtAuthorizer);
  }

  @Override
  public Map<String, IRouter> createPublicSubRouters() {
    return new HashMap<>();
  }

  @Override
  public Map<String, IRouter> createProtectedSubRouters() {
    return new HashMap<>();
  }
}
