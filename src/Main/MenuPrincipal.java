/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controlador.ControladorPrincipal;
import Vista.VistaInicio;

/**
 *
 * @author Christian
 */
public class MenuPrincipal {
    
    public static void main(String[] args) {
        VistaInicio vm = new VistaInicio();
        ControladorPrincipal cm = new ControladorPrincipal(vm);
        cm.IniciarControlador();
    }
    
}
