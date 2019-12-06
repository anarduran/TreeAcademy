package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import interfaz.GUIAplicacion;
import treeAcademy.TreeAcademy;

/**
 * Esta clase define el controlador para que un profesor pueda modificar un ejercicio
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class ControladorModificarEjercicio implements ActionListener{
	TreeAcademy ta;
	GUIAplicacion gui;
	
	public ControladorModificarEjercicio(TreeAcademy ta, GUIAplicacion gui){
		this.ta = ta;
		this.gui = gui;
		gui.getVistaModificarEjercicio().setControlador(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().compareTo("Salir") == 0){
			try {
				ta.cerrarSesion();
				gui.getVistaAsignaturaProf().clear();
				gui.getCard_layout().show(gui.getPantallas(), "Login");
				gui.getVistaLogin().clear();
				gui.getVistaModificarEjercicio().clear();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}else if (e.getActionCommand().compareTo("Inicio") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Profesor");
			gui.getVistaModificarEjercicio().clear();
			
		}else if (e.getActionCommand().compareTo("Volver") == 0){
			String nombre = gui.getVistaModificarEjercicio().getNombre().getText();
			
			if (nombre == null){
				JOptionPane.showMessageDialog(gui, "Error");
			}else{
				String partes[] = nombre.split(">");
				if (partes.length == 5){
					gui.getCard_layout().show(gui.getPantallas(), "Subtema Profesor");
					gui.getVistaModificarEjercicio().clear();
				}else{
					gui.getCard_layout().show(gui.getPantallas(), "Tema Profesor");
					gui.getVistaModificarEjercicio().clear();
				}
			}
		}
		
	}

}
