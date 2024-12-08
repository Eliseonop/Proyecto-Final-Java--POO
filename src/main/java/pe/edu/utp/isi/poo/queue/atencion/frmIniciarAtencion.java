/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pe.edu.utp.isi.poo.queue.atencion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import pe.edu.utp.isi.poo.queue.BaseStreamFrame;
import pe.edu.utp.isi.poo.queue.Codigo;
import pe.edu.utp.isi.poo.queue.Notificacion;
import pe.edu.utp.isi.poo.queue.Persona;
import pe.edu.utp.isi.poo.queue.Ventanilla;

/**
 *
 * @author elise
 */
public class frmIniciarAtencion extends javax.swing.JFrame {

    Boolean iniciado;
    String colaCount;
    ObjectOutputStream salida;

    public frmIniciarAtencion(ObjectOutputStream salida) {
        this.salida = salida;
        initComponents();
        configurarKeyBindings();
    }

    private void iniciarAtencion(String dni, String name) {
        try {
            Persona p1 = new Persona(dni, name);

            Notificacion noty = new Notificacion(Codigo.NUEVO_VENTANILLA, "xs", p1);
            salida.writeObject(noty);

            salida.flush();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al comunicarse con el servidor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void configurarKeyBindings() {
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getRootPane().getActionMap();

        // Asociar la tecla Enter con una acción personalizada
        inputMap.put(KeyStroke.getKeyStroke("ENTER"), "enviarDNI");

        // Definir la acción de enviar el DNI
        actionMap.put("enviarDNI", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String dni = txtDni.getText().trim();
                String name = txtName.getText().trim();
                if (!dni.isEmpty()) {
                    iniciarAtencion(dni, name);
                } else {
                    JOptionPane.showMessageDialog(frmIniciarAtencion.this, "Por favor, ingrese un DNI.", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btcIniciar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Iniciar Atencion");

        jLabel2.setText("Nombre");

        btcIniciar.setText("Iniciar");
        btcIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcIniciarActionPerformed(evt);
            }
        });

        jButton2.setText("Cerrar");

        jLabel3.setText("DNI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btcIniciar))
                    .addComponent(txtDni))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addComponent(btcIniciar)
                .addGap(29, 29, 29)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btcIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcIniciarActionPerformed
        // TODO add your handling code here:
        String dni = txtDni.getText().trim();
        String name = txtName.getText().trim();
        if (!dni.isEmpty()) {
            iniciarAtencion(dni, name);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un DNI.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btcIniciarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcIniciar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
