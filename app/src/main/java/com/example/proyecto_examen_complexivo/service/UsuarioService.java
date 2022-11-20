package com.example.proyecto_examen_complexivo.service;

import com.example.proyecto_examen_complexivo.modelo.Persona;
import com.example.proyecto_examen_complexivo.modelo.Usuario;


import com.google.gson.JsonArray;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface UsuarioService {
    @GET("listar")
    Call<List<Usuario>> getPosts();

    @GET("listar/{usuusuario}")
    Call<Usuario> getUser(@Path("usuusuario") String usuario);

    @POST("login")
    Call<Integer> validar_login(@Body Usuario usuario);

    @POST("crear")
    Call<Usuario> addUsuario(@Body Usuario usuario);
}
