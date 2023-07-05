/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Empleado extends Persona{
    private int cod_empleado;
    private double salario;
    private String cedula_per1;
    private Date fecha_contratacion;

    public Empleado() {
       
    }

    public Empleado(int cod_empleado, double salario, String cedula_per, Date fecha_contratacion) {
        this.cod_empleado = cod_empleado;
        this.salario = salario;
        this.cedula_per1 = cedula_per;
        this.fecha_contratacion = fecha_contratacion;
    }

    public Empleado(int cod_empleado, double salario, String cedula_per1, Date fecha_contratacion, String cedula_per, String primeNombre_per, String segundoNombre_per, String apellidoPat_per, String apellidoMat_per, String telefono_per, String direccion_per, String email_per, String genero_per, Date fechaNacimiento_per) {
        super(cedula_per, primeNombre_per, segundoNombre_per, apellidoPat_per, apellidoMat_per, telefono_per, direccion_per, email_per, genero_per, fechaNacimiento_per);
        this.cod_empleado = cod_empleado;
        this.salario = salario;
        this.cedula_per1 = cedula_per1;
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

    public String getCedula_per1() {
        return cedula_per1;
    }

    public void setCedula_per1(String cedula_per1) {
        this.cedula_per1 = cedula_per1;
    }

    public Date getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(Date fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    @Override
    public String toString() {
        return "Empleado{" + "cod_empleado=" + cod_empleado + ", salario=" + salario + ", cedula_per1=" + cedula_per1 + ", fecha_contratacion=" + fecha_contratacion + '}';
    }

  
}
