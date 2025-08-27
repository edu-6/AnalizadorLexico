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
public class OperadorReconocedor extends ReconocedorCaracterSimple {

    public OperadorReconocedor(SIMBOLOS simbolos, AnalizadorLexico analizador) {
        super(simbolos, analizador);
    }

    @Override
    protected void configurarAtributosEspeciales() {
        this.tipo = "operador";
        this.caracteresPermitidos = simbolos.getOperadores();
    }

}
