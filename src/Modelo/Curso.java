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

    private int id_curso, cupos;
    private String nombre_curso;
    private Date fehca_inicio, fecha_fin;
    private String periodo;
    private String descripcion;
    private double precio;
    private String aula_des;

    public Curso() {
    }

    public Curso(int id_curso, int cupos, String nombre_curso, Date fehca_inicio, Date fecha_fin, String periodo, String descripcion, double precio, String aula_des) {
        this.id_curso = id_curso;
        this.cupos = cupos;
        this.nombre_curso = nombre_curso;
        this.fehca_inicio = fehca_inicio;
        this.fecha_fin = fecha_fin;
        this.periodo = periodo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.aula_des = aula_des;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public Date getFehca_inicio() {
        return fehca_inicio;
    }

    public void setFehca_inicio(Date fehca_inicio) {
        this.fehca_inicio = fehca_inicio;
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

    @Override
    public String toString() {
        return "Curso{" + "id_curso=" + id_curso + ", cupos=" + cupos + ", nombre_curso=" + nombre_curso + ", fehca_inicio=" + fehca_inicio + ", fecha_fin=" + fecha_fin + ", periodo=" + periodo + ", descripcion=" + descripcion + ", precio=" + precio + ", aula_des=" + aula_des + '}';
    }
    
    

}
