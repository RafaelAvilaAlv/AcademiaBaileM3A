/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Christian
 */
public class Categoria {
    
    private int cod_categoria;
    private String nombre;
    private String tipo;
    private String asi_descripcion;

    public Categoria() {
    }

    public Categoria(int cod_categoria, String nombre, String tipo, String asi_descripcion) {
        this.cod_categoria = cod_categoria;
        this.nombre = nombre;
        this.tipo = tipo;
        this.asi_descripcion = asi_descripcion;
    }

    public int getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAsi_descripcion() {
        return asi_descripcion;
    }

    public void setAsi_descripcion(String asi_descripcion) {
        this.asi_descripcion = asi_descripcion;
    }

    @Override
    public String toString() {
        return "Categoria{" + "cod_categoria=" + cod_categoria + ", nombre=" + nombre + ", tipo=" + tipo + ", asi_descripcion=" + asi_descripcion + '}';
    }
    
    
}
