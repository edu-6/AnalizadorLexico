/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.backend;

import com.mycompany.analizadorlexico.backend.analisis.tokens.Token;
import java.util.ArrayList;

/**
 *
 * @author edu
 */
public class CreadorReportes {

    public ArrayList<Token> generarReportes(ArrayList<Token> lista) {

        return null;
    }

    public boolean hayErrores(ArrayList<Token> lista) {
        for (Token token : lista) {
            if (token.getTipoToken().equals("error")) { // si es tipo error
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Token> generarListaErrores(ArrayList<Token> lista){
        ArrayList<Token> nuevaLista = unificarErrores(lista); // unifica los errores
        return filtrarErrores(nuevaLista);  // elimina lo que no es error
        
    }
    
    private ArrayList<Token>  filtrarErrores(ArrayList<Token> lista){
        ArrayList<Token> nueva = new ArrayList();
        for (Token token : lista) {
            if(token.getTipoToken().equals("error")){
                nueva.add(token);
            }
        }
        return nueva;
    }

    /**
     * Une a los tokens de error seguidos
     * @param lista
     * @return 
     */
    private ArrayList<Token> unificarErrores(ArrayList<Token> lista) {
        Token tokenError = null;
        ArrayList<Token> nuevos = new ArrayList();
        for (Token token : lista) {
            if (token.getTipoToken().equals("error")) {
                if (tokenError == null) {
                    tokenError = token;
                } else {
                    tokenError.concatenarToken(token);
                }
            } else {
                if (tokenError != null) {
                    nuevos.add(tokenError);
                    tokenError = null; // vaciar token error 
                }
                nuevos.add(token);
            }
        }

        if (tokenError != null) { // para el ultimo token
            nuevos.add(tokenError);
            tokenError = null; // vaciar token error 
        }
        return nuevos;
    }
}
