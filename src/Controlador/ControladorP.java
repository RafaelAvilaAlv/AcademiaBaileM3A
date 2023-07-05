/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloHorario;
import Vista.VistaHorario;
import Vista.VistaPrincipal;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author estef
 */
public class ControladorP {

    VistaPrincipal vistaprincipal;

    public ControladorP(VistaPrincipal vistaPrincipal) {
        this.vistaprincipal = vistaPrincipal;
        vistaPrincipal.setVisible(true);
        vistaPrincipal.setIconImage(getIconImage());
        vistaPrincipal.setLocationRelativeTo(null);

    }

    public void iniciarControl() {
        vistaprincipal.getBtnhorario().addActionListener(l -> registroHorario());
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Iconos/logogrande.png"));
        return retValue;
    }

    private void registroHorario() {
        vistaprincipal.getEscritorioPrincipal().removeAll(); //Remuevo todos los elementos que esten en sobre el desktopPane
        VistaHorario vista = new VistaHorario();
        ModeloHorario modelo = new ModeloHorario();
        vistaprincipal.getEscritorioPrincipal().add(vista);
        ControladorHorario control = new ControladorHorario(modelo, vista);
        control.iniciarControl();

    }

}
