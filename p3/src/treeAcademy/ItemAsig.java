package treeAcademy;

import java.io.Serializable;

/**
 * Clase abstracta. Clase de los items (ejercicios, temas y apuntes) de una asignatura
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public abstract class ItemAsig implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre;/*nombre del item*/
	private boolean visibilidad;/*visibilidad del item*/
	public double nota;
	
	/**
	 * Constructor de la clase ItemAsig
	 * @param nombre nombre del item
	 * @param visibilidad visbilidad del item
	 */
	public ItemAsig(String nombre, boolean visibilidad){
		this.nombre = nombre;
		this.visibilidad = visibilidad;
		this.nota = 0;
	}	
	
	public void setNota(double nota){
  		this.nota = nota;
  	}
  	
  	public double getNota(){
  		return this.nota;
  	}

	/**
	 * Funcion que obtiene el nombre del item
	 * @return nombre del item
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Funcion que establece el nombre del item
	 * @param nombre nombre del item 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Funcion que obtiene la visibilidad de un item
	 * @return true si esta visible y false en caso contrario
	 */
	public boolean getVisibilidad() {
		return this.visibilidad;
	}

	/**
	 * Funcion que establece la visibilidad de un item
	 * @param visibilidad visibilidad del item, true si esta visible y false en caso contrario
	 */
	public void setVisibilidad(boolean visibilidad) {
		this.visibilidad = visibilidad;
	}

	
	
}
