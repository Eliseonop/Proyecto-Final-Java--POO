/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pe.edu.utp.isi.poo.queue.atencion;

import java.awt.Color;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import pe.edu.utp.isi.poo.queue.BaseStreamFrame;
import pe.edu.utp.isi.poo.queue.Codigo;
import pe.edu.utp.isi.poo.queue.Mensaje;
import pe.edu.utp.isi.poo.queue.Notificacion;
import pe.edu.utp.isi.poo.queue.Persona;
import pe.edu.utp.isi.poo.queue.Ventanilla;

/**
 *
 * @author elise
 */
public class frmAtencion extends javax.swing.JFrame {

    ObjectOutputStream salida;
    Persona persona;
    java.util.List<JLabel> scrollChats = new java.util.ArrayList<>();

    public frmAtencion(ObjectOutputStream salida, Persona persona) {
        this.salida = salida;
        this.persona = persona;
        initComponents();
        panelChats.setBackground(new java.awt.Color(255, 255, 255)); // Fondo blanco
        panelChats.setPreferredSize(new java.awt.Dimension(320, 235)); // Tamaño preferido

    }

    public void actualizarCliente(Ventanilla ventanilla) {
        System.out.println(ventanilla.toString());
        // Actualizar información en los componentes
        if (ventanilla.getCliente() != null) {
            nameCliente.setText(ventanilla.getCliente().getName());
            dniCliente.setText(ventanilla.getCliente().getDni());
        } else {
            nameCliente.setText("Sin cliente");
            dniCliente.setText("COLA VACIA");

        }

    }

    public void actualizarCola(String count) {
        countCola.setText(count);
    }

    public void actualizarPersonal(Persona persona) {
        personal.setText(persona.getName());
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
        JLabel lblMensaje = new JLabel(persona.getName() + ":: " + mensaje);
        lblMensaje.setHorizontalAlignment(SwingConstants.LEFT);
        lblMensaje.setForeground(Color.BLACK);
        scrollChats.add(lblMensaje); // Añadir el mensaje a la lista
        actualizarPanelChats(); // Actualizar el panel de mensajes
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitle = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        personal = new javax.swing.JLabel();
        infoCliente = new javax.swing.JPanel();
        nameCliente = new javax.swing.JLabel();
        dniCliente = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        countCola = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        txtChat = new javax.swing.JTextField();
        scrollPaneChats = new javax.swing.JScrollPane();
        panelChats = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlTitle.setText("Punto de Atencion");

        btnFinalizar.setText("Finalizar");

        btnClose.setText("Cerrar");

        personal.setText("Personal");

        infoCliente.setBackground(new java.awt.Color(255, 255, 255));
        infoCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        infoCliente.setForeground(new java.awt.Color(255, 255, 255));

        nameCliente.setText("Nombre Cliente");

        dniCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dniCliente.setForeground(new java.awt.Color(255, 153, 0));
        dniCliente.setText("7713");

        javax.swing.GroupLayout infoClienteLayout = new javax.swing.GroupLayout(infoCliente);
        infoCliente.setLayout(infoClienteLayout);
        infoClienteLayout.setHorizontalGroup(
            infoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoClienteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(nameCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(dniCliente)
                .addGap(58, 58, 58))
        );
        infoClienteLayout.setVerticalGroup(
            infoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoClienteLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(infoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameCliente)
                    .addComponent(dniCliente))
                .addGap(25, 25, 25))
        );

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        countCola.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        countCola.setForeground(new java.awt.Color(255, 102, 0));
        countCola.setText("0");

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
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
            .addGap(0, 247, Short.MAX_VALUE)
        );

        scrollPaneChats.setViewportView(panelChats);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(countCola)
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFinalizar)
                        .addGap(133, 133, 133)
                        .addComponent(btnSiguiente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose)))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(personal)
                        .addGap(247, 247, 247))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(infoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEnviar)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(scrollPaneChats, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countCola)
                    .addComponent(jlTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(personal)
                .addGap(18, 18, 18)
                .addComponent(infoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(scrollPaneChats, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizar)
                    .addComponent(btnClose)
                    .addComponent(btnSiguiente))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        scrollChats.clear();
        actualizarPanelChats();
        try {
            Notificacion noty = new Notificacion(Codigo.SIGUIENTE, "siguiente", null);
            salida.writeObject(noty);
        } catch (Exception e) {
            System.out.println("ee" + e.getMessage());
        }

    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        String text = txtChat.getText();
        if (text != null) {
            agregarEmisor(text, this.persona.getName());
            System.out.println("text");
            try {
                salida.reset();
                salida.writeObject(text);
                salida.flush();
            } catch (Exception e) {
                System.out.println("e- >" + e.getMessage());
            }
        }


    }//GEN-LAST:event_btnEnviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel countCola;
    private javax.swing.JLabel dniCliente;
    private javax.swing.JPanel infoCliente;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JLabel nameCliente;
    private javax.swing.JPanel panelChats;
    private javax.swing.JLabel personal;
    private javax.swing.JScrollPane scrollPaneChats;
    private javax.swing.JTextField txtChat;
    // End of variables declaration//GEN-END:variables
}
