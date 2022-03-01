package edu.mooncoder.mapleanalyzer.model.tipos;

public enum FaseAnalisis {
    LEXICO, SINTACTICO, SEMANTICO;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
