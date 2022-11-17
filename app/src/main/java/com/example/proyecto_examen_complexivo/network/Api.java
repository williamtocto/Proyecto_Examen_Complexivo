package com.example.proyecto_examen_complexivo.network;

import com.example.proyecto_examen_complexivo.modelo.CategoriaP;
import com.example.proyecto_examen_complexivo.modelo.CategoriaS;
import com.example.proyecto_examen_complexivo.modelo.Producto;
import com.example.proyecto_examen_complexivo.modelo.Servicio;
import com.example.proyecto_examen_complexivo.modelo.SubcategoriaP;
import com.example.proyecto_examen_complexivo.modelo.SubcategoriaS;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("api/servicio/listar")
    public Call<List<Servicio>> getServicio() ;

    @GET("api/prodcuto/listar")
    public Call<List<Producto>> getProducto();

  /*  @GET("api/prodcuto/listar/{id}")
    public Call<List<Producto>> getIdProducto();*/


    @GET("api/subcategoriaproducto/listar")
    public Call<List<SubcategoriaP>> getSubcategoria();

    @GET("api/categoriaproducto/listar")
    public Call<List<CategoriaP>> getCegoria();

    //servicios subcategoria
    @GET("api/subcategoriaservicio/listar")
    public Call<List<SubcategoriaS>> getSubcategoriaS();

    //servicios categoria
    @GET("api/categoriaservicio/listar")
    public Call<List<CategoriaS>> getCategoriaS();



}
