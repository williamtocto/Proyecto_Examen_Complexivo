package com.example.proyecto_examen_complexivo.service;

import com.example.proyecto_examen_complexivo.modelo.Persona;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface PersonaInterface {
    @GET("listar")
    Call<List<Persona>> getPosts();
}
