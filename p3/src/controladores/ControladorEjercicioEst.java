package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import interfaz.GUIAplicacion;
import interfaz.VistaPregunta;
import treeAcademy.*;

/**
 * Esta clase define el controlador para acceda a un ejercicio
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class ControladorEjercicioEst implements ActionListener{
	private TreeAcademy ta;
	private GUIAplicacion gui;
	
	@SuppressWarnings("unused")
	public ControladorEjercicioEst(TreeAcademy ta, GUIAplicacion gui){
		this.ta = ta;
		this.gui = gui;
		gui.getVistaAsignaturaEst().setControlador(this);
		ArrayList<VistaPregunta> vistaPreguntas;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().compareTo("Salir") == 0){
			try {
				ta.cerrarSesion();
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
			
		}else if (e.getActionCommand().compareTo("Volver") == 0){
			//MOSTRAR PANTALLA ANTERIOR
			gui.getVistaAsignaturaProf().clear();
			
		}else{
			
			/*VistaEjercicioProf panel = gui.getVistaEjercicioProf();*/
			
			/*for (VistaPregunta panelPreg : panel.getVistaPreguntas()) {

			}*/
		}
	}
}