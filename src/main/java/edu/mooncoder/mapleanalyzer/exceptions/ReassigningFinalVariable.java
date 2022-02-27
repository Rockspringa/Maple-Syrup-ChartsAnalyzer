package edu.mooncoder.mapleanalyzer.exceptions;

public class ReassigningFinalVariable extends Exception {

    public ReassigningFinalVariable(String variable) {
        super("The '" + variable + "' variable has already a value.");
    }
    
}
