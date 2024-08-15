package com.example.IT.support.App.Exceptions;
public class PanneNotFoundException extends RuntimeException {

  public PanneNotFoundException(){
      super("Panne not found!");
  }
}
