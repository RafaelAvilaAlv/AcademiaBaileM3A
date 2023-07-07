/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Christian
 */
public class ModeloEstudiante extends Estudiante {

    ConexionPG conpg = new ConexionPG();

    public ModeloEstudiante() {
    }

    public ModeloEstudiante(int pk_idestudiante, String representante, String fk_cedulaper, String telefonorepresentante, String correorepresentante, String estado) {
        super(pk_idestudiante, representante, fk_cedulaper, telefonorepresentante, correorepresentante, estado);
    }

    public ModeloEstudiante(int pk_idestudiante, String representante, String fk_cedulaper, String telefonorepresentante, String correorepresentante, String estado, String cedula_per, String primeNombre_per, String segundoNombre_per, String apellidoPat_per, String apellidoMat_per, String telefono_per, String direccion_per, String email_per, String genero_per, Date fechaNacimiento_per) {
        super(pk_idestudiante, representante, fk_cedulaper, telefonorepresentante, correorepresentante, estado, cedula_per, primeNombre_per, segundoNombre_per, apellidoPat_per, apellidoMat_per, telefono_per, direccion_per, email_per, genero_per, fechaNacimiento_per);
    }

    public SQLException crearEstudiante() {
        String sql = "INSERT INTO estudiante(pk_idestudiante, fk_cedulaper, estado, representante, telefonorepresentante, correorepresentante) VALUES ("
                + getPk_idestudiante() + ", '" + getFk_cedulaper() + "', '" + getEstado() + "', '" + getRepresentante() + "', '" + getTelefonorepresentante() + "', '" + getCorreorepresentante() + "');";

        return conpg.accion(sql);
    }

//    public SQLException crearEstudianteOP() {
//        String sql = "INSERT INTO estudiante(fk_cedulaper, estado) VALUES (" + getFk_cedulaper() + ", 'A');";
//
//        return conpg.accion(sql);
//    }
    public SQLException crearEstudiante2(String codigoPersona) {
        String sql = "UPDATE estudiante SET pk_idestudiante = " + getPk_idestudiante() + ", fk_cedulaper = '" + getFk_cedulaper() + "', estado = '" + getEstado() + "', representante = '" + getRepresentante() + "', telefonorepresentante = '" + getTelefonorepresentante() + "', correorepresentante = '" + getCorreorepresentante() + "' WHERE fk_cedulaper = " + codigoPersona + ";";

        return conpg.accion(sql);

    }

//    public SQLException crearEstudiante2OP(String codigoPersona) {
//        String sql = "UPDATE estudiante SET estado= 'A' where fk_cedulaper = " + codigoPersona + ";";
//
//        return conpg.accion(sql);
//    }
    public SQLException modificarEstudiante() {
        String sql = "UPDATE estudiante SET pk_idestudiante = " + getPk_idestudiante() + ", fk_cedulaper = '" + getFk_cedulaper() + "', estado = '" + getEstado() + "', representante = '" + getRepresentante() + "', telefonorepresentante = '" + getTelefonorepresentante() + "', correorepresentante = '" + getCorreorepresentante() + "' WHERE pk_idestudiante = " + getPk_idestudiante() + ";";

        return conpg.accion(sql);
    }

//    public SQLException modificarEstudianteOP() {
//        String sql = "UPDATE estudiante SET fk_cedulaper = " + getFk_cedulaper()+ " where pk_idestudiante = " + getPk_idestudiante()+ ";";
//
//        return conpg.accion(sql);
//    }
    public SQLException modificarEstudiante2(String fk_cedulaper) {
        String sql = "UPDATE estudiante SET estado = " +  fk_cedulaper + ";";

        return conpg.accion(sql);
    }

//    public SQLException modificarEstudiante2OP(String codigoPersona) {
//        String sql = "UPDATE estudiante SET estado= 'A' where fk_cedulaper = " + codigoPersona + ";";
//
//        return conpg.accion(sql);
//    }

    public SQLException eliminarEstudiante(int pk_idestudiante) {
        String sql = "UPDATE estudiante SET estado= 'I' WHERE pk_idestudiante = "  + pk_idestudiante + ";";

        return conpg.accion(sql);
    }

//    public SQLException eliminarEstudianteOP(int codigoEstudiante) {
//        String sql = "UPDATE estudiante SET estado= 'I' where pk_idestudiante = " + codigoEstudiante + ";";
//
//        return conpg.accion(sql);
//    }

    public List<Estudiante> listaEstudiantesTabla() {
        try {
            //Me retorna un "List" de "persona"
            List<Estudiante> lista = new ArrayList<>();

            String sql = "select * from persona, estudiante where cedula_per = fk_cedulaper ";

            ResultSet rs = conpg.Consultas(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de los docentes
                Estudiante estudiante = new Estudiante();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                estudiante.setCedula_per(rs.getString("cedula_per"));
                estudiante.setPrimeNombre_per(rs.getString("primeNombre_per"));
                estudiante.setSegundoNombre_per(rs.getString("segundoNombre_per"));
                estudiante.setApellidoPat_per(rs.getString("apellidoPat_per"));
                estudiante.setApellidoMat_per(rs.getString("apellidoMat_per"));
                estudiante.setTelefono_per(rs.getString("telefono_per"));
                estudiante.setDireccion_per(rs.getString("direccion_per"));
                estudiante.setEmail_per(rs.getString("email_per"));
                estudiante.setGenero_per(rs.getString("genero_per"));
                estudiante.setFechaNacimiento_per(rs.getDate("fechaNacimiento_per"));

                lista.add(estudiante); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Estudiante> buscarEstudiante(String cedula) {
        try {
            //Me retorna un "List" de "persona"
            List<Estudiante> lista = new ArrayList<>();

            String sql = "select * from persona, estudiante where cedula_per = fk_cedulaper ";

            ResultSet rs = conpg.Consultas(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                Estudiante estudiante = new Estudiante();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                estudiante.setCedula_per(rs.getString("cedula_per"));
                estudiante.setPrimeNombre_per(rs.getString("primeNombre_per"));
                estudiante.setSegundoNombre_per(rs.getString("segundoNombre_per"));
                estudiante.setApellidoPat_per(rs.getString("apellidoPat_per"));
                estudiante.setApellidoMat_per(rs.getString("apellidoMat_per"));
                estudiante.setTelefono_per(rs.getString("telefono_per"));
                estudiante.setDireccion_per(rs.getString("direccion_per"));
                estudiante.setEmail_per(rs.getString("email_per"));
                estudiante.setGenero_per(rs.getString("genero_per"));
                estudiante.setFechaNacimiento_per(rs.getDate("fechaNacimiento_per"));

                lista.add(estudiante); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public String traerEstadoDelEstudiante(String codigoPersona) { //Trae el codigo de la persona que esta en la tabla estudiante
        String estado = "";
        try {

            String sql = "select estado from estudiante where fk_cedulaper = " + codigoPersona + ";";

            ResultSet rs = conpg.Consultas(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                estado = rs.getString("estado"); //Trae el estado del estudiante

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ModeloEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return estado;
    }

    public int traerCodigoDeEstudianteEliminar(String cedula) {
        int codigo = 0;
        try {

            String sql = "select pk_idestudiante from persona,estudiante where cedula_per = '" + cedula + "' and cedula_per = fk_cedulaper;";

            ResultSet rs = conpg.Consultas(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                codigo = rs.getInt("pk_idestudiante"); //Trae el codigo de la persona recien creada

            }

            //Cierro la conexion a la BD
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ModeloEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return codigo;
    }

}
