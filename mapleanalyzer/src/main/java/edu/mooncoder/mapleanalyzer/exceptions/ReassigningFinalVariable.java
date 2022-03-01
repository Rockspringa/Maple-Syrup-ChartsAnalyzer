package edu.mooncoder.mapleanalyzer.exceptions;

public class ReassigningFinalVariable extends Exception {

    public ReassigningFinalVariable(String variable) {
        super("La variable '" + variable + "' ya tiene un valor asignado.");
    }
    
}
