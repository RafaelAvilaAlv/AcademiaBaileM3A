/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.ConexionPG;
import Modelo.Estudiante;
import Modelo.ModeloEstudiante;
import Modelo.ModeloPersona;
import Modelo.Persona;
import Vista.VistaEstudiante;
import Vista.VistaPrincipal;
import java.awt.event.KeyAdapter;
//import java.util.jar.pack.Attribute.Holder;

//import java.util.jar.pack.Attribute.Holder;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian
 */
public class ControladorEstudiante {

    ModeloEstudiante modelo;
    VistaEstudiante vista;

    VistaPrincipal p = new VistaPrincipal();

    public ControladorEstudiante(ModeloEstudiante modelo, VistaEstudiante vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);

        vista.setSize(p.getEscritorioPrincipal().getWidth(), p.getEscritorioPrincipal().getHeight());
        vista.getjDlgBuscarPersonas().setResizable(false);
        vista.getjDlgBuscarPersonas().setLocationRelativeTo(null);
//        vista.getBtnImprimir().addActionListener(l -> imprimir());
        cargarTablaDeEstudiantes();
        buscarEstudiante();
    }

    public void iniciarControl() {
//        vista.getBtnAsignar().addActionListener(l -> abrirjDlgEstudiante());
//        vista.getBtnGuardar().addActionListener(l -> crearEditarEstudiante());
        vista.getBtnBuscarPersona().addActionListener(l -> abrirjDialogPersonas());
        vista.getBtnCargarPer().addActionListener(l -> cargarDatosPersonaEnTXT());
        vista.getBtnActualizar().addActionListener(l -> cargarTablaDeEstudiantes());
        vista.getBtnModificar().addActionListener(l -> cargarDatosEstudianteEnTXT());
        vista.getBtnEliminar().addActionListener(l -> eliminarEstudiante());
        vista.getBtnCancelar().addActionListener(l -> cancelar());
        //vista.getBtnImprimir().addActionListener(l -> imprimir());
        buscarEstudiante();

    }

    public void cancelar() {
        vista.getjDlgEstudiante().setVisible(false);
    }

    public void eliminarEstudiante() {
        ModeloEstudiante estudiante = new ModeloEstudiante();

        int fila = vista.getTblEstudiante().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            int response = JOptionPane.showConfirmDialog(vista, "¿Seguro que desea eliminar esta información?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {

                int codigoEstudianteEliminar;
                codigoEstudianteEliminar = Integer.parseInt(vista.getTblEstudiante().getValueAt(fila, 0).toString());

                if (estudiante.eliminarEstudiante(codigoEstudianteEliminar) == null) {
                    JOptionPane.showMessageDialog(null, "El estudiante fue eliminado exitosamente");
                    cargarTablaDeEstudiantes();//Actualizo la tabla con los datos
                } else {
                    JOptionPane.showMessageDialog(null, "Error: El estudiante no se pudo eliminar");
                }
            }
        }
    }

    int codigoEstudiante; //Esta variable almacenara el codigo del estudiante traido de la BD. Sirve para modificar los datos del estudiante

    public void cargarDatosEstudianteEnTXT() {
        int fila = vista.getTblEstudiante().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            //Abrir jDialog de campos de Docente
            vista.getjDlgEstudiante().setVisible(true);
            vista.getjDlgEstudiante().setSize(838, 602);
            vista.getjDlgEstudiante().setLocationRelativeTo(null);
            vista.getjDlgEstudiante().setName("Modificar estudiante");
            vista.getjDlgEstudiante().setTitle("Modificar  estudiante");

            //ModeloPersona modeloPersona = new ModeloPersona();
            List<Estudiante> listap = modelo.listaEstudiantesTabla();

            listap.stream().forEach(persona -> {

                if (persona.getPk_idestudiante() == Integer.parseInt(vista.getTblEstudiante().getValueAt(fila, 0).toString())) {

                    vista.getTxtCedula().setText(persona.getCedula_per());
                    vista.getTxtPrimerNombre().setText(persona.getPrimeNombre_per());
                    vista.getTxtSegundoNombre().setText(persona.getSegundoNombre_per());
                    vista.getTxtPrimerApellido().setText(persona.getApellidoPat_per());
                    vista.getTxtSegundoApellido().setText(persona.getApellidoMat_per());

                    if (persona.getGenero_per().equals("M")) {
                        vista.getMasculino().setSelected(true);
                    } else {
                        if (persona.getGenero_per().equals("F")) {
                            vista.getFemenino().setSelected(true);
                        } else {
                            vista.getNoBinario().setSelected(true);
                        }
                    }

                    vista.getTxtTelefono().setText(persona.getTelefono_per());
                    vista.getFechaNacimiento().setDate(persona.getFechaNacimiento_per());
                    vista.getTxtEmail().setText(persona.getEmail_per());
                    vista.getTxtDireccion().setText(persona.getDireccion_per());
                    codigoEstudiante = persona.getPk_idestudiante();//Asigno el codigo del estudiante a la variable
                }
            });
        }
    }

    public void cargarDatosPersonaEnTXT() {
        int fila = vista.getTblDlgPersonas().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            ModeloPersona modeloPersona = new ModeloPersona();
            List<Persona> listap = modeloPersona.enlistaPersonas();

            listap.stream().forEach(persona -> {

                if (persona.getCedula_per().equals(vista.getTblDlgPersonas().getValueAt(fila, 0).toString())) {

                    //vista.getTxtCodigoPersona().setText(String.valueOf(persona.getPer_codigo())); //SE PUEDE ELIMINAR
                    vista.getTxtCedula().setText(persona.getCedula_per());
                    vista.getTxtPrimerNombre().setText(persona.getPrimeNombre_per());
                    vista.getTxtSegundoNombre().setText(persona.getSegundoNombre_per());
                    vista.getTxtPrimerApellido().setText(persona.getApellidoPat_per());
                    vista.getTxtSegundoApellido().setText(persona.getApellidoMat_per());

                    if (persona.getGenero_per().equals("M")) {
                        vista.getMasculino().setSelected(true);
                    } else {
                        if (persona.getGenero_per().equals("F")) {
                            vista.getFemenino().setSelected(true);
                        } else {
                            vista.getNoBinario().setSelected(true);
                        }
                    }

                    vista.getTxtTelefono().setText(persona.getTelefono_per());
                    vista.getFechaNacimiento().setDate(persona.getFechaNacimiento_per());
                    vista.getTxtEmail().setText(persona.getEmail_per());
                    vista.getTxtDireccion().setText(persona.getDireccion_per());

                }
            });

            vista.getjDlgBuscarPersonas().dispose();

        }
    }

    //Todo sobre el registro de personas en el jDialog
    public void abrirjDialogPersonas() {
        vista.getjDlgBuscarPersonas().setVisible(true);
        vista.getjDlgBuscarPersonas().setSize(763, 366);
        vista.getjDlgBuscarPersonas().setLocationRelativeTo(null);
        vista.getjDlgBuscarPersonas().setTitle("Seleccione una persona");
        cargarRegistroDePersonas();
        buscarPersona();
    }

