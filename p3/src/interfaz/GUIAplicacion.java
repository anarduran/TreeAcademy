package interfaz;

import java.awt.*;
import java.text.ParseException;

import javax.swing.*;

/**
 * Esta clase define las vistas que se usan en la interfaz de
 * la aplicacion
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class GUIAplicacion extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel pantallas;
	private CardLayout card_layout;

	private VistaLogin vistaLogin;
	private VistaProfesor vistaProfesor;
	private VistaEstudiante vistaEstudiante;
	private VistaAsignaturaProf vistaAsignaturaProf;
	private VistaAsignaturaEst vistaAsignaturaEst;
	private VistaEjercicioProf vistaEjercicioProf;
	private VistaEjercicioEst vistaEjercicioEst;
	private VistaTemaProf vistaTemaProf;
	private VistaApunteProf vistaApunteProf;
	private VistaSubtemaProf vistaSubtemaProf;
	private VistaSubtemaEst vistaSubtemaEst;
	private VistaTemaEst vistaTemaEst;
	private VistaApunteEst vistaApunteEst;
	private VistaEstudiantesMatriculados vistaEstudiantesMatriculados;
	private VistaEstadisticas vistaEstadisticas;
	private VistaPreguntaAbierta vistaPreguntaAbierta;
	private VistaPreguntaMulti vistaPreguntaMulti;
	private VistaPreguntaUnica vistaPreguntaUnica;
	private VistaPreguntaVF vistaPreguntaVF;
	private VistaPregunta vistaPregunta;
	private VistaCrearEjercicio vistaCrearEjercicio;
	private VistaModificarEjercicio vistaModificarEjercicio;
	private VistaAccederEjercicio vistaAccederEjercicio;
	
	public GUIAplicacion() throws ParseException {
		super("TreeAcademy");
		setLayout(new FlowLayout());
		Image logo = new ImageIcon("icono.png").getImage();
		setIconImage(logo);
		this.setSize(900, 650);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		pantallas = new JPanel(new CardLayout());
		card_layout = (CardLayout) (pantallas.getLayout());

		vistaLogin = new VistaLogin();
		vistaProfesor = new VistaProfesor();
		vistaEstudiante = new VistaEstudiante();
		vistaAsignaturaProf = new VistaAsignaturaProf();
		vistaAsignaturaEst = new VistaAsignaturaEst();
		vistaEjercicioProf = new VistaEjercicioProf();
		vistaEjercicioEst = new VistaEjercicioEst();
		vistaTemaProf = new VistaTemaProf();
		vistaApunteProf = new VistaApunteProf();
		vistaSubtemaProf = new VistaSubtemaProf();
		vistaSubtemaEst = new VistaSubtemaEst();
		vistaTemaEst = new VistaTemaEst();
		vistaApunteEst = new VistaApunteEst();
		vistaEstudiantesMatriculados = new VistaEstudiantesMatriculados();
		vistaEstadisticas = new VistaEstadisticas();
		vistaPreguntaAbierta = new VistaPreguntaAbierta();
		vistaPreguntaMulti = new VistaPreguntaMulti();
		vistaPreguntaUnica = new VistaPreguntaUnica();
		vistaPreguntaVF = new VistaPreguntaVF();
		vistaPregunta = new VistaPregunta();
		vistaCrearEjercicio = new VistaCrearEjercicio();
		vistaModificarEjercicio = new VistaModificarEjercicio();
		vistaAccederEjercicio = new VistaAccederEjercicio();
		
		pantallas.add(vistaLogin, "Login");
		pantallas.add(vistaProfesor, "Profesor");
		pantallas.add(vistaEstudiante, "Estudiante");
		pantallas.add(vistaAsignaturaProf, "Asignatura Profesor");
		pantallas.add(vistaAsignaturaEst, "Asignatura Estudiante");
		pantallas.add(vistaEjercicioProf, "Ejercicio Profesor");
		pantallas.add(vistaEjercicioEst, "Ejercicio Estudiante");
		pantallas.add(vistaTemaProf, "Tema Profesor");
		pantallas.add(vistaApunteProf, "Apunte Profesor");
		pantallas.add(vistaSubtemaProf, "Subtema Profesor");
		pantallas.add(vistaSubtemaEst, "Subtema Estudiante");
		pantallas.add(vistaTemaEst, "Tema Estudiante");
		pantallas.add(vistaApunteEst, "Apunte Estudiante");
		pantallas.add(vistaEstudiantesMatriculados, "Estudiantes Matriculados");
		pantallas.add(vistaEstadisticas, "Estadisticas");
		pantallas.add(vistaPreguntaAbierta, "Pregunta Abierta");
		pantallas.add(vistaPreguntaMulti, "Pregunta Multi");
		pantallas.add(vistaPreguntaUnica, "Pregunta Unica");
		pantallas.add(vistaPreguntaVF, "Pregunta VF");
		pantallas.add(vistaPregunta, "Pregunta");
		pantallas.add(vistaCrearEjercicio, "Crear Ejercicio");
		pantallas.add(vistaModificarEjercicio, "Modificar Ejercicio");
		pantallas.add(vistaAccederEjercicio, "Acceder Ejercicio");
		
		this.add(pantallas);
		
		card_layout.show(pantallas, "Login");		
		this.setVisible(true);
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public JPanel getPantallas() {
		return this.pantallas;
	}

	public CardLayout getCard_layout() {
		return this.card_layout;
	}

	public VistaLogin getVistaLogin() {
		return this.vistaLogin;
	}
	
	public VistaProfesor getVistaProfesor() {
		return this.vistaProfesor;
	}
	
	public VistaEstudiante getVistaEstudiante() {
		return this.vistaEstudiante;
	}
	
	public VistaAsignaturaProf getVistaAsignaturaProf() {
		return vistaAsignaturaProf;
	}
	
	public VistaAsignaturaEst getVistaAsignaturaEst() {
		return vistaAsignaturaEst;
	}
	
	public VistaTemaProf getVistaTemaProf(){
		return vistaTemaProf;
	}

	public VistaApunteProf getVistaApunteProf() {
		return vistaApunteProf;
	}

	public VistaSubtemaProf getVistaSubtemaProf() {
		return vistaSubtemaProf;
	}

	public VistaEjercicioProf getVistaEjercicioProf() {
		return vistaEjercicioProf;
	}

	public VistaSubtemaEst getVistaSubtemaEst() {
		return vistaSubtemaEst;
	}

	public VistaTemaEst getVistaTemaEst() {
		return vistaTemaEst;
	}

	public VistaApunteEst getVistaApunteEst() {
		return vistaApunteEst;
	}

	public VistaEstudiantesMatriculados getVistaEstudiantesMatriculados() {
		return vistaEstudiantesMatriculados;
	}

	public VistaEstadisticas getVistaEstadisticas() {
		return vistaEstadisticas;
	}

	public VistaEjercicioEst getVistaEjercicioEst() {
		return vistaEjercicioEst;
	}

	public VistaPreguntaAbierta getVistaPreguntaAbierta() {
		return vistaPreguntaAbierta;
	}

	public VistaPreguntaMulti getVistaPreguntaMulti() {
		return vistaPreguntaMulti;
	}

	public VistaPreguntaUnica getVistaPreguntaUnica() {
		return vistaPreguntaUnica;
	}

	public VistaPreguntaVF getVistaPreguntaVF() {
		return vistaPreguntaVF;
	}

	public VistaPregunta getVistaPregunta() {
		return vistaPregunta;
	}

	public VistaCrearEjercicio getVistaCrearEjercicio() {
		return vistaCrearEjercicio;
	}

	public VistaModificarEjercicio getVistaModificarEjercicio() {
		return vistaModificarEjercicio;
	}

	public VistaAccederEjercicio getVistaAccederEjercicio() {
		return vistaAccederEjercicio;
	}
	
}