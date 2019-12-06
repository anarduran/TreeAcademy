package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;

import interfaz.GUIAplicacion;
import treeAcademy.*;
import usuarios.*;

/**
 * Esta clase define el controlador propio del estudiante
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class ControladorEstudiante implements ActionListener{
	TreeAcademy ta;
	GUIAplicacion gui;
	
	public ControladorEstudiante(TreeAcademy app, GUIAplicacion gui){
		this.ta = app;
		this.gui = gui;
		gui.getVistaEstudiante().setControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().compareTo("Salir") == 0){
			try {
				ta.cerrarSesion();
				gui.getCard_layout().show(gui.getPantallas(), "Login");
				gui.getVistaLogin().clear();
				gui.getVistaEstudiante().getLista_asignaturas().removeAllElements();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}else if (e.getActionCommand().compareTo("Solicitar") == 0){
			String asign = gui.getVistaEstudiante().getLista2().getSelectedValue();
			Asignatura a = TreeAcademy.buscarAsignatura(asign);
			for (Estudiante es : TreeAcademy.getEstudiantes()){
				if (es.getIniciado()){
					if (es.getMatriculas().size() == 0){
						ta.solicitarMatricula(a, es);
	            		JOptionPane.showMessageDialog(gui, "Solicitud realizada correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						for (Matricula m: ta.getMatriculas()){
							gui.getVistaProfesor().getLista_matriculas().addElement(m.getId()+ "-" + es.getNuma()+ "-"+ es.getApellido() + "-"+ a.getNombreAsignatura());
							break;
						}
						
					}else{
						for (Matricula m : es.getMatriculas()){
							if (m.getAsignaturas().equals(a)){
								JOptionPane.showMessageDialog(gui, "Error. Ya tiene solicitada esa asignatura", "Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
						}
						
						ta.solicitarMatricula(a, es);
				        JOptionPane.showMessageDialog(gui, "Solicitud realizada correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						for (Matricula ma: ta.getMatriculas()){
							gui.getVistaProfesor().getLista_matriculas().addElement(ma.getId()+ "-" + es.getNuma()+ "-"+ es.getApellido() + "-"+ a.getNombreAsignatura());
							break;
						}
					}
				}
			}
			
		}else if (e.getActionCommand().compareTo("Ir") == 0){
			String a = gui.getVistaEstudiante().getLista_asignaturas2().getSelectedValue();
			
			if (a == null){
				JOptionPane.showMessageDialog(gui, "Error. Seleccione una asignatura", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				Asignatura as = TreeAcademy.buscarAsignatura(a);
				
				if (as == null){
					JOptionPane.showMessageDialog(gui, "Error", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					
					if (as.getVisibile()){
						gui.getVistaAsignaturaEst().setNombre(a);
						gui.getCard_layout().show(gui.getPantallas(), "Asignatura Estudiante");
						for (Tema t : as.getTemas()){
							gui.getVistaAsignaturaEst().getLista().addElement(t.getNombre());
						}
						
					}else{
						JOptionPane.showMessageDialog(gui, "La asignauta no esta disponible", "No disponible", JOptionPane.INFORMATION_MESSAGE);
					}	
				}	
			}		
		}
	}	
}