//    public void buscarPersona() {
//
//        KeyListener eventoTeclado = new KeyListener() {//Crear un objeto de tipo keyListener(Es una interface) por lo tanto se debe implementar sus metodos abstractos
//
//            @Override
//            public void keyTyped(KeyEvent e) {
//                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//
//                ModeloPersona modeloPersona = new ModeloPersona();
//                vista.getTblDlgPersonas().setRowHeight(25);
//                DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTblDlgPersonas().getModel();
//                estructuraTabla.setRowCount(0);
//
//                List<Persona> listap = (List<Persona>) modeloPersona.consultarPersona(vista.getTxtBuscarPer().getText());
//
//                Holder<Integer> i = new Holder<>(0);
//
//                listap.stream().forEach(persona -> {
//
//                    estructuraTabla.addRow(new Object[8]);
//
//                    vista.getTblDlgPersonas().setValueAt(persona.getCedula_per(), i.value, 0);
//                    vista.getTblDlgPersonas().setValueAt(persona.getPrimeNombre_per(), i.value, 1);
//                    vista.getTblDlgPersonas().setValueAt(persona.getApellidoPat_per(), i.value, 2);
//                    vista.getTblDlgPersonas().setValueAt(persona.getTelefono_per(), i.value, 3);
//                    vista.getTblDlgPersonas().setValueAt(persona.getEmail_per(), i.value, 4);
//
//                    i.value++;
//                });
//            }
//        };
//
//        vista.getTxtBuscarPer().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
//    }
    
    
    public void buscarPersona() {
    KeyListener eventoTeclado = new KeyAdapter() { // Utilizamos la clase KeyAdapter en lugar de implementar KeyListener

        @Override
        public void keyReleased(KeyEvent e) {
            ModeloPersona modeloPersona = new ModeloPersona();
            vista.getTblDlgPersonas().setRowHeight(25);
            DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTblDlgPersonas().getModel();
            estructuraTabla.setRowCount(0);

            List<Persona> listap = (List<Persona>) modeloPersona.consultarPersona(vista.getTxtBuscarPer().getText());

            int contador = 0;

            for (Persona persona : listap) {
                estructuraTabla.addRow(new Object[8]);

                vista.getTblDlgPersonas().setValueAt(persona.getCedula_per(), contador, 0);
                vista.getTblDlgPersonas().setValueAt(persona.getPrimeNombre_per(), contador, 1);
                vista.getTblDlgPersonas().setValueAt(persona.getApellidoPat_per(), contador, 2);
                vista.getTblDlgPersonas().setValueAt(persona.getTelefono_per(), contador, 3);
                vista.getTblDlgPersonas().setValueAt(persona.getEmail_per(), contador, 4);

                contador++;
            }
        }
    };

    vista.getTxtBuscarPer().addKeyListener(eventoTeclado);
}

    

