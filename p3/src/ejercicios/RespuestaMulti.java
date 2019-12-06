package ejercicios;

/**
 * Clase heredada de Respuesta. Clase del tipo de respuesta multi opcion
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class RespuestaMulti extends Respuesta {
	@Override
	public String toString() {
		return "RespuestaMulti [respuesta=" + respuesta + "]";
	}

	private static final long serialVersionUID = 1L; /*id para la implementazion Serializable*/
	private String respuesta; /*respuesta introducida, supondremos que uno es la primera opcion*/
	
	/**
     * Constructor de la clase RespuestaMulti
     * @param pregunta pregunta introducida por el usuario
     * @param respuesta respuesta introducida por el usuario
     */
	public RespuestaMulti (Pregunta pregunta, String respuesta){
		super(pregunta);
		this.respuesta = respuesta;
		this.setId(3);
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