/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.isi.poo.queue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author elise
 */
public class Ventanilla implements Serializable {

    String id;
    Persona personal;
    Persona cliente;

    public Ventanilla(Persona personal) {
        this.id = UUID.randomUUID().toString();
        this.personal = personal;

    }

    public Persona getCliente() {
        return this.cliente;
    }
    

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public String getId() {
        return id;
    }
    

    public Ventanilla(String id, Persona personal) {
        this.id = id;
        this.personal = personal;
    }

    public void mensajeNuevo(String mensaje) {
        System.out.println(mensaje);
    }

    public Persona getPersonal() {
        return personal;
    }

    @Override
    public String toString() {
        return "qui estoy ->" + this.cliente + this.personal ;
    }

    
    
}
