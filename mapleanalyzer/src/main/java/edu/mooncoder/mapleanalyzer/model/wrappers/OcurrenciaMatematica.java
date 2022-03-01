package edu.mooncoder.mapleanalyzer.model.wrappers;

import edu.mooncoder.mapleanalyzer.model.tipos.Operador;

public class OcurrenciaMatematica {
    private final String ocurrencia;
    private final Operador operador;
    private final int column;
    private final int line;
    
    public OcurrenciaMatematica(String ocurrencia, String representacion, int column, int line) {
        this.ocurrencia = ocurrencia;
        this.operador = Operador.valueOfRepresentation(representacion);
        this.column = column;
        this.line = line;

        Reporte.getReporte().addOcurrenciaMatematica(this);
    }

    public String getOcurrencia() {
        return ocurrencia;
    }

    public Operador getOperador() {
        return operador;
    }

    public int getColumn() {
        return column;
    }

    public int getLine() {
        return line;
    }
}
