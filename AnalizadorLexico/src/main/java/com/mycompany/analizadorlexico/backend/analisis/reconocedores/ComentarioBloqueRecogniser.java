/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.backend.analisis.reconocedores;

import com.mycompany.analizadorlexico.backend.SIMBOLOS;

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

    private String analizar(String texto, int indiceActual) {
        int tamañoEtiquetaInicio = simbolos.getBloqueInicio().length();
        int primerCaracterRelevante = indiceActual + tamañoEtiquetaInicio;

        String comentario = "";

        while (indiceActual + tamañoEtiquetaInicio < texto.length()) {
            String siguentesCaracteres = avanzarNCaracteres(primerCaracterRelevante, tamañoEtiquetaInicio, texto);
            if (String.valueOf(siguentesCaracteres).equals(simbolos.getBloqueFin())) {
                System.out.println("se ha encontrado el fin del comentario");
            } else {
                comentario += texto.charAt(indiceActual + tamañoEtiquetaInicio);
                indiceActual++;
            }
        }

        return comentario;

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
