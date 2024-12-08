package pe.edu.utp.isi.poo.queue.tickets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;
import pe.edu.utp.isi.poo.queue.Codigo;
import static pe.edu.utp.isi.poo.queue.Codigo.COLA_LLENA;
import static pe.edu.utp.isi.poo.queue.Codigo.EN_COLA;
import static pe.edu.utp.isi.poo.queue.Codigo.TU_TURNO;
import pe.edu.utp.isi.poo.queue.Mensaje;
import pe.edu.utp.isi.poo.queue.Notificacion;
import pe.edu.utp.isi.poo.queue.Persona;
import pe.edu.utp.isi.poo.queue.Ventanilla;

public class Plataforma {

    frmTurno turno;
    frmCliente ofrmCliente;
    Socket socket;
    ObjectInputStream entrada;
    ObjectOutputStream salida;
    private Thread listenerThread;
    frmTicket frmTickt;
    Persona cliente;

    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma();
        try {
            plataforma.iniciar();
        } catch (Exception e) {
            System.out.println("error- plataforma...");
        }
    }

    public void iniciar() throws Exception {
        this.socket = new Socket("localhost", 5000);
        iniciarEscuchaSocket();
        ofrmCliente = new frmCliente(salida);
        ofrmCliente.setVisible(true);

    }

    private void iniciarEscuchaSocket() {
        listenerThread = new Thread(() -> {
            try {
                salida = new ObjectOutputStream(this.socket.getOutputStream());
                entrada = new ObjectInputStream(this.socket.getInputStream());
                Object message;

                while ((message = entrada.readObject()) != null) {
                    if (message instanceof Notificacion notificacion) {
                        System.out.println("NOTIFICACION");
                        Notificacion noty = notificacion;
                        switch (noty.getCode()) {
                            case EN_COLA -> {
                                // Realiza las acciones necesarias con el mensaje recibido
                                System.out.println("Mensaje recibido: " + noty.getCode());
                                frmTickt = new frmTicket(noty.getPersona());
                                this.cliente = noty.getPersona();
                                ofrmCliente.setVisible(false);
                                frmTickt.setVisible(true);
                                break;
                            }
                            case COLA_LLENA -> {
                                System.out.println("cOLA LLENA recibido: " + noty.getCode());
                                break;
                            }
                            case COUNT_COLA -> {
                                System.out.println(noty.getMensaje());
                                Notificacion nuevos = new Notificacion(Codigo.PERSONAS_DELANTE, "", noty.getPersona());
                                salida.reset();
                                salida.writeObject(nuevos);
                                salida.flush();
                                System.out.println("colaaaaaaaaaaaaaaaaaaaaaa");
                                break;
                            }
                            case PERSONAS_DELANTE -> {
                                System.out.println(noty.getMensaje());
                                if (this.frmTickt != null) {
                                    this.frmTickt.modifyinCola(noty.getMensaje());
                                }
                                break;
                            }
                            case TU_TURNO -> {
                                System.out.println("tu turno");
                                //frmTickt.setVisible(false);
                                //turno = new frmTurno(salida, this.cliente);
                                //turno.setVisible(true);
                                break;
                            }

                            default -> {
                                System.out.println("que pasa" + noty.getCode());
                                break;
                            }
                        }
                    } else if (message instanceof Mensaje mensaje) {
                        Mensaje msje = mensaje;
                        System.out.println("mesnaje" + mensaje.getContenido());
                        this.turno.agregarReceptor(mensaje.getContenido(), mensaje.getRemitente());
                        //this.turno.agregarReceptor(msje.getContenido(), persona);
                    } else if (message instanceof Ventanilla vent) {
                        frmTickt.setVisible(false);
                        turno = new frmTurno(salida, vent);
                        turno.setVisible(true);
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(ofrmCliente, "Error al escuchar el socket: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        listenerThread.setDaemon(true);  // Hacer que el hilo se termine cuando se cierre la aplicación
        listenerThread.start();
    }
}
