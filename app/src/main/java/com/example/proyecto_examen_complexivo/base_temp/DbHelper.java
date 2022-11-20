package com.example.proyecto_examen_complexivo.base_temp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import com.example.proyecto_examen_complexivo.Registro_Usuario;

public class DbHelper extends   SQLiteOpenHelper {

    //Creamos nuestra base temporal que va ser utilizada siempre en la version 2
    private static final String DATABASE_NOMBRE = "basetemp.db";
    private static final int DATABASE_VERSION=2;


    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    public DbHelper(@Nullable Context context) {
        super(context,  DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_CARRITO);
        sqLiteDatabase.execSQL(Utilidades.TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CARRITO);
        sqLiteDatabase.execSQL(Utilidades.TABLA_USUARIO);
        onCreate(sqLiteDatabase);
    }

    public  void noQuery(String nsql ){
        this.getWritableDatabase().execSQL(nsql);
    }

    public Cursor query(String sql){
        return this.getReadableDatabase().rawQuery(sql, null);
    }



    //TABLA USUARIO
    public boolean agregarUsuario(long usu_id, String usuusuario, String usu_contrasena, long rol_id, int persona_id,String estado){
        SQLiteDatabase bd= getWritableDatabase();

        if (bd!=null){
            try{
                bd.execSQL("DELETE FROM usuario");
                bd.execSQL("INSERT INTO usuario VALUES("+usu_id+",'"+usuusuario+"','"+usu_contrasena+"','"+rol_id+"','"+persona_id+"','"+estado+"')");
                bd.close();
                return true;
            }catch (SQLiteConstraintException e){
                return false;
            }

        }else{
            return false;
        }
    }

}
