/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Christian
 */
public class Curso {

    private int pk_idcurso;
    private String nombre_curso;
    private Date fehca_ini;
    private Date fecha_fin;
    private String periodo;
    private String descripcion;
    private int cupos;
    private double precio;
    private String aula_des;

    public Curso() {
    }

    public Curso(int pk_idcurso, String nombre_curso, Date fehca_ini, Date fecha_fin, String periodo, String descripcion, int cupos, double precio, String aula_des) {
        this.pk_idcurso = pk_idcurso;
        this.nombre_curso = nombre_curso;
        this.fehca_ini = fehca_ini;
        this.fecha_fin = fecha_fin;
        this.periodo = periodo;
        this.descripcion = descripcion;
        this.cupos = cupos;
        this.precio = precio;
        this.aula_des = aula_des;
    }

    public int getPk_idcurso() {
        return pk_idcurso;
    }

    public void setPk_idcurso(int pk_idcurso) {
        this.pk_idcurso = pk_idcurso;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public Date getFehca_ini() {
        return fehca_ini;
    }

    public void setFehca_ini(Date fehca_ini) {
        this.fehca_ini = fehca_ini;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getAula_des() {
        return aula_des;
    }

    public void setAula_des(String aula_des) {
        this.aula_des = aula_des;
    }    
    
}
