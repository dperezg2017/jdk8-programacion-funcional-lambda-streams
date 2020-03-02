package com.util.entity;

public class Inmueble {

    private int idInmueble;
    private String numero;
    private String piso;
    private String direccion;

    public Inmueble(int idInmueble, String numero, String piso, String direccion) {
        this.idInmueble = idInmueble;
        this.numero = numero;
        this.piso = piso;
        this.direccion = direccion;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
