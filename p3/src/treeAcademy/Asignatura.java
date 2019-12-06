package treeAcademy;

import java.io.Serializable;
import java.util.ArrayList;

import usuarios.Estudiante;
import usuarios.Matricula;
import usuarios.Profesor;

/**
 * Clase de una asignatura de TreeAcademy
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class Asignatura implements Serializable {
	private static final long serialVersionUID = 1L;/* id del serializable */
	private String nombreAsig;/* nombre de la asignatura */
	private boolean visible;/* visibilidad de la asignatura */
	private boolean soloNombre;
	private Profesor profesor;/* profesor de TreeAcademy */
	private ArrayList<Tema> temas;/* arraylist de temas */
	private ArrayList<Matricula> matriculas;
	private ArrayList<Estudiante> estudiantes;
	private ArrayList<Estudiante> estudiantes_bloqueados;
	private double media;

	/**
	 * Constructor de la clase Asignatura
	 * 
	 * @param nombre
	 *            nombre de la asignatura
	 */
	public Asignatura(String nombre) {
		this.nombreAsig = nombre;
		this.visible = true;
		this.soloNombre = false;
		this.temas = new ArrayList<Tema>();
		this.matriculas = new ArrayList<Matricula>();
		this.estudiantes = new ArrayList<Estudiante>();
		this.estudiantes_bloqueados = new ArrayList<Estudiante>();
		this.media = 0;
	}
	
	/**
	 * @return estudiantes_bloqueados estudiantes bloqueados
	 */
	public ArrayList<Estudiante> getEstudiantesBloqueados() {
		return estudiantes_bloqueados;
	}
	
	/**
	 * @param estudiante estudiante a buscar
	 */
	public void aniadirEstudianteBloqueado(Estudiante estudiante){
		if (!this.getEstudiantesBloqueados().contains(estudiante)){
			this.estudiantes_bloqueados.add(estudiante);
		}
	}

	/**
	 * @param tema tema a buscar
	 * @return null retorna null
	 */
	public Tema buscarTema(String tema){
		for (Tema t: this.getTemas()){
			if (t.getNombre().compareTo(tema) == 0){
				return t;
			}
		}
		return null;
	}
	
	/**
	 * @return media media a devolver
	 */
	public double getMedia(){
		return this.media;
	}
	
	/**
	 * @return media calculada
	 */
	public double calculaMedia(){
		for (Tema t: this.temas){
			this.media = t.notaEjercicio()/t.getNumEjercicios();
		}	
		return this.media;
	}

	/**
	 * Funcion que obtiene el nombre de la asignatura
	 * 
	 * @return nombre de la asignatura
	 */
	public String getNombreAsignatura() {
		return this.nombreAsig;
	}

	/**
	 * Funcion para aniadir una matricula al array de matriculas
	 * 
	 * @param m
	 *            matricula que se aniadira al array
	 */
	public void aniadirMatricula(Matricula m) {
		this.matriculas.add(m);
		this.estudiantes.add(m.getEstudiante());
	}

	/**
	 * @return nombre
	 */
	public boolean isSoloNombre() {
		return soloNombre;
	}

	/**
	 * @param soloNombre nombre
	 */
	public void setSoloNombre(boolean soloNombre) {
		this.soloNombre = soloNombre;
	}

	/**
	 * Funcion que obtiene los estudiantes matriculados en la asignatura
	 * 
	 * @return estudiantes matriculados en la asignatura
	 */
	public ArrayList<Estudiante> getEstudiantesMatriculados() {
		return this.estudiantes;
	}

	/**
	 * Funcion que obtiene las matriculas de esa asignatura
	 * 
	 * @return matriculas de esa asignatura
	 */
	public ArrayList<Matricula> getMatricula() {
		return this.matriculas;
	}

	/**
	 * Funcion que devuelve la visibilidad de la asignatura
	 * 
	 * @return visibilidad de la asignatura
	 */
	public boolean getVisibile() {
		return this.visible;
	}

	/**
	 * Funcion que establece la visibilidad de la asginatura
	 * 
	 * @param visible
	 *            la visibilidad de la asignatura
	 */
	public void setVisibilidad(boolean visible) {
		this.visible = visible;
	}

	/**
	 * Funcion que obtiene el profesor de TreeAcademy
	 * 
	 * @return profesor de TreeAcademy
	 */
	public Profesor getProfesor() {
		return this.profesor;
	}

	/**
	 * Funcion que obtiene los temas de una asignatura
	 * 
	 * @return temas de una asignatura
	 */
	public ArrayList<Tema> getTemas() {
		return this.temas;
	}

	/**
	 * Funcion que aniade un tema al ArrayList de temas
	 * 
	 * @param tema
	 *            tema que se aniade
	 */
	public void aniadirTema(Tema tema) {
		if (!this.getTemas().contains(tema)) {
			this.temas.add(tema);
		}
	}
	
	/**
	 * @param estudiante estudiante
	 */
	public void aniadirEstudianteMatriculado(Estudiante estudiante){
		if (!this.getEstudiantesMatriculados().contains(estudiante)){
			this.estudiantes.add(estudiante);
		}
	}

	/**
	 * Funcion de contain
	 * 
	 * @param s
	 *            string que se va comprobar si esta contenido en el array
	 * @return false en caso de que s no este en el array
	 */
	public boolean contains(String s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
	if(this.isSoloNombre()){
		return this.nombreAsig + "(Estudiantes: "+this.estudiantes.size()+" Temas: "+ this.temas.size()+")";
	}
	return "\n\n" + "Nombre: "+ this.nombreAsig +"\n"+ "Temas: " + this.getTemas()+ "\n"+"Numero de temas: " 
			+ this.temas.size()+"\n"+ "Numero de matriculas: " + this.matriculas.size()+ "\n" + "Numero de estudiantes: "+this.estudiantes.size();
	}

	/**
	 * @param asignatura asignatura
	 * @return false retorna false
	 */
	public boolean contains(Asignatura asignatura) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		if (estudiantes == null) {
			if (other.estudiantes != null)
				return false;
		} else if (!estudiantes.equals(other.estudiantes))
			return false;
		if (matriculas == null) {
			if (other.matriculas != null)
				return false;
		} else if (!matriculas.equals(other.matriculas))
			return false;
		if (nombreAsig == null) {
			if (other.nombreAsig != null)
				return false;
		} else if (!nombreAsig.equals(other.nombreAsig))
			return false;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		if (temas == null) {
			if (other.temas != null)
				return false;
		} else if (!temas.equals(other.temas))
			return false;
		if (visible != other.visible)
			return false;
		return true;
	}
}