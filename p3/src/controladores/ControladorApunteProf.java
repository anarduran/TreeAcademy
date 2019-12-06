package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import interfaz.GUIAplicacion;
import treeAcademy.*;

/**
 * Esta clase define el controlador para que un profesor acceda y cree un apunte
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class ControladorApunteProf implements ActionListener{
	TreeAcademy ta;
	GUIAplicacion gui;
	
	public ControladorApunteProf(TreeAcademy ta, GUIAplicacion gui){
		this.ta = ta;
		this.gui = gui;
		gui.getVistaApunteProf().setControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().compareTo("Salir") == 0){
			try {
				ta.cerrarSesion();
				gui.getVistaAsignaturaProf().clear();
				gui.getCard_layout().show(gui.getPantallas(), "Login");
				gui.getVistaLogin().clear();
				gui.getVistaApunteProf().clear();
				String nombre = gui.getVistaApunteProf().getNombre().getText();
				String partes[] = nombre.split(">");
				if (partes.length == 4){
					String nombre_asig = partes[0];
					String nombre_tema = partes[1];
					String nombre_st = partes[2];
					Asignatura a = TreeAcademy.buscarAsignatura(nombre_asig);
					Tema t = a.buscarTema(nombre_tema);
					Tema st = (Tema) t.buscarItem(nombre_st);
					Apunte ap = (Apunte) st.buscarItem(gui.getVistaSubtemaProf().getLista_apun2().getSelectedValue());
					if (gui.getVistaApunteProf().getVisibilidad2_()){
						ap.setVisibilidad(true);
					}else if (gui.getVistaApunteProf().getInvisible_()){
						ap.setVisibilidad(false);
					}
				}else{
					String nombre_asig = partes[0];
					String nombre_tema = partes[1];
					Asignatura a = TreeAcademy.buscarAsignatura(nombre_asig);
					Tema t = a.buscarTema(nombre_tema);
					Apunte ap = (Apunte) t.buscarItem(gui.getVistaTemaProf().getLista_apun2().getSelectedValue());
					if (gui.getVistaApunteProf().getVisibilidad2_()){
						ap.setVisibilidad(true);
					}else if (gui.getVistaApunteProf().getInvisible_()){
						ap.setVisibilidad(false);
					}
				}
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}else if (e.getActionCommand().compareTo("Inicio") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Profesor");
			gui.getVistaApunteProf().clear();
			String nombre = gui.getVistaApunteProf().getNombre().getText();
			String partes[] = nombre.split(">");
			if (partes.length == 4){
				String nombre_asig = partes[0];
				String nombre_tema = partes[1];
				String nombre_st = partes[2];
				Asignatura a = TreeAcademy.buscarAsignatura(nombre_asig);
				Tema t = a.buscarTema(nombre_tema);
				Tema st = (Tema) t.buscarItem(nombre_st);
				Apunte ap = (Apunte) st.buscarItem(gui.getVistaSubtemaProf().getLista_apun2().getSelectedValue());
				if (gui.getVistaApunteProf().getVisibilidad2_()){
					ap.setVisibilidad(true);
				}else if (gui.getVistaApunteProf().getInvisible_()){
					ap.setVisibilidad(false);
				}
			}else{
				String nombre_asig = partes[0];
				String nombre_tema = partes[1];
				Asignatura a = TreeAcademy.buscarAsignatura(nombre_asig);
				Tema t = a.buscarTema(nombre_tema);
				Apunte ap = (Apunte) t.buscarItem(gui.getVistaTemaProf().getLista_apun2().getSelectedValue());
				if (gui.getVistaApunteProf().getVisibilidad2_()){
					ap.setVisibilidad(true);
				}else if (gui.getVistaApunteProf().getInvisible_()){
					ap.setVisibilidad(false);
				}
			}
			
		}else if (e.getActionCommand().compareTo("Volver") == 0){
			String nombre = gui.getVistaApunteProf().getNombre().getText();
			
			if (nombre == null){
				JOptionPane.showMessageDialog(gui, "Error");
			}else{
				String partes[] = nombre.split(">");
				if (partes.length == 4){
					gui.getCard_layout().show(gui.getPantallas(), "Subtema Profesor");
					gui.getVistaApunteProf().clear();
					String nombre_asig = partes[0];
					String nombre_tema = partes[1];
					String nombre_st = partes[2];
					Asignatura a = TreeAcademy.buscarAsignatura(nombre_asig);
					Tema t = a.buscarTema(nombre_tema);
					Tema st = (Tema) t.buscarItem(nombre_st);
					Apunte ap = (Apunte) st.buscarItem(gui.getVistaSubtemaProf().getLista_apun2().getSelectedValue());
					if (gui.getVistaApunteProf().getVisibilidad2_()){
						ap.setVisibilidad(true);
					}else if (gui.getVistaApunteProf().getInvisible_()){
						ap.setVisibilidad(false);
					}
				}else{
					gui.getCard_layout().show(gui.getPantallas(), "Tema Profesor");
					gui.getVistaApunteProf().clear();
					String nombre_asig = partes[0];
					String nombre_tema = partes[1];
					Asignatura a = TreeAcademy.buscarAsignatura(nombre_asig);
					Tema t = a.buscarTema(nombre_tema);
					Apunte ap = (Apunte) t.buscarItem(gui.getVistaTemaProf().getLista_apun2().getSelectedValue());
					if (gui.getVistaApunteProf().getVisibilidad2_()){
						ap.setVisibilidad(true);
					}else if (gui.getVistaApunteProf().getInvisible_()){
						ap.setVisibilidad(false);
					}
				}
			}
			
		}else if (e.getActionCommand().compareTo("Guardar") == 0){
			String contenido = gui.getVistaApunteProf().getApunte().getText();
			String nombre = gui.getVistaApunteProf().getNombre().getText();
			
			if (nombre == null){
				JOptionPane.showMessageDialog(gui, "Error");
			}else{
				String partes[] = nombre.split(">");
				if (partes.length == 4){
					String asig = partes[0];
					String tem = partes[1];
					String subt = partes[2];
					String apun = partes[3];
					
					Asignatura a = TreeAcademy.buscarAsignatura(asig);
					Tema t = a.buscarTema(tem);
					Tema st = (Tema) t.buscarItem(subt);
					Apunte ap = (Apunte) st.buscarItem(apun);
					
					if (ap == null){
						JOptionPane.showMessageDialog(gui, "Error");
					}else{
						ap.setContenido(contenido);
						gui.getVistaApunteProf().getApunte().setEditable(true);
						JOptionPane.showMessageDialog(gui, "Apunte guardado", "Guardado", JOptionPane.INFORMATION_MESSAGE);
					}
				}else{
					String asig = partes[0];
					String tem = partes[1];
					String apun = partes[2];
					
					Asignatura a = TreeAcademy.buscarAsignatura(asig);
					Tema t = a.buscarTema(tem);
					Apunte ap = (Apunte) t.buscarItem(apun);
					
					if (ap == null){
						JOptionPane.showMessageDialog(gui, "Error");
					}else{
						ap.setContenido(contenido);
						gui.getVistaApunteProf().getApunte().setEditable(true);
						gui.getVistaApunteProf().updateUI();
						JOptionPane.showMessageDialog(gui, "Apunte guardado", "Guardado", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
			
		}	
	}
}