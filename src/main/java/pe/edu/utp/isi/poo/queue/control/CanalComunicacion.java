package pe.edu.utp.isi.poo.queue.control;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.utp.isi.poo.queue.Codigo;
import static pe.edu.utp.isi.poo.queue.Codigo.ATENCION;
import pe.edu.utp.isi.poo.queue.Cola;
import pe.edu.utp.isi.poo.queue.Mensaje;
import pe.edu.utp.isi.poo.queue.Notificacion;
import pe.edu.utp.isi.poo.queue.Persona;
import pe.edu.utp.isi.poo.queue.Ventanilla;
import static pe.edu.utp.isi.poo.queue.Codigo.NUEVO_VENTANILLA;
import static pe.edu.utp.isi.poo.queue.Codigo.PERSONAS_DELANTE;

public class CanalComunicacion implements Runnable {

    ObjectInputStream entrada;
    ObjectOutputStream salida;
    private Socket socket;
    private Servidor servidor;
    Persona persona;
    String idVentanilla;
    Ventanilla ventanilla;

    public CanalComunicacion(Socket socket, Servidor servidor
    ) {
        this.socket = socket;
        this.servidor = servidor;
        this.servidor.canals.add(this);

    }

    public void manejarNotificacion(Notificacion notificacion) throws IOException {
        System.out.println("NOTIFICACION");
        System.out.println("NOTIFICACION**********" + notificacion.getCode() + "**********");
        switch (notificacion.getCode()) {
            case ATENCION:
                persona = notificacion.getPersona();
                boolean resultado = this.servidor.cola.agregarObjeto(persona);
                System.out.println(resultado);

                if (resultado) {
                    Notificacion resOk = new Notificacion(Codigo.EN_COLA, "", persona);
                    System.out.println("escribiendo ");
                    this.servidor.ofrmServidor.anotarLlegadaPersona();
                    salida.writeObject(resOk);
                    salida.flush();

                } else {
                    Notificacion resNot = new Notificacion(Codigo.COLA_LLENA, "", null);
                    salida.writeObject(resNot);
                }

                break;
            case NUEVO_VENTANILLA:

                ventanilla = new Ventanilla(notificacion.getPersona());
                this.persona = notificacion.getPersona();
                this.idVentanilla = ventanilla.getId();
                System.out.println("nuevo personal en ventanilla");
                Notificacion resOk = new Notificacion(Codigo.AGREGADO_VENTANILLA, "", persona);
                salida.writeObject(resOk);
                break;

            case SIGUIENTE:
                Persona clientePrevio = this.ventanilla.getCliente();
                System.out.println("cliente previo es esto: " + clientePrevio);
                if (clientePrevio != null) {
                    System.out.println("cliente previo no es null");
                    this.ventanilla.setCliente(null);
                    this.servidor.cola.quitarObjeto();
                    this.servidor.ofrmServidor.anotarSalidaPersona();
                }
                System.out.println("llego aqui");
                if (this.servidor.cola.estaVacia()) {
                    Notificacion noty = new Notificacion(Codigo.COLA_VACIA, "ASD", null);
                    System.out.println("Esta vacia");
                    salida.writeObject(noty);
                    salida.reset();
                    salida.writeObject(this.ventanilla);
                    salida.flush();
                    break;
                }

                Persona cliente = (Persona) this.servidor.cola.getObjetos()[0];
                this.ventanilla.setCliente(cliente);
                salida.reset();
                this.servidor.notificarTurno(ventanilla);
                salida.flush();
                salida.reset();
                salida.writeObject(ventanilla);
                salida.flush();
                break;
            case PERSONAS_DELANTE:
                Integer pcola = this.servidor.cola.obtenerPosicionEnCola(this.persona);
                Notificacion notyCola = new Notificacion(Codigo.PERSONAS_DELANTE, pcola + "", null);
                salida.reset();
                salida.writeObject(notyCola);
                salida.flush();
                break;

            default:
                throw new AssertionError();
        }
    }

    @Override
    public void run() {
        try {
            //DataInputStream entrada = new DataInputStream(socket.getInputStream());
            //DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            entrada = new ObjectInputStream(socket.getInputStream());
            salida = new ObjectOutputStream(socket.getOutputStream());

            Object msje;

            while ((msje = entrada.readObject()) != null) {
                if (msje instanceof Notificacion notificacion) {
                    manejarNotificacion(notificacion);
                } else if (msje instanceof String mensaje) {
                    System.out.println("mensaje nuevo canal -> " + mensaje);
                    salida.reset();
                    Mensaje nuevo = new Mensaje(mensaje, this.ventanilla.getPersonal(), this.ventanilla.getCliente());
                    this.servidor.enviarMensaje(nuevo);
                } else if (msje instanceof Mensaje mensaje) {
                    salida.reset();
                    this.servidor.enviarMensaje(mensaje);
                    salida.flush();
                }
            }
        } catch (Exception e) {
            System.out.println("e -> " + e.getMessage());
        }
    }
}
