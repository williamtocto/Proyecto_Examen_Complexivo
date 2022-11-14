package com.example.proyecto_examen_complexivo.service;

import com.example.proyecto_examen_complexivo.modelo.Usuario;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface UsuarioInterface {
    @GET("listar")
    Call <List<Usuario>> getPosts();
}
