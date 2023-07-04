/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ASUS
 */
public class Docente {
    private int pk_doccod;
    private int fk_codemple;
    private String especialidad;
       private String  estdo ;

    public Docente() {
    }

    public Docente(int pk_doccod, int fk_codemple, String especialidad, String estdo) {
        this.pk_doccod = pk_doccod;
        this.fk_codemple = fk_codemple;
        this.especialidad = especialidad;
        this.estdo = estdo;
    }

    public int getPk_doccod() {
        return pk_doccod;
    }

    public void setPk_doccod(int pk_doccod) {
        this.pk_doccod = pk_doccod;
    }

    public int getFk_codemple() {
        return fk_codemple;
    }

    public void setFk_codemple(int fk_codemple) {
        this.fk_codemple = fk_codemple;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEstdo() {
        return estdo;
    }

    public void setEstdo(String estdo) {
        this.estdo = estdo;
    }

    @Override
    public String toString() {
        return "Docente{" + "pk_doccod=" + pk_doccod + ", fk_codemple=" + fk_codemple + ", especialidad=" + especialidad + ", estdo=" + estdo + '}';
    }
       
}
