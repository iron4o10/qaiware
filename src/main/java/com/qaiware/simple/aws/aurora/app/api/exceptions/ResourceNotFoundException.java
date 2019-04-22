package com.qaiware.simple.aws.aurora.app.api.exceptions;

public class ResourceNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -211996424781008682L;

  public ResourceNotFoundException() {
    super();
  }

  public ResourceNotFoundException(String message) {
    super(message);
  }

}
