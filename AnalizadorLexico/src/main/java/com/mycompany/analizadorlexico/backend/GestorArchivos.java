/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.backend;

import java.io.File;

/**
 *
 * @author edu
 */
public class GestorArchivos {
    private File currentFile;
    private boolean fileIsSaved;
    private File jsonConfigFile;
    private boolean jsonIsSaved;

    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
        this.fileIsSaved = true;
    }

    public void setFileIsSaved(boolean fileIsSaved) {
        this.fileIsSaved = fileIsSaved;
    }

    public void setJsonConfigFile(File jsonConfigFile) {
        this.jsonConfigFile = jsonConfigFile;
    }

    public void setJsonIsSaved(boolean jsonIsSaved) {
        this.jsonIsSaved = jsonIsSaved;
    }

    public File getCurrentFile() {
        return currentFile;
    }

    public boolean isFileIsSaved() {
        return fileIsSaved;
    }

    public File getJsonConfigFile() {
        return jsonConfigFile;
    }

    public boolean isJsonIsSaved() {
        return jsonIsSaved;
    }
    
    
    
}
