/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConexionPG;
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
public class ModeloAsignatura extends Asignatura {
    
    ConexionPG conpg = new ConexionPG();

    public ModeloAsignatura() {
    }

    public ModeloAsignatura(int pk_idasig, int fk_idcurso, String nombreasig, String descripcionasig) {
        super(pk_idasig, fk_idcurso, nombreasig, descripcionasig);
    }


    public SQLException crearAsignatura() {
    String sql = "INSERT INTO asignatura(pk_idasig, fk_idcurso, nombreasig, descripcionasig) VALUES (" 
                 + getPk_idasig() + ", " + getFk_idcurso() + ", '" + getNombreasig() + "', '" + getDescripcionasig() + "');";

    return conpg.accion(sql);
}
    
    
    public SQLException modificarAsignatura() {
    String sql = "UPDATE asignatura SET pk_idasig = " + getPk_idasig() + ", fk_idcurso = " + getFk_idcurso() + ", nombreasig = '" + getNombreasig() + "', descripcionasig = '" + getDescripcionasig() + "' WHERE pk_idasig = " + getPk_idasig()+ ";";

    return conpg.accion(sql);
}

    
    public SQLException eliminarAsignatura(int codigoAsignatura) {
        String sql = "UPDATE asignatura SET descripcionasig = 'I' where pk_idasig = " + codigoAsignatura + "";

        return conpg.accion(sql);
    }


    public List<Asignatura> listaAsignaturaTabla() {
        try {
            //Me retorna un "List" de "persona"
            List<Asignatura> lista = new ArrayList<>();

            String sql = "select * from asignatura";

            ResultSet rs = conpg.Consultas(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de los docentes
                Asignatura asignatura = new Asignatura();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                asignatura.setPk_idasig(rs.getInt("pk_idasig"));
                asignatura.setFk_idcurso(rs.getInt("fk_idcurso"));
                asignatura.setNombreasig(rs.getString("nombreasig"));
                asignatura.setDescripcionasig(rs.getString("descripcionasig"));

                lista.add(asignatura); //Agrego los datos a la lista
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
    
    
        public List<Asignatura> buscarAsignatura(String nombre) {
        try {
            //Me retorna un "List" de "persona"
            List<Asignatura> lista = new ArrayList<>();

            String sql = "select * from asignatura where Lower(nombreasig) like '"+nombre.toLowerCase()+"'";

            ResultSet rs = conpg.Consultas(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de los docentes
                Asignatura asignatura = new Asignatura();

                 //Todo lo que haga en la sentencia define como voy a extraer los datos
                asignatura.setPk_idasig(rs.getInt("pk_idasig"));
                asignatura.setFk_idcurso(rs.getInt("fk_idcurso"));
                asignatura.setNombreasig(rs.getString("nombreasig"));
                asignatura.setDescripcionasig(rs.getString("descripcionasig"));

                
                lista.add(asignatura); //Agrego los datos a la lista
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
    
    
}
