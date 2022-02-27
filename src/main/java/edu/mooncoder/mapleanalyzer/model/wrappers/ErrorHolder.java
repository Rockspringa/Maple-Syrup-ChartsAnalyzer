package edu.mooncoder.mapleanalyzer.model.wrappers;

public class ErrorHolder {
    private String msg;

    public ErrorHolder(String msg) {
        this.msg = msg;
    }

    public ErrorHolder(int line1, int col1, int line2, int col2) {
        msg = ("Se encontro un error entre la linea " + line1 + ", columna " + col1
                + " y la linea " + line2 + ", columna " + col2);
    }

    public ErrorHolder(String esperado, int line1, int col1, int line2, int col2) {
        msg = ("Se esperaba un " + esperado + " entre la linea " + line1 + ", columna " + col1
                + " y la linea " + line2 + ", columna " + col2);
    }

    public ErrorHolder(String esperado, int line, int col) {
        msg = ("Se esperaba un " + esperado + ", cerca de "
                + "la fila: " + line + ", columna: " + col);
    }

    @Override
    public String toString() {
        return msg;
    }
}
