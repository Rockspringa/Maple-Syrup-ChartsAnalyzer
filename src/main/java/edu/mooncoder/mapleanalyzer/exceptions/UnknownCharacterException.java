package edu.mooncoder.mapleanalyzer.exceptions;

public class UnknownCharacterException extends Exception {
  
  public UnknownCharacterException(String unknownInput, int line, int col) {
    super("La cadena « " + unknownInput + " » en la fila " + line + ", columna " + col
        + " no es reconocida dentro del lenguaje.");
  }

}
