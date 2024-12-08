package pe.edu.utp.isi.poo.queue.control;

import java.awt.List;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import pe.edu.utp.isi.poo.queue.Codigo;
import pe.edu.utp.isi.poo.queue.Cola;
import pe.edu.utp.isi.poo.queue.Mensaje;
import pe.edu.utp.isi.poo.queue.Notificacion;
import pe.edu.utp.isi.poo.queue.Persona;
import pe.edu.utp.isi.poo.queue.Ventanilla;

public class Servidor {

    CopyOnWriteArrayList<Socket> clientesConectados = new CopyOnWriteArrayList<>();
    frmServidor ofrmServidor;
    private String direccionIP;
    private int puerto;
    private int tamanoMaximoCola;
    Cola cola;
    CopyOnWriteArrayList<Ventanilla> ventanillas = new CopyOnWriteArrayList<>();
    CopyOnWriteArrayList<CanalComunicacion> canals = new CopyOnWriteArrayList<>();

    public Servidor() {
        //Leer la configuración del servidor desde un archivo de configuración
        direccionIP = "127.0.0.1";
        puerto = 5000;
        tamanoMaximoCola = 10;

    }

    public void iniciar() throws Exception {
        cola = new Cola(tamanoMaximoCola);

        ServerSocket serverSocket = new ServerSocket(puerto);
        System.out.println("Servidor iniciado en el puerto " + puerto);
        ofrmServidor = new frmServidor(direccionIP, puerto, tamanoMaximoCola);
        ofrmServidor.setVisible(true);
        cola.setOnChange(cantidad -> {
            System.out.println("Cantidad actual de elementos: " + cantidad);
            Notificacion count = new Notificacion(Codigo.COUNT_COLA, cantidad + "", null);
            enviarNotificacion(count);
        });
        while (true) {
            Socket socket = serverSocket.accept();

            clientesConectados.add(socket);

            new Thread(new CanalComunicacion(socket, this)).start();
        }
    }

    public void notificarTurno(Ventanilla vent) {
        Notificacion not = new Notificacion(Codigo.TU_TURNO, "", vent.getCliente());
        for (CanalComunicacion canal : canals) {
            if (canal.persona.getId().equals(vent.getCliente().getId())) {
                try {
                    canal.salida.writeObject(vent);
                } catch (Exception e) {
                    System.out.println("eroror" + e.getMessage());
                }

            }
        }
    }

    public void enviarMensaje(Mensaje msje) {
        for (CanalComunicacion canal : canals) {
            if (canal.persona.getId().equals(msje.getDestinatario().getId())) {
                try {
                    canal.salida.writeObject(msje);
                } catch (Exception e) {
                    System.out.println("eroror" + e.getMessage());
                }

            }
        }
    }

    public void enviarNotificacion(Notificacion msje) {
        for (CanalComunicacion canal : canals) {

            try {
                canal.salida.reset();
                canal.salida.writeObject(msje);
                canal.salida.flush();

            } catch (Exception e) {
                System.out.println("eroror" + e.getMessage());
            }

        }

    }

    public static void main(String[] args) {
        Servidor servidor = new Servidor();

        try {
            servidor.iniciar();
        } catch (Exception e) {
        }
    }
}
