package edu.mooncoder.mapleanalyzer.controller;

import java.io.Reader;
import java.io.StringReader;

import edu.mooncoder.mapleanalyzer.logic.lexic.Lexer;
import edu.mooncoder.mapleanalyzer.logic.syntax.Parser;

public class Interpretator {
    private final Reader reader;
    private final Lexer lexer;
    private final Parser parser;

    private boolean acceptable = false;

    public Interpretator(String code) {
        reader = new StringReader(code + "\n");
        lexer = new Lexer(reader);
        parser = new Parser(lexer);

        try {
            parser.parse();
            acceptable = true;
        } catch (Exception e) {
            // TODO: Agregar catch eficiente
            acceptable = false;
        }
    }

    public boolean isAcceptable() {
        return acceptable;
    }
}