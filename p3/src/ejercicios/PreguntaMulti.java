package ejercicios;

/**
 * Clase heredada de Pregunta. Clase del tipo de pregunta multi opcion
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class PreguntaMulti extends Pregunta {
	private static final long serialVersionUID = 1L; /*id para la implementazion Serializable*/
	
	/**
     * Constructor de la clase PreguntaMulti
     * @param nota nota de la pregunta (Ej 1 punto)
     * @param enunciado enunciado de la pregunta
     * @param penalizacion penalizacion al fallar la pregunta
     */
	public PreguntaMulti(double nota, String enunciado, double penalizacion){
		super(nota, enunciado, penalizacion);
		this.setIdPregunta(3);
	}
}