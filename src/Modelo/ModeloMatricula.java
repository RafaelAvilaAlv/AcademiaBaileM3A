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
 * @author Zhunio
 */
public class ModeloMatricula {
    ConexionPG cpg = new ConexionPG();
    
    public ModeloMatricula() { 
    }
    
    public List<Matricula> enlistaMatricula() {
        List<Matricula> listaMatricula = new ArrayList<>();
        String sql = "SELECT pk_matcodigo, fk_matcodadmr, fk_matcodest, fk_matcodcurso, fechamatri, estado\n" +
                    "FROM public.matricula;";
        ResultSet rs = cpg.Consultas(sql);
        try {
            while(rs.next()) {
                Matricula matricula = new Matricula();
                
                matricula.setCodigo_mat(rs.getInt("pk_matcodigo"));
                matricula.setCodigoAdm_mat(rs.getInt("fk_matcodadmr"));
                matricula.setCodigoEst_mat(rs.getInt("fk_matcodest"));
                matricula.setCodigoCurso_mat(rs.getInt("fk_matcodcurso"));
                matricula.setFecha_mat(rs.getDate("fechamatri"));
                matricula.setEstado_mat(rs.getString("estado"));
                          
                listaMatricula.add(matricula);
            }  
            rs.close();
            return listaMatricula;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public boolean crearMatricula(Matricula m) { 
        String sql = "INSERT INTO public.matricula(\n" +
        "fk_matcodadmr, fk_matcodest, fk_matcodcurso, fechamatri, estado)\n" +
        "VALUES ("+m.getCodigo_mat()+", "+m.getCodigoEst_mat()+", "+m.getCodigoCurso_mat()+", '"+m.getFecha_mat()+"', '"+m.getEstado_mat()+"');";
        
        return cpg.CRUD(sql);
        
    }
    
    public Matricula consultarMatricula(int codigo) {
        Matricula matricula = new Matricula();
        String sql = "SELECT pk_matcodigo, fk_matcodadmr, fk_matcodest, fk_matcodcurso, fechamatri, estado\n" +
                    "FROM public.matricula\n" +
                    "WHERE pk_matcodigo ="+codigo+";";
        ResultSet rs = cpg.Consultas(sql);   
        
        try {
            while(rs.next()) {
                matricula.setCodigo_mat(rs.getInt("pk_matcodigo"));
                matricula.setCodigoAdm_mat(rs.getInt("fk_matcodadmr"));
                matricula.setCodigoEst_mat(rs.getInt("fk_matcodest"));
                matricula.setCodigoCurso_mat(rs.getInt("fk_matcodcurso"));
                matricula.setFecha_mat(rs.getDate("fechamatri"));
                matricula.setEstado_mat(rs.getString("estado"));
                          
            }
            rs.close();
            return matricula;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public boolean editarMatricula(Matricula m) {
        String sql = "UPDATE public.matricula\n" +
                    "SET fk_matcodadmr="+m.getCodigoAdm_mat()+", fk_matcodest="+m.getCodigoEst_mat()+", fk_matcodcurso="+m.getCodigoCurso_mat()+", "
                + "fechamatri='"+m.getFecha_mat()+"', estado='"+m.getEstado_mat()+"'\n" +
                    "WHERE pk_matcodigo = "+m.getCodigo_mat()+";";   
        return cpg.CRUD(sql);
    }
    
    
    public boolean removerMatricula(int codigo) {
        String sql = "DELETE FROM public.matricula\n" +
"	WHERE pk_matcodigo = "+codigo+";";   
        return cpg.CRUD(sql);
    }
}
