package edu.mooncoder.mapleanalyzer.exceptions;

public class RequiredAttributesNotFilledException extends Exception {
    public RequiredAttributesNotFilledException(String attribute) {
        super("The attribute '" + attribute + "' is required.");
    }
}
