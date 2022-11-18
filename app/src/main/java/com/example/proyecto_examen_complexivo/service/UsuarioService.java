package com.example.proyecto_examen_complexivo.service;

import com.example.proyecto_examen_complexivo.modelo.Usuario;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface UsuarioService {
    @GET("listar")
    Call<List<Usuario>> getPosts();

    @POST("login")
    Call<Integer> validar_login(@Body Usuario usuario);

    @POST("crear")
    Call<Usuario> addUsuario(@Body Usuario usuario);
}
