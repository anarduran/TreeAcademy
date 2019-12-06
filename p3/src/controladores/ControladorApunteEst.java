package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import interfaz.GUIAplicacion;
import treeAcademy.TreeAcademy;

/**
 * Esta clase define el controlador para que un estudiante acceda a un apunte
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class ControladorApunteEst implements ActionListener{
	TreeAcademy ta;
	GUIAplicacion gui;
	
	public ControladorApunteEst(TreeAcademy ta, GUIAplicacion gui){
		this.ta = ta;
		this.gui = gui;
		gui.getVistaApunteEst().setControlador(this);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().compareTo("Salir") == 0){
			try {
				ta.cerrarSesion();
				gui.getCard_layout().show(gui.getPantallas(), "Login");
				gui.getVistaLogin().clear();
				gui.getVistaApunteEst().clear();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}else if (e.getActionCommand().compareTo("Inicio") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Estudiante");
			gui.getVistaApunteEst().clear();
			
		}else if (e.getActionCommand().compareTo("Volver") == 0){
			String nombre = gui.getVistaApunteEst().getNombre().getText();
			
			if (nombre == null){
				JOptionPane.showMessageDialog(gui, "Error", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				String partes[] = nombre.split(">");
				if (partes.length == 4){
					gui.getCard_layout().show(gui.getPantallas(), "Subtema Estudiante");
					gui.getVistaApunteEst().clear();
				}else{
					gui.getCard_layout().show(gui.getPantallas(), "Tema Estudiante");
					gui.getVistaApunteEst().clear();
				}
			}
			
		}
		
	}
}