package pruebas;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import treeAcademy.Asignatura;
import usuarios.Estudiante;
import usuarios.Matricula;

/**
 * JUnit de la clase Matricula
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class MatriculaTest {
	
	Matricula m;
	Estudiante e;
	Asignatura a;
	private static final double DELTA = 0;
	

	/**
	 * @throws java.lang.Exception java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		e = new Estudiante ("2592", "Mor", "Rosa", "Moreno", "Rosa.Moreno@esdu.es");
		a = new Asignatura ("Algebra");
		m = new Matricula(e, a);
		m.setAceptada(true);
		m.setId(2);
	}


	@Test
	public void testMatricula() {
		assertNotEquals(-1, m.getId());
		assertEquals(true, m.getAceptada());
		assertEquals(0.0, m.getNota(), DELTA);
	}
	
	@Test
	public void testSetAceptada(){
		m.setAceptada(true);
		assertEquals(true, m.getAceptada());
	}
	
	@Test
	public void testGetAceptada(){
		assertEquals(true, m.getAceptada());
	}
	
	@Test
	public void testGetEstudiante(){
		assertEquals(e, m.getEstudiante());
	}
	
	@Test
	public void testGetAsignaturas(){
		assertEquals(a, m.getAsignaturas());
	}
	

	
	@Test
	public void testSetId(){
		m.setId(2);
	}
	
	@Test
	public void testGetId(){
		assertEquals(2, m.getId());
	}
	
	@Test
	public void testSetBloqueada(){
		m.setBloqueada(true);
	}
	
	@Test
	public void testGetBloqueada(){
		m.setBloqueada(true);
		assertEquals(true, m.getBloqueada());
	}
	
	
}
