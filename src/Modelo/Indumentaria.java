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
public class Indumentaria {
    private int cod_indu;
    private String nombre;
    private String tipo;
    private double valor;
    private int fk_codevento;
    private int fk_codcate;

    public int getCod_indu() {
        return cod_indu;
    }

    public void setCod_indu(int cod_indu) {
        this.cod_indu = cod_indu;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getFk_codevento() {
        return fk_codevento;
    }

    public void setFk_codevento(int fk_codevento) {
        this.fk_codevento = fk_codevento;
    }

    public int getFk_codcate() {
        return fk_codcate;
    }

    public void setFk_codcate(int fk_codcate) {
        this.fk_codcate = fk_codcate;
    }

    
    
    
    
}
