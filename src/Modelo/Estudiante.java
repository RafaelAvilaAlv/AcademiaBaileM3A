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
public class Estudiante extends Persona{
    
    private int pk_idestudiante;
     private String fk_cedulaper;
    private String representante;
    private String telefonorepresentante;
    private String correorepresentante;
    private String estado;

    public Estudiante() {
    }
    
   
    public Estudiante(int pk_idestudiante, String representante, String fk_cedulaper, String telefonorepresentante, String correorepresentante, String estado) {
        this.pk_idestudiante = pk_idestudiante;
        this.representante = representante;
        this.fk_cedulaper = fk_cedulaper;
        this.telefonorepresentante = telefonorepresentante;
        this.correorepresentante = correorepresentante;
        this.estado = estado;
    }

    public Estudiante(int pk_idestudiante, String representante, String fk_cedulaper, String telefonorepresentante, String correorepresentante, String estado, String cedula_per, String primeNombre_per, String segundoNombre_per, String apellidoPat_per, String apellidoMat_per, String telefono_per, String direccion_per, String email_per, String genero_per, Date fechaNacimiento_per) {
        super(cedula_per, primeNombre_per, segundoNombre_per, apellidoPat_per, apellidoMat_per, telefono_per, direccion_per, email_per, genero_per, fechaNacimiento_per);
        this.pk_idestudiante = pk_idestudiante;
        this.representante = representante;
        this.fk_cedulaper = fk_cedulaper;
        this.telefonorepresentante = telefonorepresentante;
        this.correorepresentante = correorepresentante;
        this.estado = estado;
    }

    public int getPk_idestudiante() {
        return pk_idestudiante;
    }

    public void setPk_idestudiante(int pk_idestudiante) {
        this.pk_idestudiante = pk_idestudiante;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getFk_cedulaper() {
        return fk_cedulaper;
    }

    public void setFk_cedulaper(String fk_cedulaper) {
        this.fk_cedulaper = fk_cedulaper;
    }

    public String getTelefonorepresentante() {
        return telefonorepresentante;
    }

    public void setTelefonorepresentante(String telefonorepresentante) {
        this.telefonorepresentante = telefonorepresentante;
    }

    public String getCorreorepresentante() {
        return correorepresentante;
    }

    public void setCorreorepresentante(String correorepresentante) {
        this.correorepresentante = correorepresentante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}