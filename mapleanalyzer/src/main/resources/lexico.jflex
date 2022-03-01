package edu.mooncoder.mapleanalyzer.logic.lexic;

import java_cup.runtime.Symbol;
import edu.mooncoder.mapleanalyzer.exceptions.UnknownCharacterException;
import edu.mooncoder.mapleanalyzer.logic.syntax.Tokens;
import edu.mooncoder.mapleanalyzer.model.wrappers.ErrorHolder;

%%

%class Lexer
%unicode
%cupsym Tokens
%cup
%public
%line
%column

%{
  private StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline + 1, yycolumn + 1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline + 1, yycolumn + 1, value);
  }

  private String getErrorMessage() {
    return new UnknownCharacterException(yytext()).getMessage();
  }
%}

SaltoLinea = \n | \r | \r\n
Espacios = {SaltoLinea} | [ \t\f]

Comentarios = "#" [^\r\n]* {SaltoLinea}?

// Etc

Number = [0-9]+ ("." [0-9]+)?

%state LITERAL

%%

<YYINITIAL> {

  "Porcentaje"                      { return symbol(Tokens.PORCENTAJE); }
  "etiquetas"                       { return symbol(Tokens.ETIQUETAS); }
  "valores"                         { return symbol(Tokens.VALORES); }
  "Barras"                          { return symbol(Tokens.BARRAS); }
  "titulo"                          { return symbol(Tokens.TITULO); }
  "total"                           { return symbol(Tokens.TOTAL); }
  "extra"                           { return symbol(Tokens.EXTRA); }
  "ejex"                            { return symbol(Tokens.EJE_X); }
  "ejey"                            { return symbol(Tokens.EJE_Y); }
  "unir"                            { return symbol(Tokens.UNIR); }
  "tipo"                            { return symbol(Tokens.TIPO); }
  "Def" | "def"                     { return symbol(Tokens.DEF); }
  "Pie"                             { return symbol(Tokens.PIE); }

  "Cantidad"                        { return symbol(Tokens.CANTIDAD); }
  "Ejecutar"                        { return symbol(Tokens.EJECUTAR); }
  
  {Number}                          { return symbol(Tokens.NUMBER, Double.parseDouble(yytext())); }

  \"                                { string.setLength(0); yybegin(LITERAL); }

  ";"                               { return symbol(Tokens.SEPARADOR); }
  ":"                               { return symbol(Tokens.ASIGNAR); }
  ","                               { return symbol(Tokens.COMA); }

  "("                               { return symbol(Tokens.IZQ_PARENTESIS); }
  ")"                               { return symbol(Tokens.DER_PARENTESIS); }
  "["                               { return symbol(Tokens.IZQ_CORCHETE); }
  "]"                               { return symbol(Tokens.DER_CORCHETE); }
  "{"                               { return symbol(Tokens.IZQ_LLAVE); }
  "}"                               { return symbol(Tokens.DER_LLAVE); }

  "-"                               { return symbol(Tokens.MENOS); }
  "+"                               { return symbol(Tokens.MAS); }
  "*"                               { return symbol(Tokens.POR); }
  "/"                               { return symbol(Tokens.DIV); }

  {Comentarios} | {Espacios}        { /* ignore */ }
}

<LITERAL> {
  \"                             { yybegin(YYINITIAL); return symbol(Tokens.LITERAL, string.toString()); }

  [^\n\r\"\\]+                   { string.append( yytext() ); }

  \\t                            { string.append('\t'); }

  \\n                            { string.append('\n'); }

  \\r                            { string.append('\r'); }

  \\\"                           { string.append('\"'); }

  \\                             { string.append('\\'); }
}

[^] {Espacios} { ErrorHolder.messageThrowed(getErrorMessage(), 0, yyline + 1, yycolumn + 1); }

