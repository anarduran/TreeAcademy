package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import interfaz.GUIAplicacion;
import treeAcademy.*;

/**
 * Esta clase define el controlador para que un estudiante acceda a una asignatura
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class ControladorAsignaturaEst implements ActionListener{
	private TreeAcademy ta;
	private GUIAplicacion gui;
	
	public ControladorAsignaturaEst(TreeAcademy ta, GUIAplicacion gui){
		this.ta = ta;
		this.gui = gui;
		gui.getVistaAsignaturaEst().setControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().compareTo("Salir") == 0){
			try {
				ta.cerrarSesion();
				gui.getVistaAsignaturaProf().clear();
				gui.getCard_layout().show(gui.getPantallas(), "Login");
				gui.getVistaLogin().clear();
				gui.getVistaAsignaturaEst().getLista().removeAllElements();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}else if (e.getActionCommand().compareTo("Inicio") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Estudiante");
			gui.getVistaProfesor().clear();
			gui.getVistaAsignaturaEst().getLista().removeAllElements();
			
		}else if (e.getActionCommand().compareTo("Volver") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Estudiante");
			gui.getVistaAsignaturaProf().clear();
			gui.getVistaAsignaturaEst().getLista().removeAllElements();
			
		}else if (e.getActionCommand().compareTo("Acceder") == 0){
			String tema = gui.getVistaAsignaturaEst().getLista2().getSelectedValue();
			
			if (tema == null){
				JOptionPane.showMessageDialog(gui, "Error. Seleccione un tema de la lista", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				String nombre = gui.getVistaAsignaturaEst().getNombre().getText();
				if (nombre == null){
					JOptionPane.showMessageDialog(gui, "Error");
				}else{
					Asignatura a = TreeAcademy.buscarAsignatura(nombre);
					if (a == null){
						JOptionPane.showMessageDialog(gui, "Error");
					}else{
							gui.getVistaTemaEst().setNombre(nombre + ">" + tema);
							
							Tema t = a.buscarTema(tema);
							if (t == null){
								JOptionPane.showMessageDialog(gui, "Error");
							}else{
								for (ItemAsig it : t.getItems()){
									if (it instanceof Tema){
										gui.getVistaTemaEst().getLista_sub().addElement(it.getNombre());
									}else if (it instanceof Apunte){
										gui.getVistaTemaEst().getLista_apun().addElement(it.getNombre());
									}else{
										gui.getVistaTemaEst().getLista_ejer().addElement(it.getNombre());
									}
								}
								if (t.getVisibilidad()){
									gui.getCard_layout().show(gui.getPantallas(), "Tema Estudiante");
								}else{
									JOptionPane.showMessageDialog(gui, "Error. Ese tema no esta disponible", "No disponible", JOptionPane.ERROR_MESSAGE);
								}
							}
					}
				}
			}
		}
	}
}