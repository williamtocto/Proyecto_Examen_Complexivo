package com.example.proyecto_examen_complexivo.modelo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsuarioService {

    @POST("create")
    Call<Usuario> addUsuario(@Body Usuario usuario);
}
