package edu.mooncoder.mapleanalyzer.exceptions;

public class UnknownChartException extends Exception {
    public UnknownChartException(String title) {
        super("Unknown chart '" + title + "''.");
    }
}
