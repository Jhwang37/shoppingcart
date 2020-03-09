package com.james.demo.finalproject.exceptions;

public class EmptyCartException extends Exception {
  private int status;
  private String message;
  
  public EmptyCartException(int status, String message) {
    this.status = status;
    this.message = message;
  } 
  
  public String getMessage() {
    return message;
  }

  public int getStatus() {
    return status;
  }
}
