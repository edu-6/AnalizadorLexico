/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.backend.analisis;

import com.mycompany.analizadorlexico.backend.SIMBOLOS;
import com.mycompany.analizadorlexico.backend.analisis.reconocedores.ComentarioBloqueRecogniser;
import com.mycompany.analizadorlexico.backend.analisis.reconocedores.ReconocedorToken;

/**
 *
 * @author edu
 */

public class AnalizadorLexico {

    private SIMBOLOS simbolos;
    private ReconocedorToken[] reconocedores;

    public AnalizadorLexico(SIMBOLOS simbolos) {
        this.simbolos = simbolos;
        this.reconocedores = new ReconocedorToken[]{new ComentarioBloqueRecogniser(simbolos)};
    }

    public void analizar(String contenido) {
        if (!contenido.isBlank()) { // si el contenido no esta vacio
            int indiceActual = encontrarPrimerCaracterRelevante(contenido);
            
           ReconocedorToken reconocedor = intentarReconocerToken(contenido,indiceActual);
        } else {
            // tirar exception de que el contenido está vacio
        }
    }

    private int encontrarPrimerCaracterRelevante(String contenido) {
        for (int i = 0; i < contenido.length(); i++) {
            char caracter = contenido.charAt(i);
            if (caracter != '\n' || caracter != ' ') {
                return i;
            }
        }
        return -1;
    }
    
    private ReconocedorToken intentarReconocerToken(String contenido, int indiceActual){
        for (int i = 0; i < reconocedores.length; i++) {
            ReconocedorToken reconocedor = reconocedores[i];
            if(reconocedor.esCandidato(contenido, indiceActual)){
                return reconocedor;
            }
        }
        
        return null;
    }

}
