package com.covid19.demo.exception;

public class UserAlreadyRegisteredException extends Exception {
  
  /**
   * 
   */
  private static final long serialVersionUID = -4131896036764018251L;
  
  public UserAlreadyRegisteredException(String msg) {
    super(msg);
  }
}
