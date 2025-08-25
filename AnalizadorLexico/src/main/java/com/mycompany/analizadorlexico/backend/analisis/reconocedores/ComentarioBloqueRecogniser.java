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

    @Override
    public String analizar(String texto, int indiceActual) {
        int tamañoEtiquetaInicio = simbolos.getBloqueInicio().length();
        int primerCaracterRelevante = indiceActual + tamañoEtiquetaInicio;
        
        indiceActual+= tamañoEtiquetaInicio; // esto es clave

        String comentario = "";

        while (indiceActual  < texto.length()) {
            String siguentesCaracteres = avanzarNCaracteres(indiceActual, tamañoEtiquetaInicio, texto);
            if (String.valueOf(siguentesCaracteres).equals(simbolos.getBloqueFin())) {
                indiceActual++;
                return generarToken(texto, indiceActual, comentario);
            } else {
                comentario += texto.charAt(indiceActual);
                indiceActual++;
            }
        }

        return "es un error"; // tirar nuevo token error porque no logró enviar antes de que fuera el fin del archivo

    }
    
    private String generarToken(String contenido, int indiceActual, String comentario){
        
        System.out.println("se ha encontrado el fin del comentario");
        System.out.println("Se está verificando si es error o es valido");
        boolean esError = this.esError(contenido, indiceActual);
        if(!this.esError(contenido, indiceActual)){ // si no es error
            return "es valido: "+ comentario;
        }
        
        return "es un error";
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
