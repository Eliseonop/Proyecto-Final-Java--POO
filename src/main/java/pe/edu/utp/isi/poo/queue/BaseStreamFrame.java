/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.isi.poo.queue;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author elise
 */
public class BaseStreamFrame extends javax.swing.JFrame {

    //  protected DataInputStream entrada;
    //protected DataOutputStream salida;
    protected ObjectInputStream msent;
    protected ObjectOutputStream salida;
    protected Socket socket;

    public BaseStreamFrame(Socket socket) {
        this.socket = socket;
        inicializarStreams();
    }

    private void inicializarStreams() {
        try {
            //entrada = new DataInputStream(socket.getInputStream());
            //salida = new DataOutputStream(socket.getOutputStream());
            salida = new ObjectOutputStream(socket.getOutputStream());
            //msent = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al inicializar los flujos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