//    public void cargarRegistroDePersonas() {
//
//        ModeloPersona modeloPersona = new ModeloPersona();
//        vista.getTblDlgPersonas().setRowHeight(25);
//        DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTblDlgPersonas().getModel();
//        estructuraTabla.setRowCount(0);
//
//        List<Persona> listap = modeloPersona.enlistaPersonas();
//
//        Holder<Integer> i = new Holder<>(0);
//
//        listap.stream().forEach(persona -> {
//
//            estructuraTabla.addRow(new Object[8]);
//
//            vista.getTblDlgPersonas().setValueAt(persona.getCedula_per(), i.value, 0);
//            vista.getTblDlgPersonas().setValueAt(persona.getPrimeNombre_per(), i.value, 1);
//            vista.getTblDlgPersonas().setValueAt(persona.getSegundoNombre_per(), i.value, 2);
//            vista.getTblDlgPersonas().setValueAt(persona.getTelefono_per(), i.value, 3);
//            vista.getTblDlgPersonas().setValueAt(persona.getEmail_per(), i.value, 4);
//
//            i.value++;
//        });
//    }

    public void cargarRegistroDePersonas() {
    ModeloPersona modeloPersona = new ModeloPersona();
    vista.getTblDlgPersonas().setRowHeight(25);
    DefaultTableModel estructuraTabla = (DefaultTableModel) vista.getTblDlgPersonas().getModel();
    estructuraTabla.setRowCount(0);

    List<Persona> listap = modeloPersona.enlistaPersonas();

    int contador = 0;

    for (Persona persona : listap) {
        estructuraTabla.addRow(new Object[8]);

        vista.getTblDlgPersonas().setValueAt(persona.getCedula_per(), contador, 0);
        vista.getTblDlgPersonas().setValueAt(persona.getPrimeNombre_per(), contador, 1);
        vista.getTblDlgPersonas().setValueAt(persona.getSegundoNombre_per(), contador, 2);
        vista.getTblDlgPersonas().setValueAt(persona.getTelefono_per(), contador, 3);
        vista.getTblDlgPersonas().setValueAt(persona.getEmail_per(), contador, 4);

        contador++;
    }
}

    
    
