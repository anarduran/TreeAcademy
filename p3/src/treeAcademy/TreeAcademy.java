package treeAcademy;
import java.util.ArrayList;
import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import usuarios.Estudiante;
import usuarios.Matricula;
import usuarios.Profesor;
import usuarios.Usuario;


import java.io.*;

/**
 * Clase de TreeAcademy. Se implementaran todas las funciones que realiza la aplicacion
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class TreeAcademy implements Serializable {
	private static final long serialVersionUID = 1L;/*id del serializable*/
	private static ArrayList<Estudiante> estudiantes;/*estudiantes de la academia*/
	private static ArrayList<Asignatura> asignaturas;/*asignaturas de la academia*/
	private Profesor profesor;/*profesor de la academia*/
	private boolean iniciado;/*variable que determina si se ha iniciado sesion o no*/
	private ArrayList<Matricula> matriculas;
	private Profesor profesor_guardado;
	private ArrayList<Estudiante> estudiante_guardado;
	private ArrayList<Asignatura> asignatura_guardada;
	
	/**
	 * Constructor de TreeAcademy
	 */
	public TreeAcademy(){
		TreeAcademy.estudiantes =  new ArrayList<Estudiante>();
		TreeAcademy.asignaturas = new ArrayList<Asignatura>();
		this.matriculas = new ArrayList<Matricula>();
		this.profesor = new Profesor ("prof", "prof");
	}
	
		
	@Override
	public String toString() {
		for(Asignatura asignatura : TreeAcademy.asignaturas){
			asignatura.setSoloNombre(true);
		}
		String cadenaAux = "TreeAcademy\n"+"-Numero de asignaturas:"+TreeAcademy.getAsignaturas().size()+ "\n" + TreeAcademy.asignaturas + 
				"\n-Numero de estudiantes: " + TreeAcademy.getEstudiantes().size();
		
		for(Asignatura asignatura : TreeAcademy.asignaturas){
			asignatura.setSoloNombre(false);
		}
		
		return cadenaAux;
			
	}
	
	/**
	 * Funcion que obtiene las matriculas de la academia
	 * @return matriculas de la academia
	 */
	public ArrayList<Matricula> getMatriculas(){
		return this.matriculas;
	}
	
	/**
	 * Funcion para iniciar sesion
	 * @param usuario usuario con el que iniciaran sesion los estudiantes o el profesor
	 * @param contrasenia contrasenia con la que iniciaran sesion los estudiantes o el profesor
	 * @return devuelve el usuario que ha iniciado sesion, es decir, un profesor o un estudiante
	 */
	public Usuario iniciarSesion(String usuario, String contrasenia){
		
		if ((usuario.compareTo("prof") == 0) && (contrasenia.compareTo("prof") == 0)){
			this.setIniciado(true);
			this.profesor.setIniciado(true);
			return this.profesor;
		}else {
			for (int i = 0; i< estudiantes.size(); i++){
				if ((TreeAcademy.estudiantes.get(i).comprobarEstudiante(usuario, contrasenia)) == true){
					this.setIniciado(true);
					TreeAcademy.estudiantes.get(i).setIniciado(true);
					return TreeAcademy.estudiantes.get(i);
				}
			}	
	 	}
			return null;
	}
	
	/**
	 * Funcion que obtiene las asignaturas que tiene la academia
	 * @return asignaturas que tiene la academia
	 */
	public static ArrayList<Asignatura> getAsignaturas() {
		return TreeAcademy.asignaturas;
	}
	
	/**
	 * Funcion que obtiene los estudiantes de la academia
	 * @return estudiantes de la academia
	 */
	public static ArrayList<Estudiante> getEstudiantes(){
		return TreeAcademy.estudiantes;
	}

	/**
	 * Funcion que obtiene si se ha iniciado sesion o no
	 * @return true si se ha iniciado sesion y false en caso contrario
	 */
	public boolean getIniciado(){
		return this.iniciado;
	}
	
	/**
	 * Funcion que establece la variable iniciado
	 * @param iniciado boolean 
	 */
	public void setIniciado(boolean iniciado){
		this.iniciado = iniciado;
	}
	
	/**
	 * Funcion que obtiene el profesor de la academia
	 * @return profesor de la academia
	 */
	public Profesor getProfesor(){
		return this.profesor;
	}
	
	/**
	 * Funcion para cerrar sesion
	 * @throws FileNotFoundException excepcion
	 * @throws IOException excepcion
	 */
	public void cerrarSesion() throws FileNotFoundException, IOException {
		this.guardarDatos();
		this.setIniciado(false);
		if (this.profesor.getIniciado() == true){
			this.profesor.setIniciado(false);
		}
		for (int i = 0; i < TreeAcademy.estudiantes.size(); i++){
			if (TreeAcademy.estudiantes.get(i).getIniciado() == true){
				TreeAcademy.estudiantes.get(i).setIniciado(false);
			}
		}
		return;
	}
	
	/**
	 * Funcion static para poder buscar una asignatura
	 * @param s nombre de la asignatura que se desea buscar
	 * @return asignatura que tiene el nombre que se ha buscado
	 */
	public static Asignatura buscarAsignatura(String s) {
		for(int i = 0; i < TreeAcademy.asignaturas.size(); i++){
			if (TreeAcademy.asignaturas.get(i).getNombreAsignatura().equals(s)){
				return TreeAcademy.asignaturas.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Funcion static para poder buscar un estudiante
	 * @param s numa del estudiante que se desea buscar
	 * @return null retorna null
	 */
	public static Estudiante buscarEstudiante(String s) {
		for (int i = 0; i< TreeAcademy.estudiantes.size(); i++){
			if ((TreeAcademy.estudiantes.get(i).getNuma().equals(s)) || (TreeAcademy.estudiantes.get(i).getNombre().equals(s))){
				return TreeAcademy.estudiantes.get(i);
			}
		}				
		return null;
	}
	
	/**
	 * Funcion que aniade asignaturas en la academia
	 * @param asig asignatura que se desea aniadir
	 */
	public static void aniadirAsignatura(Asignatura asig) {
		TreeAcademy.asignaturas.add(asig);
	}
	
	
	 /**
	  * Funcion para poder guardar todo lo que hizo un usuario
	  * @throws IOException excepcion
	  * @throws FileNotFoundException excepcion
	  */
	 public void guardarDatos() throws IOException, FileNotFoundException{
		this.profesor_guardado = this.profesor;
		this.estudiante_guardado = TreeAcademy.estudiantes;
		this.asignatura_guardada = TreeAcademy.asignaturas;	
		File f = new File("TreeAcademy.obj");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.close();
	}
	 
	 /**
	  * Funcion que lee del fichero todo lo que ha realizado el usuario
	  * @return devuelve el estado de la aplicacion, es decir, de TreeAcademy 
	  * @throws ClassNotFoundException excepcion
	  * @throws IOException excepcion
	  */
	 public TreeAcademy cargarDatos() throws ClassNotFoundException, IOException{
			ObjectInputStream ois = null;
			File f = new File("TreeAcademy.obj");
			FileInputStream fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			TreeAcademy ta = (TreeAcademy)ois.readObject();
			ois.close();
			estudiantes = this.estudiante_guardado;
			asignaturas = this.asignatura_guardada;
			profesor = this.profesor_guardado;
			return ta;
			
	}

	/**
	 * Funcion que aniade un nuevo estudiante 
	 * @param nuevoEstudiante nuevo estudiante a aniadir
	 */
	public static void aniadirEstudiante(Estudiante nuevoEstudiante) {
		TreeAcademy.estudiantes.add(nuevoEstudiante);
		
	}
	
	/**
	 * Funcion que imprime los estudiantes de la academia, las asignaturas creadas y las matriculas
	 */
	public void mostrarContenidoAcademia(){
		/*Asignaturas*/
		for (int i = 0; i< TreeAcademy.getAsignaturas().size(); i++){
			System.out.println("(" + (i+1) +")"+TreeAcademy.getAsignaturas().get(i));
				for (int j = 0; j< TreeAcademy.getAsignaturas().get(i).getTemas().size(); j++){
					for (int k = 0; k < TreeAcademy.getAsignaturas().get(i).getTemas().get(j).getItems().size(); k++){
						System.out.println("- " + TreeAcademy.getAsignaturas().get(i).getTemas().get(j).getItems().get(k).toString());
					}
				} 
		}
	}
	
	  /**
	   * Funcion que acepta la solicitud de un estudiante 
	   * @param estudiante estudiante que ha solicitado matricula en una asignatura
	   * @param asignatura asignatura a la que quiere matricularse el estudiante
	   * @throws FailedInternetConnectionException excepcion
	   * @throws InvalidEmailAddressException excepcion
	   */
	  public void aceptarSolicitud (Estudiante estudiante, Asignatura asignatura) throws FailedInternetConnectionException, InvalidEmailAddressException{
		  for (Matricula m : estudiante.getMatriculas()){
			  if((m.getEstudiante().equals(estudiante)) && (m.getAsignaturas().equals(asignatura))){
				  m.setAceptada(true);
				  m.setPendiente(false);
				  m.getAsignaturas().aniadirMatricula(m);
				  //m.getEstudiante().aniadirMatricula(m);
				  estudiante.getAsignaturas().add(asignatura);
				  asignatura.aniadirEstudianteMatriculado(estudiante);
				  estudiante.setPendiente(false);
				  estudiante.setAceptado(true);
				  EmailSystem.send(estudiante.getCorreo(), "Solicitud aceptada", "Su solicitud ha sido aceptada");
				  break;
			  }
		  }
	  }
	  
	  /**
	   * Funcion que rechaza la solicitud de un estudiante
	   * @param estudiante estudiante que ha solicitado matricula en una asignatura
	   * @param asignatura asignatura a la que quiere matricularse el estudiante
	   * @throws FailedInternetConnectionException excepcion
	   * @throws InvalidEmailAddressException excepcion
	   */
	  public void rechazarSolicitud (Estudiante estudiante, Asignatura asignatura) throws FailedInternetConnectionException, InvalidEmailAddressException{
		  for (Matricula m : estudiante.getMatriculas()){
			  if((m.getEstudiante().equals(estudiante)) && (m.getAsignaturas().equals(asignatura))){
				  m.setAceptada(false);
				  m.setPendiente(false);
				  estudiante.getMatriculas().remove(m);
				  EmailSystem.send(estudiante.getCorreo(), "Solicitud rechazada", "Su solicitud ha sido rechazada");
				  break;
			  }
		  }
	  }
	  
	  
	  
	  /**
		 * Funcion para expulsar a un estudiante de una asignatura	
		 * @param asignatura asignatura de la que se expulsara al estudiante
		 * @param estudiante estudiante que se expulsara
		 * @throws FailedInternetConnectionException excepcion
		 * @throws InvalidEmailAddressException excepcion
		 */
		public void expulsarEstudiante(Estudiante estudiante, Asignatura asignatura) throws FailedInternetConnectionException, InvalidEmailAddressException{ 
			if (asignatura.getEstudiantesMatriculados().contains(estudiante)){
				for (Matricula m: asignatura.getMatricula()){
					if ((m.getEstudiante().getNombre().compareTo(estudiante.getNombre()) == 0 && m.getAsignaturas().getNombreAsignatura().compareTo(asignatura.getNombreAsignatura()) == 0)){
						m.setBloqueada(true);
						estudiante.setBloqueado(true);
						//estudiante.getMatriculas().remove(m);
						asignatura.getEstudiantesMatriculados().remove(estudiante);
						estudiante.setAceptado(false);
						estudiante.getAsignaturas().remove(asignatura);
						asignatura.aniadirEstudianteBloqueado(estudiante);
						EmailSystem.send(estudiante.getCorreo(), "Bloqueado", "Ha sido bloqueado de la asignatura");
						break;
					}
				}
			}
		}
		

		/**
		 * Funcion para readmitir a un estudiante en una asignatura
		 * @param asignatura asignatura a la que se quiere readmitir
		 * @param estudiante estudiante que se quiere readmitir
		 * @throws FailedInternetConnectionException excepcion
		 * @throws InvalidEmailAddressException excepcion
		 */
		public void readmitirEstudiante(Estudiante estudiante, Asignatura asignatura) throws FailedInternetConnectionException, InvalidEmailAddressException{
			if (asignatura.getEstudiantesMatriculados().contains(estudiante)){
				for (Matricula m: asignatura.getMatricula()){
					if (m.getEstudiante().equals(estudiante) && m.getAsignaturas().equals(asignatura)){
						m.setBloqueada(false);
						estudiante.setBloqueado(false);
						//estudiante.getMatriculas().add(m);
						estudiante.getAsignaturas().add(asignatura);
						asignatura.getEstudiantesBloqueados().remove(estudiante);
						asignatura.aniadirEstudianteMatriculado(estudiante);
						EmailSystem.send(estudiante.getCorreo(), "Readmitido", "Ha sido readmitido de la asignatura");
						break;
					}
				}
			}
			
		}
		
		/**
		   * Funcion para solicitar una matricula de una asignatura
		   * @param asig asignatura a la que el estudiante se quiere matricular
		   * @param estu estudiante de la academia
		   */
	 public void solicitarMatricula(Asignatura asig, Estudiante estu){
		 if ((TreeAcademy.getAsignaturas().contains(asig)) && !(estu.getAsignaturas().contains(asig))){
			if (this.matriculas.size() == 0){
				estu.setPendiente(true);
				Matricula matricula = new Matricula(estu, asig);
				this.matriculas.add(matricula);
				estu.aniadirMatricula(matricula);
				matricula.setPendiente(true);
					  
			}else{
				if (!asig.getEstudiantesMatriculados().contains(this)){
					estu.setPendiente(true);
					Matricula matricula = new Matricula(estu, asig);
					this.matriculas.add(matricula);
					estu.aniadirMatricula(matricula);
					matricula.setPendiente(true);
				}
					  
			}
		}
					  
	 }
	 
	 public static void enviarNotificacion() throws InvalidEmailAddressException, FailedInternetConnectionException{
		 for (Asignatura a: TreeAcademy.getAsignaturas()){
			 for (Tema t: a.getTemas()){
				 for (int i = 0; i < t.getItems().size(); i++){
					 if (t.getItems().get(i) instanceof Apunte){
						 if (t.getItems().get(i).getVisibilidad() == true){
							 for (Estudiante e : TreeAcademy.getEstudiantes()){
								 EmailSystem.send(e.getCorreo(), "Apunte visible", "Apunte disponible");
							 }
						 }
					 }
					 if (t.getItems().get(i) instanceof Ejercicio){
						 if (t.getItems().get(i).getVisibilidad() == true){
							 for (Estudiante e : TreeAcademy.getEstudiantes()){
								 EmailSystem.send(e.getCorreo(), "Ejercicio visible", "Ejercicio disponible");
							 }
						 }
					 }
				 }
			 }
		 }
	 }
		

}