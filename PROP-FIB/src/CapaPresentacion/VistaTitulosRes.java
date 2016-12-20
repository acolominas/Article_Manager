/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaPresentacion;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Casa
 */
public class VistaTitulosRes extends javax.swing.JDialog {

    /**
     * Creates new form VistaTitulosRes
     */
    public VistaTitulosRes(java.awt.Frame parent, boolean modal,ArrayList<String> titulos) {
        super(parent, modal);
        initComponents();
        DefaultTableModel modelo = new DefaultTableModel();
        jTable1.setModel(modelo);        
        modelo.addColumn("TITULOS");
        Iterator<String> it = titulos.iterator();
        while(it.hasNext()){
            String titulo = it.next(); 
            Object [] obj = new Object[1];
            obj[0] = titulo;            
            modelo.addRow(obj);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonCerrar.setText("Cerrar");
        buttonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 307, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Mostrar Titulos de Autor");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 23, 630, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 710, 210));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}