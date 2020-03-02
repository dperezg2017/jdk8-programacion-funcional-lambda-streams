package com.util.entity;

public class Persona {

    private String nombre;
    private String apelligoPaterno;
    private String apellidoMatero;

    public Persona(String nombre, String apelligoPaterno, String apellidoMatero) {
        this.nombre = nombre;
        this.apelligoPaterno = apelligoPaterno;
        this.apellidoMatero = apellidoMatero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelligoPaterno() {
        return apelligoPaterno;
    }

    public void setApelligoPaterno(String apelligoPaterno) {
        this.apelligoPaterno = apelligoPaterno;
    }

    public String getApellidoMatero() {
        return apellidoMatero;
    }

    public void setApellidoMatero(String apellidoMatero) {
        this.apellidoMatero = apellidoMatero;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apelligoPaterno='" + apelligoPaterno + '\'' +
                ", apellidoMatero='" + apellidoMatero + '\'' +
                '}';
    }
}
