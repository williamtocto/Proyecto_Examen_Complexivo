package com.example.proyecto_examen_complexivo.service;

import com.example.proyecto_examen_complexivo.modelo.UsuarioService;

public class Apis {

    public static final String BASE_URL = "http://10.0.2.2:8080/usuario/";


    public static UsuarioService getUsuarioService() {
        return User.getUser(BASE_URL).create(UsuarioService.class);
    }
}
