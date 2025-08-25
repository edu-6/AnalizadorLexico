/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.backend.analisis.tokens;

/**
 *
 * @author edu
 */
public class Token {

    private String tipoToken;
    private String lexema;
    private int fila;
    private int columna;

    public Token(String tipoToken, String lexema, int fila, int columna) {
        this.tipoToken = tipoToken;
        this.lexema = lexema;
        this.fila = fila;
        this.columna = columna;
    }

    public void selfDescribe() {
        System.out.println(" \n");
        System.out.println(" \n");
        System.out.println("----------------------------------------------------");
        System.out.println("Token de tipo: " + tipoToken);
        System.out.println("lexema: " + lexema);
        System.out.println("fila: " + fila);
        System.out.println("columna: " + columna);
    }

}
