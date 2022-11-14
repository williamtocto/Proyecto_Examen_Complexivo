package com.example.proyecto_examen_complexivo.network;

import com.example.proyecto_examen_complexivo.modelo.Categoria;
import com.example.proyecto_examen_complexivo.modelo.Producto;
import com.example.proyecto_examen_complexivo.modelo.Servicio;
import com.example.proyecto_examen_complexivo.modelo.Subcategoria;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("servicios")
    public Call<List<Servicio>> getServicio() ;

    @GET("producto")
    public Call<List<Producto>> getProducto();

    @GET("subcategoria")
    public Call<List<Subcategoria>> getSubcategoria();

    @GET("categoria")
    public Call<List<Categoria>> getCegoria();
    //servicios
    @GET("subcategoria")
    public Call<List<Subcategoria>> getSubcategoriaS();

    @GET("categoria")
    public Call<List<Categoria>> getCategoriaS();

}
