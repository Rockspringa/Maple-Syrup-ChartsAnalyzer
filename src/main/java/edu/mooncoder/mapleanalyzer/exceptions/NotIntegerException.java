package edu.mooncoder.mapleanalyzer.exceptions;

public class NotIntegerException extends Exception {
    public NotIntegerException(double num) {
        super("El numero '" + num + "'' no es un entero.");
    }
}
