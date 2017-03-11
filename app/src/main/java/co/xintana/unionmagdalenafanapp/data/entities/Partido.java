package co.xintana.unionmagdalenafanapp.data.entities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

import co.xintana.unionmagdalenafanapp.utilities.DataUtilities;

/**
 * Created by jmcon on 3/5/2017.
 */

public class Partido {

    private Equipo visitante;
    private Equipo local;
    private int[] marcador;
    private Date fecha;
    private Estadio estadio;
    private String torneo;
    private int jornada;

    public Partido() {
    }

    public Partido(Equipo visitante, Equipo local, int[] marcador, Date fecha, Estadio estadio, String torneo, int jornada) {
        this.visitante = visitante;
        this.local = local;
        this.marcador = marcador;
        this.fecha = fecha;
        this.estadio = estadio;
        this.torneo = torneo;
        this.jornada = jornada;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public int[] getMarcador() {
        return marcador;
    }

    public void setMarcador(int[] marcador) {
        this.marcador = marcador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public String getTorneo() {
        return torneo;
    }

    public void setTorneo(String torneo) {
        this.torneo = torneo;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    public static Partido parse(JSONObject json) {
        try {

            int[] marcador = null;
            if (!json.isNull("marcador")) {
                JSONArray jsonArray =  json.getJSONArray("marcador");
                marcador = new int[]{jsonArray.getInt(0), jsonArray.getInt(1)};
            }

            int localId = json.getInt("local");
            return new Partido(
                    DataUtilities.getEquipo(json.getInt("visitante")),
                    DataUtilities.getEquipo(localId),
                    marcador,
                    DataUtilities.parseFecha(json.getString("fecha")),
                    DataUtilities.getEstadio(localId),
                    json.getString("torneo"),
                    json.getInt("jornada")
            );
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
