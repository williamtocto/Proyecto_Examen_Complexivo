package com.example.proyecto_examen_complexivo.network;

import com.example.proyecto_examen_complexivo.modelo.CategoriaP;
import com.example.proyecto_examen_complexivo.modelo.CategoriaS;
import com.example.proyecto_examen_complexivo.modelo.Persona;
import com.example.proyecto_examen_complexivo.modelo.Producto;
import com.example.proyecto_examen_complexivo.modelo.Servicio;
import com.example.proyecto_examen_complexivo.modelo.SubcategoriaP;
import com.example.proyecto_examen_complexivo.modelo.SubcategoriaS;
import com.example.proyecto_examen_complexivo.modelo.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

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

    //buscar product categoria
    @GET("api/prodcuto/listar/categoria/{id}")
    Call<List<Producto>> getProductoCat(@Path("id") long id);

    //buscar product subcategoria
    @GET("api/prodcuto/listar/subcategoria/{id}")
    Call<List<Producto>> getProductoSub(@Path("id") long id);

    //buscar servicio categoria
    @GET("api/servicio/listar/categoria/{id}")
    Call<List<Servicio>> getServicioCat(@Path("id") long id);

    //buscar servicio subcategoria
    @GET("api/servicio/listar/subcategoria/{id}")
    Call<List<Servicio>> getServicioSub(@Path("id") long id);

    @GET("/api/usuario/listar/{usuusuario}")
    Call<Usuario> getusuario(@Path("usuusuario") String usuusuario);
    //Call<List<Usuario>> getusuario(@Path("usuusuario") String usuusuario);

    @GET("/api/usuario/listar/{usuusuario}")
    Call<Persona> getpersona(@Path("usuusuario") String usuusuario);

}
