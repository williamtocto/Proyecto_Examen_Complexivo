package com.example.proyecto_examen_complexivo.base_temp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    //Creamos nuestra base temporal que va ser utilizada siempre en la version 2
    private static final String DATABASE_NOMBRE = "basetemp.db";
    private static final int DATABASE_VERSION=2;

    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_CARRITO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CARRITO);
        onCreate(sqLiteDatabase);
    }

    public  void noQuery(String nsql ){
        this.getWritableDatabase().execSQL(nsql);
    }

    public Cursor query(String sql){
        return this.getReadableDatabase().rawQuery(sql, null);
    }

    //
}
