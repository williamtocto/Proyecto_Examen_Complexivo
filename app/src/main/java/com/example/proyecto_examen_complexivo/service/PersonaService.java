package com.example.proyecto_examen_complexivo.service;

import com.example.proyecto_examen_complexivo.modelo.Persona;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface PersonaService {
    @POST("crear")
    Call<Persona> createPerson(@Body Persona persona);
}
