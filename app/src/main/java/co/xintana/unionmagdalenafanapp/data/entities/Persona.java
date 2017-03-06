package co.xintana.unionmagdalenafanapp.data.entities;

/**
 * Created by jmcon on 3/5/2017.
 */

public class Persona {
    private long id;
    private String nombre;
    private String apellido;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
