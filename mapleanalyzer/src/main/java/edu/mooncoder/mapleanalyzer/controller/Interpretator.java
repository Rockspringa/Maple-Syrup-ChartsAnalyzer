package edu.mooncoder.mapleanalyzer.controller;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Map;

import edu.mooncoder.mapleanalyzer.logic.lexic.Lexer;
import edu.mooncoder.mapleanalyzer.logic.syntax.Parser;
import edu.mooncoder.mapleanalyzer.logic.syntax.Tokens;
import edu.mooncoder.mapleanalyzer.model.contracts.Grafico;
import edu.mooncoder.mapleanalyzer.model.wrappers.ErrorHolder;
import edu.mooncoder.mapleanalyzer.model.wrappers.Reporte;

public class Interpretator {

    private LinkedList<Grafico> colaEjecucion;
    private Map<String, Grafico> graficos;

    public Interpretator(String code) {
        Grafico.clean();
        Reporte.getReporte(true);

        Reader reader = new StringReader(code + "\n");
        Lexer lexer = new Lexer(reader);
        Parser parser = new Parser(lexer);

        try {
            parser.parse();

            if (Reporte.getReporte().getErrores().size() != 0)
                Grafico.clean();

            graficos = Grafico.getGraficos();
            colaEjecucion = (LinkedList<Grafico>) Grafico.getColaEjecucion();
        } catch (Exception e) {
            ErrorHolder.messageThrowed(e.getMessage(), 1);
            Grafico.clean();
        }
    }

    public Map<String, Grafico> getGraficos() {
        return graficos;
    }

    public LinkedList<Grafico> getColaEjecucion() {
        return colaEjecucion;
    }

    public boolean hasErrors() {
        return !Reporte.getReporte().getErrores().isEmpty();
    }
}