/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.backend.analisis.reconocedores;

import com.mycompany.analizadorlexico.backend.SIMBOLOS;
import com.mycompany.analizadorlexico.backend.analisis.AnalizadorLexico;

/**
 *
 * @author edu
 */
public class AgrupacionReconocedor extends ReconocedorCaracterSimple {

    public AgrupacionReconocedor(SIMBOLOS simbolos, AnalizadorLexico analizador) {
        super(simbolos, analizador);
    }

    @Override
    protected void configurarAtributosEspeciales() {
        this.tipo = "agrupacion";
        this.caracteresPermitidos = simbolos.getAgrupacion();
    }
    
    

}
