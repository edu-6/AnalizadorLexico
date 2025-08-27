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
public class ComentarioBloqueRecogniser extends ReconocedorToken {

    public ComentarioBloqueRecogniser(SIMBOLOS simbolos, AnalizadorLexico analizador) {
        super(simbolos, analizador);
    }

    @Override
    public boolean esCandidato(String contenido, int indiceActual) {
        String etiquetaInicio = simbolos.getBloqueInicio();
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

    @Override
    public Token analizar(String texto, int indiceActual) {
        int columnaInicio = analizador.getColumna(); // guardar la fila en la que venía
        int lineaInicio = analizador.getLinea(); // guardar la fila actual donde empieza
        int indiceInicio = indiceActual;

        int tamañoEtiquetaInicio = simbolos.getBloqueInicio().length();

        indiceActual += tamañoEtiquetaInicio; // esto es clave
        analizador.aumentarColumna(tamañoEtiquetaInicio); // aumentar las columnas
        String comentario = "";

        while (indiceActual + tamañoEtiquetaInicio - 1 < texto.length()) {
            String siguentesCaracteres = avanzarNCaracteres(indiceActual, tamañoEtiquetaInicio, texto);
            if (String.valueOf(siguentesCaracteres).equals(simbolos.getBloqueFin())) {
                indiceActual++;
                this.ultimoIndiceUsado = indiceActual;
                return generarToken(texto, indiceActual, comentario, lineaInicio, columnaInicio, indiceInicio, indiceActual);
            } else {
                char caracter = texto.charAt(indiceActual);
                comentario += caracter;
                indiceActual++;
                this.verificarSaltoLinea(caracter); // se verifica que no sea salto de linea
                analizador.aumentarColumna(1);
            }
        }

        this.ultimoIndiceUsado = indiceActual;
        return new Token("error", comentario, lineaInicio, columnaInicio, indiceInicio, indiceActual); // tirar nuevo token error porque no logró enviar antes de que fuera el fin del archivo

    }

    private Token generarToken(String contenido, int indiceActual, String comentario, int linea, int columna, int indiceInicio, int indiceFin) {
       /*boolean esError = this.esError(contenido, indiceActual);
        if (!this.esError(contenido, indiceActual)) { // si no es error
            return new Token("comentario bloque", comentario, linea, columna, indiceInicio, indiceFin);
        }*/
        return new Token("comentario bloque", comentario, linea, columna, indiceInicio, indiceFin);

        //return new Token("error", comentario, linea, columna, indiceInicio, indiceFin); // token error
    }

    private String avanzarNCaracteres(int caracterInicio, int cantidadAvance, String contenido) {
        String avance = "";
        for (int i = 0; i < cantidadAvance; i++) {
            char caracter = contenido.charAt(caracterInicio);
            avance += caracter;
            caracterInicio++;
        }

        return avance;
    }
}
