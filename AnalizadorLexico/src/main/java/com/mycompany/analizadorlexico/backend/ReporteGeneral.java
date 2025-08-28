/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.backend;

/**
 *
 * @author edu
 */
public class ReporteGeneral {
    private int cantidadErrores;
    private String porcentajeValidos;
    private String tokensNoUsados;

    public ReporteGeneral(int cantidadErrores, String porcentajeValidos, String tokensNoUsados) {
        this.cantidadErrores = cantidadErrores;
        this.porcentajeValidos = porcentajeValidos;
        this.tokensNoUsados = tokensNoUsados;
    }

    public String getReporte(){
        String reporte = "CANTIDAD ERRORES: "+ cantidadErrores +"\n"
                + "PORCENTAJE TOKENS VALIDOS: "+ porcentajeValidos+"\n"
                + "TOKENS NO USADOS:"+"\n" + tokensNoUsados;
        return reporte;
    }
    
    
    
}
