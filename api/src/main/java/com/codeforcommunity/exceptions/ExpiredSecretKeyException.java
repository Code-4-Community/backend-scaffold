package com.codeforcommunity.exceptions;

import com.codeforcommunity.enums.VerificationKeyType;
import com.codeforcommunity.rest.FailureHandler;
import io.vertx.ext.web.RoutingContext;

/**
 * Secret keys are generated tokens used to verify user identity during email verification or
 * password reset
 */
public class ExpiredSecretKeyException extends HandledException {

  private final VerificationKeyType type;

  public ExpiredSecretKeyException(VerificationKeyType type) {
    super();
    this.type = type;
  }

  public VerificationKeyType getType() {
    return type;
  }

  @Override
  public void callHandler(FailureHandler handler, RoutingContext ctx) {
    handler.handleExpiredSecretKey(ctx, this);
  }
}
