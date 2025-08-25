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
public abstract class ReconocedorToken {

    protected SIMBOLOS simbolos;
    public ReconocedorToken(SIMBOLOS simbolos) {
        this.simbolos = simbolos;
    }
    
    public abstract boolean esCandidato(String contenido, int indiceActual); // sirve para descartar si es o no es
    
    protected boolean esError(String contenido, int indiceActual){
        System.out.println("Llegamos al metodo");
        if(indiceActual == contenido.length()-1){ // si está en el final del archivo
         return false;   
        }
        
        char caracterSiguente = contenido.charAt(indiceActual+1); // el siguente caracter
        System.out.println("siguente "+caracterSiguente);
        return !(caracterSiguente ==  '\n') && !(caracterSiguente == ' '); // si no  es ninguno de los dos
    }
    
    public abstract String analizar(String texto, int indiceActual);
    
}
