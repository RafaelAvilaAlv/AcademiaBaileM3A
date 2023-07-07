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
public class ModeloCurso extends Curso {

    ConexionPG conpg = new ConexionPG();

    public ModeloCurso() {
    }

    public ModeloCurso(int pk_idcurso, String nombre_curso, Date fehca_ini, Date fecha_fin, String periodo, String descripcion, int cupos, double precio, String aula_des) {
        super(pk_idcurso, nombre_curso, fehca_ini, fecha_fin, periodo, descripcion, cupos, precio, aula_des);
    }

    public SQLException crearCurso() {
        String sql = "INSERT INTO curso(pk_idcurso, nombre_curso, fehca_ini, fecha_fin, periodo, descripcion, cupos,precio,aula_des ) VALUES ("
                + getPk_idcurso() + ", '" + getNombre_curso() + "', '" + getFehca_ini() + "', '" + getFecha_fin() + "', '" + getPeriodo() + "', '" + getDescripcion() + "', " + getCupos() + ", " + getPrecio() + ", " + getAula_des() + ");";

        return conpg.accion(sql);
    }

    public SQLException modificarCurso() {
        String sql = "UPDATE curso SET nombre_curso = '" + getNombre_curso() + "', periodo = '" + getPeriodo() + "', fehca_ini = '" + getFehca_ini() + "', fecha_fin = '" + getFecha_fin() + "', descripcion = '" + getDescripcion() + "', precio = " + getPrecio() + " where pk_idcurso = " + getPk_idcurso() + ";";

        return conpg.accion(sql);
    }

    ///////////////////////HEEEEEEEEEEEELLLLLLLLLLLLLLLLLLLLLLPPPPPPPPPPPPPPPPPP
    public SQLException eliminarCurso(int codigoCurso) {
        String sql = "UPDATE curso SET nombre_curso= 'I' where pk_idcurso = " + codigoCurso + ";";

        return conpg.accion(sql);
    }

    public List<Curso> listaCursoTabla() {
        try {
            List<Curso> lista = new ArrayList<>();

            String sql = "select * from curso";

            ResultSet rs = conpg.Consultas(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {

                Curso curso = new Curso();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                curso.setPk_idcurso(rs.getInt("pk_idcurso"));
                curso.setNombre_curso(rs.getString("nombre_curso"));
                curso.setFehca_ini(rs.getDate("fehca_ini"));
                curso.setFecha_fin(rs.getDate("fecha_fin"));
                curso.setPeriodo(rs.getString("periodo"));
                curso.setDescripcion(rs.getString("descripcion"));
                curso.setCupos(rs.getInt("cupos"));
                curso.setPrecio(rs.getDouble("precio"));
                curso.setAula_des(rs.getString("aula_des"));

                lista.add(curso); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloCurso.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Curso> buscarCurso(String nombre) {
        try {
            //Me retorna un "List" de "persona"
            List<Curso> lista = new ArrayList<>();

            String sql = "select * from curso where Lower(nombre_curso) like '" + nombre.toLowerCase() + "%'"; //Paso a minuscula el nombre del curso que esta 
            //guardado en la BD y tambien paso a minuscula el nombre recuperado del txr para poder comparar los nombres. Sin importar si esta en mayuscula o en minuscula

            ResultSet rs = conpg.Consultas(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de los docentes
                Curso curso = new Curso();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                curso.setPk_idcurso(rs.getInt("pk_idcurso"));
                curso.setNombre_curso(rs.getString("nombre_curso"));
                curso.setFehca_ini(rs.getDate("fehca_ini"));
                curso.setFecha_fin(rs.getDate("fecha_fin"));
                curso.setPeriodo(rs.getString("periodo"));
                curso.setDescripcion(rs.getString("descripcion"));
                curso.setCupos(rs.getInt("cupos"));
                curso.setPrecio(rs.getDouble("precio"));
                curso.setAula_des(rs.getString("aula_des"));

                lista.add(curso); //Agrego los datos a la lista
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
