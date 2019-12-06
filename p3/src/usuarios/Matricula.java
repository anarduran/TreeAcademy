package usuarios;
import java.io.Serializable;
import java.util.ArrayList;

import treeAcademy.Asignatura;

/**
 * Clase de una matricula de TreeAcademy
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */

public class Matricula implements Serializable{
	private static final long serialVersionUID = 1L;/*id del Serializable*/
	private double nota; /*nota de una matricula*/
	private Estudiante estudiante; /*estudiante de la matricula*/
	private Asignatura asignaturas;/*asignatura de la matricula*/
	private static int id;/*id de la matricula*/
	private boolean aceptada;/*variable para determinar si una matricula ha sido aceptada o no*/
	private boolean bloqueada;/*variable que determina si una matricula esta bloqueada o no*/
	private ArrayList<Evaluacion> evaluaciones;
	private boolean pendiente;
	

	
	/**
	 * Constructor de la clase matricula
	 * 
	 * @param estudiante estudiante
	 * @param asig asignatura
	 */
	public Matricula(Estudiante estudiante, Asignatura asig){
		this.nota = 0;
		Matricula.id ++;
		this.aceptada = false;
		this.estudiante = estudiante;
		this.asignaturas = asig;
		this.evaluaciones = new ArrayList<Evaluacion>();
		this.pendiente = true;
	}
	
	@Override
	public String toString() {
		return "Matricula [id=" + id + "]";
	}
	
	/**
	 * Funcion que establece el estado de pendiente 
	 * @param pendiente true o false
	 */
	public void setPendiente(boolean pendiente){
		this.pendiente = pendiente;
	}
	
	/**
	 * Funcion que obtiene si una matricula esta pendiente o no
	 * @return true si esta pendiente y false si no esta pendiente
	 */
	public boolean getPendiente(){
		return this.pendiente;
	}

	/**
	 * Funcion que obtiene si la matricula ha sido aceptada o no
	 * @return true si ha sido aceptado y false en caso contrario
	 */
	public boolean getAceptada(){
		return this.aceptada;
	}
	
	/**
	 * Funcion que establece los id de la matricula
	 * @param id id a asignar
	 */
	public void setId(int id){
		Matricula.id = id;
	}

	/**
	 * Funcion que establece si una matricula ha sido aceptada o no
	 * @param aceptada true si se acepta y false en caso contrario
	 */
	public void setAceptada(boolean aceptada) {
		this.aceptada = aceptada;
	}

	/**
	 * Funcion que obtiene el estudiante de la matricula
	 * @return estudiante de la matricula
	 */
	public Estudiante getEstudiante() {
		return estudiante;
	}
	
	/**
	 * Funcion que estable un estudiante
	 * @param e estudiante que se va a establecer
	 */
	public void setEstudiante(Estudiante e){
		this.estudiante = e;
	}

	/**
	 * Funcion que obtiene las asignaturas 
	 * @return asignaturas
	 */
	public Asignatura getAsignaturas() {
		return this.asignaturas;
	}
	
	/**
	 * Funcion que establece una asignatura
	 * @param asignatura asignatura
	 */
	public void setAsignatura(Asignatura asignatura){
		this.asignaturas = asignatura;
	}
	
	/**
	 * Funcion que obtiene la nota de un estudiante
	 * @return nota del estudiante
	 */
	public double getNota() {
		for (Evaluacion ev : this.evaluaciones){
			this.nota = ev.getNota();
		}
		return this.nota;
	}

	
	
	/**
	 * Funcion que obtiene el id de la matricula
	 * @return id de la matricula
	 */
	public int getId(){
		return Matricula.id;
	}
	  
	/**
	 * Funcion que verifica si una matricula contiene una asignatura
	 * @param asig asignatura que se verificara
	 * @return false 
	 */
	public boolean contains(Asignatura asig) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Funcion que establece si una matricula esta bloqueada o no
	 * @param bloqueada boolean para establecer si esta bloqueada o no
	 */
	public void setBloqueada(boolean bloqueada){
		this.bloqueada = bloqueada;
	}
	
	/**
	 * Funcion que obtiene si una matricula esta bloqueada o no
	 * @return true si esta bloqueada y false en caso contrario
	 */
	public boolean getBloqueada(){
		return this.bloqueada;
	}
	
	public ArrayList<Evaluacion> getEvaluaciones() {
		return this.evaluaciones;
	}

	public void setEvaluaciones(ArrayList<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}
	
	public void aniadirEvaluacion(Evaluacion evalu){
		this.evaluaciones.add(evalu);
	}
	
	
}
