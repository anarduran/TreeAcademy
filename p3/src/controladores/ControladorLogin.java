package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import interfaz.GUIAplicacion;
import treeAcademy.Asignatura;
import treeAcademy.TreeAcademy;
import usuarios.*;

/**
 * Esta clase define el controlador propio para iniciar sesion
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class ControladorLogin implements ActionListener{
	TreeAcademy ta;
	GUIAplicacion gui;
	
	public ControladorLogin (TreeAcademy ta, GUIAplicacion gui){
		this.ta = ta;
		this.gui = gui;
		gui.getVistaLogin().setControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField usuario = gui.getVistaLogin().getCampo_nombre();
		JTextField contrasenia = gui.getVistaLogin().getCampo_password();
	
		Usuario u = ta.iniciarSesion(usuario.getText(), contrasenia.getText()); 
		
		if (e.getActionCommand().compareTo("Entrar") == 0){
			if (u == null){
				JOptionPane.showMessageDialog(gui, "Error al iniciar sesion", "Error", JOptionPane.ERROR_MESSAGE);
				gui.getVistaLogin().clear();
			}
			
			else{
				if (usuario.getText().compareTo("prof") == 0 && contrasenia.getText().compareTo("prof") == 0){
					
					gui.getVistaProfesor().getLista().removeAllElements();
					
					for (Asignatura al : TreeAcademy.getAsignaturas()) {
						gui.getVistaProfesor().getLista().addElement(al.getNombreAsignatura());
					}
					
					gui.getVistaProfesor().getLista_matriculas().removeAllElements();
					for (Matricula m : ta.getMatriculas()){
						if (m.getPendiente()){
							gui.getVistaProfesor().getLista_matriculas().addElement((m.getId()) + "-"+ m.getEstudiante().getNuma() + "-" 
								+ m.getEstudiante().getApellido() + "-" + m.getAsignaturas().getNombreAsignatura());
						}
					}
					
					gui.getCard_layout().show(gui.getPantallas(), "Profesor");
					
				}else{
					Estudiante es = TreeAcademy.buscarEstudiante(usuario.getText());
					gui.getVistaEstudiante().setTitulo("<<Pagina de inicio de " + es.getNombre() +" " + es.getApellido() + ">>");
					gui.getVistaAsignaturaEst().setTitulo("<<Sesion de "+ es.getNombre() +" " + es.getApellido() + ">>");
					gui.getVistaTemaEst().setTitulo("<<Sesion de "+ es.getNombre() +" " + es.getApellido() + ">>");
					gui.getVistaSubtemaEst().setTitulo("<<Sesion de "+ es.getNombre() +" " + es.getApellido() + ">>");
					gui.getVistaApunteEst().setTitulo("<<Sesion de "+ es.getNombre() +" " + es.getApellido() + ">>");
					
					gui.getVistaEstudiante().getLista().removeAllElements();
					for (Asignatura a1 : TreeAcademy.getAsignaturas()){
						gui.getVistaEstudiante().getLista().addElement(a1.getNombreAsignatura());
					}
					
					
					for (Asignatura a: es.getAsignaturas()){
						gui.getVistaEstudiante().getLista_asignaturas().addElement(a.getNombreAsignatura());
						if (es.getMatriculas().size() == 0){
							gui.getVistaEstudiante().getLista().addElement(a.getNombreAsignatura());
						}
						
					}
					gui.getCard_layout().show(gui.getPantallas(), "Estudiante");
				}
			}
		}
	}
}