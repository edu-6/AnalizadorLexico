/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.backend.analisis.reconocedores;

import com.mycompany.analizadorlexico.backend.SIMBOLOS;
import com.mycompany.analizadorlexico.backend.analisis.AnalizadorLexico;
import com.mycompany.analizadorlexico.backend.analisis.tokens.Token;

/**
 
 * @author edu
 */
public class IdentificadorOReservada extends ReconocedorToken {

    public IdentificadorOReservada(SIMBOLOS simbolos, AnalizadorLexico analizador) {
        super(simbolos, analizador);
    }

    @Override
    public boolean esCandidato(String contenido, int indiceActual) {
        char caracter = contenido.charAt(indiceActual);
        return esLetra(caracter);
    }

    @Override
    public Token analizar(String texto, int indiceActual) {
        int columnaInicio = analizador.getColumna(); // guardar la fila en la que venía
        int lineaInicio = analizador.getLinea(); // guardar la fila actual donde empieza
        int indiceInicio = indiceActual;

        String cadena = "";
        while (indiceActual < texto.length()) {
            char caracter = texto.charAt(indiceActual);
            if (esLetra(caracter) || esNumero(caracter)) {
                cadena += caracter;
                indiceActual++;
                analizador.aumentarColumna(1);
            } else if (isEspacioOrSalto(caracter)) { // si es espacio o salto enviar token valido
                indiceActual--;
                this.ultimoIndiceUsado = indiceActual;
                descartarSiEsReservada(cadena, lineaInicio, columnaInicio, indiceInicio, indiceActual);
            } else {
                indiceActual--;
                this.ultimoIndiceUsado = indiceActual;
                return new Token("error", cadena, lineaInicio, columnaInicio, indiceInicio, indiceActual);// si es otro caracter entonces es error indiceActual -1
            }

        }
        this.ultimoIndiceUsado = indiceActual;
        return descartarSiEsReservada(cadena, lineaInicio, columnaInicio, indiceInicio, indiceActual);
    }

    /* esta clase no verifica los saltos de linea, si encuentra uno o un espacio, 
    ahí para el analisis y no aumenta caracterActual ya es trabajo del analizador buscar
    y encontrar el caracter relevante y de paso contar saltos de linea*/


    private boolean isEspacioOrSalto(char caracter) {
        return String.valueOf(caracter).equals(" ") || String.valueOf(caracter).equals("\n");
    }

    /**
     * Verifica si es una palabra reservada o no y envia el token final correcto
     */
    private Token descartarSiEsReservada(String cadena, int lineaInicio, int columnaInicio, int indiceInicio, int indiceActual) {
        String tipo = "identificador";
        String[] reservadas = simbolos.getPalabrasReservadas();
        for (String reservada : reservadas) {
            if (String.valueOf(reservada).equals(cadena)) {
                tipo = "reservada";
                break;
            }
        }
        return new Token(tipo, cadena, lineaInicio, columnaInicio, indiceInicio, indiceActual);

    }

}
