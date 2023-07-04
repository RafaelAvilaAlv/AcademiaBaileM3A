package Modelo;

import java.sql.Date;

/**
 *
 * @author Zhunio
 */
public class Persona {
    private String cedula_per;
    private String primeNombre_per;
    private String segundoNombre_per;
    private String apellidoPat_per;
    private String apellidoMat_per;
    private String telefono_per;
    private String direccion_per;
    private String email_per;
    private String genero_per;
    private Date fechaNacimiento_per;

    public Persona() {
    }

    public Persona(String cedula_per, String primeNombre_per, String segundoNombre_per, String apellidoPat_per, String apellidoMat_per, String telefono_per, String direccion_per, String email_per, String genero_per, Date fechaNacimiento_per) {
        this.cedula_per = cedula_per;
        this.primeNombre_per = primeNombre_per;
        this.segundoNombre_per = segundoNombre_per;
        this.apellidoPat_per = apellidoPat_per;
        this.apellidoMat_per = apellidoMat_per;
        this.telefono_per = telefono_per;
        this.direccion_per = direccion_per;
        this.email_per = email_per;
        this.genero_per = genero_per;
        this.fechaNacimiento_per = fechaNacimiento_per;
    }

    public String getCedula_per() {
        return cedula_per;
    }

    public void setCedula_per(String cedula_per) {
        this.cedula_per = cedula_per;
    }

    public String getPrimeNombre_per() {
        return primeNombre_per;
    }

    public void setPrimeNombre_per(String primeNombre_per) {
        this.primeNombre_per = primeNombre_per;
    }

    public String getSegundoNombre_per() {
        return segundoNombre_per;
    }

    public void setSegundoNombre_per(String segundoNombre_per) {
        this.segundoNombre_per = segundoNombre_per;
    }

    public String getApellidoPat_per() {
        return apellidoPat_per;
    }

    public void setApellidoPat_per(String apellidoPat_per) {
        this.apellidoPat_per = apellidoPat_per;
    }

    public String getApellidoMat_per() {
        return apellidoMat_per;
    }

    public void setApellidoMat_per(String apellidoMat_per) {
        this.apellidoMat_per = apellidoMat_per;
    }

    public String getTelefono_per() {
        return telefono_per;
    }

    public void setTelefono_per(String telefono_per) {
        this.telefono_per = telefono_per;
    }

    public String getDireccion_per() {
        return direccion_per;
    }

    public void setDireccion_per(String direccion_per) {
        this.direccion_per = direccion_per;
    }

    public String getEmail_per() {
        return email_per;
    }

    public void setEmail_per(String email_per) {
        this.email_per = email_per;
    }

    public String getGenero_per() {
        return genero_per;
    }

    public void setGenero_per(String genero_per) {
        this.genero_per = genero_per;
    }

    public Date getFechaNacimiento_per() {
        return fechaNacimiento_per;
    }

    public void setFechaNacimiento_per(Date fechaNacimiento_per) {
        this.fechaNacimiento_per = fechaNacimiento_per;
    }

    @Override
    public String toString() {
        return "Persona{" + "cedula_per=" + cedula_per + ", primeNombre_per=" + primeNombre_per + ", segundoNombre_per=" + segundoNombre_per + ", apellidoPat_per=" + apellidoPat_per + ", apellidoMat_per=" + apellidoMat_per + ", telefono_per=" + telefono_per + ", direccion_per=" + direccion_per + ", email_per=" + email_per + ", genero_per=" + genero_per + ", fechaNacimiento=" + fechaNacimiento_per + '}';
    }
    
}
