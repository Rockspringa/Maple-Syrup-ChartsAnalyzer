package edu.mooncoder.mapleanalyzer;

import java.io.FileReader;

import edu.mooncoder.mapleanalyzer.logic.lexic.Lexer;
import edu.mooncoder.mapleanalyzer.logic.syntax.Parser;
import edu.mooncoder.mapleanalyzer.model.contracts.Grafico;

public class Main {
    public static void main(String[] args) {
        try {
            Parser par = new Parser(new Lexer(
                new FileReader("C:/Users/dylan/Desktop/Everything,+but+Nothing/Programacion+Eliminar/MapleAnalyzer/Prueba.txt")
            ));
            par.debug_parse();
            par.printErrores();
            Grafico.getColaEjecucion().forEach(grafico -> System.out.println(grafico.getTitulo()));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
