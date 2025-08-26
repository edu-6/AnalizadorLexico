/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.backend.analisis;

import com.mycompany.analizadorlexico.backend.SIMBOLOS;
import com.mycompany.analizadorlexico.backend.analisis.reconocedores.ComentarioBloqueRecogniser;
import com.mycompany.analizadorlexico.backend.analisis.reconocedores.ComentarioLineaReconocedor;
import com.mycompany.analizadorlexico.backend.analisis.reconocedores.ErrorReconocedor;
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
    private int linea = 1;
    private int columna = 0;

    public AnalizadorLexico(SIMBOLOS simbolos) {
        this.simbolos = simbolos;
        this.reconocedores = new ReconocedorToken[]{new ComentarioBloqueRecogniser(simbolos,this)
        , new ComentarioLineaReconocedor(simbolos, this)};
    }

    public ArrayList<Token> analizar(String contenido) {
        ArrayList<Token> lista = new ArrayList<>();
        if (!contenido.isBlank()) { // si el contenido no esta vacio
            int indiceActual = 0;

            while (indiceActual < contenido.length()) {
                indiceActual = encontrarPrimerCaracterRelevante(indiceActual, contenido); // buscar el primer caracter relevante 
                if (indiceActual > -1) {
                    ReconocedorToken reconocedor = intentarReconocerToken(contenido, indiceActual); // escoger reconocedor
                    Token token = reconocedor.analizar(contenido, indiceActual);// obtener el token
                    lista.add(token); // añadir el token a una lista
                    int ultimoIndice = reconocedor.getUltimoIndiceUsado(); // obtener el indice acutal
                    indiceActual = ultimoIndice + 1; // sumarle al indice
                    System.out.println("indice actual:" + indiceActual);
                }else{
                    return lista; // ya se llegó al final del archivo
                }

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
            columna++;
            char caracter = contenido.charAt(i);
            if (caracter != '\n' && caracter != ' ') {
                return i;
            } else if (caracter == '\n') {
                agregarLinea();
            }
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
        return new ErrorReconocedor(simbolos, this);
    }

    public void agregarLinea() {
        this.linea++;
        this.columna = 0;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    public void aumentarColumna(int i) {
        this.columna += i;
    }

}
