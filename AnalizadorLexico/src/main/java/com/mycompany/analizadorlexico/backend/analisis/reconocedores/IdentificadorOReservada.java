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
            }else{
                // si es otro caracter
                // veriricar si no es no permitido y tirar error
            }
        }
        this.ultimoIndiceUsado = indiceActual;
        return new Token("", cadena, lineaInicio, columnaInicio, indiceInicio, indiceActual);
    }
    
    /* esta clase no verifica los saltos de linea, si encuentra uno o un espacio, 
    ahí para el analisis y no aumenta caracterActual ya es trabajo del analizdor buscar
    y encontrar el caracter relevante y de paso contar saltos de linea*/

    private boolean esLetra(char parametro) {
        String[] letras = simbolos.getAbecedario();
        for (String letra : letras) {
            if (String.valueOf(parametro).equalsIgnoreCase(letra)) {
                return true;
            }
        }

        return false;
    }

    private boolean esNumero(char parametro) {
        String[] digitos = simbolos.getDigitos();
        for (String digito : digitos) {
            if (String.valueOf(parametro).equals(digito)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isEspacioOrSalto(char caracter){
        return String.valueOf(caracter).equals(" ") || String.valueOf(caracter).equals("\n");
    }

}
