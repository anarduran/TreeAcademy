package pruebas;
import static org.junit.Assert.*;
import java.io.IOException;
import java.util.*;
import org.junit.*;
import treeAcademy.Asignatura;
import treeAcademy.TreeAcademy;
import usuarios.Estudiante;
import usuarios.Profesor;
import usuarios.Usuario;

/**
 * JUnit de la clase TreeAcademy
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class TreeAcademyTest {

	TreeAcademy ta;
	Usuario u;
	Profesor p;
	ArrayList<Estudiante> estudiantes;
	ArrayList<Asignatura> asignaturas;
	
	
	
	@Before
	public void setUp() throws Exception {
		ta = new TreeAcademy();
		estudiantes = new ArrayList<Estudiante>();
		asignaturas = new ArrayList<Asignatura>();
		p = new Profesor("prof", "prof");
		ta.setIniciado(true);
	}
	
	
	@Test
	public void testAniadirAsignatura() {
		Asignatura asig1 = new Asignatura("Calculo");
		TreeAcademy.aniadirAsignatura(asig1);
		assertEquals(asig1, TreeAcademy.getAsignaturas().get(0));
	}
	
	@Test
	public void testSetIniciado(){
		ta.setIniciado(true);
		assertEquals(true, ta.getIniciado());
	}
	
	@Test
	public void testGetIniciado(){
		assertEquals(true, ta.getIniciado());
	}
	
	@Test
	public void testIniciarSesion() throws ClassNotFoundException, IOException{
		u = ta.iniciarSesion("prof", "prof");
		assertEquals(u, ta.getProfesor());
		assertNotNull(u);
		p.setIniciado(true);
		assertEquals(true, p.getIniciado());
		ta.setIniciado(true);
		assertEquals(true, ta.getIniciado());
	}
	
	@Test
	public void testCerrarSesion(){
		ta.setIniciado(false);
		assertEquals(false, ta.getIniciado());
		p.setIniciado(false);
		assertEquals(false, p.getIniciado());
	}
	
	@Test
	public void testGetEstudiantes(){
		assertEquals(estudiantes, TreeAcademy.getEstudiantes());
	}
	
	@Test
	public void testGetAsignaturas(){
		assertEquals(asignaturas, TreeAcademy.getAsignaturas());
	}

}
