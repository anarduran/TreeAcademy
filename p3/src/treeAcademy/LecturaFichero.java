package treeAcademy;
import java.io.*;
import java.util.StringTokenizer;

import es.uam.eps.padsof.emailconnection.EmailSystem;
import usuarios.Estudiante;

/**
 * Clase para cargar los datos del fichero de texto DatosAlumnos.txt
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */

public class LecturaFichero {
	/**
	 * Funcion para cargar los datos y asignarselos a los estudiantes
	 * @param fichero fichero DatosAlumnos.txt
	 * @throws FileNotFoundException excepcion
	 * @throws IOException excepcion
	 */
	public static void cargarEstudiantes(String fichero) throws FileNotFoundException, IOException{
		BufferedReader buffer = new BufferedReader(new FileReader(fichero));
		String linea;
		
		while ((linea =buffer.readLine()) != null){
			StringTokenizer tokens = new StringTokenizer(linea, ";");
			String nombre = tokens.nextToken();
			String apellido = tokens.nextToken();
			String correo = tokens.nextToken();
			String numa = tokens.nextToken();
			String contrasenia = tokens.nextToken();
			
			if (EmailSystem.isValidEmailAddr(correo)== true){
				Estudiante nuevoEstudiante = new Estudiante(numa, contrasenia, nombre, apellido, correo);
				TreeAcademy.aniadirEstudiante(nuevoEstudiante);
			}
			
		}
		
		
		buffer.close();
	}
	
	
	
}
