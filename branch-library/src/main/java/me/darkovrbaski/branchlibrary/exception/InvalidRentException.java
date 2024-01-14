package me.darkovrbaski.branchlibrary.exception;


import java.io.Serial;

public class InvalidRentException extends RuntimeException {


  @Serial
  private static final long serialVersionUID = -3318214197796948381L;

  public InvalidRentException(final String message) {
    super(message);
  }

}

