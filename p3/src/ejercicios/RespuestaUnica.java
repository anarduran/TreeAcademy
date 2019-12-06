package ejercicios;

/**
 * Clase heredada de Respuesta. Clase del tipo de respuesta con una unica opcion
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class RespuestaUnica extends Respuesta {
	@Override
	public String toString() {
		return "RespuestaUnica [respuesta=" + respuesta + "]";
	}

	private static final long serialVersionUID = 1L; /*id para la implementazion Serializable*/
	private String respuesta; /*respuesta introducida, supondremos que uno es la primera opcion*/
	
	/**
     * Constructor de la clase RespuestaUnica
     * @param pregunta pregunta introducida por el usuario
     * @param respuesta respuesta introducida por el usuario
     */
	public RespuestaUnica (Pregunta pregunta, String respuesta){
		super(pregunta);
		this.respuesta = respuesta;
		this.setId(4);
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