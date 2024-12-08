package pe.edu.utp.isi.poo.queue;

import java.util.function.Consumer;

public class Cola {

    private Persona[] objetos; // Arreglo para almacenar los objetos de la cola
    private int indice; // Última posición ocupada en el arreglo
    private Consumer<Integer> onChange; // Callback para manejar cambios

    public Cola(int capacidad) {
        this.objetos = new Persona[capacidad]; // Inicializa el arreglo con la capacidad especificada
        this.indice = -1; // Inicializa el índice en -1 (cola vacía)
    }

    public Persona[] getObjetos() {
        return objetos;
    }

    public int obtenerPosicionEnCola(Persona persona) {
        if (persona == null) {
            return -1; // Retorna -1 si el parámetro es nulo
        }
        for (int i = 0; i <= indice; i++) {
            if (persona.getId().equals(objetos[i].getId())) { // Compara la persona con cada elemento
                return i; // Retorna la posición de la persona en la cola
            }
        }
        return -1; // Retorna -1 si no se encuentra la persona en la cola
    }

    public void setOnChange(Consumer<Integer> onChange) {
        this.onChange = onChange; // Asigna el callback que se ejecutará en cambios
    }

    public boolean agregarObjeto(Persona objeto) {
        if (indice == objetos.length - 1) {
            return false; // No se puede agregar más objetos si la cola está llena
        } else {
            objetos[++indice] = objeto; // Incrementa el índice y agrega el objeto
            notificarCambio(); // Notifica el cambio de estado
            return true;
        }
    }

    public Object quitarObjeto() {
        if (indice == -1) {
            return null; // Retorna null si la cola está vacía
        }

        Object objeto = objetos[0]; // Obtiene el primer objeto
        // Desplaza los elementos restantes hacia la izquierda
        for (int i = 1; i <= indice; i++) {
            objetos[i - 1] = objetos[i];
        }
        objetos[indice] = null; // Limpia la última posición
        indice--; // Decrementa el índice
        notificarCambio(); // Notifica el cambio de estado
        return objeto; // Retorna el objeto eliminado
    }

    public int getCantidad() {
        return indice + 1; // Retorna la cantidad de elementos en la cola
    }

    public boolean estaVacia() {
        return indice == -1; // Retorna true si la cola está vacía
    }

    public boolean estaLlena() {
        return indice == objetos.length - 1; // Retorna true si la cola está llena
    }

    private void notificarCambio() {
        if (onChange != null) {
            onChange.accept(getCantidad()); // Llama al callback con la cantidad actual
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= indice; i++) {
            sb.append(objetos[i]);
            if (i < indice) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString(); // Representación en cadena de la cola
    }
}
