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
public class ErrorReconocedor extends ReconocedorToken {

    public ErrorReconocedor(SIMBOLOS simbolos) {
        super(simbolos);
    }

    @Override
    public boolean esCandidato(String contenido, int indiceActual) {
        return true;
    }

    @Override
    public Token analizar(String texto, int indiceActual) {
        return new Token("error", String.valueOf(texto.charAt(indiceActual)),1,1); // reportar nuevo error
    }

}
