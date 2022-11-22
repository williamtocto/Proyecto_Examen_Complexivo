package com.example.proyecto_examen_complexivo.datos_sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;
import com.example.proyecto_examen_complexivo.R;
import com.example.proyecto_examen_complexivo.base_temp.DbHelper;
import com.example.proyecto_examen_complexivo.modelo.Persona;
import com.example.proyecto_examen_complexivo.modelo.Usuario;


import java.util.ArrayList;

public class CargarUsuario {
    
    private Context context;
    private ArrayList<Usuario> usuarioArrayList= new ArrayList<>();

    public CargarUsuario(Context context) {
        this.context = context;
    }

    public ArrayList<Usuario> listarUsuarioP(){

        DbHelper base= new DbHelper(context);
        SQLiteDatabase open= base.getReadableDatabase();
        Cursor fila= open.rawQuery("select * from usuario",null );
        if (fila.moveToFirst()){
            System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
            do{
                Usuario usuario= new Usuario();
                usuario.setUsu_id(fila.getLong(1));
                usuario.setUsuusuario(fila.getString(2));
                usuario.setUsu_contrasena(fila.getString(3));
                Persona p=new Persona();
                p.setNombre(fila.getString(4));
                p.setApellido(fila.getString(5));
                usuario.setIdpersona(p);
                usuarioArrayList.add(usuario);
            }while (fila.moveToNext());
            base.close();
            open.close();

            return usuarioArrayList;

        }else{
            Toast.makeText(context, "No olvides registrarte", Toast.LENGTH_LONG).show();
            return null;
        }
    }
}
