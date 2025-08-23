/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.analizadorlexico.backend.frontend;

import com.mycompany.analizadorlexico.backend.GestorArchivos;
import com.mycompany.analizadorlexico.backend.LectorDeArchivos;

/**
 *
 * @author edu
 */
public class EditorArea extends javax.swing.JPanel {

    //Backend
    private GestorArchivos gestor;
    private LectorDeArchivos lector;
    /**
     * Creates new form EditorArea
     */
    public EditorArea(GestorArchivos gestor, LectorDeArchivos lector) {
        initComponents();
        
        //Backend
        this.gestor = gestor;
        this.lector = lector;
        
        //Frontend
        this.lineaTextPane.setEditable(false);
        ocultarBarrasScroll();
    }
    
    public void cargarTexto(){
        String texto = this.lector.leerArchivoTexto(gestor.getCurrentFile());
        this.editorTextPane.setText(texto);
        actualizarNumeroLineas(texto);
    }
    
    
    private void actualizarNumeroLineas(String texto){
        String [] saltosDeLinea = texto.split("\n");
        int numeroLineas = saltosDeLinea.length;
        String textoLineas = "";
        for (int i = 0; i < saltosDeLinea.length; i++) {
            textoLineas = textoLineas +(i+1) +"\n";
        }
        
        this.lineaTextPane.setText(textoLineas);
    }
    
    private void ocultarBarrasScroll(){
        int h = javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER; // horzintal oculta
        int v = javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER; // vertical oculta
        jScrollPane2.setHorizontalScrollBarPolicy(h);
        jScrollPane2.setVerticalScrollBarPolicy(v);
        
        ScrollLIneas.setHorizontalScrollBarPolicy(h);
        ScrollLIneas.setVerticalScrollBarPolicy(v);
        
        // sincronizar las barras 
        scrollEditor.getVerticalScrollBar().addAdjustmentListener(e -> {
            ScrollLIneas.getVerticalScrollBar().setValue(e.getValue());
        });
        
        scrollEditor.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // siempre visible
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        ScrollLIneas = new javax.swing.JScrollPane();
        lineaTextPane = new javax.swing.JTextPane();
        scrollEditor = new javax.swing.JScrollPane();
        editorTextPane = new javax.swing.JTextPane();

        jScrollPane2.setViewportView(jTextPane1);

        lineaTextPane.setBackground(new java.awt.Color(204, 255, 255));
        ScrollLIneas.setViewportView(lineaTextPane);

        editorTextPane.setBackground(new java.awt.Color(204, 255, 204));
        scrollEditor.setViewportView(editorTextPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ScrollLIneas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollLIneas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
            .addComponent(scrollEditor)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollLIneas;
    private javax.swing.JTextPane editorTextPane;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane lineaTextPane;
    private javax.swing.JScrollPane scrollEditor;
    // End of variables declaration//GEN-END:variables
}
