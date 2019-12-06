package ejercicios;

/**
 * Clase heredada de Respuesta. Clase del tipo de respuesta abierta 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class RespuestaAbierta extends Respuesta {
	

	private static final long serialVersionUID = 1L; /*id para la implementazion Serializable*/
	private String respuesta; /*respuesta introducida*/
	
	/**
     * Constructor de la clase RespuestaAbierta
     * @param pregunta pregunta introducida por el usuario
     * @param respuesta respuesta introducida por el usuario
     */
	public RespuestaAbierta(Pregunta pregunta, String respuesta){
		super(pregunta);
		this.respuesta = respuesta;
		this.setId(2);
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
	@Override
	public String toString() {
		return "RespuestaAbierta [respuesta=" + respuesta + "]";
	}
}