/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.backend.analisis.reconocedores;

import com.mycompany.analizadorlexico.backend.SIMBOLOS;
import com.mycompany.analizadorlexico.backend.analisis.AnalizadorLexico;
import com.mycompany.analizadorlexico.backend.analisis.tokens.Token;

/**
 *
 * @author edu
 */
public abstract class ReconocedorCaracterSimple extends ReconocedorToken {

    // atributos especiales
    protected String[] caracteresPermitidos;
    protected String tipo;

    public ReconocedorCaracterSimple(SIMBOLOS simbolos, AnalizadorLexico analizador) {
        super(simbolos, analizador);
        configurarAtributosEspeciales();
    }

    protected abstract void configurarAtributosEspeciales();

    @Override
    public boolean esCandidato(String contenido, int indiceActual) {
        return esCaracterPermitido(contenido, indiceActual);
    }

    @Override
    public Token analizar(String texto, int indiceActual) {
        int columnaInicio = analizador.getColumna(); // guardar la fila en la que venía
        int lineaInicio = analizador.getLinea(); // guardar la fila actual donde empieza
        int indiceInicio = indiceActual;

        String cadena = String.valueOf(texto.charAt(indiceActual));
        boolean esError = this.esError(texto, indiceActual); // no está solo, hay un caracter más y no es espacio ni salto
        if (esError) {
            // si es error
            cadena += String.valueOf(texto.charAt(indiceActual+1));
            analizador.aumentarColumna(1);
            indiceActual++;
            this.ultimoIndiceUsado = indiceActual;
            return new Token("error", cadena, lineaInicio, columnaInicio, indiceInicio, indiceActual);//enviar token
        } else {
            // si no es error
            this.ultimoIndiceUsado = indiceActual;
            return new Token(tipo, cadena, lineaInicio, columnaInicio, indiceInicio, indiceActual);//enviar token
        }
    }

    protected boolean esCaracterPermitido(String contenido, int indiceActual) {
        char caracter = contenido.charAt(indiceActual);
        for (String s : caracteresPermitidos) {
            if (String.valueOf(caracter).equals(s)) {
                return true;
            }
        }
        return false;
    }
}
