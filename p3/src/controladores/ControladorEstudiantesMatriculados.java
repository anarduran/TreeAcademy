package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import interfaz.GUIAplicacion;
import treeAcademy.*;
import usuarios.*;

/**
 * Esta clase define el controlador para gestionar los estudiantes matriculados
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class ControladorEstudiantesMatriculados implements ActionListener{
	TreeAcademy ta;
	GUIAplicacion gui;
	
	public ControladorEstudiantesMatriculados(TreeAcademy ta, GUIAplicacion gui){
		this.ta = ta;
		this.gui = gui;
		gui.getVistaEstudiantesMatriculados().setControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().compareTo("Salir") == 0){
			try {
				ta.cerrarSesion();
				gui.getCard_layout().show(gui.getPantallas(), "Login");
				gui.getVistaLogin().clear();
				gui.getVistaEstudiantesMatriculados().getLista_bloqueados().removeAllElements();
				gui.getVistaEstudiantesMatriculados().getLista_estudiantes().removeAllElements();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}else if (e.getActionCommand().compareTo("Inicio") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Profesor");
			gui.getVistaEstudiantesMatriculados().getLista_bloqueados().removeAllElements();
			gui.getVistaEstudiantesMatriculados().getLista_estudiantes().removeAllElements();
			
		}else if (e.getActionCommand().compareTo("Volver") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Asignatura Profesor");
			gui.getVistaEstudiantesMatriculados().getLista_bloqueados().removeAllElements();
			gui.getVistaEstudiantesMatriculados().getLista_estudiantes().removeAllElements();
	
		}else if (e.getActionCommand().compareTo("Bloquear") == 0){
			String estudiante = gui.getVistaEstudiantesMatriculados().getLista_estudiantes2().getSelectedValue();
			
			if (estudiante == null){
				JOptionPane.showMessageDialog(gui, "Error. Seleccione un estudiante a bloquear", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				String partes[] = estudiante.split(",");
				String numa = partes[0];
				String asignatura = gui.getVistaAsignaturaProf().getNombre().getText();
				
				if (asignatura == null){
					JOptionPane.showMessageDialog(gui, "Error", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					Asignatura a = TreeAcademy.buscarAsignatura(asignatura);
					Estudiante es = TreeAcademy.buscarEstudiante(numa);
					
					if (a == null || es == null){
						JOptionPane.showMessageDialog(gui, "Error", "Error", JOptionPane.ERROR_MESSAGE);
					}else{
						try {
							ta.expulsarEstudiante(es, a);
							JOptionPane.showMessageDialog(gui, "Estudiante bloqueado", "Bloqueado", JOptionPane.INFORMATION_MESSAGE);
							gui.getVistaEstudiantesMatriculados().getLista_bloqueados().addElement(estudiante);
							gui.getVistaEstudiantesMatriculados().getLista_estudiantes().removeElement(estudiante);
							gui.getVistaEstudiante().getLista_asignaturas().removeElement(asignatura);
						} catch (FailedInternetConnectionException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InvalidEmailAddressException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}	
				}
			}
			
		}else if (e.getActionCommand().compareTo("Readmitir") == 0){
			
			String bloqueado = gui.getVistaEstudiantesMatriculados().getLista_bloqueados2().getSelectedValue();
			
			if (bloqueado == null){
				JOptionPane.showMessageDialog(gui, "Error. Seleccione un estudiante a readmitir", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				
				String partes[] = bloqueado.split(",");
				String numa = partes[0];
				String asignatura = gui.getVistaAsignaturaProf().getNombre().getText();
				
				if (asignatura == null){
					JOptionPane.showMessageDialog(gui, "Error", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					Asignatura a = TreeAcademy.buscarAsignatura(asignatura);
					Estudiante es = TreeAcademy.buscarEstudiante(numa);
					
					if (a == null || es == null){
						JOptionPane.showMessageDialog(gui, "Error", "Error", JOptionPane.ERROR_MESSAGE);
					}else{
						try {
							ta.readmitirEstudiante(es, a);
							JOptionPane.showMessageDialog(gui, "Estudiante readmitido", "Readmitido", JOptionPane.INFORMATION_MESSAGE);
							gui.getVistaEstudiantesMatriculados().getLista_bloqueados().removeElement(bloqueado);
							gui.getVistaEstudiantesMatriculados().getLista_estudiantes().addElement(bloqueado);
							gui.getVistaEstudiante().getLista_asignaturas().addElement(asignatura);
						} catch (FailedInternetConnectionException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InvalidEmailAddressException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		}
	}
}