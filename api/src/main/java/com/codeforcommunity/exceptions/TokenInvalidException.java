package com.codeforcommunity.exceptions;

import com.codeforcommunity.rest.FailureHandler;
import io.vertx.ext.web.RoutingContext;

/**
 * Used when either an access or refresh JWT token is invalid for any reason, including when it is
 * expired.
 */
public class TokenInvalidException extends HandledException {

  private String tokenType;

  public TokenInvalidException(String tokenType) {
    super();
    this.tokenType = tokenType;
  }

  public String getTokenType() {
    return tokenType;
  }

  @Override
  public void callHandler(FailureHandler handler, RoutingContext ctx) {
    handler.handleTokenInvalid(ctx, this);
  }
}
