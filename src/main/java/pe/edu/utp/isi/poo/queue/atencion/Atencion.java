/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.isi.poo.queue.atencion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import static pe.edu.utp.isi.poo.queue.Codigo.COLA_LLENA;
import static pe.edu.utp.isi.poo.queue.Codigo.COUNT_COLA;
import static pe.edu.utp.isi.poo.queue.Codigo.EN_COLA;
import pe.edu.utp.isi.poo.queue.Mensaje;
import pe.edu.utp.isi.poo.queue.Notificacion;
import pe.edu.utp.isi.poo.queue.Ventanilla;
import pe.edu.utp.isi.poo.queue.tickets.frmTicket;

/**
 *
 * @author elise
 */
public class Atencion {

    ObjectInputStream entrada;
    ObjectOutputStream salida;
    private Thread listenerThread;
    Socket socket;
    frmIniciarAtencion frmInitAte;
    frmAtencion frmAte;

    public static void main(String[] args) {
        try {
            Atencion at = new Atencion();
            at.iniciar();
        } catch (Exception e) {
        }
    }

    public void iniciar() throws Exception {

        this.socket = new Socket("localhost", 5000);

        iniciarEscuchaSocket();
        frmInitAte = new frmIniciarAtencion(salida);
        frmInitAte.setVisible(true);

    }

    private void iniciarEscuchaSocket() {
        listenerThread = new Thread(() -> {
            try {
                salida = new ObjectOutputStream(this.socket.getOutputStream());
                entrada = new ObjectInputStream(this.socket.getInputStream());
                Object message;

                while ((message = entrada.readObject()) != null) {

                    if (message instanceof Notificacion) {
                        System.out.println("NOTIFICACION");
                        Notificacion noty = (Notificacion) message;
                        switch (noty.getCode()) {
                            case AGREGADO_VENTANILLA:
                                System.out.println("vwentanilla agregado");
                                frmInitAte.setVisible(false);
                                frmAte = new frmAtencion(salida, noty.getPersona());
                                frmAte.setVisible(true);
                                frmAte.actualizarPersonal(noty.getPersona());

                                // Aquí puedes agregar lógica específica para manejar diferentes tipos de notificaciones
                                break;
                            case COUNT_COLA:
                                System.out.println("colaaaaaaaaaaaaaaaaaaaaaa");
                                frmAte.actualizarCola(noty.getMensaje());
                                break;
                            case COLA_VACIA:
                                JOptionPane.showMessageDialog(frmAte, "Cola vacia: ", "Error", JOptionPane.INFORMATION_MESSAGE);
                                System.out.println("Cola vacia");
                                break;
                            default:
                                System.out.println("que pasa" + noty.getCode());
                        }
                    } else if (message instanceof Mensaje mensaje) {

                        System.out.println("mensaje");
                        System.out.println("mesnaje" + mensaje.getContenido());
                        this.frmAte.agregarReceptor(mensaje.getContenido(), mensaje.getRemitente());

                    } else if (message instanceof Ventanilla) {
                        System.out.println("VENTANILLA RECIBIDA");
                        System.out.println(message);
                        this.frmAte.actualizarCliente((Ventanilla) message);

                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(frmInitAte, "Error al escuchar el socket: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        listenerThread.setDaemon(true);  // Hacer que el hilo se termine cuando se cierre la aplicación
        listenerThread.start();
    }
}
