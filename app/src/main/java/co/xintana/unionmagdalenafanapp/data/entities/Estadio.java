package co.xintana.unionmagdalenafanapp.data.entities;

/**
 * Created by jmcon on 3/5/2017.
 */

public class Estadio {
    int id;
    String nombre;

    public Estadio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
