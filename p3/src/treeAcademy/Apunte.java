package treeAcademy;

/**
 * Clase heredada de ItemAsig. Clase de un apunte de una asignatura
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class Apunte extends ItemAsig{
	private static final long serialVersionUID = 1L;/*id para del Serializable*/
	private String contenido; /*contenido de un apunte*/
  
    /**
     * Constructor de la clase Apunte
     * @param nombre nombre del apunte
     * @param visibilidad visibilidad del apunte
     */
    public Apunte(String nombre, boolean visibilidad){
    	super (nombre, visibilidad);
    }
  
    /**
     * Funcion que establece el contenido de un apunte
     * @param contenido el contenido del apunte
     * @return string, es decir, el contenido
     */
    public String setContenido(String contenido){
    	return this.contenido = contenido;
    }
  
    /**
     * Funcion que obtiene el contenido de un apunte
     * @return contenido del apunte
     */
    public String getContenido(){
    	return this.contenido;
    }

    @Override
  	public String toString() {
	  
	  	if (this.getVisibilidad() == true){
	  		return "Apunte: " + this.getNombre() + " - (visible)";
	  	}else{
	  		return "Apunte: " + this.getNombre() + " - (invisible)";
	  	}
	
  	}
}