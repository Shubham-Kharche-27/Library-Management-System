package com.shubham.Library.Management.System.Exception;

public class BookExistException extends RuntimeException {
  public BookExistException(String message) {
    super(message);
  }
}
