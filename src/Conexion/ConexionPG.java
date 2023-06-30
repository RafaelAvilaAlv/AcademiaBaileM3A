package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexionPG {

    String URL = "jdbc:postgresql://localhost:5432/AcademiaBaile";
    private final String USER = "postgres";
    private final String PASSWORD = "1234";

    private Connection con = null;
    private Statement st;

    public ConexionPG() {
        con = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean CRUD(String sql) {
        st = null;
        try {
            st = con.createStatement();
            st.execute(sql);
            st.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ResultSet Consultas(String SQL) {

        st = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(URL, USER,PASSWORD);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
       
       return con;
 }
}