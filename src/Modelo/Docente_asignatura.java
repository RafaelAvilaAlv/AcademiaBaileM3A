/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Docente_asignatura {

    private int pk_asigcodigo, fk_coddocente, fk_codasi;
    private Date asig_fecha;

    public Docente_asignatura() {
    }

    public Docente_asignatura(int pk_asigcodigo, int fk_coddocente, int fk_codasi, Date asig_fecha) {
        this.pk_asigcodigo = pk_asigcodigo;
        this.fk_coddocente = fk_coddocente;
        this.fk_codasi = fk_codasi;
        this.asig_fecha = asig_fecha;
    }

    public int getPk_asigcodigo() {
        return pk_asigcodigo;
    }

    public void setPk_asigcodigo(int pk_asigcodigo) {
        this.pk_asigcodigo = pk_asigcodigo;
    }

    public int getFk_coddocente() {
        return fk_coddocente;
    }

    public void setFk_coddocente(int fk_coddocente) {
        this.fk_coddocente = fk_coddocente;
    }

    public int getFk_codasi() {
        return fk_codasi;
    }

    public void setFk_codasi(int fk_codasi) {
        this.fk_codasi = fk_codasi;
    }

    public Date getAsig_fecha() {
        return asig_fecha;
    }

    public void setAsig_fecha(Date asig_fecha) {
        this.asig_fecha = asig_fecha;
    }

    @Override
    public String toString() {
        return "Docente_asignatura{" + "pk_asigcodigo=" + pk_asigcodigo + ", fk_coddocente=" + fk_coddocente + ", fk_codasi=" + fk_codasi + ", asig_fecha=" + asig_fecha + '}';
    }

}