//    public void abrirjDlgEstudiante() {
//
//        vista.getjDlgEstudiante().setVisible(true);
//        vista.getjDlgEstudiante().setSize(840, 610);
//        vista.getjDlgEstudiante().setLocationRelativeTo(null);
//        vista.getjDlgEstudiante().setName("Crear nuevo estudiante");
//        vista.getjDlgEstudiante().setTitle("Crear nuevo estudiante");
//        limpiarCampos();
//        bloquearCampos1();
//    }
//    public void crearEditarEstudiante() {
//
//        if ("Crear nuevo estudiante".equals(vista.getjDlgEstudiante().getName())) {
//
//            if (validarDatos()) {
//                ModeloPersona persona = new ModeloPersona();
//
//                if (modelo.traerEstadoDelEstudiante(persona.(vista.getTxtCedula().getText())).equals("A")) {
//
//                    JOptionPane.showMessageDialog(null, "Esta persona ya ha sido ha asignada como estudiante");
//                } else {
//                    if (modelo.traerEstadoDelEstudiante(persona.traerCodigoDePersonaCrear(vista.getTxtCedula().getText())).equals("I")) {
//                        if (modelo.crearEstudiante2(persona.traerCodigoDePersonaCrear(vista.getTxtCedula().getText())) == null) {
//                            JOptionPane.showMessageDialog(null, "Estudiante asignado correctamente");
//                        }
//                    } else {
//                        //Setear Datos de estudiante
//                        ModeloEstudiante estudiantes = new ModeloEstudiante();
//                        estudiantes.setEst_codper(persona.traerCodigoDePersonaCrear(vista.getTxtCedula().getText()));
//
//                        if (estudiantes.crearEstudiante() == null) {
//
//                            JOptionPane.showMessageDialog(null, "Estudiante asignado correctamente");
//
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Error al asignar el rol de estudiante");
//                        }
//                    }
//                }
//            }
//        } else {
//
//            if (validarDatos()) {
//                ModeloPersona persona = new ModeloPersona();
//
//                if (modelo.traerEstadoDelEstudiante(persona.traerCodigoDePersonaCrear(vista.getTxtCedula().getText())).equals("A")) {
//
//                    JOptionPane.showMessageDialog(null, "Esta persona ya ha sido ha asignada como estudiante");
//                } else {
//                    if (modelo.traerEstadoDelEstudiante(persona.traerCodigoDePersonaCrear(vista.getTxtCedula().getText())).equals("I")) {
//                        if (modelo.modificarEstudiante2(persona.traerCodigoDePersonaCrear(vista.getTxtCedula().getText())) == null) {
//                            if (modelo.eliminarEstudiante(codigoEstudiante) == null) {
//                                JOptionPane.showMessageDialog(null, "Estudiante modificado correctamente. Cambio estado");
//                            }
//                        }
//                    } else {
//
//                        //Setear Datos de estudiante
//                        modelo.setEst_codigo(codigoEstudiante);
//                        System.out.println("Codigo del estudiante: " + codigoEstudiante);
//                        modelo.setEst_codper(persona.traerCodigoDePersonaCrear(vista.getTxtCedula().getText()));
//                        System.out.println("Codigo de la persona: " + persona.traerCodigoDePersonaCrear(vista.getTxtCedula().getText()));
//
//                        if (modelo.modificarEstudiante() == null) {
//
//                            JOptionPane.showMessageDialog(null, "Estudiante modificado correctamente. Modificado");
//
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Error al modificar estudiante");
//                        }
//                    }
//                }
//            }
//        }
//
//        cargarTablaDeEstudiantes();
//    }
    public boolean validarDatos() {

        boolean validar = true;

        if (vista.getTxtCedula().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione una persona");
            validar = false;
        }
        return validar;
    }

    public void cargarTablaDeEstudiantes() {
        DefaultTableModel tabla = (DefaultTableModel) vista.getTblEstudiante().getModel();
        tabla.setNumRows(0);

        List<Estudiante> docentes = modelo.listaEstudiantesTabla();
        docentes.stream().forEach(p -> {
            String[] datos = {String.valueOf(p.getPk_idestudiante()), p.getCedula_per(), p.getPrimeNombre_per() + " " + p.getApellidoPat_per(), p.getTelefono_per(), p.getGenero_per()};
            tabla.addRow(datos);
        });
    }

