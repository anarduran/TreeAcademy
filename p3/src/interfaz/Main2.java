package interfaz;

import java.io.*;
import java.text.ParseException;

import controladores.Controlador;
import treeAcademy.*;

/**
 * Clase del main de la interfaz
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */

public class Main2 {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, ParseException {
		/*TreeAcademy tree_academy = new TreeAcademy();
		LecturaFichero.cargarEstudiantes("DatosAlumnos.txt");
		
		
		Controlador controlador = new Controlador(tree_academy, new GUIAplicacion());*/
		
		TreeAcademy ta = new TreeAcademy();
		GUIAplicacion gui = new GUIAplicacion();
		File fichero = new File("TreeAcademy.obj");
		
		
		if (fichero.isFile()){
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("TreeAcademy.obj"));
			ta = (TreeAcademy) entrada.readObject();
			
			ta.cargarDatos();
			Controlador controlador = new Controlador(ta, gui);
			entrada.close();
		}else{
			ta = new TreeAcademy();
			LecturaFichero.cargarEstudiantes("DatosAlumnos.txt");
			Controlador controlador = new Controlador(ta, gui);
		}
		
	}
}