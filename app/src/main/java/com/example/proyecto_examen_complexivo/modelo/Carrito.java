package com.example.proyecto_examen_complexivo.modelo;

import android.content.Context;
import android.database.Cursor;

import com.example.proyecto_examen_complexivo.base_temp.DbHelper;
import com.example.proyecto_examen_complexivo.base_temp.Utilidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Carrito implements Serializable {




    private String Id_producto;
    private String nombre_producto;
    private double precio_producto;
    private String descricpion_producto;
    private String img;
    private int cantidad;
    private double total_precio;
    ArrayList<Carrito> comprados;


    public Carrito() {
    }

    public Carrito(String id_producto, String nombre_producto, double precio_producto, String descricpion_producto, String img, int cantidad, double total_precio, ArrayList<Carrito> comprados) {
        Id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.precio_producto = precio_producto;
        this.descricpion_producto = descricpion_producto;
        this.img = img;
        this.cantidad = cantidad;
        this.total_precio = total_precio;
        this.comprados = comprados;
    }

    public double getTotal_precio() {
        return total_precio;
    }

    public void setTotal_precio(double total_precio) {
        this.total_precio = total_precio;
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

    //Listar Carrito
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

    //Actualizar Carrito
    public void ActualizarCarrito(Context context, String id){
        DbHelper dbHelper = new DbHelper(context);
        String nosql = "UPDATE "+Utilidades.TABLA_CARRITO+" SET "+
                " cantidad='"+getCantidad()+"' "+
                " WHERE id_carrito='"+id+"';";
        dbHelper.noQuery(nosql);
        dbHelper.close();
    }

    //Eliminar del Carrito
    public void EliminarCarrito(Context context, String id){
        DbHelper dbHelper = new DbHelper(context);
        String nosql = "DELETE FROM "+ Utilidades.TABLA_CARRITO+" WHERE id_carrito='"+id+"';";
        dbHelper.noQuery(nosql);
        dbHelper.close();
    }






}
