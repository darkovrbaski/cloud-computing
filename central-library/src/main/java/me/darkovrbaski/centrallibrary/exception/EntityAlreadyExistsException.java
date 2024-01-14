package me.darkovrbaski.centrallibrary.exception;

import java.io.Serial;

public class EntityAlreadyExistsException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = -2407292233999304385L;

  public EntityAlreadyExistsException(final String message) {
    super(message);
  }

}
