/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author estef
 */
public class Horario {
    private int cod_horario;
    private String hora_ini;
    private String hora_fin;
    private String dia;

    public int getCod_horario() {
        return cod_horario;
    }

    public void setCod_horario(int cod_horario) {
        this.cod_horario = cod_horario;
    }

    public String getHora_ini() {
        return hora_ini;
    }

    public void setHora_ini(String hora_ini) {
        this.hora_ini = hora_ini;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Horario() {
    }

    public Horario(int cod_horario, String hora_ini, String hora_fin, String dia) {
        this.cod_horario = cod_horario;
        this.hora_ini = hora_ini;
        this.hora_fin = hora_fin;
        this.dia = dia;
    }
    
    
    
    
}
