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
public class PuntuacionReconocedor extends ReconocedorCaracterSimple {

    public PuntuacionReconocedor(SIMBOLOS simbolos, AnalizadorLexico analizador) {
        super(simbolos, analizador);
    }

    @Override
    protected void configurarAtributosEspeciales() {
        this.tipo = "puntuacion";
        this.caracteresPermitidos = simbolos.getPuntuacion();
    }
    
}
