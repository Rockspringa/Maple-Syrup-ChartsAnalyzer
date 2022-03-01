package edu.mooncoder.mapleanalyzer.exceptions;

public class UnknownChartException extends Exception {
    public UnknownChartException(String title) {
        super("No se encontro ninguna grafica llamada: '" + title + "''.");
    }
}
