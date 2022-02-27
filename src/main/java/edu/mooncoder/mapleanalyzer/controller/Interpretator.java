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

public class Interpretator {
    private final Parser parser;
    private ErrorHolder[] errors = new ErrorHolder[0];

    private LinkedList<Grafico> colaEjecucion;
    private Map<String, Grafico> graficos;

    private boolean acceptable;

    public Interpretator(String code) {
        Grafico.clean();

        if (!isLexerBugged(code)) {
            Reader reader = new StringReader(code + "\n");
            Lexer lexer = new Lexer(reader);
            parser = new Parser(lexer);

            try {
                parser.parse();
                graficos = Grafico.getGraficos();
                acceptable = true;
                colaEjecucion = (LinkedList<Grafico>) Grafico.getColaEjecucion();
            } catch (Exception e) {
                errors = new ErrorHolder[] { new ErrorHolder(e.getMessage()) };
            }
        } else {
            parser = null;
        }
    }

    private boolean isLexerBugged(String code) {
        Reader reader = new StringReader(code + "\n");
        Lexer lexer = new Lexer(reader);
        ErrorHolder[] errors;

        try {
            while (lexer.next_token().sym != Tokens.EOF) {}

            errors = lexer.getErrorHolderList();
            if (errors.length == 0) {
                return false;
            }
        } catch (IOException e) {
            errors = new ErrorHolder[] { new ErrorHolder(e.getMessage()) };
        }
        this.errors = errors;
        return true;
    }

    public Map<String, Grafico> getGraficos() {
        return graficos;
    }

    public LinkedList<Grafico> getColaEjecucion() {
        return colaEjecucion;
    }

    public ErrorHolder[] getErrores() {
        return (errors == null) ? parser.getErrores() : errors;
    }

    public boolean isAcceptable() {
        return acceptable;
    }
}