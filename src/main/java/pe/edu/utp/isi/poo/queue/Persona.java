package pe.edu.utp.isi.poo.queue;

import java.io.Serializable;
import java.util.UUID;

public class Persona implements Serializable {

    private String id;
    private String dni;
    private String name;

    public Persona(String dni, String name) {
        this.id = UUID.randomUUID().toString();
        this.dni = dni;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Persona{dni='" + dni + "', nombre='" + name + "'}";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name.toUpperCase();
    }

    public String getDni() {
        return "N° DNI: " + dni;
    }

}
