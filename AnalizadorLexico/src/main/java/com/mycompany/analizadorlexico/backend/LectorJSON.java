/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author edu
 */
public class LectorJSON {
    
    
    public void iniciar(){
        File achivo = new File("/home/edu/Descargas/archivo.json");
        SIMBOLOS simbolos = convertirJSON(achivo);
        simbolos.selfDescribe();
        
    }

    private String leerContenido(File file) {
        String contenido = "";
        try {
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String linea = br.readLine();
            while (linea != null) {
                contenido += linea; // agregar la linea
                linea = br.readLine();
            }
        } catch (IOException e) {
        }
        return contenido;
    }

    public SIMBOLOS convertirJSON(File file) {
        String contenido = leerContenido(file);

        String[] palabrasReservadas = convertirObjectToArray(contenido, "palabrasReservadas");
        String[] operadores = convertirObjectToArray(contenido, "operadores");
        String[] puntuacion = convertirObjectToArray(contenido, "puntuacion");
        String[] agrupacion = convertirObjectToArray(contenido, "agrupacion");

        JSONObject json = new JSONObject(contenido);
        JSONObject comentarios = json.getJSONObject("comentarios");
        
        String linea = comentarios.getString("linea");
        String bloqueInicio = comentarios.getString("bloqueInicio");
        String bloqueFin = comentarios.getString("bloqueFin");
        
        return new SIMBOLOS(palabrasReservadas, operadores, puntuacion, agrupacion, linea, bloqueInicio, bloqueFin);
    }

    private String[] convertirObjectToArray(String contenido, String nombreArray) {
        JSONObject json = new JSONObject(contenido);

        JSONArray jsonArray = json.getJSONArray(nombreArray);
        String[] nuevoArray = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            nuevoArray[i] = jsonArray.getString(i);
        }

        return nuevoArray;
    }

}
