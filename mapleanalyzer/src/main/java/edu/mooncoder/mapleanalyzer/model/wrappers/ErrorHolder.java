package edu.mooncoder.mapleanalyzer.model.wrappers;

import edu.mooncoder.mapleanalyzer.model.tipos.FaseAnalisis;

public class ErrorHolder {
    private final String msg;
    private final int line;
    private final int col;
    private final FaseAnalisis fase;

    private ErrorHolder(String msg, int fase, int line, int col) {
        this.msg = msg;
        this.line = line;
        this.col = col;
        this.fase = FaseAnalisis.values()[fase];

        Reporte.getReporte().addError(this);
    }

    public static void messageThrowed(String msg, int fase) {
        new ErrorHolder(msg, fase, -1, -1);
    }

    public static void messageThrowed(String msg, int fase, int line, int col) {
        new ErrorHolder(msg, fase, line, col);
    }

    public static void messageEsperabaUn(String esperado, int fase, int line, int col) {
        new ErrorHolder("Se esperaba un " + esperado, fase, line, col);
    }

    public static void messageEsperabaUna(String esperado, int fase, int line, int col) {
        new ErrorHolder("Se esperaba una " + esperado, fase, line, col);
    }

    public String getMessage() {
        return this.msg;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.col;
    }

    public FaseAnalisis getFase() {
        return fase;
    }
}
