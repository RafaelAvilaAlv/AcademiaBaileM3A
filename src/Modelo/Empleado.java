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
public class Empleado {
    private int cod_empleado;
    private double salario;
    private String cedula_per;
    private Date fecha_contratacion;

    public Empleado() {
    }

    public Empleado(int cod_empleado, double salario, String cedula_per, Date fecha_contratacion) {
        this.cod_empleado = cod_empleado;
        this.salario = salario;
        this.cedula_per = cedula_per;
        this.fecha_contratacion = fecha_contratacion;
    }

    public int getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(int cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCedula_per() {
        return cedula_per;
    }

    public void setCedula_per(String cedula_per) {
        this.cedula_per = cedula_per;
    }

    public Date getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(Date fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    @Override
    public String toString() {
        return "Empleado{" + "cod_empleado=" + cod_empleado + ", salario=" + salario + ", cedula_per=" + cedula_per + ", fecha_contratacion=" + fecha_contratacion + '}';
    }
    
}
