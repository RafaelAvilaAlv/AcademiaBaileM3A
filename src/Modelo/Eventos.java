/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author estef
 */
public class Eventos {
    private int cod_eve;
    private String nombre_evento;
    private String descripcion;
    private String ubicacion;

    public int getCod_eve() {
        return cod_eve;
    }

    public void setCod_eve(int cod_eve) {
        this.cod_eve = cod_eve;
    }

    public String getNombre_evento() {
        return nombre_evento;
    }

    public void setNombre_evento(String nombre_evento) {
        this.nombre_evento = nombre_evento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Eventos(int cod_eve, String nombre_evento, String descripcion, String ubicacion) {
        this.cod_eve = cod_eve;
        this.nombre_evento = nombre_evento;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    public Eventos() {
    }
    
    
           
}
