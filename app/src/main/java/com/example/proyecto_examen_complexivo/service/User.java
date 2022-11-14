package com.example.proyecto_examen_complexivo.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class User {

    public static Retrofit getUser(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
