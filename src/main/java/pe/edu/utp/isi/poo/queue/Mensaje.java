/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.isi.poo.queue;

import java.time.LocalDateTime;

import java.io.Serializable;

/**
 *
 * @author elise
 */
public class Mensaje implements Serializable {

    private String contenido;
    private Persona remitente;
    private Persona destinatario;

    public Mensaje(String contenido, Persona remitente, Persona destinatario) {
        this.contenido = contenido;
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

   
    public String getContenido() {
        return contenido;
    }

    public Persona getRemitente() {
        return remitente;
    }

    public Persona getDestinatario() {
        return destinatario;
    }

    @Override
    public String toString() {
        return remitente + " -> " + destinatario + ": " + contenido;
    }
}
