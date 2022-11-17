package com.example.proyecto_examen_complexivo.service;

import com.example.proyecto_examen_complexivo.modelo.Usuario;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import org.json.JSONArray;

import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface UsuarioService {
    @GET("listar")
    Call<List<Usuario>> getPosts();

    @POST("login")
    Call<Integer> addUsuario(@Body Usuario usuario);
}
