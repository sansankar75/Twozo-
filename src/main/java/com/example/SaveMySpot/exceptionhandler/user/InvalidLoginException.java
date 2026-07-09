package com.example.SaveMySpot.exceptionhandler.user;

public class InvalidLoginException extends UserException {
  public InvalidLoginException(String message) {
    super(message);
  }
}
