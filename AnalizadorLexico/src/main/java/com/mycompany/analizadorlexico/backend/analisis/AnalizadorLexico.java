/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.backend.analisis;

import com.mycompany.analizadorlexico.backend.SIMBOLOS;
import com.mycompany.analizadorlexico.backend.analisis.reconocedores.ComentarioBloqueRecogniser;
import com.mycompany.analizadorlexico.backend.analisis.reconocedores.ReconocedorToken;
import com.mycompany.analizadorlexico.backend.analisis.tokens.Token;
import java.util.ArrayList;

/**
 *
 * @author edu
 */
public class AnalizadorLexico {

    private SIMBOLOS simbolos;
    private ReconocedorToken[] reconocedores;
    private int numeroLinea;
    private int numeroColumna;

    public AnalizadorLexico(SIMBOLOS simbolos) {
        this.simbolos = simbolos;
        this.reconocedores = new ReconocedorToken[]{new ComentarioBloqueRecogniser(simbolos)};
    }

    public ArrayList<Token>  analizar(String contenido) {
        ArrayList<Token> lista = new ArrayList<>();
        if (!contenido.isBlank()) { // si el contenido no esta vacio
            int indiceActual = 0;
            
            while (indiceActual < contenido.length()) {
                indiceActual = encontrarPrimerCaracterRelevante(indiceActual,contenido); // buscar el primer caracter relevante 
                ReconocedorToken reconocedor = intentarReconocerToken(contenido, indiceActual); // escoger reconocedor
                Token token = reconocedor.analizar(contenido, indiceActual);// obtener el token
                lista.add(token); // añadir el token a una lista
                int ultimoIndice = reconocedor.getUltimoIndiceUsado(); // obtener el indice acutal
                indiceActual = ultimoIndice +1; // sumarle al indice
            }
        }
        return lista;
    }

    public void analizar(int indiceActual, String contenido) {
        while (indiceActual < contenido.length()) {
            // buscar el primer caracter relevante 
            // escoger reconocedor
            // analizar con el reconocedor
            // obtener el token
            // obtener el indice acutal
            // sumarle al indice actual

        }
    }

    private int encontrarPrimerCaracterRelevante(int indiceActual, String contenido) {
        for (int i = indiceActual; i < contenido.length(); i++) {
            char caracter = contenido.charAt(i);
            if (caracter != '\n' && caracter != ' ') {
                return i;
            }
            System.out.println("el caracter en posicion "+ indiceActual +"es:"+caracter);
        }
        return -1;
    }

    private ReconocedorToken intentarReconocerToken(String contenido, int indiceActual) {
        for (int i = 0; i < reconocedores.length; i++) {
            ReconocedorToken reconocedor = reconocedores[i];
            if (reconocedor.esCandidato(contenido, indiceActual)) {
                return reconocedor;
            }
        }
        return null;
    }

}
