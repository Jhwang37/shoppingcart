package com.james.demo.finalproject.exceptions;

import com.james.demo.finalproject.models.Product;

public class InvalidCartItemException extends Exception {
  private int status;
  private String message;
  private Product product;
  
  /**
   * InvalidCartItemException constructor.

   */
  public InvalidCartItemException(int status, String message, Product product) {
    this.status = status;
    this.message = message + " ("
      + product.getName() + " - "
      + product.getCollection().getName() + " - "
      + product.getSize() + ")";
    this.product = product;
  } 
  
  public String getMessage() {
    return message;
  }
  
  public int getStatus() {
    return status;
  }  
}
