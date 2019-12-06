package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import interfaz.GUIAplicacion;
import treeAcademy.*;

/**
 * Esta clase define el controlador para que un estudiante acceda a un tema
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class ControladorTemaEst implements ActionListener{
	TreeAcademy ta;
	GUIAplicacion gui;
	
	public ControladorTemaEst(TreeAcademy ta, GUIAplicacion gui){
		this.ta = ta;
		this.gui = gui;
		gui.getVistaTemaEst().setControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().compareTo("Salir") == 0){
			try {
				ta.cerrarSesion();
				gui.getCard_layout().show(gui.getPantallas(), "Login");
				gui.getVistaLogin().clear();
				gui.getVistaTemaEst().getLista_apun().removeAllElements();
				gui.getVistaTemaEst().getLista_sub().removeAllElements();
				gui.getVistaTemaEst().getLista_ejer().removeAllElements();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}else if (e.getActionCommand().compareTo("Inicio") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Estudiante");
			gui.getVistaTemaEst().getLista_apun().removeAllElements();
			gui.getVistaTemaEst().getLista_sub().removeAllElements();
			gui.getVistaTemaEst().getLista_ejer().removeAllElements();
			
		}else if (e.getActionCommand().compareTo("Volver") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Asignatura Estudiante");
			gui.getVistaTemaEst().getLista_apun().removeAllElements();
			gui.getVistaTemaEst().getLista_sub().removeAllElements();
			gui.getVistaTemaEst().getLista_ejer().removeAllElements();
			
		}else if (e.getActionCommand().compareTo("Acceder subtema") == 0){
			String subtema = gui.getVistaTemaEst().getLista_sub2().getSelectedValue();
			if (subtema == null){
				JOptionPane.showMessageDialog(gui, "Error. Seleccione un subtema", "Error", JOptionPane.INFORMATION_MESSAGE);
			}else{
				String nombre = gui.getVistaTemaEst().getNombre().getText();
				
				if (nombre == null){
					JOptionPane.showMessageDialog(gui, "Error", "Error",JOptionPane.ERROR_MESSAGE);
				}else{
					String partes[] = nombre.split(">");
					String asig = partes[0];
					String tema = partes[1];
					
					Asignatura a = TreeAcademy.buscarAsignatura(asig);
					Tema t = a.buscarTema(tema);
					Tema st = (Tema) t.buscarItem(subtema);
					
					if (st == null){
						JOptionPane.showMessageDialog(gui, "Error", "Error",JOptionPane.ERROR_MESSAGE);
					}else{
							for (ItemAsig it : st.getItems()){
								if (it instanceof Apunte){
									gui.getVistaSubtemaEst().getLista_apun().addElement(it.getNombre());
								}else if (it instanceof Ejercicio){
									gui.getVistaSubtemaEst().getLista_ejer().addElement(it.getNombre());
								}
							}
							if (st.getVisibilidad()){
								gui.getVistaSubtemaEst().setNombre(nombre + ">" + st.getNombre());
								gui.getCard_layout().show(gui.getPantallas(), "Subtema Estudiante");
							}else{
								JOptionPane.showMessageDialog(gui, "Subtema no disponible", "No disponible", JOptionPane.ERROR_MESSAGE);
							}
					}
				}
			}
			
		}else if (e.getActionCommand().compareTo("Acceder apunte") == 0){
			
			String apunte = gui.getVistaTemaEst().getLista_apun2().getSelectedValue();
			
			if (apunte == null){
				JOptionPane.showMessageDialog(gui, "Error. Seleccione un apunte", "Error", JOptionPane.INFORMATION_MESSAGE);
			}else{
				String nombre = gui.getVistaTemaEst().getNombre().getText();
				
				if (nombre == null){
					JOptionPane.showMessageDialog(gui, "Error", "Error",JOptionPane.ERROR_MESSAGE);
				}else{
					
					String partes[] = nombre.split(">");
					String asig = partes[0];
					String tema = partes[1];
					
					Asignatura a = TreeAcademy.buscarAsignatura(asig);
					Tema t = a.buscarTema(tema);
					Apunte apu = (Apunte) t.buscarItem(apunte);
					
					if (apu == null){
						JOptionPane.showMessageDialog(gui, "Error", "Error",JOptionPane.ERROR_MESSAGE);
					}else{
						gui.getVistaApunteEst().getApunte().setText(apu.getContenido());
						if (apu.getVisibilidad()){
							gui.getVistaApunteEst().setNombre(nombre + ">" + apu.getNombre());
							gui.getCard_layout().show(gui.getPantallas(), "Apunte Estudiante");
						}else{
							JOptionPane.showMessageDialog(gui, "Subtema no disponible", "No disponible", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		}else if (e.getActionCommand().compareTo("Acceder ejercicio") == 0){

				JOptionPane.showMessageDialog(gui, "Error. Este ejercicio no disponible.", "Error", JOptionPane.INFORMATION_MESSAGE);

		}
	}
}