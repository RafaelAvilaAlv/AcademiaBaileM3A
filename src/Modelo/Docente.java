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
public class Docente extends Empleado {

    private int pk_doccod;
    private int fk_codemple;
    private String especialidad;
    private String estdo;

    public Docente() {
    }

    public Docente(int pk_doccod, int fk_codemple, String especialidad, String estdo, int cod_empleado, double salario, String cedula_per1, java.sql.Date fecha_contratacion, String cedula_per, String primeNombre_per, String segundoNombre_per, String apellidoPat_per, String apellidoMat_per, String telefono_per, String direccion_per, String email_per, String genero_per, java.sql.Date fechaNacimiento_per) {
        super(cod_empleado, salario, cedula_per1, fecha_contratacion, cedula_per, primeNombre_per, segundoNombre_per, apellidoPat_per, apellidoMat_per, telefono_per, direccion_per, email_per, genero_per, fechaNacimiento_per);
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
