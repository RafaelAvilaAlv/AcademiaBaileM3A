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
    
    private int id_asi;
    private int fk_idCurso;
    private String nombreasi;
    private String descripcionasi;

    public Asignatura() {
    }

    public Asignatura(int id_asi, int fk_idCurso, String nombreasi, String descripcionasi) {
        this.id_asi = id_asi;
        this.fk_idCurso = fk_idCurso;
        this.nombreasi = nombreasi;
        this.descripcionasi = descripcionasi;
    }

    public int getId_asi() {
        return id_asi;
    }

    public void setId_asi(int id_asi) {
        this.id_asi = id_asi;
    }

    public int getFk_idCurso() {
        return fk_idCurso;
    }

    public void setFk_idCurso(int fk_idCurso) {
        this.fk_idCurso = fk_idCurso;
    }

    public String getNombreasi() {
        return nombreasi;
    }

    public void setNombreasi(String nombreasi) {
        this.nombreasi = nombreasi;
    }

    public String getDescripcionasi() {
        return descripcionasi;
    }

    public void setDescripcionasi(String descripcionasi) {
        this.descripcionasi = descripcionasi;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "id_asi=" + id_asi + ", fk_idCurso=" + fk_idCurso + ", nombreasi=" + nombreasi + ", descripcionasi=" + descripcionasi + '}';
    }
    
    
    
}
