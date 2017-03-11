package co.xintana.unionmagdalenafanapp.data;

import java.util.Date;

import co.xintana.unionmagdalenafanapp.data.entities.Partido;

/**
 * Created by jmcon on 3/4/2017.
 */

public class ActualidadInfo {
    Partido ultimo;
    Partido siguiente;

    public Partido getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Partido siguiente) {
        this.siguiente = siguiente;
    }

    public Partido getUltimo() {

        return ultimo;
    }

    public void setUltimo(Partido ultimo) {
        this.ultimo = ultimo;
    }
}
