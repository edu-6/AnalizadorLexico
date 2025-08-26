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
public class NumeroReconocedor extends ReconocedorToken {

    private boolean yaHayPunto = false;
    private String tipo = "numero";

    public NumeroReconocedor(SIMBOLOS simbolos, AnalizadorLexico analizador) {
        super(simbolos, analizador);
    }

    @Override
    public boolean esCandidato(String contenido, int indiceActual) {
        char caracter = contenido.charAt(indiceActual); // obtener caracter
        return esNumero(caracter); // verificar si es numero
    }

    @Override
    public Token analizar(String texto, int indiceActual) {
        int columnaInicio = analizador.getColumna(); // guardar la fila en la que venía
        int lineaInicio = analizador.getLinea(); // guardar la fila actual donde empieza
        int indiceInicio = indiceActual;

        yaHayPunto = false;
        tipo = "numero";

        String cadena = "";
        while (indiceActual < texto.length()) {
            char caracter = texto.charAt(indiceActual);

            if (esValido(caracter)) {
                cadena += caracter;
                indiceActual++;
                analizador.aumentarColumna(1);
            } else if (caracter == '\n' || caracter == ' ') { // si es salto linea o espacio
                indiceActual--;
                this.ultimoIndiceUsado = indiceActual;
                return new Token(tipo, cadena, lineaInicio, columnaInicio, indiceInicio, indiceActual); // si hay final
            } else {
                indiceActual--;
                this.ultimoIndiceUsado = indiceActual;
                return new Token("error", cadena, lineaInicio, columnaInicio, indiceInicio, indiceActual); // si no es valido ni indica final
            }
        }
        this.ultimoIndiceUsado = indiceActual;
        return new Token(tipo, cadena, lineaInicio, columnaInicio, indiceInicio, indiceActual);//si no huvieron errores y llegó al final
    }

    private boolean esValido(char caracter) {
        if (esNumero(caracter)) {
            return true;
        } else if (caracter == '.' && !yaHayPunto) { // si es punto y  aun no hay punto
            this.yaHayPunto = true;
            this.tipo = "decimal";
            return true;
        }
        return false;
    }

}
