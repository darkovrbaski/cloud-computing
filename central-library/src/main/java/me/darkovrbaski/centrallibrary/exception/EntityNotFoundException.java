package me.darkovrbaski.centrallibrary.exception;

import java.io.Serial;

public class EntityNotFoundException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 2064734757895456264L;

  public EntityNotFoundException(final String message) {
    super(message);
  }

}
