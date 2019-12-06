package usuarios;
import java.io.Serializable;

/**
 * Clase heredada de Usuario.Clase del profesor de TreeAcademy
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 *
 */
public class Profesor extends Usuario implements Serializable{
	private static final long serialVersionUID = 1L;/*id del Serializable*/
	
  
  /**
   * Constructor del Profesor
   * @param usuario usuario
   * @param contrasenia contrasenia
   */
  public Profesor(String usuario, String contrasenia){
	  super(usuario, contrasenia);
  }
  
  @Override
  public String toString() {
	  return "Profesor [numa: "+ this.getNuma() +", contrasenia:"+ this.getContrasenia()+"]";
  }
 	
	 
}