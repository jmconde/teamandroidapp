package co.xintana.unionmagdalenafanapp.data.entities;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by jmcon on 3/5/2017.
 */

public class Equipo {
    private int id;
    private String nombre;
    private int estadio;
    private int icon;
    private List<Jugador> plantilla;

    public Equipo(int id, String nombre, int estadio, int icon) {
        this.id = id;
        this.nombre = nombre;
        this.estadio = estadio;
        this.icon = icon;
    }

    public Equipo(int id, String nombre, int estadio, int icon, List<Jugador> plantilla) {
        this.id = id;
        this.nombre = nombre;
        this.estadio = estadio;
        this.icon = icon;
        this.plantilla = plantilla;
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

    public int getEstadio() {
        return estadio;
    }

    public void setEstadio(int estadio) {
        this.estadio = estadio;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public List<Jugador> getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(List<Jugador> plantilla) {
        this.plantilla = plantilla;
    }
}
