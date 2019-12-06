package ejercicios;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase Pregunta Abstracta
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public abstract class Pregunta implements Serializable {
  private static final long serialVersionUID = 1L;
  private double nota; /*nota de la pregunta, (Ej 1,5)*/
  private String enunciado; /*enunciado de la pregunta*/
  private double penalizacion; /*penalizacion al fallar una pregunta*/
  private ArrayList<String> opciones; /*array de respuestas*/
  private int numrespuestas; /*numero de respuestas*/
  private int numrespuestascorrectas; /*numero de respuestas correctas de una pregunta*/
  private Respuesta respuesta;
  private int id;
  
  /**
   * Constructor de la clase Pregunta
   * @param nota nota de la pregunta (Ej 1 punto)
   * @param enunciado enunciado de la pregunta
   * @param penalizacion penalizacion al fallar la pregunta
   */
  public Pregunta(double nota, String enunciado, double penalizacion){
	  this.nota = nota;
	  this.enunciado = enunciado;
	  this.penalizacion = penalizacion;
	  this.setNumrespuestas(0);
	  this.setNumrespuestascorrectas(0);
	  this.opciones = new ArrayList<String>();
  }
  
  public int getIdPregunta(){
	  return this.id;
  }
  
  public void setIdPregunta(int id){
	  this.id = id;
  }
  
  /**
   * Funcion que establece la nota de la pregunta
   * @param nota nota de la pregunta
   * @return int
   */
  public double setNota(double nota){
	  return this.nota = nota;
  }
  
  /**
   * Funcion que obtiene la respuesta de la pregunta
   * @return respuesta de la pregunta 
   */
  public Respuesta getRespuesta(){
	  return this.respuesta;
  }
  
  /**
   * Funcion que obtiene el numero de opciones posibles
   * @return el numero de opciones
   */
  public double getNota(){
	  return this.nota;
  }
  
  /**
   * Funcion que establece el enunciado de la pregunta
   * @param enun el enunciado de la pregunta
   * @return String
   */
  public String setEnunciado(String enun){
	  return this.enunciado = enun;
  }
  
  /**
   * Funcion que obtiene el enunciado de la pregunta
   * @return el enunciado de la pregunta
   */
  public String getEnunciado(){
	  return this.enunciado;
  }
  
  /**
   * Funcion que establece la penalizacion al fallar la pregunta
   * @param penalizacion penalizacion de la pregunta
   * @return int
   */
  public double setPenalizacion(double penalizacion){
	  return this.penalizacion = penalizacion;
  }
  
  /**
   * Funcion que obtiene el enunciado de la pregunta
   * @return el enunciado de la pregunta
   */
  public double getPenalizacion(){
	  return this.penalizacion;
  }
  
  /**
   * Funcion que establece el array de respuestas de la pregunta
   * @param opciones array de respuestas
   */
  public void setOpciones(ArrayList<String> opciones) {
	  this.opciones = opciones;
  }
  
  /**
   * Funcion que obtiene el array de respuestas de la pregunta
   * @return array de respuestas
   */
  public ArrayList<String> getOpciones() {
	  return this.opciones;
  }
  
  
  
  /**
   * Funcion que aniade opciones a una pregunta
   * @param opciones opciones que se desean aniadir
   */
  public void aniadirOpciones(String opciones) {
	  this.opciones.add(opciones);
  }
  
  /**
   * Funcion que obtiene el numero de respuestas de una pregunta
   * @return int numero de respuestas de una pregunta
   */
  public int getNumrespuestas() {
	  return numrespuestas;
  }
  
  /**
   * Funcion que establece el numero de respuestas de una pregunta
   * @param numrespuestas numero de respuestas
   */
  public void setNumrespuestas(int numrespuestas) {
	  this.numrespuestas = numrespuestas;
  }
  
  /**
   * Funcion que obtiene el numero de respuestas correctas de una pregunta
   * @return int numero de respuestas correctas de una pregunta
   */
  public int getNumrespuestascorrectas() {
	  return numrespuestascorrectas;
  }
  
  /**
   * Funcion que establece el numero de respuestas correctas de una pregunta
   * @param numrespuestascorrectas numero de respuestas correctas
   */
  public void setNumrespuestascorrectas(int numrespuestascorrectas) {
	  this.numrespuestascorrectas = numrespuestascorrectas;
  }

  public String toString(){
	  return "*" + getEnunciado() + "\n";
  }
}