//           public void imprimir() {
//
//        ConexionPG cpg = new ConexionPG();//Instanciar la conexion con esto abrimos la conexion a la BD
//        try {
////            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/EstudianteReporte.jasper"));
//
//            //Hacer una vista previa
//            //JasperPrint jp = JasperFillManager.fillReport(jr, null, cpg.getCon());//JasperFillManager.fillReport: Carga los datos de la BD.//JasperPrint: Hace la impresion del reporte. Puede ir 'null' si en el jasper no existen parametros caso contrario se envian los parametros necesarios
//            Map<String, Object> parametros = new HashMap<String, Object>();
//
//            parametros.put("ImagenRuta", "src/imagenesJasper/estudiante.png"); //En donde esta 'titulo' tienen que ser igual al nombre que esta en el parametro del jasper
//
//            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, cpg.getCon());//'parametros' es el Map recien creado que contiene los parametros que iran al jasper
//
//            JasperViewer jv = new JasperViewer(jp, false); //Se pasa false para que no se cierre el sistema 
//            jv.setVisible(true);
//
//        } catch (JRException ex) {
//            Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public void buscarEstudiante() {

        KeyListener eventoTeclado = new KeyListener() {//Crear un objeto de tipo keyListener(Es una interface) por lo tanto se debe implementar sus metodos abstractos

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {

                DefaultTableModel tabla = (DefaultTableModel) vista.getTblEstudiante().getModel();
                tabla.setNumRows(0);

                List<Estudiante> estudiantes = modelo.buscarEstudiante(vista.getTxtBuscar().getText());
                estudiantes.stream().forEach(p -> {
                    String[] datos = {p.getCedula_per(), p.getPrimeNombre_per() + " " + p.getApellidoPat_per(), p.getTelefono_per(), p.getGenero_per()};
                    tabla.addRow(datos);
                });
            }
        };

        vista.getTxtBuscar().addKeyListener(eventoTeclado); //"addKeyListener" es un metodo que se le tiene que pasar como argumento un objeto de tipo keyListener 
    }

    public void limpiarCampos() {
        vista.getTxtCedula().setText("");
        vista.getTxtPrimerNombre().setText("");
        vista.getTxtSegundoNombre().setText("");
        vista.getTxtPrimerApellido().setText("");
        vista.getTxtSegundoApellido().setText("");
        vista.getGenero().clearSelection();
        vista.getTxtTelefono().setText("");
        vista.getFechaNacimiento().setDate(null);
        vista.getTxtEmail().setText("");
        vista.getTxtDireccion().setText("");
    }

    public void bloquearCampos1() {
        vista.getTxtCedula().setEditable(false);
        vista.getTxtPrimerNombre().setEditable(false);
        vista.getTxtSegundoNombre().setEditable(false);
        vista.getTxtPrimerApellido().setEditable(false);
        vista.getTxtSegundoApellido().setEditable(false);
        vista.getMasculino().setEnabled(false);
        vista.getFemenino().setEnabled(false);
        vista.getNoBinario().setEnabled(false);
        vista.getTxtTelefono().setEditable(false);
        vista.getFechaNacimiento().setEnabled(false);
        vista.getTxtEmail().setEditable(false);
        vista.getTxtDireccion().setEditable(false);
    }

}
