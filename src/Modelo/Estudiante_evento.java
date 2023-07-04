/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Christian
 */
public class Estudiante_evento {

    private int dir_codigo, fk_codigo_est, fk_codigo_evento;
    private Date fechaEvento;
    private String descripcion;

    public Estudiante_evento() {
    }

    public Estudiante_evento(int dir_codigo, int fk_codigo_est, int fk_codigo_evento, Date fechaEvento, String descripcion) {
        this.dir_codigo = dir_codigo;
        this.fk_codigo_est = fk_codigo_est;
        this.fk_codigo_evento = fk_codigo_evento;
        this.fechaEvento = fechaEvento;
        this.descripcion = descripcion;
    }

    public int getDir_codigo() {
        return dir_codigo;
    }

    public void setDir_codigo(int dir_codigo) {
        this.dir_codigo = dir_codigo;
    }

    public int getFk_codigo_est() {
        return fk_codigo_est;
    }

    public void setFk_codigo_est(int fk_codigo_est) {
        this.fk_codigo_est = fk_codigo_est;
    }

    public int getFk_codigo_evento() {
        return fk_codigo_evento;
    }

    public void setFk_codigo_evento(int fk_codigo_evento) {
        this.fk_codigo_evento = fk_codigo_evento;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Estudiante_evento{" + "dir_codigo=" + dir_codigo + ", fk_codigo_est=" + fk_codigo_est + ", fk_codigo_evento=" + fk_codigo_evento + ", fechaEvento=" + fechaEvento + ", descripcion=" + descripcion + '}';
    }
    
    

}
