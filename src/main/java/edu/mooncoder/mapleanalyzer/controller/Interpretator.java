package edu.mooncoder.mapleanalyzer.controller;

import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import edu.mooncoder.mapleanalyzer.logic.lexic.Lexer;
import edu.mooncoder.mapleanalyzer.logic.syntax.Parser;
import edu.mooncoder.mapleanalyzer.model.contracts.Grafico;
import edu.mooncoder.mapleanalyzer.model.wrappers.ErrorHolder;

public class Interpretator {
    private final Reader reader;
    private final Lexer lexer;
    private final Parser parser;

    private LinkedList<Grafico> colaEjecucion;
    private Map<String, Grafico> graficos;

    private boolean acceptable;

    public Interpretator(String code) {
        Grafico.clean();

        reader = new StringReader(code + "\n");
        lexer = new Lexer(reader);
        parser = new Parser(lexer);

        try {
            parser.parse();
            graficos = Grafico.getGraficos();
            acceptable = true;
            colaEjecucion = (LinkedList<Grafico>) Grafico.getColaEjecucion();
        } catch (Exception e) {
            // TODO: Agregar catch eficiente
            acceptable = false;
        }
    }

    public Map<String, Grafico> getGraficos() {
        return graficos;
    }

    public LinkedList<Grafico> getColaEjecucion() {
        return colaEjecucion;
    }

    public ErrorHolder[] getErrores() {
        return parser.getErrores();
    }

    public boolean isAcceptable() {
        return acceptable;
    }
}