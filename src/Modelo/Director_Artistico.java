/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author LENOVO
 */
public class Director_Artistico {
    private int codigoprod;
    private int fkcodigoemple;
    private int añoexpe;

    public Director_Artistico() {
    }

    public Director_Artistico(int codigoprod, int fkcodigoemple, int añoexpe) {
        this.codigoprod = codigoprod;
        this.fkcodigoemple = fkcodigoemple;
        this.añoexpe = añoexpe;
    }

    public int getCodigoprod() {
        return codigoprod;
    }

    public void setCodigoprod(int codigoprod) {
        this.codigoprod = codigoprod;
    }

    public int getFkcodigoemple() {
        return fkcodigoemple;
    }

    public void setFkcodigoemple(int fkcodigoemple) {
        this.fkcodigoemple = fkcodigoemple;
    }

    public int getAñoexpe() {
        return añoexpe;
    }

    public void setAñoexpe(int añoexpe) {
        this.añoexpe = añoexpe;
    }

  

  
    

}
