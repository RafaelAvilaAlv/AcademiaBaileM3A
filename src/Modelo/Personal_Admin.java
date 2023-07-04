package Modelo;

/**
 *
 * @author Zhunio
 */
public class Personal_Admin {
    private int id_adm;
    private String usuario_adm;
    private String clave_adm;

    public Personal_Admin() {
        super();
    }

    public int getId_adm() {
        return id_adm;
    }

    public void setId_adm(int id_adm) {
        this.id_adm = id_adm;
    }

    public String getUsuario_adm() {
        return usuario_adm;
    }

    public void setUsuario_adm(String usuario_adm) {
        this.usuario_adm = usuario_adm;
    }

    public String getClave_adm() {
        return clave_adm;
    }

    public void setClave_adm(String clave_adm) {
        this.clave_adm = clave_adm;
    }

    @Override
    public String toString() {
        return "Personal_Admin{" + "id_adm=" + id_adm + ", usuario_adm=" + usuario_adm + ", clave_adm=" + clave_adm + '}';
    }
    
}
