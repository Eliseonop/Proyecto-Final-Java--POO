package pe.edu.utp.isi.poo.queue.control;

public class frmServidor extends javax.swing.JFrame {
    private String direccionIP;
    private int puerto;
    private int tamanoMaximoCola;
    private int personasEnCola;
    
    public frmServidor(String direccionIP, int puerto, int tamanoMaximoCola) {
        initComponents();
 
        this.direccionIP = direccionIP;
        this.puerto = puerto;
        this.tamanoMaximoCola = tamanoMaximoCola;
                
        txtDireccionIP.setText(direccionIP);
        txtPuerto.setText(Integer.toString(puerto));
        txtTamanoMaximoCola.setText(Integer.toString(tamanoMaximoCola));
        
        personasEnCola = 0;
    }
    
    public void anotarLlegadaPersona() {
        personasEnCola++;
        txtPersonasEnCola.setText(Integer.toString(personasEnCola));        
    }
    public void anotarSalidaPersona() {
        personasEnCola--;
        txtPersonasEnCola.setText(Integer.toString(personasEnCola));        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDireccionIP = new javax.swing.JLabel();
        txtDireccionIP = new javax.swing.JTextField();
        lblPuerto = new javax.swing.JLabel();
        txtPuerto = new javax.swing.JTextField();
        lblTamanoMaximoCola = new javax.swing.JLabel();
        txtTamanoMaximoCola = new javax.swing.JTextField();
        lblPersonasEnCola = new javax.swing.JLabel();
        txtPersonasEnCola = new javax.swing.JTextField();
        btnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor | Control");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        lblDireccionIP.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblDireccionIP.setText("Dirección IP");

        txtDireccionIP.setEditable(false);
        txtDireccionIP.setBackground(new java.awt.Color(255, 255, 255));
        txtDireccionIP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDireccionIP.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblPuerto.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblPuerto.setText("Puerto");

        txtPuerto.setEditable(false);
        txtPuerto.setBackground(new java.awt.Color(255, 255, 255));
        txtPuerto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPuerto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblTamanoMaximoCola.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblTamanoMaximoCola.setText("Tamaño Máximo de la Cola");

        txtTamanoMaximoCola.setEditable(false);
        txtTamanoMaximoCola.setBackground(new java.awt.Color(255, 255, 255));
        txtTamanoMaximoCola.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTamanoMaximoCola.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblPersonasEnCola.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPersonasEnCola.setText("Personas en Cola");

        txtPersonasEnCola.setEditable(false);
        txtPersonasEnCola.setBackground(new java.awt.Color(255, 255, 204));
        txtPersonasEnCola.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        txtPersonasEnCola.setForeground(new java.awt.Color(0, 51, 255));
        txtPersonasEnCola.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPersonasEnCola.setText("0");
        txtPersonasEnCola.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPersonasEnCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPersonasEnColaActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Servidor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(170, 170, 170))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDireccionIP)
                            .addComponent(lblPuerto)
                            .addComponent(lblTamanoMaximoCola))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTamanoMaximoCola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccionIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addComponent(btnCerrar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblPersonasEnCola, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPersonasEnCola, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccionIP)
                    .addComponent(txtDireccionIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPuerto)
                    .addComponent(txtPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTamanoMaximoCola)
                    .addComponent(txtTamanoMaximoCola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(txtPersonasEnCola, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPersonasEnCola)
                .addGap(1, 1, 1)
                .addComponent(btnCerrar)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtPersonasEnColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPersonasEnColaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPersonasEnColaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblDireccionIP;
    private javax.swing.JLabel lblPersonasEnCola;
    private javax.swing.JLabel lblPuerto;
    private javax.swing.JLabel lblTamanoMaximoCola;
    private javax.swing.JTextField txtDireccionIP;
    private javax.swing.JTextField txtPersonasEnCola;
    private javax.swing.JTextField txtPuerto;
    private javax.swing.JTextField txtTamanoMaximoCola;
    // End of variables declaration//GEN-END:variables
}