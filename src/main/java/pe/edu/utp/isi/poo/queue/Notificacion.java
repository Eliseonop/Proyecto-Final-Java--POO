/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.isi.poo.queue;

import java.io.Serializable;

/**
 *
 * @author elise
 */
public class Notificacion implements Serializable {

    Codigo code;
    String mensaje;
    Persona persona;

    public Notificacion(Codigo code, String mensaje, Persona persona) {
        this.code = code;
        this.mensaje = mensaje;
        this.persona = persona;

    }

    public Codigo getCode() {
        return code;
    }

    public Persona getPersona() {
        return persona;
    }

    public String getMensaje() {
        return mensaje;
    }

    
    
    @Override
    public String toString() {
        return "Codigo" + this.code + this.mensaje;
    }

}
