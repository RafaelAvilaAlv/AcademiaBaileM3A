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
public class Estudiante {
    
    private int est_codigo, fk_cedula_per;
    private String representante;
    private String telefonorepresentante;
    private String correo;
    private String est_estado;

    public Estudiante() {
    }

    public Estudiante(int est_codigo, int fk_cedula_per, String representante, String telefonorepresentante, String correo, String est_estado) {
        this.est_codigo = est_codigo;
        this.fk_cedula_per = fk_cedula_per;
        this.representante = representante;
        this.telefonorepresentante = telefonorepresentante;
        this.correo = correo;
        this.est_estado = est_estado;
    }
    
    

    public int getEst_codigo() {
        return est_codigo;
    }

    public void setEst_codigo(int est_codigo) {
        this.est_codigo = est_codigo;
    }

    public int getFk_cedula_per() {
        return fk_cedula_per;
    }

    public void setFk_cedula_per(int fk_cedula_per) {
        this.fk_cedula_per = fk_cedula_per;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getTelefonorepresentante() {
        return telefonorepresentante;
    }

    public void setTelefonorepresentante(String telefonorepresentante) {
        this.telefonorepresentante = telefonorepresentante;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEst_estado() {
        return est_estado;
    }

    public void setEst_estado(String est_estado) {
        this.est_estado = est_estado;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "est_codigo=" + est_codigo + ", fk_cedula_per=" + fk_cedula_per + ", representante=" + representante + ", telefonorepresentante=" + telefonorepresentante + ", correo=" + correo + ", est_estado=" + est_estado + '}';
    }
    
    
    
    
}
