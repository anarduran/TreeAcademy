package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import interfaz.GUIAplicacion;
import treeAcademy.*;

/**
 * Esta clase define el controlador para que un profesor acceda y cree un tema
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class ControladorTemaProf implements ActionListener{
	TreeAcademy ta;
	GUIAplicacion gui;
	
	public ControladorTemaProf(TreeAcademy ta, GUIAplicacion gui){
		this.ta = ta;
		this.gui = gui;
		gui.getVistaTemaProf().setControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField subtema = gui.getVistaTemaProf().getCampo_crear();
		JTextField apunte = gui.getVistaTemaProf().getCampo_crear_apun();
		
		if (e.getActionCommand().compareTo("Salir") == 0){
			try {
				ta.cerrarSesion();
				gui.getVistaAsignaturaProf().clear();
				gui.getCard_layout().show(gui.getPantallas(), "Login");
				gui.getVistaLogin().clear();
				gui.getVistaTemaProf().getLista_apun().removeAllElements();
				gui.getVistaTemaProf().getLista_sub().removeAllElements();
				gui.getVistaTemaProf().getLista_ejer().removeAllElements();
				String nombre = gui.getVistaTemaProf().getNombre().getText();
				
					String partes[] = nombre.split(">");
					String nombre_asig = partes[0];
					String nombre_tema = partes[1];
					
					Asignatura a = TreeAcademy.buscarAsignatura(nombre_asig);
					Tema t = a.buscarTema(nombre_tema);
					if (gui.getVistaTemaProf().getVisibilidad2_()){
						t.setVisibilidad(true);
					}else if (gui.getVistaTemaProf().getInvisible_()){
						t.setVisibilidad(false);
					}
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}else if (e.getActionCommand().compareTo("Inicio") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Profesor");
			gui.getVistaProfesor().clear();
			gui.getVistaTemaProf().getLista_apun().removeAllElements();
			gui.getVistaTemaProf().getLista_sub().removeAllElements();
			gui.getVistaTemaProf().getLista_ejer().removeAllElements();
			String nombre = gui.getVistaTemaProf().getNombre().getText();
			
			if (subtema.getText().compareTo("") == 0){
				JOptionPane.showMessageDialog(gui, "Error. Rellene el campo de crear subtema", "Error", JOptionPane.ERROR_MESSAGE);
				gui.getVistaTemaProf().clear();
			}else{
				String partes[] = nombre.split(">");
				String nombre_asig = partes[0];
				String nombre_tema = partes[1];
				
				Asignatura a = TreeAcademy.buscarAsignatura(nombre_asig);
				Tema t = a.buscarTema(nombre_tema);
				if (gui.getVistaTemaProf().getVisibilidad2_()){
					t.setVisibilidad(true);
				}else if (gui.getVistaTemaProf().getInvisible_()){
					t.setVisibilidad(false);
				}
			}
			
		}else if (e.getActionCommand().compareTo("Volver") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Asignatura Profesor");
			gui.getVistaTemaProf().getLista_apun().removeAllElements();
			gui.getVistaTemaProf().getLista_sub().removeAllElements();
			gui.getVistaTemaProf().getLista_ejer().removeAllElements();
			gui.getVistaAsignaturaProf().clear();
			String nombre = gui.getVistaTemaProf().getNombre().getText();
			
			String partes[] = nombre.split(">");
			String nombre_asig = partes[0];
			String nombre_tema = partes[1];
				
				Asignatura a = TreeAcademy.buscarAsignatura(nombre_asig);
				Tema t = a.buscarTema(nombre_tema);
				if (gui.getVistaTemaProf().getVisibilidad2_()){
					t.setVisibilidad(true);
				}else if (gui.getVistaTemaProf().getInvisible_()){
					t.setVisibilidad(false);
				}
			
			
		}else if (e.getActionCommand().compareTo("Crear subtema") == 0){
			String nombre = gui.getVistaTemaProf().getNombre().getText();
			
			if (subtema.getText().compareTo("") == 0){
				JOptionPane.showMessageDialog(gui, "Error. Rellene el campo de crear subtema", "Error", JOptionPane.ERROR_MESSAGE);
				gui.getVistaTemaProf().clear();
			}else{
				String partes[] = nombre.split(">");
				String nombre_asig = partes[0];
				String nombre_tema = partes[1];
				
				Asignatura a = TreeAcademy.buscarAsignatura(nombre_asig);
				Tema t = a.buscarTema(nombre_tema);
				
				if (gui.getVistaTemaProf().getLista_sub().size() == 0){
					t.aniadirItem(new Tema(subtema.getText(), gui.getVistaTemaProf().getVisibilidad_sub()));
					JOptionPane.showMessageDialog(gui, "Subtema creado correctamente", "Subtema", JOptionPane.INFORMATION_MESSAGE);
					gui.getVistaTemaProf().getLista_sub().addElement(subtema.getText());
					gui.getVistaTemaProf().clear();
				}else{
					if (gui.getVistaTemaProf().getLista_sub().contains(subtema.getText())){
						JOptionPane.showMessageDialog(gui, "Error. Ese subtema ya existe", "Subtema ya creado", JOptionPane.ERROR_MESSAGE);
						gui.getVistaTemaProf().clear();
					}else{
						t.aniadirItem(new Tema(subtema.getText(), false));
						JOptionPane.showMessageDialog(gui, "Subtema creado correctamente", "Subtema", JOptionPane.INFORMATION_MESSAGE);
						gui.getVistaTemaProf().getLista_sub().addElement(subtema.getText());
						gui.getVistaTemaProf().clear();
					}
				}
				
				gui.getVistaTemaProf().getVisibilidadSub().setSelected(false);	
			}
			
		}else if (e.getActionCommand().compareTo("Crear apunte") == 0){
			String nombre = gui.getVistaTemaProf().getNombre().getText();
			
			if (apunte.getText().compareTo("") == 0){
				JOptionPane.showMessageDialog(gui, "Error", "Error", JOptionPane.ERROR_MESSAGE);
				gui.getVistaTemaProf().clear();
			}else{
				String partes[] = nombre.split(">");
				String nombre_asig = partes[0];
				String nombre_tema = partes[1];
				
				Asignatura a = TreeAcademy.buscarAsignatura(nombre_asig);
				Tema t = a.buscarTema(nombre_tema);
				
				if (gui.getVistaTemaProf().getLista_apun().size() == 0){
					t.aniadirItem(new Apunte(apunte.getText(), gui.getVistaTemaProf().getVisibilidad_apun()));
					JOptionPane.showMessageDialog(gui, "Apunte creado correctamente", "Apunte", JOptionPane.INFORMATION_MESSAGE);
					gui.getVistaTemaProf().getLista_apun().addElement(apunte.getText());
					gui.getVistaTemaProf().clear();
				}else{
					if (gui.getVistaTemaProf().getLista_apun().contains(apunte.getText())){
						JOptionPane.showMessageDialog(gui, "Error. Ese apunte ya existe", "Error", JOptionPane.ERROR_MESSAGE);
						gui.getVistaTemaProf().clear();
					}else{
						t.aniadirItem(new Apunte(apunte.getText(), false));
						JOptionPane.showMessageDialog(gui, "Apunte creado correctamente", "Apunte", JOptionPane.INFORMATION_MESSAGE);
						gui.getVistaTemaProf().getLista_apun().addElement(apunte.getText());
						gui.getVistaTemaProf().clear();
					}
				}
				gui.getVistaTemaProf().getVisibilidadApun().setSelected(false);
			}
		}else if (e.getActionCommand().compareTo("Acceder subtema") == 0){
			String subtema_lis = gui.getVistaTemaProf().getLista_sub2().getSelectedValue();
		
			if (subtema_lis == null){
				JOptionPane.showMessageDialog(gui, "Error. Seleccione un elemento de la lista de subtemas", "Error", JOptionPane.ERROR_MESSAGE);
				gui.getVistaTemaProf().clear();
			}else{
				gui.getVistaSubtemaProf().setNombre(gui.getVistaTemaProf().getNombre().getText() + ">" + subtema_lis);
				String titulo = gui.getVistaSubtemaProf().getNombre().getText();
				if (titulo == null){
					JOptionPane.showMessageDialog(gui, "Error");
				}else{
					String parte[] = titulo.split(">");
					String asig = parte[0];
					String tem = parte[1];
					
					Asignatura a = TreeAcademy.buscarAsignatura(asig);
					Tema t = a.buscarTema(tem);
					Tema st = (Tema) t.buscarItem(subtema_lis);
					
					if (st == null){
						JOptionPane.showMessageDialog(gui, "Error");
					}else{
						for (ItemAsig it : st.getItems()){
							if (it instanceof Apunte){
								gui.getVistaSubtemaProf().getLista_apun().addElement(it.getNombre());
							}else if (it instanceof Ejercicio){
								gui.getVistaSubtemaProf().getLista_ejer().addElement(it.getNombre());
							}
						}
						
						if (st.getVisibilidad()){
							gui.getVistaSubtemaProf().setVisibilidad_eti("Estado: VISIBLE");
						}else{
							gui.getVistaSubtemaProf().setVisibilidad_eti("Estado: INVISIBLE");
						}
					}
				}
				gui.getCard_layout().show(gui.getPantallas(), "Subtema Profesor");
				gui.getVistaTemaProf().clear();
			}
			
		}else if (e.getActionCommand().compareTo("Acceder apunte") == 0){
			String apunte_lis = gui.getVistaTemaProf().getLista_apun2().getSelectedValue();
			
			if (apunte_lis == null){
				JOptionPane.showMessageDialog(gui, "Error. Seleccione un elemento de la lista de apuntes", "Error", JOptionPane.ERROR_MESSAGE);
				gui.getVistaTemaProf().clear();
			}else {
				gui.getVistaApunteProf().setNombre(gui.getVistaTemaProf().getNombre().getText() + ">" + apunte_lis);
				String nombre =gui.getVistaApunteProf().getNombre().getText();
				
				if (nombre == null){
					JOptionPane.showMessageDialog(gui, "Error");
				}else{
					String partes[] = nombre.split(">");
					String asi = partes[0];
					String tem = partes[1];
					
					Asignatura a = TreeAcademy.buscarAsignatura(asi);
					Tema t = a.buscarTema(tem);
					Apunte ap = (Apunte) t.buscarItem(apunte_lis);
					
					if (ap == null){
						JOptionPane.showMessageDialog(gui, "Error");
					}else{
						gui.getVistaApunteProf().getApunte().setText(ap.getContenido());
						gui.getCard_layout().show(gui.getPantallas(), "Apunte Profesor");
					}
					
					if (ap.getVisibilidad()){
						gui.getVistaApunteProf().setVisibilidad_eti("Estado: VISIBLE");
					}else{
						gui.getVistaApunteProf().setVisibilidad_eti("Estado: INVISIBLE");
					}
				}
			}
			
		}else if (e.getActionCommand().compareTo("Crear ejercicio") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Crear Ejercicio");
			gui.getVistaCrearEjercicio().setNombre(gui.getVistaTemaProf().getNombre().getText() + ">Crear ejercicio" );
		}else if (e.getActionCommand().compareTo("Acceder ejercicio") == 0){
			
		}else if(e.getActionCommand().compareTo("Eliminar apunte") == 0){
			String apun = gui.getVistaTemaProf().getNombre().getText();
			
			if (apun == null){
				JOptionPane.showMessageDialog(gui, "Error");
				gui.getVistaSubtemaProf().clear();
			}else{
				String partes[] = apun.split(">");
				String asig = partes[0];
				String tema = partes[1];
				
				String apu = gui.getVistaTemaProf().getLista_apun2().getSelectedValue();
				
				if (apu == null){
					JOptionPane.showMessageDialog(gui, "Error seleccione un apunte", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					Asignatura a = TreeAcademy.buscarAsignatura(asig);
					Tema t = a.buscarTema(tema);
					Apunte apu1 = (Apunte) t.buscarItem(apu);
					
					
					if (apu1 == null){
						JOptionPane.showMessageDialog(gui, "Error");
						gui.getVistaSubtemaProf().clear();
					}else{
						gui.getVistaTemaProf().getLista_apun().removeElement(apu);
						t.eliminarItem(apu1);
						JOptionPane.showMessageDialog(gui, "Apunte eliminado correctamente", "Eliminad", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
			}
			
		}else if (e.getActionCommand().compareTo("Eliminar ejercicio") == 0){
			String apun = gui.getVistaTemaProf().getNombre().getText();
			
			if (apun == null){
				JOptionPane.showMessageDialog(gui, "Error");
				gui.getVistaSubtemaProf().clear();
			}else{
				String partes[] = apun.split(">");
				String asig = partes[0];
				String tema = partes[1];
				
				String apu = gui.getVistaTemaProf().getLista_ejer2().getSelectedValue();
				
				if (apu == null){
					JOptionPane.showMessageDialog(gui, "Error seleccione un ejercicio", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					Asignatura a = TreeAcademy.buscarAsignatura(asig);
					Tema t = a.buscarTema(tema);
					Ejercicio apu1 = (Ejercicio) t.buscarItem(apu);
					
					if (apu1 == null){
						JOptionPane.showMessageDialog(gui, "Error");
						gui.getVistaTemaProf().clear();
					}else{
						gui.getVistaTemaProf().getLista_ejer().removeElement(apu);
						t.eliminarItem(apu1);
						JOptionPane.showMessageDialog(gui, "Ejercicio eliminado correctamente", "Eliminad", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
			}
			
		}else if (e.getActionCommand().compareTo("Modificar ejercicio") == 0){
			gui.getVistaModificarEjercicio().setNombre(gui.getVistaTemaProf().getNombre().getText()+ ">" + gui.getVistaTemaProf().getLista_ejer2().getSelectedValue() + ">Modificar ejercicio");
			gui.getCard_layout().show(gui.getPantallas(), "Modificar Ejercicio");
		}
	
	}
}