package Modelo;

import java.sql.Date;

/**
 *
 * @author Zhunio
 */
public class Matricula {
    private int codigo_mat;
    private int codigoAdm_mat;
    private int codigoEst_mat;
    private int codigoCurso_mat;
    private Date fecha_mat;
    private String estado_mat;

    public Matricula() {
    }

    public Matricula(int codigo_mat, int codigoAdm_mat, int codigoEst_mat, int codigoCurso_mat, Date fecha_mat, String estado_mat) {
        this.codigo_mat = codigo_mat;
        this.codigoAdm_mat = codigoAdm_mat;
        this.codigoEst_mat = codigoEst_mat;
        this.codigoCurso_mat = codigoCurso_mat;
        this.fecha_mat = fecha_mat;
        this.estado_mat = estado_mat;
    }

    public int getCodigo_mat() {
        return codigo_mat;
    }

    public void setCodigo_mat(int codigo_mat) {
        this.codigo_mat = codigo_mat;
    }

    public int getCodigoAdm_mat() {
        return codigoAdm_mat;
    }

    public void setCodigoAdm_mat(int codigoAdm_mat) {
        this.codigoAdm_mat = codigoAdm_mat;
    }

    public int getCodigoEst_mat() {
        return codigoEst_mat;
    }

    public void setCodigoEst_mat(int codigoEst_mat) {
        this.codigoEst_mat = codigoEst_mat;
    }

    public int getCodigoCurso_mat() {
        return codigoCurso_mat;
    }

    public void setCodigoCurso_mat(int codigoCurso_mat) {
        this.codigoCurso_mat = codigoCurso_mat;
    }

    public Date getFecha_mat() {
        return fecha_mat;
    }

    public void setFecha_mat(Date fecha_mat) {
        this.fecha_mat = fecha_mat;
    }

    public String getEstado_mat() {
        return estado_mat;
    }

    public void setEstado_mat(String estado_mat) {
        this.estado_mat = estado_mat;
    }

    @Override
    public String toString() {
        return "Matricula{" + "codigo_mat=" + codigo_mat + ", codigoAdm_mat=" + codigoAdm_mat + ", codigoEst_mat=" + codigoEst_mat + ", codigoCurso_mat=" + codigoCurso_mat + ", fecha_mat=" + fecha_mat + ", estado_mat=" + estado_mat + '}';
    }
    
}
