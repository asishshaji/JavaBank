package com.app.bankapp.error;

public class UserExists extends RuntimeException {

  public UserExists(String message) {
    super(message);
  }
}
