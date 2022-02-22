package edu.mooncoder.mapleanalyzer;

import java.io.FileReader;

import edu.mooncoder.mapleanalyzer.logic.lexic.Lexer;
import edu.mooncoder.mapleanalyzer.logic.syntax.Parser;

public class Main {
    public static void main(String[] args) {
        try {
            Parser par = new Parser(new Lexer(
                new FileReader("C:/Users/dylan/Desktop/Everything,+but+Nothing/Programacion+Eliminar/MapleAnalyzer/Prueba.txt")
            ));
            par.parse();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
