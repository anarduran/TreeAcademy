package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

import interfaz.GUIAplicacion;
import treeAcademy.*;
import usuarios.Estudiante;

/**
 * Esta clase define el controlador para que un profesor acceda y cree una asignatura
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class ControladorAsignaturaProf implements ActionListener{
	TreeAcademy ta;
	GUIAplicacion gui;
	Asignatura asignatura;
	
	public ControladorAsignaturaProf(TreeAcademy app, GUIAplicacion gui){
		this.ta = app;
		this.gui = gui;
		gui.getVistaAsignaturaProf().setControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField crear = gui.getVistaAsignaturaProf().getCampoCrear();
		
		if (e.getActionCommand().compareTo("Salir") == 0){
			try {
				ta.cerrarSesion();
				gui.getVistaAsignaturaProf().clear();
				gui.getCard_layout().show(gui.getPantallas(), "Login");
				gui.getVistaLogin().clear();
				if (gui.getVistaAsignaturaProf().getVisibilidad2_()){
					String nombre = gui.getVistaAsignaturaProf().getNombre().getText();
					Asignatura a = TreeAcademy.buscarAsignatura(nombre);
					a.setVisibilidad(true);
				}else if (gui.getVistaAsignaturaProf().getInvisible_()){
					String nombre = gui.getVistaAsignaturaProf().getNombre().getText();
					Asignatura a = TreeAcademy.buscarAsignatura(nombre);
					a.setVisibilidad(false);
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}else if (e.getActionCommand().compareTo("Inicio") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Profesor");
			gui.getVistaProfesor().clear();
			if (gui.getVistaAsignaturaProf().getVisibilidad2_()){
				String nombre = gui.getVistaAsignaturaProf().getNombre().getText();
				Asignatura a = TreeAcademy.buscarAsignatura(nombre);
				a.setVisibilidad(true);
			}else if (gui.getVistaAsignaturaProf().getInvisible_()){
				String nombre = gui.getVistaAsignaturaProf().getNombre().getText();
				Asignatura a = TreeAcademy.buscarAsignatura(nombre);
				a.setVisibilidad(false);
			}
			
		}else if (e.getActionCommand().compareTo("Volver") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Profesor");
			gui.getVistaAsignaturaProf().clear();
			if (gui.getVistaAsignaturaProf().getVisibilidad2_()){
				String nombre = gui.getVistaAsignaturaProf().getNombre().getText();
				Asignatura a = TreeAcademy.buscarAsignatura(nombre);
				a.setVisibilidad(true);
			}else if (gui.getVistaAsignaturaProf().getInvisible_()){
				String nombre = gui.getVistaAsignaturaProf().getNombre().getText();
				Asignatura a = TreeAcademy.buscarAsignatura(nombre);
				a.setVisibilidad(false);
			}
			
		}else if (e.getActionCommand().compareTo("Crear") == 0){
			if (crear.getText().compareTo("") == 0){
				JOptionPane.showMessageDialog(gui, "Error. Rellene el campo", "Error", JOptionPane.ERROR_MESSAGE);
				gui.getVistaAsignaturaProf().clear();
			}else{
				Tema tema = new Tema (crear.getText(), gui.getVistaAsignaturaProf().getVisibilidad_());
				
				Asignatura asig = TreeAcademy.buscarAsignatura(gui.getVistaAsignaturaProf().getNombre().getText());
				
				if (gui.getVistaAsignaturaProf().getLista().size() == 0){
					asig.aniadirTema(tema);
					gui.getVistaAsignaturaProf().getLista().addElement(tema.getNombre());
					JOptionPane.showMessageDialog(gui, "Tema creado correctamente", "Creacion de tema", JOptionPane.INFORMATION_MESSAGE);
					gui.getVistaAsignaturaProf().clear();
				}else{
					if (gui.getVistaAsignaturaProf().getLista().contains(tema.getNombre())){
						JOptionPane.showMessageDialog(gui, "Ya existe ese tema", "Error", JOptionPane.ERROR_MESSAGE);
						gui.getVistaAsignaturaProf().clear();
					}else{
						asig.aniadirTema(tema);
						gui.getVistaAsignaturaProf().getLista().addElement(tema.getNombre());
						JOptionPane.showMessageDialog(gui, "Tema creado correctamente", "Creacion de tema", JOptionPane.INFORMATION_MESSAGE);
						gui.getVistaAsignaturaProf().clear();
					}
				}
				
				gui.getVistaAsignaturaProf().getVisibilidad().setSelected(false);
			}
			
		}else if (e.getActionCommand().compareTo("Ir") == 0){
			String tema_seleccionado = gui.getVistaAsignaturaProf().getLista2().getSelectedValue();
			
			if (tema_seleccionado != null){
				gui.getVistaTemaProf().setNombre(gui.getVistaAsignaturaProf().getNombre().getText() + ">" + tema_seleccionado);
				
				Asignatura asig = TreeAcademy.buscarAsignatura(gui.getVistaAsignaturaProf().getNombre().getText());
				
				if (asig == null){
					JOptionPane.showMessageDialog(gui, "Error");
				}else{
					Tema t1 = asig.buscarTema(tema_seleccionado);
					if (t1 == null){
						JOptionPane.showMessageDialog(gui, "Error");
					}else{
						for (ItemAsig it : t1.getItems()){
							if (it instanceof Tema){
								gui.getVistaTemaProf().getLista_sub().addElement(it.getNombre());
							}else if (it instanceof Apunte){
								gui.getVistaTemaProf().getLista_apun().addElement(it.getNombre());
							}else {
								gui.getVistaTemaProf().getLista_ejer().addElement(it.getNombre());
							}
							
						}
						
					}
					if (t1.getVisibilidad()){
						gui.getVistaTemaProf().setVisibilidad_eti("Estado: VISIBLE");
					}else{
						gui.getVistaTemaProf().setVisibilidad_eti("Estado: INVISIBLE");
					}
						
				}
				
				gui.getCard_layout().show(gui.getPantallas(), "Tema Profesor");
				gui.getVistaAsignaturaProf().clear();
				
			}else {
				JOptionPane.showMessageDialog(gui, "Error. Seleccione un tema", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if (e.getActionCommand().compareTo("Estudiantes matriculados") == 0){
			
			for (Asignatura a : TreeAcademy.getAsignaturas()){
				if (a.getNombreAsignatura().compareTo(gui.getVistaAsignaturaProf().getNombre().getText()) == 0){
					for (Estudiante es : a.getEstudiantesMatriculados()){
						gui.getVistaEstudiantesMatriculados().getLista_estudiantes().addElement(es.getNuma() + "," + es.getApellido());
					}
					for (Estudiante es1 : a.getEstudiantesBloqueados()){
						gui.getVistaEstudiantesMatriculados().getLista_bloqueados().addElement(es1.getNuma() + "," + es1.getApellido());
					}
					break;	
				}
			}
			
			
			gui.getVistaEstudiantesMatriculados().setNombre(gui.getVistaAsignaturaProf().getNombre().getText() + "> Estudiantes matriculados");
			gui.getCard_layout().show(gui.getPantallas(), "Estudiantes Matriculados");
			
		}else if (e.getActionCommand().compareTo("Ver estadisticas") == 0){
			for (Asignatura a : TreeAcademy.getAsignaturas()){
				if (a.getNombreAsignatura().compareTo(gui.getVistaAsignaturaProf().getNombre().getText()) == 0){
					for (Estudiante es : a.getEstudiantesMatriculados()){
						gui.getVistaEstadisticas().getTabla_alumno().addRow(new Object[]{es.getNombre() + ", "+ es.getApellido(), es.getNotaEstudiante()});
					}
					break;
				}
			}
			gui.getVistaEstadisticas().getTabla_estadistica().addRow(new Object[]{"No han contestado"});
			gui.getVistaEstadisticas().getTabla_estadistica().addRow(new Object[]{"Contestaron correctamente"});
			gui.getVistaEstadisticas().getTabla_estadistica().addRow(new Object[]{"Contestaron incorrectamente"});
			
			gui.getCard_layout().show(gui.getPantallas(), "Estadisticas");
		}
	}	
}