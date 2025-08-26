/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.backend;

import org.json.JSONObject;

/**
 *
 * @author edu
 */
public class SIMBOLOS {

    private String[] palabrasReservadas;
    private String[] operadores;
    private String[] puntuacion;
    private String[] agrupacion;

    private String linea;
    private String bloqueInicio;
    private String bloqueFin;
    
    private String[] digitos = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
    
    private String[] abecedario = { 
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", 
            "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", 
            "t", "u", "v", "w", "x", "y", "z" 
    };

    public SIMBOLOS(String[] palabrasReservadas, String[] operadores, String[] puntuacion, String[] agrupacion, String linea, String bloqueInicio, String bloqueFin) {
        this.palabrasReservadas = palabrasReservadas;
        this.operadores = operadores;
        this.puntuacion = puntuacion;
        this.agrupacion = agrupacion;
        this.linea = linea;
        this.bloqueInicio = bloqueInicio;
        this.bloqueFin = bloqueFin;
    }

    public void selfDescribe() {
        writeStringArray(palabrasReservadas);
        writeStringArray(operadores);
        writeStringArray(puntuacion);
        writeStringArray(agrupacion);
        
        System.out.println(linea);
        System.out.println(bloqueInicio);
        System.out.println(bloqueFin);
    }

    private void writeStringArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public String[] getPalabrasReservadas() {
        return palabrasReservadas;
    }

    public String[] getOperadores() {
        return operadores;
    }

    public String[] getPuntuacion() {
        return puntuacion;
    }

    public String[] getAgrupacion() {
        return agrupacion;
    }

    public String getLinea() {
        return linea;
    }

    public String getBloqueInicio() {
        return bloqueInicio;
    }

    public String getBloqueFin() {
        return bloqueFin;
    }

    public String[] getDigitos() {
        return digitos;
    }

    public String[] getAbecedario() {
        return abecedario;
    }
    
    
    
    

}
