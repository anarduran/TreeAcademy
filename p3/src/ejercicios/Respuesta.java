package ejercicios;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase Respuesta abstracta
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public abstract class Respuesta implements Serializable {
	private static final long serialVersionUID = 1L; /*id para la implementazion Serializable*/
	private Pregunta pregunta; /*Pregunta a la que se refiere la respuesta*/
	private double calificacion; /*Calificacion de la pregunta*/
	private boolean correcta; /*Variable para determinar si la pregunta es correcta*/
	private String respuesta;
	private int id;
	
	/**
	 * Constructor de la clase Respuesta
	 * @param pregunta pregunta de la respuesta
	 */
	public Respuesta (Pregunta pregunta){
		this.setPregunta(pregunta);
		this.setCalificacion(0);
		this.setCorrecta(false);
		this.id = 0;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	/**
	 * Funcion que establece la pregunta correspondiente a la respuesta
	 * @param pregunta pregunta de la respuesta
	 */
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	
	/**
	 * Funcion que obtiene la pregunta de la respuesta
	 * @return pregunta pregunta de la respuesta
	 */
	public Pregunta getPregunta() {
		return pregunta;
	}
	
	/**
	 * Funcion que establece la pregunta correcta
	 * @param correcta true si lo es, false si no
	 */
	public void setCorrecta(boolean correcta) {
		this.correcta = correcta;
	}
	
	/**
	 * Funcion que obtiene la respuesta correcta
	 * @return boolean true si es correcta, false si no
	 */
	public boolean getCorrecta() {
		return correcta;
	}
	
	/**
	 * Funcion que establece la calificacion de una respuesta
	 * @param calificacion de la respuesta
	 */
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	
	/**
	 * Funcion que obtiene la calificacion de la respuesta
	 * @return double calificacion
	 */
	public double getCalificacion() {
		return calificacion;
	}
	
	/**
	 * Funcion que obtiene las estadisticas de las respuestas
	 * @return null
	 */
	public ArrayList<Double> calcularEstadisticaRespuestas() {
		return null;
	}
	
	/**
	 * Funcion que establece la respuesta introducida
	 * @param respuesta respuesta introducida
	 * @return String
	 */
	public String setRespuesta(String respuesta){
		return this.respuesta = respuesta;
	}
	
	/**
	 * Funcion que obtiene la respuesta introducida
	 * @return respuesta introducida
	 */
	public String getRespuesta(){
		return this.respuesta;
	}
}