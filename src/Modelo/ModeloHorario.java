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
        super(codigo, horaInicio,horaFin,dia);
    }

    public SQLException crearHorario() {

        String sql = "Insert into horario (hora_ini, hora_fin, dia) values ('" + getHora_ini() + "', '" + getHora_fin() + "', '" + getDia()+ "')";

        return conpg.accion(sql);
    }

    public SQLException modificarHorario() {
        String sql = "UPDATE horario SET dia = '" + getDia() + "', hora_ini = '" + getHora_ini() + "', hora_fin = '" + getHora_fin() + "' where pk_idhorario = " + getCod_horario() + ";";

        return conpg.accion(sql);
    }

   

    public List<Horario> listaHorarioTabla() {
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
        }
    }
}
