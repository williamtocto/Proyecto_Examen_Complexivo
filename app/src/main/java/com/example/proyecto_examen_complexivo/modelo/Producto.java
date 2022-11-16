package com.example.proyecto_examen_complexivo.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Producto {

    @SerializedName("idproducto")
    @Expose
    private Long id;

    @SerializedName("nombre")
    @Expose
    private String  nombre;


    @SerializedName("precio")
    @Expose
    private double precio;

    @SerializedName("imagen")
    private String foto;

    public Producto() {

    }

    public Producto(Long id, String nombre, double precio, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.foto = foto;
    }

    public Long getId() {
        return id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
