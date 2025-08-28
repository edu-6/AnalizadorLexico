/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.backend.analisis.tokens;

import java.awt.Color;

/**
 *
 * @author edu
 */
public class Token {

    private String tipoToken;
    private String lexema;
    private int fila;
    private int columna;
    private int indiceInicio;
    private int indiceFin;
    private Color color;
    public Token(String tipoToken, String lexema, int fila, int columna, int indiceInicio, int indiceFin) {
        this.tipoToken = tipoToken;
        this.lexema = lexema;
        this.fila = fila;
        this.columna = columna;
        this.indiceInicio = indiceInicio;
        this.indiceFin = indiceFin;
        definirColor(tipoToken);
    }
    
    
    public void concatenarToken(Token token){
        this.lexema += token.getLexema();
        int indiceFin = token.getIndiceFin();
        this.indiceFin = indiceFin;
    }

    public String getTipoToken() {
        return tipoToken;
    }

    public String getLexema() {
        return lexema;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public int getIndiceInicio() {
        return indiceInicio;
    }

    public int getIndiceFin() {
        return indiceFin;
    }

    public void setTipoToken(String tipoToken) {
        this.tipoToken = tipoToken;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setIndiceInicio(int indiceInicio) {
        this.indiceInicio = indiceInicio;
    }

    public void setIndiceFin(int indiceFin) {
        this.indiceFin = indiceFin;
    }
    
    private void definirColor(String tipo) {
        switch (tipo) {
            case "identificador":
                this.color = new Color(139, 69, 19);
                break;
            case "numero":
                this.color = Color.GREEN;
                break;
            case "decimal":
                this.color = Color.BLACK;
                break;
            case "cadena":
                this.color = Color.ORANGE;
                break;
            case "reservada":
                this.color = Color.BLUE;
                break;
            case "puntuacion":
                this.color = Color.CYAN;
                break;
            case "agrupacion":
                this.color = new Color(128, 0, 128);
                break;
            case "operador":
                this.color = Color.YELLOW;
                break;
            case "comentario linea":
                this.color = new Color(0, 100, 0);
                break;
            case "comentario bloque":
                this.color = new Color(0, 100, 0);
                break;
            case "error":
                this.color = new Color(255, 0, 0);
                break;
        }
    }

    public Color getColor() {
        return color;
    }
    
    
    

    public void selfDescribe() {
        System.out.println("----------------------------------------------------");
        System.out.println("Token de tipo: " + tipoToken);
        System.out.println("lexema: " + lexema);
        System.out.println("fila: " + fila);
        System.out.println("columna: " + columna);
        System.out.println("inicio: " + indiceInicio);
        System.out.println("fin: " + indiceFin);
    }

}
