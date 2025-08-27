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
public class ComentarioLineaReconocedor extends ReconocedorToken {

    public ComentarioLineaReconocedor(SIMBOLOS simbolos, AnalizadorLexico analizador) {
        super(simbolos, analizador);
    }

    @Override
    public boolean esCandidato(String contenido, int indiceActual) {
        String etiquetaInicio = simbolos.getLinea();
        String cadena = "";
        if(indiceActual+etiquetaInicio.length() >= contenido.length()){ // si ya está fuera del rango
            return false;
        }
        
        System.out.println("Tamaño de la etiquta"+  etiquetaInicio.length());
        for (int i = 0; i < etiquetaInicio.length(); i++) {
            System.out.println("Ciclo numero"+ i);
            cadena += contenido.charAt(indiceActual);
            System.out.println(i);
            System.out.println(cadena);
            indiceActual++;
        }

        return String.valueOf(cadena).equals(etiquetaInicio);
    }
    //en este tipo de token no hay eror

    @Override
    public Token analizar(String texto, int indiceActual) {
        int columnaInicio = analizador.getColumna(); // guardar la fila en la que venía
        int lineaInicio = analizador.getLinea(); // guardar la fila actual donde empieza
        int indiceInicio = indiceActual;
        
        String comentario = "";
        int tamañoEtiquetaInicio = simbolos.getLinea().length();
        while(indiceActual < texto.length()){
         char caracter = texto.charAt(indiceActual);
         if(caracter == '\n'){ // si hay salto de linea
             //analizador.agregarLinea();
             indiceActual--;
             this.ultimoIndiceUsado = indiceActual;
             return new Token("comentario linea",comentario,lineaInicio,columnaInicio, indiceInicio, indiceActual);//enviar token
         }else{
             comentario+= texto.charAt(indiceActual);
             indiceActual++;
             analizador.aumentarColumna(1);
         }
        }
        indiceActual--;
        this.ultimoIndiceUsado = indiceActual;
        return new Token("comentario linea",comentario,lineaInicio,columnaInicio, indiceInicio, indiceActual);
    }
}
