package treeAcademy; 

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import ejercicios.Pregunta;
import ejercicios.Respuesta;
import usuarios.Evaluacion;

/**
 * Clase Ejercicio
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class Ejercicio extends ItemAsig{
  private static final long serialVersionUID = 1L; /*id para la implementazion Serializable*/
  private static int id; /*id del ejercicio*/
  private LocalDate fechaInicio; /*fecha de inicio del ejercicio*/
  private LocalDate fechaFin; /*fecha de finalizacion del ejercicio*/
  private double ponderacion; /*ponderacion que tendra el ejercicio en la asignatura*/
  private boolean realizando; /*variable que determina si un estudiante esta realizando un ejercicio*/
  private boolean orden; /*orden de las preguntas. true en orden. false desordenadas*/
  private int ejercicioEstudiante; /*variable para contabilizar los alumnos que han hecho un ejercicio*/
  private ArrayList<Pregunta> preguntas; /*array de preguntas en un ejercicio*/
  private ArrayList<Evaluacion> evaluacion; /*array de evaluaciones de cada ejercicio*/
  private ArrayList<Respuesta> respuestas; /*array de respuestas para un ejercicio*/
  
  /**
   * Constructor de la clase Ejercicio
   * @param nombre nombre
   * @param ponderacion ponderacion del ejercicio
   * @param visibilidad visibilidad del ejercicio
   * @param orden de las preguntas
   */
  public Ejercicio(String nombre, double ponderacion, boolean visibilidad, boolean orden){
	  super(nombre, visibilidad);
	  Ejercicio.setId(Ejercicio.getId() + 1);
	  this.ponderacion = ponderacion;
	  this.fechaFin = LocalDate.now();
	  this.fechaInicio = LocalDate.now();
	  this.preguntas = new ArrayList<Pregunta>();
	  this.evaluacion = new ArrayList<Evaluacion>();
	  this.respuestas = new ArrayList<Respuesta>();
	  this.setRealizando(true);
	  this.orden = true; /*Por defecto las preguntas estaran ordenadas*/
	  this.ejercicioEstudiante = 0;
  	}
  
  	
  	
  	/**
  	 * Funcion que establece la fecha de inicio 
  	 * @param fechaModificada fecha modificada
  	 */
  	public void setFechaIni(LocalDate fechaModificada) {
		if(this.modificaEjercicio()){
			this.fechaInicio = fechaModificada;
		}
	}
  	
  	/**
     * Funcion que obtiene la fecha de inicio del ejercicio
     * @return el enunciado de la pregunta
     */
  	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	
  	/**
  	 * Funcion que fuerza la fecha de inicio (unicamente para comrpobaciones para el main)
  	 * @param dia dia
  	 * @param mes mes
  	 * @param anyo anio
  	 */
  	public void setFechaSimuladaIni(int dia, int mes, int anyo){
  		LocalDate fechaSimulada = LocalDate.now().withDayOfMonth(dia).withMonth(mes).withYear(anyo);
		this.fechaInicio = fechaSimulada;
  	}
  	
  	/**
  	 * Funcion que fuerza la fecha de fin (unicamente para comrpobaciones para el main)
  	 * @param dia dia
  	 * @param mes mes
  	 * @param anyo anio
  	 */
  	public void setFechaSimuladaFin(int dia, int mes, int anyo){
  		LocalDate fechaSimulada = LocalDate.now().withDayOfMonth(dia).withMonth(mes).withYear(anyo);
		this.fechaFin = fechaSimulada;
  	}
  	
  	/**
  	 * Funcion que establece la fecha de inicio con la fecha actual a traves de los metodos de fecha de java
  	 * @param dia dia
  	 * @param mes mes
  	 * @param anio anio
  	 */
	public void setFechaInicio(int dia, int mes, int anio) {
		LocalDate fechaActual = LocalDate.now().withDayOfMonth(dia).withMonth(mes).withYear(anio);
		if((fechaActual.equals(LocalDate.now()) || fechaActual.isAfter(this.fechaFin)) && (fechaActual.equals(this.fechaFin) || fechaActual.isAfter(this.fechaFin))){	
			if(this.modificaEjercicio()){
				this.fechaInicio = fechaActual;
			}
		}
	}
	
	/**
     * Funcion que obtiene la fecha de fin del ejercicio
     * @return la fecha de finalizacion
     */
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	
	/**
  	 * Funcion que establece la fecha de fin con la fecha actual a traves de los metodos de fecha de java
  	 * @param dia dia
  	 * @param mes mes
  	 * @param anio anio
  	 */
	public void setFechaFin(int dia, int mes, int anio) {
		LocalDate fechaActual = LocalDate.now().withDayOfMonth(dia).withMonth(mes).withYear(anio);
		if((fechaActual.equals(LocalDate.now()) || fechaActual.isAfter(this.fechaFin)) &&(fechaActual.equals(this.fechaInicio) || fechaActual.isAfter(this.fechaInicio))){	
			if(this.modificaEjercicio()){
				this.fechaFin = fechaActual;
			}
			else if(fechaFin.isBefore(fechaActual)){
				this.fechaFin = fechaActual;
			}
		}
	}
	
	/**
  	 * Funcion que establece la ponderacion de un ejercicio en una asignatura
  	 * @param ponderacion de un ejercicio
  	 */
	public void setPonderacion(double ponderacion){
		this.ponderacion = ponderacion;
	}
	
	/**
     * Funcion que obtiene la ponderacion del ejercicio
     * @return la ponderacion del ejercicio
     */
	public double getPonderacion(){
		return this.ponderacion;
	}
    
	/**
  	 * Funcion que establece las preguntas del ejercicio
  	 * @param preguntas array de preguntas del ejercicio
  	 */
	public void setPreguntas(ArrayList<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	/**
     * Funcion que obtiene las preguntas del ejercicio
     * @return array de preguntas
     */
	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}
	
	/**
  	 * Funcion que establece el orden de las preguntas del ejercicio
  	 */
	public void setOrden(){
		if(this.modificaEjercicio())
			this.orden = true;
	}
	
	/**
     * Funcion que obtiene el orden de las preguntas
     * @return true ordenadas, false no
     */
	public boolean getOrden(){
		return this.orden;
	}
	
	/**
     * Funcion que obtiene el id de las preguntas
     * @return id
     */
	public static int getId() {
		return id;
	}
	
	/**
  	 * Funcion que establece el id de un ejercicio
  	 * @param id id
  	 */
	public static void setId(int id) {
		Ejercicio.id = id;
	}
	
	/**
  	 * Funcion que establece el ejercicio de un estudiante
  	 * @param ejercicioEstudiante ejercicio
  	 */
	public void setEjercicioEstudiante(int ejercicioEstudiante) {
		this.ejercicioEstudiante = ejercicioEstudiante;
	}
	
	/**
     * Funcion que obtiene el ejercicio de un estudiante
     * @return int ejercicio
     */
	public int getEjercicioEstudiante() {
		return ejercicioEstudiante;
	}
	
	/**
  	 * Funcion que aniade preguntas a un ejercicio
  	 * @param pregunta a aniadir
  	 */
	public void aniadirPregunta(Pregunta pregunta) {
		this.preguntas.add(pregunta);
	}
	
	/**
  	 * Funcion que elimina preguntas a un ejercicio
  	 * @param pregunta a eliminar
  	 */
	public void eliminarPregunta(Pregunta pregunta) {
		if(modificaEjercicio()==true){
		  this.preguntas.remove(pregunta);
		}
	}
	
	/**
  	 * Funcion que desordena preguntas de un ejercicio
  	 * @param p a desordenar
  	 */
	public void desordenarPreguntas(ArrayList<Pregunta> p) {
		Collections.shuffle(p);	  
	}
	
	/**
	 * Funcion para desordenar las opciones
	 * @param opciones opciones que se desordenaran
	 */
	public void desordenarOpciones(ArrayList<String> opciones){
		Collections.shuffle(opciones);
	}
	
	/**
  	 * Funcion que modifica el ejercicio
  	 * @return true si se ha modificado, false si no
  	 */
	public boolean modificaEjercicio() {
		if(this.ejercicioEstudiante>0){
			 return false;
		}
		return true;
	}
	
	/**
  	 * Funcion que indica si un ejercicio se esta realizando
  	 * @return boolean realizando true si se esta realizando, false si no
  	 */
	public boolean isRealizando() {
		return realizando;
	}
	
	/**
  	 * Funcion que establece si un ejercicio se esta realizando
  	 * @param realizando realizando
  	 */
	public void setRealizando(boolean realizando) {
		this.realizando = realizando;
	}	
	
	/**
  	 * Funcion para acabar un ejercicio
  	 * @return media 
  	 */
	/*public void acabarEjercicio(){
		for(int i = 0; i<preguntas.size(); i++){
			preguntas.get(i).calculaNormalizacion(preguntas.size());
		}
		this.setRealizando(false);
	}*/
	
	 
	public String toString() {
	  
	  if(this.getVisibilidad()){
		  return "Ejercicio: " + getNombre() + "(" + "Fecha de inicio: " + getFechaInicio() + " / " + "Fecha de fin: " + getFechaFin()+ ")"+" - (visible)"+ "\n";
	  }
	  else
		  return "Ejercicio: " + getNombre() + "(" + "Fecha de inicio: " + getFechaInicio() + " / " + "Fecha de fin: " + getFechaFin() + ")" + " - (invisible)" + "\n";
	  }

	public ArrayList<Evaluacion> getEvaluacion() {
		return this.evaluacion;
	}

	public ArrayList<Respuesta> getRespuestas() {
		return this.respuestas;
	}



}