package com.example.proyecto_examen_complexivo.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Persona {
    @SerializedName("idpersona")
    @Expose
    private int idpersona;
    @SerializedName("cedula")
    @Expose
    private String cedula;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("apellido")
    @Expose
    private String apellido;
    @SerializedName("celular")
    @Expose
    private String celular;
    @SerializedName("telefono")
    @Expose
    private String telefono;
    @SerializedName("correo")
    @Expose
    private String correo;
    @SerializedName("direccion")
    @Expose
    private String direccion;


    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
