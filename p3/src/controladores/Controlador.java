package controladores;

import java.io.*;

import interfaz.GUIAplicacion;
import treeAcademy.TreeAcademy;

/**
 * Esta clase define el controlador de la interfaz y crea todos los controladores 
 * que necesitaremos para cada vista
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */

public class Controlador {
	TreeAcademy app;
	GUIAplicacion gui;
	
	/* Atributos para la clase controlador*/
	private ControladorProfesor controladorProfesor;
	private ControladorLogin controladorLogin;
	private ControladorEstudiante controladorEstudiante;
	private ControladorAsignaturaProf controladorAsignaturaProf;
	private ControladorAsignaturaEst controladorAsignaturaEst;
	private ControladorTemaProf controladorTemaProf;
	private ControladorApunteProf controladorApunteProf;
	private ControladorSubtemaProf controladorSubtemaProf;
	private ControladorEjercicioProf controladorEjercicioProf;
	private ControladorSubtemaEst controladorSubtemaEst;
	private ControladorTemaEst controladorTemaEst;
	private ControladorApunteEst controladorApunteEst;
	private ControladorEstudiantesMatriculados controladorEstudiantesMatriculados;
	private ControladorEstadisticas controladorEstadisticas;
	private ControladorCrearEjercicio controladorCrearEjercicio;

	public Controlador(TreeAcademy app, GUIAplicacion gui) {
		this.app = app;
		this.gui = gui;
	
		gui.addWindowListener(new java.awt.event.WindowAdapter(){
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent){
				System.out.println("Datos guardados");
				try {
					app.cerrarSesion();
					app.guardarDatos();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		
		/* Creamos todos los controladores */
		this.controladorProfesor = new ControladorProfesor(app, gui);
		this.controladorLogin = new ControladorLogin(app, gui);
		this.controladorEstudiante = new ControladorEstudiante(app, gui);
		this.controladorAsignaturaProf= new ControladorAsignaturaProf(app, gui);
		this.controladorAsignaturaEst = new ControladorAsignaturaEst(app, gui);
		this.controladorTemaProf = new ControladorTemaProf(app, gui);
		this.controladorApunteProf = new ControladorApunteProf(app, gui);
		this.controladorSubtemaProf = new ControladorSubtemaProf(app, gui);
		this.controladorEjercicioProf = new ControladorEjercicioProf(app, gui);
		this.controladorSubtemaEst = new ControladorSubtemaEst(app, gui);
		this.controladorApunteEst = new ControladorApunteEst(app, gui);
		this.controladorTemaEst = new ControladorTemaEst(app, gui);
		this.controladorEstudiantesMatriculados = new ControladorEstudiantesMatriculados(app, gui);
		this.controladorEstadisticas = new ControladorEstadisticas(app, gui);
		this.controladorCrearEjercicio = new ControladorCrearEjercicio(app, gui);
	}

	/**
	 * Metodo que devuelve la app
	 * 
	 * @return app aplicacion
	 */
	public TreeAcademy getAplicacion() {
		return this.app;
	}
	
	/**
	 * Metodo que devuelve la gui
	 * 
	 * @return gui gui de la interfaz
	 */
	public GUIAplicacion getGui() {
		return this.gui;
	}
	
	/**
	 * Metodo que devuelve el controlador de profesor
	 * 
	 * @return controladorProfesor controlador de profesor
	 */
	public ControladorProfesor getControladorProfesor() {
		return this.controladorProfesor;
	}		
	
	/**
	 * Metodo que devuelve el controlador del login
	 * 
	 * @return controladorLogin controlador de login
	 */
	public ControladorLogin getControladorLogin(){
		return this.controladorLogin;
	}
	
	/**
	 * Metodo que devuelve el controlador del estudiante
	 * 
	 * @return controladorEstudiante controlador de estudiante
	 */
	public ControladorEstudiante getControladorEstudiante(){
		return this.controladorEstudiante;
	}
	
	/**
	 * Metodo que devuelve el controlador de asignatura de profesor
	 * 
	 * @return controladorAsignaturaProf controlador de asignatura de profesor
	 */
	public ControladorAsignaturaProf getControladorAsignaturaProf() {
		return controladorAsignaturaProf;
	}
	
	/**
	 * Metodo que devuelve el controlador de asignatura de estudiante
	 * 
	 * @return controladorAsignaturaEst controlador de asignatura de estudiante
	 */
	public ControladorAsignaturaEst getControladorAsignaturaEst() {
		return controladorAsignaturaEst;
	}
	
	/**
	 * Metodo que devuelve el controlador del tema de profesor
	 * 
	 * @return controladorTemaProf controlador de tema de profesor
	 */
	public ControladorTemaProf getControladorTemaProf(){
		return controladorTemaProf;
	}
	
	/**
	 * Metodo que devuelve el controlador del apunte de profesor
	 * 
	 * @return controladorApunteProf controlador de apunte de profesor
	 */
	public ControladorApunteProf getControladorApunteProf() {
		return controladorApunteProf;
	}
	
	/**
	 * Metodo que devuelve el controlador del subtema de profesor
	 * 
	 * @return controladorSubtemaProf controlador de subtema de profesor
	 */
	public ControladorSubtemaProf getControladorSubtemaProf() {
		return controladorSubtemaProf;
	}
	
	/**
	 * Metodo que devuelve el controlador del ejercicio de profesor
	 * 
	 * @return controladorEjercicioProf controlador de ejercicio de profesor
	 */
	public ControladorEjercicioProf getControladorEjercicioProf() {
		return controladorEjercicioProf;
	}
	
	/**
	 * Metodo que devuelve el controlador del subtema de estudiante
	 * 
	 * @return controladorSubtemaEst controlador de subtema de estudiante
	 */
	public ControladorSubtemaEst getControladorSubtemaEst() {
		return controladorSubtemaEst;
	}
	
	/**
	 * Metodo que devuelve el controlador del tema de estudiante
	 * 
	 * @return controladorTemaEst controlador de tema de estudiante
	 */
	public ControladorTemaEst getControladorTemaEst() {
		return controladorTemaEst;
	}
	
	/**
	 * Metodo que devuelve el controlador del apunte de estudiante
	 * 
	 * @return controladorApunteEst controlador de apunte de estudiante
	 */
	public ControladorApunteEst getControladorApunteEst() {
		return controladorApunteEst;
	}
	
	/**
	 * Metodo que devuelve el controlador de estudiantes matriculados
	 * 
	 * @return controladorEstudiantesMatriculados controlador de estudiantes matriculados
	 */
	public ControladorEstudiantesMatriculados getControladorEstudiantesMatriculados() {
		return controladorEstudiantesMatriculados;
	}
	
	/**
	 * Metodo que devuelve el controlador de estadisticas
	 * 
	 * @return controladorEstadisticas controlador de estadisticas
	 */
	public ControladorEstadisticas getControladorEstadisticas() {
		return controladorEstadisticas;
	}
	
	/**
	 * Metodo que devuelve el controlador de crear ejercicio
	 * 
	 * @return controladorCrearEjercicio controlador de crear ejercicio
	 */
	public ControladorCrearEjercicio getControladorCrearEjercicio() {
		return controladorCrearEjercicio;
	}
}