package com.example.proyecto_examen_complexivo.modelo;

import android.content.Context;
import android.database.Cursor;

import com.example.proyecto_examen_complexivo.base_temp.DbHelper;

import java.util.ArrayList;

public class Carrito {

    private String Id_producto;
    private String nombre_producto;
    private double precio_producto;
    private String descricpion_producto;
    private String img;
    private int cantidad;
    ArrayList<Carrito> comprados;


    public Carrito() {
    }

    public Carrito(String id_producto, String nombre_producto, double precio_producto, String descricpion_producto, String img, int cantidad) {
        Id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.precio_producto = precio_producto;
        this.descricpion_producto = descricpion_producto;
        this.img = img;
        this.cantidad = cantidad;
    }

    public String getId_producto() {
        return Id_producto;
    }

    public void setId_producto(String id_producto) {
        Id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(double precio_producto) {
        this.precio_producto = precio_producto;
    }

    public String getDescricpion_producto() {
        return descricpion_producto;
    }

    public void setDescricpion_producto(String descricpion_producto) {
        this.descricpion_producto = descricpion_producto;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
//En esta parte realizamos nuestras consultas
    public void Guardar(Context context){
        DbHelper dbhelper = new DbHelper(context, "basetemp", null, 2);
        String nsql = "INSERT INTO carrito (id_carrito, nombre_producto, cantidad, precio, descripcion_producto, IMAGEN) "+
                "VALUES ('"+getId_producto()+"', '"+getNombre_producto()+"', '"+getCantidad()+"', '"+getPrecio_producto()+"', '"+getDescricpion_producto()+"', '"+getImg()+"')";
        dbhelper.noQuery(nsql);
        dbhelper.close();
    }

    public ArrayList<Carrito> getcomprados(Context context){
        DbHelper dbHelper = new DbHelper(context, "basetemp", null, 2);
        String sql = "SELECT * FROM carrito;";
        comprados = new ArrayList<>();
        Cursor cursor = dbHelper.query(sql);
        while (cursor.moveToNext()){
            Carrito carritoActual = new Carrito();
            carritoActual.setId_producto(cursor.getString(0));
            carritoActual.setNombre_producto(cursor.getString(1));
            carritoActual.setCantidad(cursor.getInt(2));
            carritoActual.setPrecio_producto(cursor.getDouble(3));
            carritoActual.setDescricpion_producto(cursor.getString(4));
            carritoActual.setImg(cursor.getString(5));
            comprados.add(carritoActual);
            dbHelper.close();
        }
        return comprados;
    }





}
