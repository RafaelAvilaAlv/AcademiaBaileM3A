/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Curso_Horario {
     private int idcursoh;
    private int idcurso;
    private Date fechaasignatura;
    private int codhorario;
    private String estado;

    public Curso_Horario() {
    }

    public Curso_Horario(int idcursoh, int idcurso, Date fechaasignatura, int codhorario, String estado) {
        this.idcursoh = idcursoh;
        this.idcurso = idcurso;
        this.fechaasignatura = fechaasignatura;
        this.codhorario = codhorario;
        this.estado = estado;
    }

    public int getIdcursoh() {
        return idcursoh;
    }

    public void setIdcursoh(int idcursoh) {
        this.idcursoh = idcursoh;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public Date getFechaasignatura() {
        return fechaasignatura;
    }

    public void setFechaasignatura(Date fechaasignatura) {
        this.fechaasignatura = fechaasignatura;
    }

    public int getCodhorario() {
        return codhorario;
    }

    public void setCodhorario(int codhorario) {
        this.codhorario = codhorario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    
    
}
