/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pe.edu.utp.isi.poo.queue.tickets;

import java.awt.Color;
import java.io.ObjectOutputStream;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import pe.edu.utp.isi.poo.queue.Mensaje;
import pe.edu.utp.isi.poo.queue.Persona;
import pe.edu.utp.isi.poo.queue.Ventanilla;

/**
 *
 * @author elise
 */
public class frmTurno extends javax.swing.JFrame {

    ObjectOutputStream salida;
    //Persona persona;
    Ventanilla ventanilla;
    private java.util.List<JLabel> scrollChats = new java.util.ArrayList<>();

    public frmTurno(ObjectOutputStream salida, Ventanilla ventanilla) {
        this.ventanilla = ventanilla;
        this.salida = salida;
        initComponents();
    }

    public void agregarEmisor(String mensaje, String persona) {
        JLabel lblMensaje = new JLabel(persona + ": " + mensaje);
        lblMensaje.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMensaje.setForeground(Color.BLUE);
        scrollChats.add(lblMensaje); // Añadir el mensaje a la lista
        actualizarPanelChats(); // Actualizar el panel de mensajes
    }

    private void actualizarPanelChats() {
        panelChats.removeAll(); // Limpia el contenido del panel
        panelChats.setLayout(new javax.swing.BoxLayout(panelChats, javax.swing.BoxLayout.Y_AXIS));
        panelChats.setPreferredSize(new java.awt.Dimension(320, scrollChats.size() * 17)); // Ajusta altura según los mensajes

        for (JLabel mensaje : scrollChats) {
            JPanel mensajePanel = new JPanel(); // Panel contenedor para cada mensaje
            mensajePanel.setLayout(new javax.swing.BoxLayout(mensajePanel, javax.swing.BoxLayout.X_AXIS));
            mensajePanel.setBackground(Color.WHITE);

            if (mensaje.getHorizontalAlignment() == SwingConstants.RIGHT) {
                mensajePanel.add(javax.swing.Box.createHorizontalGlue());
            }

            mensajePanel.add(mensaje);

            if (mensaje.getHorizontalAlignment() == SwingConstants.LEFT) {
                mensajePanel.add(javax.swing.Box.createHorizontalGlue());
            }

            panelChats.add(mensajePanel);
        }

        SwingUtilities.invokeLater(() -> {
            panelChats.revalidate();
            panelChats.repaint();
            scrollPaneChats.getVerticalScrollBar().setValue(scrollPaneChats.getVerticalScrollBar().getMaximum()); // Desplaza automáticamente al final
        });
    }

    // Método para agregar un mensaje del receptor
    public void agregarReceptor(String mensaje, Persona persona) {
        JLabel lblMensaje = new JLabel(persona.getName() + ": " + mensaje);
        lblMensaje.setHorizontalAlignment(SwingConstants.LEFT);
        lblMensaje.setForeground(Color.BLACK);
        scrollChats.add(lblMensaje); // Añadir el mensaje a la lista
        actualizarPanelChats(); // Actualizar el panel de mensajes
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPersonal = new javax.swing.JLabel();
        txtChat = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        scrollPaneChats = new javax.swing.JScrollPane();
        panelChats = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Ventanilla");

        txtPersonal.setText("Personal");

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        panelChats.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelChatsLayout = new javax.swing.GroupLayout(panelChats);
        panelChats.setLayout(panelChatsLayout);
        panelChatsLayout.setHorizontalGroup(
            panelChatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );
        panelChatsLayout.setVerticalGroup(
            panelChatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        scrollPaneChats.setViewportView(panelChats);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addGap(193, 193, 193)
                .addComponent(txtPersonal)
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEnviar))
                    .addComponent(scrollPaneChats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPersonal))
                .addGap(41, 41, 41)
                .addComponent(scrollPaneChats, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        String text = txtChat.getText();
        if (text != null) {
            agregarEmisor(text, this.ventanilla.getCliente().getName());
            System.out.println("text");

            Mensaje nuevo = new Mensaje(text, this.ventanilla.getCliente(), this.ventanilla.getPersonal());

            try {
                salida.reset();
                salida.writeObject(nuevo);
                salida.flush();
            } catch (Exception e) {
                System.out.println("e- >" + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEnviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelChats;
    private javax.swing.JScrollPane scrollPaneChats;
    private javax.swing.JTextField txtChat;
    private javax.swing.JLabel txtPersonal;
    // End of variables declaration//GEN-END:variables
}
