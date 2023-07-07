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
public class Asignatura {
    
    private int pk_idasig;
    private int fk_idcurso;
    private String nombreasig;
    private String descripcionasig;

    public Asignatura() {
    }

    public Asignatura(int pk_idasig, int fk_idcurso, String nombreasig, String descripcionasig) {
        this.pk_idasig = pk_idasig;
        this.fk_idcurso = fk_idcurso;
        this.nombreasig = nombreasig;
        this.descripcionasig = descripcionasig;
    }

    public int getPk_idasig() {
        return pk_idasig;
    }

    public void setPk_idasig(int pk_idasig) {
        this.pk_idasig = pk_idasig;
    }

    public int getFk_idcurso() {
        return fk_idcurso;
    }

    public void setFk_idcurso(int fk_idcurso) {
        this.fk_idcurso = fk_idcurso;
    }

    public String getNombreasig() {
        return nombreasig;
    }

    public void setNombreasig(String nombreasig) {
        this.nombreasig = nombreasig;
    }

    public String getDescripcionasig() {
        return descripcionasig;
    }

    public void setDescripcionasig(String descripcionasig) {
        this.descripcionasig = descripcionasig;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "pk_idasig=" + pk_idasig + ", fk_idCurso=" + fk_idcurso + ", nombreasig=" + nombreasig + ", descripcionasig=" + descripcionasig + '}';
    }
    
    
    
}
