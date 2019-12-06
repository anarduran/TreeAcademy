package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import interfaz.GUIAplicacion;
import treeAcademy.TreeAcademy;

/**
 * Esta clase define el controlador para que un profesor acceda a las estadisticas
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class ControladorEstadisticas implements ActionListener{
	TreeAcademy ta;
	GUIAplicacion gui;
	
	public ControladorEstadisticas(TreeAcademy ta, GUIAplicacion gui){
		this.ta = ta;
		this.gui = gui;
		gui.getVistaEstadisticas().setControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().compareTo("Salir") == 0){
			try {
				ta.cerrarSesion();
				gui.getCard_layout().show(gui.getPantallas(), "Login");
				gui.getVistaLogin().clear();
				int filas = gui.getVistaEstadisticas().getTabla_alumno().getRowCount();
				for (int i = 0; i< filas; i++){
					gui.getVistaEstadisticas().getTabla_alumno().removeRow(i);
				}
				int filas2 = gui.getVistaEstadisticas().getTabla_estadistica().getRowCount();
				for (int j = 0; j< filas2; j++){
					gui.getVistaEstadisticas().getTabla_estadistica().removeRow(j);
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}else if (e.getActionCommand().compareTo("Inicio") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Profesor");
			int filas = gui.getVistaEstadisticas().getTabla_alumno().getRowCount();
			for (int i = 0; i<= filas; i++){
				gui.getVistaEstadisticas().getTabla_alumno().removeRow(i);
			}
			int filas2 = gui.getVistaEstadisticas().getTabla_estadistica().getRowCount();
			for (int j = 0; j<= filas2; j++){
				gui.getVistaEstadisticas().getTabla_estadistica().removeRow(j);
			}
			
		}else if (e.getActionCommand().compareTo("Volver") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Asignatura Profesor");
			int filas = gui.getVistaEstadisticas().getTabla_alumno().getRowCount();
			for (int i = 0; i<= filas; i++){
				gui.getVistaEstadisticas().getTabla_alumno().removeRow(i);
			}
			int filas2 = gui.getVistaEstadisticas().getTabla_estadistica().getRowCount();
			for (int j = 0; j<= filas2; j++){
				gui.getVistaEstadisticas().getTabla_estadistica().removeRow(j);
			}
		}
	}
}