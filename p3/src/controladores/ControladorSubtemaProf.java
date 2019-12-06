package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

import interfaz.GUIAplicacion;
import treeAcademy.*;

/**
 * Esta clase define el controlador para que un profesor acceda y cree un subtema
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class ControladorSubtemaProf implements ActionListener{
	TreeAcademy ta;
	GUIAplicacion gui;
	
	public ControladorSubtemaProf(TreeAcademy ta, GUIAplicacion gui){
		this.ta = ta;
		this.gui = gui;
		gui.getVistaSubtemaProf().setControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField apunte = gui.getVistaSubtemaProf().getCampo_apunte();
		//JTextField ejercicio = gui.getVistaSubtemaProf().getCampo_ejercicio();
		
		if (e.getActionCommand().compareTo("Salir") == 0){
			
			try {
				ta.cerrarSesion();
				gui.getVistaAsignaturaProf().clear();
				gui.getCard_layout().show(gui.getPantallas(), "Login");
				gui.getVistaLogin().clear();
				gui.getVistaSubtemaProf().getLista_apun().removeAllElements();
				gui.getVistaSubtemaProf().getLista_ejer().removeAllElements();
				gui.getVistaTemaProf().getLista_ejer().removeAllElements();
				String nombre = gui.getVistaSubtemaProf().getNombre().getText();
				String partes[] = nombre.split(">");
				String nombre_asig = partes[0];
				String nombre_tema = partes[1];
				String nombre_st = partes[2];
				Asignatura a = TreeAcademy.buscarAsignatura(nombre_asig);
				Tema t = a.buscarTema(nombre_tema);
				Tema st = (Tema) t.buscarItem(nombre_st);
				if (gui.getVistaSubtemaProf().getVisibilidad2_()){
					st.setVisibilidad(true);
				}else if (gui.getVistaSubtemaProf().getInvisible_()){
					st.setVisibilidad(false);
				}
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}else if (e.getActionCommand().compareTo("Inicio") == 0){
			
			gui.getCard_layout().show(gui.getPantallas(), "Profesor");
			gui.getVistaProfesor().clear();
			gui.getVistaSubtemaProf().getLista_apun().removeAllElements();
			gui.getVistaSubtemaProf().getLista_ejer().removeAllElements();
			gui.getVistaTemaProf().getLista_ejer().removeAllElements();
			String nombre = gui.getVistaSubtemaProf().getNombre().getText();
			String partes[] = nombre.split(">");
			String nombre_asig = partes[0];
			String nombre_tema = partes[1];
			String nombre_st = partes[2];
			Asignatura a = TreeAcademy.buscarAsignatura(nombre_asig);
			Tema t = a.buscarTema(nombre_tema);
			Tema st = (Tema) t.buscarItem(nombre_st);
			if (gui.getVistaSubtemaProf().getVisibilidad2_()){
				st.setVisibilidad(true);
			}else if (gui.getVistaSubtemaProf().getInvisible_()){
				st.setVisibilidad(false);
			}
			
		}else if (e.getActionCommand().compareTo("Volver") == 0){
			
			gui.getCard_layout().show(gui.getPantallas(), "Tema Profesor");
			gui.getVistaAsignaturaProf().clear();
			gui.getVistaSubtemaProf().getLista_apun().removeAllElements();
			gui.getVistaSubtemaProf().getLista_ejer().removeAllElements();
			gui.getVistaTemaProf().getLista_ejer().removeAllElements();
			String nombre = gui.getVistaSubtemaProf().getNombre().getText();
			String partes[] = nombre.split(">");
			String nombre_asig = partes[0];
			String nombre_tema = partes[1];
			String nombre_st = partes[2];
			Asignatura a = TreeAcademy.buscarAsignatura(nombre_asig);
			Tema t = a.buscarTema(nombre_tema);
			Tema st = (Tema) t.buscarItem(nombre_st);
			if (gui.getVistaSubtemaProf().getVisibilidad2_()){
				st.setVisibilidad(true);
			}else if (gui.getVistaSubtemaProf().getInvisible_()){
				st.setVisibilidad(false);
			}
			
		}else if (e.getActionCommand().compareTo("Crear apunte") == 0){
			
			String apun = gui.getVistaSubtemaProf().getNombre().getText();
			
			if (apun == null){
				JOptionPane.showMessageDialog(gui, "Error");
				gui.getVistaSubtemaProf().clear();
			}else{
				String partes[] = apun.split(">");
				String asig = partes[0];
				String tema = partes[1];
				String subt = partes[2];
				
				Asignatura a = TreeAcademy.buscarAsignatura(asig);
				Tema t = a.buscarTema(tema);
				Tema st = (Tema) t.buscarItem(subt);
				
				if (gui.getVistaSubtemaProf().getLista_apun().size() == 0){
					st.aniadirItem(new Apunte(apunte.getText(), gui.getVistaSubtemaProf().getVisibilidadApun()));
					gui.getVistaSubtemaProf().getLista_apun().addElement(apunte.getText());
					gui.getVistaSubtemaProf().clear();
					JOptionPane.showMessageDialog(gui, "Apunte creado correctamente", "Apunte", JOptionPane.INFORMATION_MESSAGE);
				}else{
					if (gui.getVistaSubtemaProf().getLista_apun().contains(apunte.getText())){
						JOptionPane.showMessageDialog(gui, "Error. Ese apunte ya existe", "Error", JOptionPane.ERROR_MESSAGE);
						gui.getVistaSubtemaProf().clear();
					}else{
						st.aniadirItem(new Apunte(apunte.getText(), false));
						gui.getVistaSubtemaProf().getLista_apun().addElement(apunte.getText());
						gui.getVistaSubtemaProf().clear();
						JOptionPane.showMessageDialog(gui, "Apunte creado correctamente", "Apunte", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			
				gui.getVistaSubtemaProf().getVisibilidad_apun().setSelected(false);
			}
			
		}else if (e.getActionCommand().compareTo("Crear ejercicio") == 0){
			
			gui.getCard_layout().show(gui.getPantallas(), "Crear Ejercicio");
			gui.getVistaCrearEjercicio().setNombre(gui.getVistaSubtemaProf().getNombre().getText() + ">Crear ejercicio");
			
		}else if (e.getActionCommand().compareTo("Eliminar apunte") == 0){
			
			String apun = gui.getVistaSubtemaProf().getNombre().getText();
			
			if (apun == null){
				JOptionPane.showMessageDialog(gui, "Error");
				gui.getVistaSubtemaProf().clear();
			}else{
				String partes[] = apun.split(">");
				String asig = partes[0];
				String tema = partes[1];
				String subt = partes[2];
				
				Asignatura a = TreeAcademy.buscarAsignatura(asig);
				Tema t = a.buscarTema(tema);
				Tema st = (Tema) t.buscarItem(subt);
				
				String apu = gui.getVistaSubtemaProf().getLista_apun2().getSelectedValue();
				
				Apunte apu1 = (Apunte) st.buscarItem(apu);
				
				if (apu1 == null){
					JOptionPane.showMessageDialog(gui, "Error");
					gui.getVistaSubtemaProf().clear();
				}else{
					gui.getVistaSubtemaProf().getLista_apun().removeElement(apu);
					st.eliminarItem(apu1);
					JOptionPane.showMessageDialog(gui, "Apunte eliminado correctamente", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			
		}else if (e.getActionCommand().compareTo("Acceder apunte") == 0){
			
			String apun = gui.getVistaSubtemaProf().getLista_apun2().getSelectedValue();
			
			if (apun == null){
				JOptionPane.showMessageDialog(gui, "Error");
				gui.getVistaSubtemaProf().clear();
			}else{
				gui.getVistaApunteProf().setNombre(gui.getVistaSubtemaProf().getNombre().getText() + ">" + apun);
				String nombre = gui.getVistaApunteProf().getNombre().getText();
				
				if (nombre == null){
					JOptionPane.showMessageDialog(gui, "Error");
					gui.getVistaSubtemaProf().clear();
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
							gui.getVistaApunteProf().getApunte().setText(((Apunte) it).getContenido());
						}else if (it instanceof Ejercicio){
							gui.getVistaSubtemaProf().getLista_ejer().addElement(it.getNombre());
						}
					}
					Apunte ap = (Apunte) subt.buscarItem(gui.getVistaSubtemaProf().getLista_apun2().getSelectedValue());
					if (ap.getVisibilidad()){
						gui.getVistaApunteProf().setVisibilidad_eti("Estado: VISIBLE");
					}else{
						gui.getVistaApunteProf().setVisibilidad_eti("Estado: INVISIBLE");
					}
				}
				gui.getCard_layout().show(gui.getPantallas(), "Apunte Profesor");
				
				gui.getVistaApunteProf().getApunte().setEditable(true);
			}
			
		}else if (e.getActionCommand().compareTo("Eliminar ejercicio") == 0){
			
			String apun = gui.getVistaSubtemaProf().getNombre().getText();
			
			if (apun == null){
				JOptionPane.showMessageDialog(gui, "Error");
				gui.getVistaSubtemaProf().clear();
			}else{
				String partes[] = apun.split(">");
				String asig = partes[0];
				String tema = partes[1];
				String subt = partes[2];
				
				Asignatura a = TreeAcademy.buscarAsignatura(asig);
				Tema t = a.buscarTema(tema);
				Tema st = (Tema) t.buscarItem(subt);
				
				String apu = gui.getVistaSubtemaProf().getLista_apun2().getSelectedValue();
				
				Ejercicio apu1 = (Ejercicio) st.buscarItem(apu);
				
				if (apu1 == null){
					JOptionPane.showMessageDialog(gui, "Error");
					gui.getVistaSubtemaProf().clear();
				}else{
					gui.getVistaSubtemaProf().getLista_ejer().removeElement(apu);
					st.eliminarItem(apu1);
					JOptionPane.showMessageDialog(gui, "Ejercicio eliminado correctamente", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
				}	
			}
			
		}else if (e.getActionCommand().compareTo("Modificar ejercicio") == 0){
			gui.getVistaModificarEjercicio().setNombre(gui.getVistaSubtemaProf().getNombre().getText() +">"+ gui.getVistaSubtemaProf().getLista_ejer2().getSelectedValue() + "> Modificar Ejercicio" );
			gui.getCard_layout().show(gui.getPantallas(), "Modificar Ejercicio");
			
		}else if (e.getActionCommand().compareTo("Acceder ejercicio") == 0){
			
		}
	}
}