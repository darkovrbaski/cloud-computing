package me.darkovrbaski.branchlibrary.exception;

import java.io.Serial;

public class EntityIntegrityViolationException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 5725881270673361229L;

  public EntityIntegrityViolationException(final String message) {
    super(message);
  }
}
