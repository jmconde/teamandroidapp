package co.xintana.unionmagdalenafanapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import co.xintana.unionmagdalenafanapp.data.contracts.UMAppContract.EquipoEntry;
import co.xintana.unionmagdalenafanapp.data.contracts.UMAppContract.EstadioEntry;
import co.xintana.unionmagdalenafanapp.data.contracts.UMAppContract.TorneoEntry;

/**
 * Created by jmcon on 3/5/2017.
 */

public class UMAppDbHelper extends SQLiteOpenHelper {
    private static final String TAG = "UMAPP " +  UMAppDbHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "unionfanapp.db";
    private static final int DATABASE_VERSION = 1;

    public UMAppDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_ESTADIOS_TABLE = "CREATE TABLE " + EstadioEntry.TABLE_NAME + "(" +
                EstadioEntry._ID + " INTEGER PRIMARY KEY," +
                EstadioEntry.COLUMN_NOMBRE + " TEXT NOT NULL," +
                EstadioEntry.COLUMN_CIUDAD + " TEXT NOT NULL," +
                EstadioEntry.COLUMN_CAPACIDAD + " INTEGER NOT NULL," +
                ");";
        final String SQL_CREATE_EQUIPOS_TABLE = "CREATE TABLE " + EquipoEntry.TABLE_NAME + "(" +
                EquipoEntry._ID + " INTEGER PRIMARY KEY," +
                EquipoEntry.COLUMN_NOMBRE + " TEXT NOT NULL," +
                EquipoEntry.COLUMN_SHORT_NAME + " TEXT NOT NULL," +
                EquipoEntry.COLUMN_ESTADIO + " INTEGER NOT NULL," +
                EquipoEntry.COLUMN_ICON + " INTEGER NOT NULL"+
                ",FOREIGN KEY(trackartist) REFERENCES " + EstadioEntry.TABLE_NAME + "(" + EstadioEntry._ID + ")" +
                ");";
        final String SQL_CREATE_TORNEOS_TABLE = "CREATE TABLE " + TorneoEntry.TABLE_NAME + "(" +
                TorneoEntry._ID + " INTEGER PRIMARY KEY," +
                TorneoEntry.COLUMN_NOMBRE + " TEXT NOT NULL," +
                TorneoEntry.COLUMN_CATEGORIA + " TEXT NOT NULL," +
                ");";

        Log.d(TAG, SQL_CREATE_ESTADIOS_TABLE);
        db.execSQL(SQL_CREATE_ESTADIOS_TABLE);
        Log.d(TAG, SQL_CREATE_EQUIPOS_TABLE);
        db.execSQL(SQL_CREATE_EQUIPOS_TABLE);
        Log.d(TAG, SQL_CREATE_TORNEOS_TABLE);
        db.execSQL(SQL_CREATE_TORNEOS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EquipoEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + EstadioEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TorneoEntry.TABLE_NAME);
        onCreate(db);
    }
}
