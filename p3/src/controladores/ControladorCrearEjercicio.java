package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

import interfaz.GUIAplicacion;
import treeAcademy.*;

/**
 * Esta clase define el controlador para que un profesor acceda y cree un ejercicio
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class ControladorCrearEjercicio implements ActionListener{

	TreeAcademy ta;
	GUIAplicacion gui;
	
	public ControladorCrearEjercicio(TreeAcademy ta, GUIAplicacion gui){
		this.ta = ta;
		this.gui = gui;
		gui.getVistaCrearEjercicio().setControlador(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField enunciado = gui.getVistaCrearEjercicio().getCampo_enunciado();
		JTextField ponderacion = gui.getVistaCrearEjercicio().getCampo_ponderacion();
		JTextField fecha_ini = gui.getVistaCrearEjercicio().getCampo_fecha_ini();
		JTextField fecha_fin = gui.getVistaCrearEjercicio().getCampo_fecha_fin();
		
		if (e.getActionCommand().compareTo("Crear ejercicio") == 0){
			if (enunciado == null || ponderacion == null || fecha_ini == null || fecha_fin == null){
				JOptionPane.showMessageDialog(gui, "Error. Rellene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				String[] ini = fecha_ini.getText().split("/");
				String dia1 = ini[0];
				String mes1 = ini[1];
				String anio = ini[2];
				int diaI = Integer.parseInt(dia1);
				int mesI = Integer.parseInt(mes1);
				int anioI = Integer.parseInt(anio);
				
				String[] fin = fecha_fin.getText().split("/");
				String dia2 = fin[0];
				String mes2 = fin[1];
				String anio2 = fin[2];
				int diaF = Integer.parseInt(dia2);
				int mesF = Integer.parseInt(mes2);
				int anioF = Integer.parseInt(anio2);
				String partes1[] = ponderacion.getText().split(",");
				String entero = partes1[0];
				String decimal = partes1[1];
				String ponderacion1 = entero + decimal;
				double ponde = Double.parseDouble(ponderacion1);
				
				String nombre = gui.getVistaCrearEjercicio().getNombre().getText();
				
				if (nombre.length() == 4){
					String apun = gui.getVistaSubtemaProf().getNombre().getText();
					
					if (apun == null){
						JOptionPane.showMessageDialog(gui, "Error");
						gui.getVistaCrearEjercicio().clear();
					}else{
						String partes[] = apun.split(">");
						String asig = partes[0];
						String tema = partes[1];
						String subt = partes[2];
						
						Asignatura a = TreeAcademy.buscarAsignatura(asig);
						Tema t = a.buscarTema(tema);
						Tema st = (Tema) t.buscarItem(subt);
						
						if (gui.getVistaSubtemaProf().getLista_ejer().size() == 0){
							if (gui.getVistaCrearEjercicio().getOrden_()){
								Ejercicio ej = new Ejercicio(enunciado.getText(), ponde, gui.getVistaCrearEjercicio().getVisibilidad_(), gui.getVistaCrearEjercicio().getOrden_());
								st.aniadirItem(ej);
								ej.setFechaInicio(diaI, mesI, anioI);
								ej.setFechaFin(diaF, mesF, anioF);
								gui.getVistaSubtemaProf().getLista_ejer().addElement(ej.getNombre());
								gui.getVistaCrearEjercicio().setNombre(gui.getVistaSubtemaProf().getNombre().getText() + ">" + ej.getNombre());
								gui.getVistaCrearEjercicio().clear();
							}else{
								Ejercicio ej = new Ejercicio(enunciado.getText(), ponde, gui.getVistaCrearEjercicio().getVisibilidad_(), gui.getVistaCrearEjercicio().getDesordenadas_());
								st.aniadirItem(ej);
								ej.setFechaInicio(diaI, mesI, anioI);
								ej.setFechaFin(diaF, mesF, anioF);
								gui.getVistaSubtemaProf().getLista_ejer().addElement(ej.getNombre());
								gui.getVistaCrearEjercicio().setNombre(gui.getVistaSubtemaProf().getNombre().getText() + ">" + ej.getNombre());
								gui.getVistaCrearEjercicio().clear();
							}
							gui.getVistaSubtemaProf().getLista_ejer().addElement(enunciado.getText());
							JOptionPane.showMessageDialog(gui, "Ejercicio creado correctamente", "Ejercicio", JOptionPane.INFORMATION_MESSAGE);
							gui.getVistaSubtemaProf().clear();
						}else{
							if (gui.getVistaSubtemaProf().getLista_ejer().contains(enunciado.getText())){
								JOptionPane.showMessageDialog(gui, "Error. Ese ejercicio ya existe", "Error", JOptionPane.ERROR_MESSAGE);
								gui.getVistaSubtemaProf().clear();
							}else{
								if (gui.getVistaCrearEjercicio().getOrden_()){
									Ejercicio ej = new Ejercicio(enunciado.getText(), ponde, gui.getVistaCrearEjercicio().getVisibilidad_(), gui.getVistaCrearEjercicio().getOrden_());
									st.aniadirItem(ej);
									ej.setFechaInicio(diaI, mesI, anioI);
									ej.setFechaFin(diaF, mesF, anioF);
									gui.getVistaSubtemaProf().getLista_ejer().addElement(ej.getNombre());
									gui.getVistaCrearEjercicio().setNombre(gui.getVistaSubtemaProf().getNombre().getText() + ">" + ej.getNombre());
									gui.getVistaCrearEjercicio().clear();
								}else{
									Ejercicio ej = new Ejercicio(enunciado.getText(), ponde, gui.getVistaCrearEjercicio().getVisibilidad_(), gui.getVistaCrearEjercicio().getDesordenadas_());
									st.aniadirItem(ej);
									ej.setFechaInicio(diaI, mesI, anioI);
									ej.setFechaFin(diaF, mesF, anioF);
									gui.getVistaSubtemaProf().getLista_ejer().addElement(ej.getNombre());
									gui.getVistaCrearEjercicio().setNombre(gui.getVistaSubtemaProf().getNombre().getText() + ">" + ej.getNombre());
									gui.getVistaCrearEjercicio().clear();
								}
								gui.getVistaSubtemaProf().getLista_ejer().addElement(enunciado.getText());
								JOptionPane.showMessageDialog(gui, "Ejercicio creado correctamente", "Ejercicio", JOptionPane.INFORMATION_MESSAGE);
								gui.getVistaSubtemaProf().clear();
							}
						}
					}
				
				}else{
					String tema = gui.getVistaTemaProf().getNombre().getText();
					
					if (tema == null){
						JOptionPane.showMessageDialog(gui, "Error");
						gui.getVistaCrearEjercicio().clear();
					}else{
						String partes[] = tema.split(">");
						String asig = partes[0];
						String te = partes[1];
						
						Asignatura a = TreeAcademy.buscarAsignatura(asig);
						Tema t = a.buscarTema(te);
						
						if (gui.getVistaSubtemaProf().getLista_ejer().size() == 0){
							if (gui.getVistaCrearEjercicio().getOrden_()){
								Ejercicio ej = new Ejercicio(enunciado.getText(), ponde, gui.getVistaCrearEjercicio().getVisibilidad_(), gui.getVistaCrearEjercicio().getOrden_());
								t.aniadirItem(ej);
								ej.setFechaInicio(diaI, mesI, anioI);
								ej.setFechaFin(diaF, mesF, anioF);
								gui.getVistaTemaProf().getLista_ejer().addElement(ej.getNombre());
								gui.getVistaCrearEjercicio().setNombre(gui.getVistaTemaProf().getNombre().getText() + ">" + ej.getNombre());
								gui.getVistaCrearEjercicio().clear();
							}else{
								Ejercicio ej = new Ejercicio(enunciado.getText(), ponde, gui.getVistaCrearEjercicio().getVisibilidad_(), gui.getVistaCrearEjercicio().getDesordenadas_());
								t.aniadirItem(ej);
								ej.setFechaInicio(diaI, mesI, anioI);
								ej.setFechaFin(diaF, mesF, anioF);
								gui.getVistaTemaProf().getLista_ejer().addElement(ej.getNombre());
								gui.getVistaCrearEjercicio().setNombre(gui.getVistaTemaProf().getNombre().getText() + ">" + ej.getNombre());
								gui.getVistaCrearEjercicio().clear();
							}
							gui.getVistaSubtemaProf().getLista_ejer().addElement(enunciado.getText());
							JOptionPane.showMessageDialog(gui, "Ejercicio creado correctamente", "Ejercicio", JOptionPane.INFORMATION_MESSAGE);
							gui.getVistaSubtemaProf().clear();
						}else{
							if (gui.getVistaSubtemaProf().getLista_ejer().contains(enunciado.getText())){
								JOptionPane.showMessageDialog(gui, "Error. Ese ejercicio ya existe", "Error", JOptionPane.ERROR_MESSAGE);
								gui.getVistaSubtemaProf().clear();
							}else{
								if (gui.getVistaCrearEjercicio().getOrden_()){
									Ejercicio ej = new Ejercicio(enunciado.getText(), ponde, gui.getVistaCrearEjercicio().getVisibilidad_(), gui.getVistaCrearEjercicio().getOrden_());
									t.aniadirItem(ej);
									ej.setFechaInicio(diaI, mesI, anioI);
									ej.setFechaFin(diaF, mesF, anioF);
									gui.getVistaTemaProf().getLista_ejer().addElement(ej.getNombre());
									gui.getVistaCrearEjercicio().setNombre(gui.getVistaTemaProf().getNombre().getText() + ">" + ej.getNombre());
									gui.getVistaCrearEjercicio().clear();
								}else{
									Ejercicio ej = new Ejercicio(enunciado.getText(), ponde, gui.getVistaCrearEjercicio().getVisibilidad_(), gui.getVistaCrearEjercicio().getDesordenadas_());
									t.aniadirItem(ej);
									ej.setFechaInicio(diaI, mesI, anioI);
									ej.setFechaFin(diaF, mesF, anioF);
									gui.getVistaTemaProf().getLista_ejer().addElement(ej.getNombre());
									gui.getVistaCrearEjercicio().setNombre(gui.getVistaTemaProf().getNombre().getText() + ">" + ej.getNombre());
									gui.getVistaCrearEjercicio().clear();
								}
								gui.getVistaSubtemaProf().getLista_ejer().addElement(enunciado.getText());
								JOptionPane.showMessageDialog(gui, "Ejercicio creado correctamente", "Ejercicio", JOptionPane.INFORMATION_MESSAGE);
								gui.getVistaSubtemaProf().clear();
							}
						}
					}
					
					
				}
				
			}
			
			
		}else if (e.getActionCommand().compareTo("Salir") == 0){
			try {
				ta.cerrarSesion();
				gui.getVistaAsignaturaProf().clear();
				gui.getCard_layout().show(gui.getPantallas(), "Login");
				gui.getVistaLogin().clear();
				gui.getVistaCrearEjercicio().clear();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}else if (e.getActionCommand().compareTo("Inicio") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Profesor");
			gui.getVistaCrearEjercicio().clear();
			
		}else if (e.getActionCommand().compareTo("Volver") == 0){
			String nombre = gui.getVistaCrearEjercicio().getNombre().getText();
			
			if (nombre == null){
				JOptionPane.showMessageDialog(gui, "Error");
			}else{
				String partes[] = nombre.split(">");
				if (partes.length == 4){
					gui.getCard_layout().show(gui.getPantallas(), "Subtema Profesor");
					gui.getVistaCrearEjercicio().clear();
				}else{
					gui.getCard_layout().show(gui.getPantallas(), "Tema Profesor");
					gui.getVistaCrearEjercicio().clear();
				}
			}
		}else if (e.getActionCommand().compareTo("Agregar pregunta") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Ejercicio Profesor");
			gui.getVistaEjercicioProf().setNombre(gui.getVistaCrearEjercicio().getNombre().getText() + ">Añadir preguntas");
			gui.getVistaCrearEjercicio().clear();
			
		}
		
	}

}
