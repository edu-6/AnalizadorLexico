/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.backend;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author edu
 */
public class EditorJsonFile {
    private GestorArchivos gestorArchivos;

    public EditorJsonFile(GestorArchivos gestorArchivos) {
        this.gestorArchivos = gestorArchivos;
    }
    
    
    public void editarJson(String contenido){
        try(FileWriter writer = new FileWriter(gestorArchivos.getJsonConfigFile())) {
            writer.write(contenido);
        } catch (IOException e) {
        }
    }

    public GestorArchivos getGestorArchivos() {
        return gestorArchivos;
    }
    
    
}
