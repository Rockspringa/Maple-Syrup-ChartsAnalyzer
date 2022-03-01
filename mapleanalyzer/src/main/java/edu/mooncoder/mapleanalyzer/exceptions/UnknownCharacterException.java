package edu.mooncoder.mapleanalyzer.exceptions;

public class UnknownCharacterException extends Exception {
  
  public UnknownCharacterException(String unknownInput) {
    super("No se reconoce '" + unknownInput + "' dentro del lenguaje.");
  }

}
