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
public abstract class ReconocedorToken {

    protected int ultimoIndiceUsado;
    protected SIMBOLOS simbolos;
    protected AnalizadorLexico analizador;

    public ReconocedorToken(SIMBOLOS simbolos, AnalizadorLexico analizador) {
        this.simbolos = simbolos;
        this.analizador = analizador;
    }

    public abstract boolean esCandidato(String contenido, int indiceActual); // sirve para descartar si es o no es

    protected boolean esError(String contenido, int indiceActual) {
        if (indiceActual == contenido.length() - 1) { // si está en el final del archivo
            return false;
        }

        char caracterSiguente = contenido.charAt(indiceActual + 1); // el siguente caracter
        return !(caracterSiguente == '\n') && !(caracterSiguente == ' '); // si no  es ninguno de los dos
    }

    public abstract Token analizar(String texto, int indiceActual);

    public int getUltimoIndiceUsado() {
        return ultimoIndiceUsado;
    }

    protected boolean esLetra(char parametro) {
        String[] letras = simbolos.getAbecedario();
        for (String letra : letras) {
            if (String.valueOf(parametro).equalsIgnoreCase(letra)) {
                return true;
            }
        }

        return false;
    }

    protected boolean esNumero(char parametro) {
        String[] digitos = simbolos.getDigitos();
        for (String digito : digitos) {
            if (String.valueOf(parametro).equals(digito)) {
                return true;
            }
        }
        return false;
    }

    protected void verificarSaltoLinea(char caracter) {
        if (caracter == '\n') {
            analizador.agregarLinea();
        }
    }

}
