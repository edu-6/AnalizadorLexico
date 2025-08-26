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
public class CadenaReconocedor extends ReconocedorToken {

    public CadenaReconocedor(SIMBOLOS simbolos, AnalizadorLexico analizador) {
        super(simbolos, analizador);
    }

    @Override
    public boolean esCandidato(String contenido, int indiceActual) {
        char caracter = contenido.charAt(indiceActual);
        return caracter == '"';

    

    /// si es comillla
    }

    @Override
    public Token analizar(String texto, int indiceActual) {
        int columnaInicio = analizador.getColumna(); // guardar la fila en la que venía
        int lineaInicio = analizador.getLinea(); // guardar la fila actual donde empieza
        int indiceInicio = indiceActual;

        String cadena = "";
        cadena += texto.charAt(indiceActual); // se salta el primer caracter
        indiceActual++;
        analizador.aumentarColumna(1);

        while (indiceActual < texto.length()) {
            char caracter = texto.charAt(indiceActual);
            cadena += caracter;
            indiceActual++;
            analizador.aumentarColumna(1);
            
            if (caracter == '\n') { // si hay salto de linea
                analizador.agregarLinea();
            }

            if (caracter == '"') { // si hay final de cadena
                indiceActual--;
                this.ultimoIndiceUsado = indiceActual;
                return new Token("cadena", cadena, lineaInicio, columnaInicio, indiceInicio, indiceActual);//enviar token
            }
        }
        indiceActual--;
        this.ultimoIndiceUsado = indiceActual;
        return new Token("error", cadena, lineaInicio, columnaInicio, indiceInicio, indiceActual);
    }

}
