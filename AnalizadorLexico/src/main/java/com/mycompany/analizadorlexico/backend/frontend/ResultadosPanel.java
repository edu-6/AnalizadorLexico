/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.analizadorlexico.backend.frontend;

import com.mycompany.analizadorlexico.backend.analisis.tokens.Token;
import com.mycompany.analizadorlexico.backend.exceptions.JsonNotFoundException;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author edu
 */
public class ResultadosPanel extends javax.swing.JPanel {

    private AnalizadorFrame analizador;
    private PanelOpciones panelOpciones;
    private ReportesPanel panelReportes;
    /**
     * Creates new form ResultadosPanel
     */
    public ResultadosPanel(AnalizadorFrame analizador) {
        initComponents();
        this.analizador = analizador;
        this.setLayout( new BorderLayout());
        this.panelReportes = new ReportesPanel();
        this.panelOpciones = new PanelOpciones(analizador,panelReportes);
        this.add(panelOpciones, BorderLayout.CENTER);
        
        this.add(panelReportes, BorderLayout.SOUTH);
        this.analizador = analizador;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1044, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
