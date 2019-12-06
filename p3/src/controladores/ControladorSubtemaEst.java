package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import interfaz.GUIAplicacion;
import treeAcademy.Apunte;
import treeAcademy.Asignatura;
import treeAcademy.ItemAsig;
import treeAcademy.Tema;
import treeAcademy.TreeAcademy;

/**
 * Esta clase define el controlador para que un estudiante acceda a un subtema
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class ControladorSubtemaEst implements ActionListener{
	TreeAcademy ta;
	GUIAplicacion gui;
	
	public ControladorSubtemaEst(TreeAcademy ta, GUIAplicacion gui){
		this.ta = ta;
		this.gui = gui;
		gui.getVistaSubtemaEst().setControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().compareTo("Salir") == 0){
			try {
				ta.cerrarSesion();
				gui.getCard_layout().show(gui.getPantallas(), "Login");
				gui.getVistaSubtemaEst().getLista_apun().removeAllElements();
				gui.getVistaSubtemaEst().getLista_ejer().removeAllElements();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}else if (e.getActionCommand().compareTo("Inicio") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Estudiante");
			gui.getVistaSubtemaEst().getLista_apun().removeAllElements();
			gui.getVistaSubtemaEst().getLista_ejer().removeAllElements();
			
		}else if (e.getActionCommand().compareTo("Volver") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Tema Estudiante");
			gui.getVistaSubtemaEst().getLista_apun().removeAllElements();
			gui.getVistaSubtemaEst().getLista_ejer().removeAllElements();
	
		}else if (e.getActionCommand().compareTo("Acceder apunte") == 0){
			String nombre = gui.getVistaSubtemaEst().getNombre().getText();
			
			if (nombre == null){
				JOptionPane.showMessageDialog(gui, "Error", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				String partes[] = nombre.split(">");
				String asig = partes[0];
				String tema = partes[1];
				String st = partes[2];
				
				Asignatura a = TreeAcademy.buscarAsignatura(asig);
				Tema t = a.buscarTema(tema);
				Tema subt = (Tema) t.buscarItem(st);
				
				for (ItemAsig it : subt.getItems()){
					if (it instanceof Apunte){
						gui.getVistaApunteEst().getApunte().setText(((Apunte) it).getContenido());
					}
				}
				gui.getVistaApunteEst().setTitulo(gui.getVistaSubtemaEst().getLista_apun2().getSelectedValue());
				gui.getCard_layout().show(gui.getPantallas(), "Apunte Estudiante");
			}
			
		}else if (e.getActionCommand().compareTo("Acceder ejercicio") == 0){
			
		}
	}
}