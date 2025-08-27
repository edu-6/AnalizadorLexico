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
public class ErrorReconocedor extends ReconocedorToken {

    public ErrorReconocedor(SIMBOLOS simbolos,AnalizadorLexico analizador) {
        super(simbolos,analizador);
    }

    @Override
    public boolean esCandidato(String contenido, int indiceActual) {
        return true;
    }

    @Override
    public Token analizar(String texto, int indiceActual) {
        int columnaInicio = analizador.getColumna(); // guardar la fila en la que venía
        int lineaInicio = analizador.getLinea(); // guardar la fila actual donde empieza
        int indiceInicio = indiceActual;
        this.ultimoIndiceUsado = indiceActual;
        String error = String.valueOf(texto.charAt(indiceActual));
        return new Token("comentario linea",error,lineaInicio,columnaInicio, indiceInicio, indiceActual);
    }

}
