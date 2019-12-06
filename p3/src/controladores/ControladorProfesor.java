package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import interfaz.GUIAplicacion;
import treeAcademy.*;
import usuarios.*;

/**
 * Esta clase define el controlador propio del profesor
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class ControladorProfesor implements ActionListener{
	TreeAcademy ta;
	GUIAplicacion gui;
	
	public ControladorProfesor(TreeAcademy app, GUIAplicacion gui){
		this.ta = app;
		this.gui = gui;
		gui.getVistaProfesor().setControlador(this);
	}
	
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField crear = gui.getVistaProfesor().getCampoCrear();
		Asignatura asignatura;
		
		if (e.getActionCommand().compareTo("Salir") == 0){
			try {
				ta.cerrarSesion();
				gui.getCard_layout().show(gui.getPantallas(), "Login");
				gui.getVistaLogin().clear();
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}else if (e.getActionCommand().compareTo("Crear") == 0){
			if (crear.getText().compareTo("") == 0){
				JOptionPane.showMessageDialog(gui, "Error. Rellene el campo", "Error", 0);
				gui.getVistaProfesor().clear();
			}else{
				if (TreeAcademy.buscarAsignatura(crear.getText()) != null){
					JOptionPane.showMessageDialog(gui, "Error. Asignatura ya existente", "Error", 0);
					gui.getVistaProfesor().clear();
				}else{
					asignatura = new Asignatura(crear.getText());
					TreeAcademy.aniadirAsignatura(asignatura);
					gui.getVistaProfesor().getLista().addElement(asignatura.getNombreAsignatura());
					gui.getVistaEstudiante().getLista().addElement(asignatura.getNombreAsignatura());
					JOptionPane.showMessageDialog(gui, "Asginatura creada correctamente", "Creacion de asignatura", JOptionPane.INFORMATION_MESSAGE);
					gui.getVistaProfesor().clear();
					asignatura.setVisibilidad(gui.getVistaProfesor().getVisibilidad_seleccionada());
					gui.getVistaProfesor().getVisibilidad().setSelected(false);
				}
			}
			
		}else if(e.getActionCommand().compareTo("Aceptar") == 0){
			String asign = gui.getVistaProfesor().getLista_matriculas2().getSelectedValue();
			
			if (asign != null){
				String [] partes = asign.split("-");
				String id = partes[0];
				String numa = partes[1];
				String apellido = partes[2];
				String a = partes[3];
				
				Asignatura as = TreeAcademy.buscarAsignatura(a);
				Estudiante es = TreeAcademy.buscarEstudiante(numa);
			
				try {
					ta.aceptarSolicitud(es, as);
					gui.getVistaProfesor().getLista_matriculas().remove(gui.getVistaProfesor().getLista_matriculas2().getSelectedIndex());
					JOptionPane.showMessageDialog(gui, "Solicitud aceptada");
				} catch (FailedInternetConnectionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvalidEmailAddressException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}else{
				JOptionPane.showMessageDialog(gui, "Error al aceptar la solicitud", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}else if (e.getActionCommand().compareTo("Rechazar") == 0){
			String asign = gui.getVistaProfesor().getLista_matriculas2().getSelectedValue();
			String [] partes = asign.split("-");
			String id = partes[0];
			String numa = partes[1];
			String apellido = partes[2];
			String a = partes[3];
			
			Asignatura as = TreeAcademy.buscarAsignatura(a);
			Estudiante es = TreeAcademy.buscarEstudiante(numa);
			
			try {
				ta.rechazarSolicitud(es, as);
				gui.getVistaEstudiante().getLista_asignaturas().removeElement(as.getNombreAsignatura());
				gui.getVistaProfesor().getLista_matriculas().remove(gui.getVistaProfesor().getLista_matriculas2().getSelectedIndex());
			} catch (FailedInternetConnectionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidEmailAddressException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(gui, "Solicitud Rechazada");
			
		}else if(e.getActionCommand().compareTo("Ir") == 0) {
			String a = gui.getVistaProfesor().getLista2().getSelectedValue();
			Asignatura asig = TreeAcademy.buscarAsignatura(a);
			
			if (a == null || asig == null){
				JOptionPane.showMessageDialog(gui, "Seleccione una asignatura de la lista", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				for (Tema t: asig.getTemas()){
					gui.getVistaAsignaturaProf().getLista().addElement(t.getNombre());
				}
				gui.getVistaAsignaturaProf().setNombre(a);
				if (asig.getVisibile()){
					gui.getVistaAsignaturaProf().setVisibilidad_eti("Estado: VISIBLE");
				}else{
					gui.getVistaAsignaturaProf().setVisibilidad_eti("Estado: INVISIBLE");
				}
				gui.getCard_layout().show(gui.getPantallas(), "Asignatura Profesor");
				gui.getVistaProfesor().clear();
			}
		}	
	}
}