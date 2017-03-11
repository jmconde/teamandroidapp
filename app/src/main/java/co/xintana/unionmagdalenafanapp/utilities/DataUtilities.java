package co.xintana.unionmagdalenafanapp.utilities;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import co.xintana.unionmagdalenafanapp.R;
import co.xintana.unionmagdalenafanapp.data.ActualidadInfo;
import co.xintana.unionmagdalenafanapp.data.entities.Equipo;
import co.xintana.unionmagdalenafanapp.data.entities.Estadio;
import co.xintana.unionmagdalenafanapp.data.entities.Partido;

/**
 * Created by jmcon on 3/4/2017.
 */

public class DataUtilities {
    public static final int ID_EQUIPO_PRINCIPAL = 33;

    public static ActualidadInfo populate(JSONObject json) {
        ActualidadInfo actualidadInfo = new ActualidadInfo();
        try {
            actualidadInfo.setUltimo(Partido.parse(json.getJSONObject("ultimo")));
            actualidadInfo.setSiguiente(Partido.parse(json.getJSONObject("siguiente")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return actualidadInfo;
    }
    public static Equipo getEquipo(int id) {
        return new Equipo(id,
                getEquipoNombre(id),
                id,
                getEquipoIcon(id));
    }

    public static Estadio getEstadio(int id) {
        return new Estadio(id, DataUtilities.getNombreEstadio(id));
    }

    public static int getEquipoIcon(int id) {
        Log.d("UMAPP " + DataUtilities.class.getSimpleName(), "Requiriendo icono: " + String.valueOf(id));
        switch (id){
            case 0:
                return R.drawable.ic_aguilas_doradas;
            case 1:
                return R.drawable.ic_alianza_petrolera;
            case 2:
                return R.drawable.ic_america;
            case 3:
                return R.drawable.ic_atletico;
            case 4:
                return R.drawable.ic_barranquilla_fc;
            case 5:
                return R.drawable.ic_bogota;
            case 6:
                return R.drawable.ic_bucaramanga;
            case 7:
                return R.drawable.ic_cali;
            case 8:
                return R.drawable.ic_chico;
            case 9:
                return R.drawable.ic_cortulua;
            case 10:
                return R.drawable.ic_cucuta;
            case 11:
                return R.drawable.ic_deportes_tolima;
            case 12:
                return R.drawable.ic_dim;
            case 13:
                return R.drawable.ic_envigado;
            case 14:
                return R.drawable.ic_equidad;
            case 15:
                return R.drawable.ic_fortaleza;
            case 16:
                return R.drawable.ic_huila;
            case 17:
                return R.drawable.ic_jaguares;
            case 18:
                return R.drawable.ic_junior;
            case 19:
                return R.drawable.ic_leones;
            case 20:
                return R.drawable.ic_llaneros;
            case 21:
                return R.drawable.ic_millonarios;
            case 22:
                return R.drawable.ic_nacional;
            case 23:
                return R.drawable.ic_once_caldas;
            case 24:
                return R.drawable.ic_orsomarso;
            case 25:
                return R.drawable.ic_pasto;
            case 26:
                return R.drawable.ic_patriotas;
            case 27:
                return R.drawable.ic_pereira;
            case 28:
                return R.drawable.ic_quindio;
            case 29:
                return R.drawable.ic_real_cartagena;
            case 30:
                return R.drawable.ic_real_santander;
            case 31:
                return R.drawable.ic_santa_fe;
            case 32:
                return R.drawable.ic_tigres_fc;
            case 33:
                return R.drawable.ic_union_magdalena;
            case 34:
                return R.drawable.ic_universitario_popayan;
            case 35:
                return R.drawable.ic_valledupar;
            default:
                throw new UnsupportedOperationException("Codigo de equipo no encotnrado");
        }

    }

    public static Boolean esLocal(Partido partido) {
        return partido.getLocal().getId() == ID_EQUIPO_PRINCIPAL;
    }

    public static String getEquipoNombre(int id) {
        switch (id) {
            case 0:
                return "Rionegro Águilas";
            case 1:
                return "Alianza Petrolera";
            case 2:
                return "América";
            case 3:
                return "Atlético F.C.";
            case 4:
                return "Barranquilla F.C.";
            case 5:
                return "Bogotá F.C.";
            case 6:
                return "Atlético Bucaramanga";
            case 7:
                return "Deportivo Cali";
            case 8:
                return "Boyacá Chicó";
            case 9:
                return "Cortuluá";
            case 10:
                return "Cúcuta Deportivo";
            case 11:
                return "Deportes Tolima";
            case 12:
                return "Independiente Medellín";
            case 13:
                return "Envigado";
            case 14:
                return "Equidad";
            case 15:
                return "Fortaleza C.E.I.F.";
            case 16:
                return "Atlético Huila";
            case 17:
                return "Jaguares F.C.";
            case 18:
                return "Junior";
            case 19:
                return "Leones F.C.";
            case 20:
                return "Llaneros F.C.";
            case 21:
                return "Millonarios";
            case 22:
                return "Atlético Nacional";
            case 23:
                return "Once Caldas";
            case 24:
                return "Orsomarso";
            case 25:
                return "Deportivo Pasto";
            case 26:
                return "Patriotas";
            case 27:
                return "Deportivo Pereira";
            case 28:
                return "Deportes Quindio";
            case 29:
                return "Real Cartagena";
            case 30:
                return "Real Santander";
            case 31:
                return "Santa Fe";
            case 32:
                return "Tigres F.C.";
            case 33:
                return "Unión Magdalena";
            case 34:
                return "Universitario de Popayán";
            case 35:
                return "Valledupar F.C.";
            default:
                throw new UnsupportedOperationException("Codigo de equipo no encotnrado");
        }
    }

    public static String getNombreEstadio(int id) {
        switch (id){
            case 0:
                return "Alberto Grisales";
            case 1:
                return "Daniel Villa Zapata";
            case 2:
                return "Pascual Guerrero";
            case 3:
                return "Pascual Guerrero";
            case 4:
                return "Metropolitano Roberto Meléndez";
            case 5:
                return "Bogotá F.C.";
            case 6:
                return "Alfonso López";
            case 7:
                return "Deportivo Cali";
            case 8:
                return "La Independencia";
            case 9:
                return "Pascual Guerrero";
            case 10:
                return "Los Zipas";
            case 11:
                return "Manuel Murillo Toro";
            case 12:
                return "Atanasio Girardot";
            case 13:
                return "Polideportivo Sur";
            case 14:
                return "Metropolitano de Techo";
            case 15:
                return "Metropolitano de Techo";
            case 16:
                return "Atlético Huila";
            case 17:
                return "Municipal de Montería";
            case 18:
                return "Metropolitano Roberto Meléndez";
            case 19:
                return "John Jairo Tréllez";
            case 20:
                return "Manuel Calle Lombana";
            case 21:
                return "Nemesio Camacho El Campín";
            case 22:
                return "Atanasio Girardot";
            case 23:
                return "Palogrande";
            case 24:
                return "Francisco Rivera Escobar";
            case 25:
                return "Departamental Libertad";
            case 26:
                return "La Independencia";
            case 27:
                return "Hernán Ramírez Villegas";
            case 28:
                return "Centenario";
            case 29:
                return "Olímpico Jaime Morón León";
            case 30:
                return "Álvaro Gómez Hurtado";
            case 31:
                return "Nemesio Camacho El Campín";
            case 32:
                return "Metropolitano de Techo";
            case 33:
                return "Diego Carvajal";
            case 34:
                return "Ciro López";
            case 35:
                return "Armando Maestre Pavajeau";
            default:
                throw new UnsupportedOperationException("Codigo de equipo no encotnrado");
        }

    }

    public static Date parseFecha(String fecha){
        SimpleDateFormat df = new SimpleDateFormat("EEE MMM dd yyyy kk:mm:ss z", Locale.ENGLISH);
        try {
            return df.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getDiaMes(Date date) {
        SimpleDateFormat fechaSDF = new SimpleDateFormat("d MMM", Locale.getDefault());
        return fechaSDF.format(date);
    }

    public static String getDia(Date date) {
        SimpleDateFormat fechaSDF = new SimpleDateFormat("d", Locale.getDefault());
        return fechaSDF.format(date);
    }

    public static String getMes(Date date) {
        SimpleDateFormat fechaSDF = new SimpleDateFormat("MMM", Locale.getDefault());
        return fechaSDF.format(date);
    }

    public static String getHora(Date date) {
        SimpleDateFormat horaSDF = new SimpleDateFormat("h:mma", Locale.getDefault());
        return horaSDF.format(date);
    }

    public static String getDiaSemana(Date date) {
        SimpleDateFormat diaSDF = new SimpleDateFormat("EEEE", Locale.getDefault());
        return diaSDF.format(date);
    }
}
