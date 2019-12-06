package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.*;

import interfaz.*;
import treeAcademy.*;
import usuarios.Evaluacion;
import ejercicios.*;

/**
 * Esta clase define el controlador para que un profesor acceda y cree un ejercicio
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class ControladorEjercicioProf implements ActionListener{
	TreeAcademy ta;
	GUIAplicacion gui;
	Ejercicio ejercicio;
	RespuestaAbierta respuestaabierta;
	RespuestaMulti respuestamulti;
	RespuestaUnica respuestaunica;
	RespuestaVF respuestavf;
	
	public ControladorEjercicioProf(TreeAcademy app, GUIAplicacion gui){
		this.ta = app;
		this.gui = gui;
		gui.getVistaEjercicioProf().setControlador(this);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {

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
			
		}else if (e.getActionCommand().compareTo("Inicio") == 0){
			gui.getCard_layout().show(gui.getPantallas(), "Profesor");
			gui.getVistaProfesor().clear();
			
		}else if (e.getActionCommand().compareTo("Volver") == 0){
			gui.getVistaAsignaturaProf().clear();
			String nombre = gui.getVistaEjercicioProf().getNombre().getText();
			String[] spli = nombre.split(nombre);
			if (spli.length == 4){
				gui.getCard_layout().show(gui.getPantallas(), "Subtema Profesor");
			}else{
				gui.getCard_layout().show(gui.getPantallas(), "Tema Profesor");
			}
			
		}else if (e.getActionCommand().compareTo("Añadir pregunta") == 0) {
			
			String c = gui.getVistaEjercicioProf().getNumeroPregunta1().getText();
			int num = Integer.parseInt(c);
			
			if (num == 0) {
				JOptionPane.showMessageDialog(gui, "Error. Rellene el numero de pregunta", "Error", 0);
			
			} else if (gui.getVistaEjercicioProf().getCombobox().getSelectedItem() == "Pregunta de opcion única"){
					VistaPreguntaUnica p1 = null;
					try {
						p1 = new VistaPreguntaUnica();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					gui.getVistaEjercicioProf().getContenedor2().add(p1);
					gui.getVistaEjercicioProf().addVistaPregunta(p1);
					
			} else if (gui.getVistaEjercicioProf().getCombobox().getSelectedItem() == "Pregunta de verdadero/falso"){
				VistaPreguntaVF p1 = null;
				try {
					p1 = new VistaPreguntaVF();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				gui.getVistaEjercicioProf().getContenedor2().add(p1);
				gui.getVistaEjercicioProf().addVistaPregunta(p1);
				
			}else if (gui.getVistaEjercicioProf().getCombobox().getSelectedItem() == "Pregunta de opcion múltiple"){
				VistaPreguntaMulti panel = null;
				try {
					panel = new VistaPreguntaMulti();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				gui.getVistaEjercicioProf().getContenedor2().add(panel);
				gui.getVistaEjercicioProf().addVistaPregunta(panel);
				
			}  else if(gui.getVistaEjercicioProf().getCombobox().getSelectedItem() == "Pregunta de texto libre"){
				VistaPreguntaAbierta p1 = null;
				try {
					p1 = new VistaPreguntaAbierta();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				gui.getVistaEjercicioProf().getContenedor2().add(p1);
				gui.getVistaEjercicioProf().addVistaPregunta(p1);
			}
		}
		
		else if (e.getActionCommand().compareTo("Eliminar pregunta") == 0) {
			int size = gui.getVistaEjercicioProf().getVistaPreguntas().size();
			String numS = gui.getVistaEjercicioProf().getNumeroPregunta1().getText();
			int num = Integer.parseInt(numS);
			if (num == 0 && size !=0) {
				JOptionPane.showMessageDialog(gui, "Error. Rellene el campo", "Error", 0);
			}else if (num > size){
				JOptionPane.showMessageDialog(gui, "Error. Tiene " + size + " preguntas", "Error", 0);
			} else if (size == 0){
				JOptionPane.showMessageDialog(gui, "Error. Aun no se ha creado ninguan pregunta" , "Error", 0);
			} else{
					gui.getVistaEjercicioProf().getContenedor2().remove(gui.getVistaEjercicioProf().getVistaPreguntas().get(num-1));
					gui.getVistaEjercicioProf().getVistaPreguntas().remove(gui.getVistaEjercicioProf().getVistaPreguntas().get(num-1));
					gui.getVistaEjercicioProf().updateUI();
			}
			
		}else if (e.getActionCommand().compareTo("Añadir respuesta") == 0) {
			//JTextField crear = gui.getVistaEjercicioProf().getCampo_respuesta();
			int size = gui.getVistaEjercicioProf().getVistaPreguntas().size();
			String c = gui.getVistaEjercicioProf().getNumeroPregunta().getText();
			int num = Integer.parseInt(c);
			
			if ((num == 0 && size !=0) || gui.getVistaEjercicioProf().getRespuesta().getText().compareTo("") == 0) {
				JOptionPane.showMessageDialog(gui, "Error. Rellene todos los campos", "Error", 0);
			} else if (size == 0){
				JOptionPane.showMessageDialog(gui, "Error. Aun no se ha creado ninguan pregunta" , "Error", 0);
			} else if (num > size){
				JOptionPane.showMessageDialog(gui, "Error. Tiene " + size + " preguntas", "Error", 0);
			} else {
				if (gui.getVistaEjercicioProf().getVistaPreguntas().get(num - 1).getTipoPreg().compareTo("VF") == 0) {
					JOptionPane.showMessageDialog(gui, "Error. A esta pregunta no se le pueden aniadir respuestas","Error", 0);
				} else if (gui.getVistaEjercicioProf().getVistaPreguntas().get(num - 1).getTipoPreg().compareTo("opcionUnica") == 0) {
					VistaPregunta panel = (VistaPreguntaUnica) gui.getVistaEjercicioProf().getVistaPreguntas().get(num - 1);
					panel.aniadirOpcion(gui.getVistaEjercicioProf().getCampo_respuesta().getText());

				} else if (gui.getVistaEjercicioProf().getVistaPreguntas().get(num - 1).getTipoPreg().compareTo("opcionMultiple") == 0) {
					VistaPregunta panel = (VistaPreguntaMulti) gui.getVistaEjercicioProf().getVistaPreguntas().get(num - 1);
					panel.aniadirOpcion(gui.getVistaEjercicioProf().getCampo_respuesta().getText());

				} else if (gui.getVistaEjercicioProf().getVistaPreguntas().get(num - 1).getTipoPreg().compareTo("textoLibre") == 0) {
					VistaPregunta panel = (VistaPreguntaAbierta) gui.getVistaEjercicioProf().getVistaPreguntas().get(num - 1);
					panel.aniadirOpcion(gui.getVistaEjercicioProf().getCampo_respuesta().getText());
				}
			}
	} else if (e.getActionCommand().compareTo("Guardar") == 0) {
		
			String nombre = gui.getVistaEjercicioProf().getNombre().getText();
			String partes[] = nombre.split(">");
			Evaluacion ev = new Evaluacion();
			if (partes.length == 5) {
				String asig = partes[0];
				String tema = partes[1];
				String subt = partes[2];
				String ejer = partes[3];

				Asignatura a = TreeAcademy.buscarAsignatura(asig);
				Tema t = a.buscarTema(tema);
				Tema st = (Tema) t.buscarItem(subt);
				Ejercicio ej = (Ejercicio) st.buscarItem(ejer);
				int num = gui.getVistaEjercicioProf().getVistaPreguntas().size();
				JOptionPane.showMessageDialog(gui, num);
				for (VistaPregunta vp : gui.getVistaEjercicioProf().getVistaPreguntas()) {
					gui.getVistaAccederEjercicio().getApunte().setText("Hola ");
					if (vp instanceof VistaPreguntaUnica) {
						String enunciado = vp.getEnunciado().getText();
						String penal = vp.getPenalizacion().getText();
						double penalizacion = Double.parseDouble(penal);
						String puntuacion = vp.getPuntuacion().getText();
						double puntua = Double.parseDouble(puntuacion);

						if (gui.getVistaCrearEjercicio().getVisibilidad_()
								&& gui.getVistaCrearEjercicio().getOrden_()) {
							PreguntaUnica pu = new PreguntaUnica(puntua, enunciado, penalizacion);
							ej.aniadirPregunta(pu);
							
							for (JRadioButton rd : gui.getVistaPreguntaUnica().getOpciones()) {
								pu.aniadirOpciones(rd.getText());
								
								//gui.getVistaAccederEjercicio().getApunte().setText(pu.getEnunciado() + "\nOpciones: \n" + pu.getOpciones()+"\n");
								if (rd.isSelected()) {
									RespuestaUnica resunica = new RespuestaUnica(pu, rd.getText());
									ev.aniadirRespuestaProfesor(resunica);

								}
							}
							gui.getVistaModificarEjercicio().getLista_preg().addElement(pu.getEnunciado());

						}

					} else if (vp instanceof VistaPreguntaMulti) {
						String enunciado = vp.getEnunciado().getText();
						String penal = vp.getPenalizacion().getText();
						double penalizacion = Double.parseDouble(penal);
						String puntuacion = vp.getPuntuacion().getText();
						double puntua = Double.parseDouble(puntuacion);

						if (gui.getVistaCrearEjercicio().getVisibilidad_()
								&& gui.getVistaCrearEjercicio().getOrden_()) {
							PreguntaMulti pm = new PreguntaMulti(puntua, enunciado, penalizacion);
							ej.aniadirPregunta(pm);
							for (JCheckBox cb : gui.getVistaPreguntaMulti().getOpciones()) {
								pm.aniadirOpciones(cb.getText());
								gui.getVistaAccederEjercicio().getApunte().setText(pm.getEnunciado() + "\nOpciones: \n" + pm.getOpciones() +"\n");
								if (cb.isSelected()) {
									RespuestaMulti resmul = new RespuestaMulti(pm, cb.getText());
									ev.aniadirRespuestaProfesor(resmul);
								}
							}
							gui.getVistaModificarEjercicio().getLista_preg().addElement(pm.getEnunciado());

						}
					} else if (vp instanceof VistaPreguntaVF) {
						String enunciado = vp.getEnunciado().getText();
						String penal = vp.getPenalizacion().getText();
						double penalizacion = Double.parseDouble(penal);
						String puntuacion = vp.getPuntuacion().getText();
						double puntua = Double.parseDouble(puntuacion);

						if (gui.getVistaCrearEjercicio().getVisibilidad_()
								&& gui.getVistaCrearEjercicio().getOrden_()) {
							PreguntaVF vf = new PreguntaVF(puntua, enunciado, penalizacion);
							ej.aniadirPregunta(vf);
							
							if (gui.getVistaPreguntaVF().getVerdadero().isSelected()) {
								vf.aniadirOpciones("Verdadero");
								RespuestaVF resvf = new RespuestaVF(vf,gui.getVistaPreguntaVF().getVerdadero().getText());
								ev.aniadirRespuestaProfesor(resvf);
							} else if (gui.getVistaPreguntaVF().getFalso().isSelected()) {
								vf.aniadirOpciones("Falso");
								RespuestaVF resvf = new RespuestaVF(vf, gui.getVistaPreguntaVF().getFalso().getText());
								ev.aniadirRespuestaProfesor(resvf);
							}
							gui.getVistaAccederEjercicio().getApunte().setText(vf.getEnunciado() + "\nOpciones: \n" + vf.getOpciones() +"\n");
							gui.getVistaModificarEjercicio().getLista_preg().addElement(vf.getEnunciado());
						}
					} else {
						String enunciado = vp.getEnunciado().getText();
						String penal = vp.getPenalizacion().getText();
						double penalizacion = Double.parseDouble(penal);
						String puntuacion = vp.getPuntuacion().getText();
						double puntua = Double.parseDouble(puntuacion);

						if (gui.getVistaCrearEjercicio().getVisibilidad_()
								&& gui.getVistaCrearEjercicio().getOrden_()) {
							PreguntaAbierta pa = new PreguntaAbierta(puntua, enunciado, penalizacion);
							ej.aniadirPregunta(pa);
							for (int i = 0; i < gui.getVistaPreguntaAbierta().getLista().size(); i++) {
								pa.aniadirOpciones(gui.getVistaPreguntaAbierta().getLista().getElementAt(i));
								Respuesta resab = new RespuestaAbierta(pa,gui.getVistaPreguntaAbierta().getLista().getElementAt(i));
								ev.aniadirRespuestaProfesor(resab);
							}
							gui.getVistaAccederEjercicio().getApunte().setText(pa.getEnunciado() + "\nOpciones: \n" + pa.getOpciones() +"\n");
							gui.getVistaModificarEjercicio().getLista_preg().addElement(pa.getEnunciado());
						}
					}
				}
			}else {
				String asig = partes[0];
				String tema = partes[1];
				String ejer = partes[2];

				Asignatura a = TreeAcademy.buscarAsignatura(asig);
				Tema t = a.buscarTema(tema);
				Ejercicio ej = (Ejercicio) t.buscarItem(ejer);
				for (VistaPregunta vp : gui.getVistaEjercicioProf().getVistaPreguntas()) {
					if (vp instanceof VistaPreguntaUnica) {
						String enunciado = vp.getEnunciado().getText();
						String penal = vp.getPenalizacion().getText();
						double penalizacion = Double.parseDouble(penal);
						String puntuacion = vp.getPuntuacion().getText();
						double puntua = Double.parseDouble(puntuacion);

						if (gui.getVistaCrearEjercicio().getVisibilidad_()
								&& gui.getVistaCrearEjercicio().getOrden_()) {
							PreguntaUnica pu = new PreguntaUnica(puntua, enunciado, penalizacion);
							ej.aniadirPregunta(pu);
							
							for (JRadioButton rd : gui.getVistaPreguntaUnica().getOpciones()) {
								pu.aniadirOpciones(rd.getText());
								
								gui.getVistaAccederEjercicio().getApunte().setText(pu.getEnunciado() + "\nOpciones: \n" + pu.getOpciones()+"\n");
								if (rd.isSelected()) {
									RespuestaUnica resunica = new RespuestaUnica(pu, rd.getText());
									ev.aniadirRespuestaProfesor(resunica);

								}
							}
							gui.getVistaModificarEjercicio().getLista_preg().addElement(pu.getEnunciado());

						}

					} else if (vp instanceof VistaPreguntaMulti) {
						String enunciado = vp.getEnunciado().getText();
						String penal = vp.getPenalizacion().getText();
						double penalizacion = Double.parseDouble(penal);
						String puntuacion = vp.getPuntuacion().getText();
						double puntua = Double.parseDouble(puntuacion);

						if (gui.getVistaCrearEjercicio().getVisibilidad_()
								&& gui.getVistaCrearEjercicio().getOrden_()) {
							PreguntaMulti pm = new PreguntaMulti(puntua, enunciado, penalizacion);
							ej.aniadirPregunta(pm);
							for (JCheckBox cb : gui.getVistaPreguntaMulti().getOpciones()) {
								pm.aniadirOpciones(cb.getText());
								gui.getVistaAccederEjercicio().getApunte().setText(pm.getEnunciado() + "\nOpciones: \n" + pm.getOpciones() +"\n");
								if (cb.isSelected()) {
									RespuestaMulti resmul = new RespuestaMulti(pm, cb.getText());
									ev.aniadirRespuestaProfesor(resmul);
								}
							}
							gui.getVistaModificarEjercicio().getLista_preg().addElement(pm.getEnunciado());

						}
					} else if (vp instanceof VistaPreguntaVF) {
						String enunciado = vp.getEnunciado().getText();
						String penal = vp.getPenalizacion().getText();
						double penalizacion = Double.parseDouble(penal);
						String puntuacion = vp.getPuntuacion().getText();
						double puntua = Double.parseDouble(puntuacion);

						if (gui.getVistaCrearEjercicio().getVisibilidad_()
								&& gui.getVistaCrearEjercicio().getOrden_()) {
							PreguntaVF vf = new PreguntaVF(puntua, enunciado, penalizacion);
							ej.aniadirPregunta(vf);
							
							if (gui.getVistaPreguntaVF().getVerdadero().isSelected()) {
								vf.aniadirOpciones("Verdadero");
								RespuestaVF resvf = new RespuestaVF(vf,gui.getVistaPreguntaVF().getVerdadero().getText());
								ev.aniadirRespuestaProfesor(resvf);
							} else if (gui.getVistaPreguntaVF().getFalso().isSelected()) {
								vf.aniadirOpciones("Falso");
								RespuestaVF resvf = new RespuestaVF(vf, gui.getVistaPreguntaVF().getFalso().getText());
								ev.aniadirRespuestaProfesor(resvf);
							}
							gui.getVistaAccederEjercicio().getApunte().setText(vf.getEnunciado() + "\nOpciones: \n" + vf.getOpciones() +"\n");
							gui.getVistaModificarEjercicio().getLista_preg().addElement(vf.getEnunciado());
						}
					} else {
						String enunciado = vp.getEnunciado().getText();
						String penal = vp.getPenalizacion().getText();
						double penalizacion = Double.parseDouble(penal);
						String puntuacion = vp.getPuntuacion().getText();
						double puntua = Double.parseDouble(puntuacion);

						if (gui.getVistaCrearEjercicio().getVisibilidad_()
								&& gui.getVistaCrearEjercicio().getOrden_()) {
							PreguntaAbierta pa = new PreguntaAbierta(puntua, enunciado, penalizacion);
							ej.aniadirPregunta(pa);
							for (int i = 0; i < gui.getVistaPreguntaAbierta().getLista().size(); i++) {
								pa.aniadirOpciones(gui.getVistaPreguntaAbierta().getLista().getElementAt(i));
								Respuesta resab = new RespuestaAbierta(pa,gui.getVistaPreguntaAbierta().getLista().getElementAt(i));
								ev.aniadirRespuestaProfesor(resab);
							}
							gui.getVistaAccederEjercicio().getApunte().setText(pa.getEnunciado() + "\nOpciones: \n" + pa.getOpciones() +"\n");
							gui.getVistaModificarEjercicio().getLista_preg().addElement(pa.getEnunciado());
						}
					}
				}
			}
			gui.getCard_layout().show(gui.getPantallas(), "Profesor");
		
		
	} else if (e.getActionCommand().compareTo("Cancelar") == 0) {
		gui.getCard_layout().show(gui.getPantallas(), "Profesor");
	}
		gui.getVistaEjercicioProf().updateUI();
	}
}