/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.ConexionPG;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ModeloEmpleado extends Empleado {

    ConexionPG cpg = new ConexionPG();

    public ModeloEmpleado() {
    }

    public ModeloEmpleado(int cod_empleado, double salario, String cedula_per, Date fecha_contratacion) {
        super(cod_empleado, salario, cedula_per, fecha_contratacion);
    }

    public ModeloEmpleado(int cod_empleado, double salario, String cedula_per1, Date fecha_contratacion, String cedula_per, String primeNombre_per, String segundoNombre_per, String apellidoPat_per, String apellidoMat_per, String telefono_per, String direccion_per, String email_per, String genero_per, Date fechaNacimiento_per) {
        super(cod_empleado, salario, cedula_per1, fecha_contratacion, cedula_per, primeNombre_per, segundoNombre_per, apellidoPat_per, apellidoMat_per, telefono_per, direccion_per, email_per, genero_per, fechaNacimiento_per);
    }

    public boolean crearEmpleado() {
        String sql = "INSERT INTO empleado(cod_empleado, fecha_contratacion, salario) VALUES (" + getCod_empleado() + ", '" + getFecha_contratacion().toString() + "', " + getSalario() + ");";

        return cpg.CRUD(sql);

    }

    public boolean modificarEmpleado() {
        String sql = "UPDATE empleado SET fecha_contratacion= '" + getFecha_contratacion() + "', salario='" + getSalario() + "' where cod_empleado = " + getCod_empleado() + ";";

        return cpg.CRUD(sql);
    }

    public List<Empleado> listaEmpleadoTabla() {
        List<Empleado> lista = new ArrayList<>();

        String sql = "select * from empleado";

       ResultSet rs = cpg.Consultas(sql);
        try {
            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de los docentes
                Empleado empleado = new Empleado();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                empleado.setCod_empleado(rs.getInt("cod_empleado"));
                empleado.setCedula_per(rs.getString("cedula_per"));
                empleado.setFecha_contratacion(rs.getDate("fecha_contratacion"));
                empleado.setSalario(rs.getDouble("salario"));

                lista.add(empleado); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int traerCodigoDeEmpleadoCrear() { //Retorna el codigo maximo. Este codigo sirve para crear un docente en la BD
        int codigo = 0;
        try {

            String sql = "select max(cod_empleado) from empleado";

           ResultSet rs = cpg.Consultas(sql);//La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                codigo = rs.getInt("max"); //Trae el codigo de la persona recien creada

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ModeloEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return codigo;
    }
}
