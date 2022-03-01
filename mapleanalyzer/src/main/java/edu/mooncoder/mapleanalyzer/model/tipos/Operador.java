package edu.mooncoder.mapleanalyzer.model.tipos;

public enum Operador {
    SUMA, RESTA, DIVISION, MULTIPLICACION;

    public static Operador valueOfRepresentation(String representacion) {
        switch (representacion) {
            case "+": return SUMA;
            case "-": return RESTA;
            case "/": return DIVISION;
            case "*": return MULTIPLICACION;
            default: return null;
        }
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
