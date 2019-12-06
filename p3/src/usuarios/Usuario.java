package usuarios;
import java.io.Serializable;

/**
 * Clase de un usuario de TreeAcademy
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class Usuario implements Serializable{
  private static final long serialVersionUID = 1L;/*id del serializable*/
  private String numa;/*numa del estudiante y usuario del profesor*/
  private String contrasenia;/*contrasenia del estudiante y del profesor*/
  private boolean iniciado;/*variable para determinar si un un usuario ha iniciado sesion o no*/
  
  /**
   * Constructor de la clase Usuario
   * @param numa numa del estudiante o usuario del profesor
   * @param contrasenia contrasenia del profesor o del estudiante
   */
  public Usuario(String numa, String contrasenia){
	  this.numa = numa;
	  this.contrasenia = contrasenia;
	  this.iniciado = false;
  }
  
  /**
   * Funcion que obtiene el numa del estudiante o usuario del profesor
   * @return numa o usuario 
   */
  public String getNuma(){
	  return this.numa;
  }
  
  /**
   * Funcion que obtiene la contrasenia de un estudiante y de un profesor
   * @return contrasenia de un estudiante y de un profesor
   */
  public String getContrasenia(){
	  return this.contrasenia;
  }
  
  /**
   * Funcion que obtiene si el usuario ha iniciado sesion o no
   * @return true si ha iniciado sesion y falso en caso contrario
   */
  public boolean getIniciado(){
	  return this.iniciado;
  }
  
  /**
   * Funcion que establece si un usuario ha iniciado sesion o no
   * @param iniciado boolean
   */
  public void setIniciado(boolean iniciado){
	  this.iniciado = iniciado;
  }
  
  @Override
	public String toString() {
		return "Usuario [usuario=" + this.numa + ", contrasenia=" + this.contrasenia + "]";
	}

  

}