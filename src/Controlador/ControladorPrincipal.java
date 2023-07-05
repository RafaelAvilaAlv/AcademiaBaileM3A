/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloPersona;
import Vista.VistaInicio;
import Vista.VistaPersona;
import Vista.VistaPrincipal;

/**
 *
 * @author Christian
 */
public class ControladorPrincipal {

    VistaInicio vi = new VistaInicio();

    public ControladorPrincipal(VistaInicio vi) {
        this.vi = vi;
        vi.setVisible(true);
     
    }

    public void IniciarControlador() {

        vi.setTitle("Inicio de seción");
        vi.getBtniniciar().addActionListener(l -> VisPrincipal());

    }

    public void VisPrincipal() {

        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        ControladorP control = new ControladorP(vistaPrincipal);
        control.iniciarControl();
        vi.setVisible(false);

    }

}
