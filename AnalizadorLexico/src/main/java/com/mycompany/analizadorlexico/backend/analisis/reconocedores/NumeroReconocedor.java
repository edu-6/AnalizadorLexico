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
            cadena += caracter;
            analizador.aumentarColumna(1);
            this.ultimoIndiceUsado = indiceActual;

            if (!esValido(caracter)) { // si no es valido

                if (caracter == '\n' || caracter == ' ') { // si es salto linea o espacio
                    indiceActual--;
                    this.ultimoIndiceUsado =indiceActual;
                    cadena = this.obiarUltimoCaracter(cadena);
                    return validarUltimoCaracter(tipo, cadena, lineaInicio, columnaInicio, indiceInicio, indiceActual); // si hay final
                } else {
                    return validarUltimoCaracter("error", cadena, lineaInicio, columnaInicio, indiceInicio, indiceActual); // si no es valido ni indica final
                }
            }
            indiceActual++;
        }
        indiceActual--; // porque sumo el ultimo y ya no pasó en el ciclo
        this.ultimoIndiceUsado = indiceActual;
        return validarUltimoCaracter(tipo, cadena, lineaInicio, columnaInicio, indiceInicio, indiceActual);//si no huvieron errores y llegó al final
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
    
    private Token validarUltimoCaracter(String tipo, String cadena, int lineaInicio, int columnaInicio, int indiceInicio, int indiceFinal){
        char ultimoCaracter = cadena.charAt(cadena.length()-1);
        if(!esNumero(ultimoCaracter)){
            tipo = "error";
        }
        return new Token(tipo, cadena, lineaInicio, columnaInicio, indiceInicio, indiceFinal);
    }
    
    
    private String obiarUltimoCaracter(String cadena){
        String nueva = "";
        for (int i = 0; i < cadena.length()-1; i++) {
            nueva+= cadena.charAt(i);
            
        }
        return nueva;
    }

}
