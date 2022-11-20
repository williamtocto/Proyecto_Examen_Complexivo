package com.example.proyecto_examen_complexivo.base_temp;

import com.example.proyecto_examen_complexivo.modelo.Persona;
import com.example.proyecto_examen_complexivo.modelo.Rol;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Utilidades {


    //Esta clase se utiliza para armar las tablas

    //Constantes campos tabla persona
    public static final String TABLA_CARRITO = "carrito ";
    public static final String ID_CARRITO = "id_carrito ";
    public static final String NOMBRE_PRODUCTO = "nombre_producto ";
    public static final String CANTIDAD_CARRITO = "cantidad ";
    public static final String PRECIO = "precio ";
    public static final String DESCRIPCION_PRODUCTO = "descripcion_producto ";
    public static final String IMAGENFOTO = "IMAGEN ";


    public static final String CREAR_TABLA_CARRITO = "CREATE TABLE " +
            "" + TABLA_CARRITO + " (" + ID_CARRITO + " " +
            " TEXT PRIMARY KEY, "
            + NOMBRE_PRODUCTO + " TEXT,"
            + CANTIDAD_CARRITO + " INTEGER,"
            + PRECIO + " DOUBLE, "
            + DESCRIPCION_PRODUCTO + " TEXT,"
            + IMAGENFOTO + " TEXT)";

    public static final String TABLA_USUARIO= "create table usuario (" +
            "ud_id INTEGER PRIMARY KEY NOT NULL," +
            "usuusuario text, " +
            "usu_contrasena text, " +
            "rol_id INTEGER, " +
            "persona_id INTEGER, " +
            "estado text)";



}
