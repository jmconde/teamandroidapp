package co.xintana.unionmagdalenafanapp.data.contracts;

import android.provider.BaseColumns;

/**
 * Created by jmcon on 3/5/2017.
 */

public class UMAppContract {

    public static class EstadioEntry implements BaseColumns {
        public static final String TABLE_NAME = "estadios";

        public static final String COLUMN_NOMBRE = "nombre";
        public static final String COLUMN_CIUDAD = "ciudad";
        public static final String COLUMN_CAPACIDAD = "capacidad";
    }

    public static class EquipoEntry implements BaseColumns{
        public static final String TABLE_NAME = "equipos";

        public static final String COLUMN_NOMBRE = "nombre";
        public static final String COLUMN_ESTADIO = "estadioId";
        public static final String COLUMN_ICON = "iconId";
        public static final String COLUMN_SHORT_NAME = "nombre_corto";
    }

    public static class TorneoEntry implements BaseColumns {
        public static final String TABLE_NAME = "torneos";

        public static final String COLUMN_NOMBRE = "nombre";
        public static final String COLUMN_CATEGORIA = "categoria";
    }
}
