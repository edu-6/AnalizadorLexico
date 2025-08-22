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

}
