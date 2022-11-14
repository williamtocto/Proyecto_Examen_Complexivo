package com.example.proyecto_examen_complexivo.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("usuusuario")
    @Expose
    private String usuusuario;
    @SerializedName("usu_contrasena")
    @Expose
    private String usu_contrasena;
    @SerializedName("rol_id")
    @Expose
    private String rol_id;

    public String getUsuusuario() {
        return usuusuario;
    }

    public void setUsuusuario(String usuusuario) {
        this.usuusuario = usuusuario;
    }

    public String getUsu_contrasena() {
        return usu_contrasena;
    }

    public void setUsu_contrasena(String usu_contrasena) {
        this.usu_contrasena = usu_contrasena;
    }

    public String getRol_id() {
        return rol_id;
    }

    public void setRol_id(String rol_id) {
        this.rol_id = rol_id;
    }
}