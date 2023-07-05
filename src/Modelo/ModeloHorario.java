package Modelo;

import Conexion.ConexionPG;
import Modelo.Horario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloHorario extends Horario {

    ConexionPG conpg = new ConexionPG();

    public ModeloHorario() {
    }

    public ModeloHorario(int codigo, String horaInicio, String horaFin, String dia) {
        super(codigo, horaInicio, horaFin, dia);
    }

    public SQLException crearHorario() {

        String sql = "Insert into horario (pk_idhorario,hora_ini, hora_fin, dia) values ('" + getCod_horario() + "','" + getHora_ini() + "', '" + getHora_fin() + "', '" + getDia() + "')";

        return conpg.accion(sql);
    }

    public int CargarCod() throws SQLException {

        int codigo = 0;

        String sql = "select max(pk_idhorario) from horario;";
        ResultSet res = conpg.Consultas(sql);

        while (res.next()) {

            codigo = res.getInt("max") + 1;
        }

        res.close();
        return codigo;

    }

    public SQLException modificarHorario() {
        String sql = "UPDATE horario SET dia = '" + getDia() + "', hora_ini = '" + getHora_ini() + "', hora_fin = '" + getHora_fin() + "' where pk_idhorario = " + getCod_horario() + ";";

        return conpg.accion(sql);
    }

    /* public List<Horario> listaHorarioTabla() {
        try {
            List<Horario> lista = new ArrayList<>();

            String sql = "select * from horario where hor_estado = 'A'";

            ResultSet rs = conpg.Consultas(sql);

            while (rs.next()) {

                Horario horario = new Horario();

                horario.setCod_horario(rs.getInt("pk_idhorario"));
                horario.setHora_ini(rs.getString("hora_ini"));
                horario.setHora_fin(rs.getString("hora_fin"));
                horario.setDia(rs.getString("dia"));
                

                lista.add(horario);
            }

            rs.close();
            //Retorno la lista            
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloHorario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }*/
    public List<Horario> listaHorarioTabla() {

        try {
            String sql = "select * from horario "
                    + "order by pk_idhorario;";
            ResultSet res = conpg.Consultas(sql);
            List<Horario> horario = new ArrayList<>();

            while (res.next()) {

                Horario mihorario = new Horario();

                mihorario.setCod_horario(res.getInt("pk_idhorario"));
                mihorario.setHora_ini(res.getString("hora_ini"));
                mihorario.setHora_fin(res.getString("hora_fin"));
                mihorario.setDia(res.getString("dia"));

                horario.add(mihorario);
            }
            res.close();
            return horario;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloHorario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
