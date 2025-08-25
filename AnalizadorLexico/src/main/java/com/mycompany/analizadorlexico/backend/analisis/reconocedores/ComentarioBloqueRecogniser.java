/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.backend.analisis.reconocedores;

import com.mycompany.analizadorlexico.backend.SIMBOLOS;
import com.mycompany.analizadorlexico.backend.analisis.tokens.Token;

/**
 *
 * @author edu
 */
public class ComentarioBloqueRecogniser extends ReconocedorToken {

    public ComentarioBloqueRecogniser(SIMBOLOS simbolos) {
        super(simbolos);
    }

    @Override
    public boolean esCandidato(String contenido, int indiceActual) {
        String etiquetaInicio = simbolos.getBloqueInicio();
        String cadena = "";
        for (int i = 0; i < etiquetaInicio.length(); i++) {
            cadena += contenido.charAt(indiceActual);
            indiceActual++;
        }

        return String.valueOf(cadena).equals(etiquetaInicio);
    }

    @Override
    public Token analizar(String texto, int indiceActual) {
        int tamañoEtiquetaInicio = simbolos.getBloqueInicio().length();
        int primerCaracterRelevante = indiceActual + tamañoEtiquetaInicio;

        indiceActual += tamañoEtiquetaInicio; // esto es clave
        System.out.println("estamos en el inicide " + indiceActual);
        String comentario = "";

        while (indiceActual + tamañoEtiquetaInicio - 1 < texto.length()) {
            String siguentesCaracteres = avanzarNCaracteres(indiceActual, tamañoEtiquetaInicio, texto);
            if (String.valueOf(siguentesCaracteres).equals(simbolos.getBloqueFin())) {
                indiceActual++;
                this.ultimoIndiceUsado  = indiceActual;
                return generarToken(texto, indiceActual, comentario);
            } else {
                comentario += texto.charAt(indiceActual);
                indiceActual++;
            }
        }

        this.ultimoIndiceUsado = indiceActual;
        return new Token("error", comentario, 1, 1); // tirar nuevo token error porque no logró enviar antes de que fuera el fin del archivo

    }

    private Token generarToken(String contenido, int indiceActual, String comentario) {
        boolean esError = this.esError(contenido, indiceActual);
        if (!this.esError(contenido, indiceActual)) { // si no es error
            return new Token(" comentario bloque", comentario, 1, 1);
        }

        return new Token("error", comentario, 1, 1); // token provisional
    }

    private String avanzarNCaracteres(int caracterInicio, int cantidadAvance, String contenido) {
        String avance = "";
        for (int i = 0; i < cantidadAvance; i++) {
            avance += contenido.charAt(caracterInicio);
            caracterInicio++;
        }

        return avance;
    }
}
