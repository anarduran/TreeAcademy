package usuarios; 
import java.io.Serializable;
import java.util.ArrayList;

import treeAcademy.Asignatura;

/**
 * Clase heredada de Usuario. Clase de un estudiante de TreeAcademy
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */

public class Estudiante extends Usuario implements Serializable{
  private static final long serialVersionUID = 1L;/*id del Serializable*/
  private String nombre;/*nombre del estudiante*/
  private String apellido; /*apellido del estudiante*/
  private boolean pendiente;/*variable que determina si un estudiante esta pendiente o no de ser aceptada su solicitud*/
  private boolean bloqueado; /*variable que determina si un estudiante ha sido expulsado o no de una asignatura*/
  private String correo; /*correo del estudiante*/
  private ArrayList<Asignatura> asignaturas;/*asignaturas en las que el estudiante esta matriculado*/
  private ArrayList<Matricula> matriculas;/*matriculas del estudiante*/
  private boolean aceptado; /*Variable para determinar si un estudiante ha sido aceptado o no*/
  private double nota;

  /**
   * Constructor de la clase Estudianate
   * @param id numa del estudiante
   * @param contrasenia contrasenia del estudiante
   * @param nombre2 nombre del estudiante
   * @param apellido2 apellido del estudiante
   * @param correo2 correo del estudiante
   */
  public Estudiante(String id,String contrasenia, String nombre2, String apellido2, String correo2){
	  super(id, contrasenia);
	  this.nombre = nombre2;
	  this.apellido = apellido2;
	  this.correo = correo2;
	  this.asignaturas = new ArrayList<Asignatura>();
	  this.bloqueado = false;
	  this.matriculas = new ArrayList<Matricula>();
	  this.aceptado =false;
	  this.nota = 0.0;
  }
  
  public void setNotaEstudiante(Evaluacion ev){
	  this.nota = ev.getNota();
  }
  
  public double getNotaEstudiante(){
	  return this.nota;
  }
  
  /**
   * Funcion que obtiene las asignaturas en las que esta matriculado el estudiante  
   * @return asignaturas en las que esta matriculado el estudiante
   */
  public ArrayList<Asignatura> getAsignaturas() {
	return this.asignaturas;
  }
  
   
  /**
   * Funcion que obtiene las matriculas de un estudiante
   * @return matriculas del estudiante
   */
  public ArrayList<Matricula> getMatriculas(){
	  return this.matriculas;
  }
  
  /**
   * Funcion que aniade al estudiante una nueva matricula a su array de matriculas
   * @param m matricula que se aniadira
   */
  public void aniadirMatricula(Matricula m){
	  this.matriculas.add(m);
  }
  
  /**
   * Funcion que obtiene si un estudiante ha sido aceptado o no
   * @return true si ha sido aceptado y false en caso contrario
   */
  public boolean getAceptado() {
	return this.aceptado;
  }

  /**
   * Funcion que establece si un estudiante ha sido aceptado o no
   * @param aceptado boolean
   */
  public void setAceptado(boolean aceptado) {
	this.aceptado = aceptado;
  }

/**
   * Funcion que obtiene el nombre de un estudiante
   * @return nombre del estudiante
   */
  public String getNombre(){
	  return this.nombre;
  }
  
  /**
   * Funcion que obtiene si un estudiante ha sido bloqueado o no
   * @return false si fue bloqueado y true si no lo fue 
   */
  public boolean getBloqueado(){
	  return this.bloqueado;
  }
  
  /**
   * Funcion que obtiene el apellido del estudiante 
   * @return apellido del estudiante
   */
  public String getApellido(){
	  return this.apellido;
  }
 
  /**
   * Funcion que establece si un estudiante ha sido bloquead
   * @param bloqueado true si fue expulsado y falso en caso contrario
   */
  public void setBloqueado(boolean bloqueado) {
	this.bloqueado = bloqueado;
  }

  /**
   * Funcion que obtiene si un estudiante esta pendiente de ser aceptada su solicitud de matriculacion
   * @return true si esta pendiente y false en caso contrario
   */
  public boolean getPendiente(){
	  return this.pendiente;
  }
  
  /**
   * Funcion que establece si un estudiante esta pendiente de recibir la acpetacion/rechazo de una solicitud
   * @param pendiente true si esta pendiente y false en caso contrario
   */
  public void setPendiente(boolean pendiente) {
		this.pendiente = pendiente;
  }
  
  /**
   * Funcion que obtiene el correo de un estudiante
   * @return correo del estudiante
   */
  public String getCorreo(){
	  return this.correo;
  }

  /**
   * Funcion de contain
   * @param s string que se va comprobar si esta contenido en el array
   * @return false en caso de que s no este en el array
   */
  public boolean contains(String s) {
	// TODO Auto-generated method stub
	return false;
  }
  
  
  @Override
  public String toString() {
	  return "\n"+ "\t"+ "-Nombre: " + this.nombre + "\n"+ "\t"+ "-Apellido: " + this.apellido +"\n"+ "\t" +"-Numa: " + this.getNuma() + 
			  "\n" + "\t"+ "-Correo: " + this.correo + "\n"+ "\t"+"-Contrasenia: "+ this.getContrasenia()+ "\n"+ "\t"+ "-Asignaturas: " + this.getAsignaturas() + "(" 
			  + this.getAsignaturas().size() +")";
  }	

  
  /**
   * Funcion para comprobar los datos a la hora de iniciar sesion 
   * @param numa numa del estudiante
   * @param contrasenia contrasenia del estudiante
   * @return true si son iguales y false en caso contrario
   */
  public boolean comprobarEstudiante(String numa, String contrasenia){
	  if (this.getNuma().equals(numa) && this.getContrasenia().equals(contrasenia)){
		  return true;
	  }
	  
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
		Estudiante other = (Estudiante) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (asignaturas == null) {
			if (other.asignaturas != null)
				return false;
		} else if (!asignaturas.equals(other.asignaturas))
			return false;
		if (bloqueado != other.bloqueado)
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (matriculas == null) {
			if (other.matriculas != null)
				return false;
		} else if (!matriculas.equals(other.matriculas))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (pendiente != other.pendiente)
			return false;
		return true;
	}

	public boolean contains(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return false;
	}
   
}