package pruebas;
import static org.junit.Assert.*;
import org.hamcrest.Matcher;
import org.junit.*;
import treeAcademy.Asignatura;
import usuarios.Estudiante;
import usuarios.Matricula;

import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * JUnit de la clase Estudiante
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class EstudianteTest {
	
	Estudiante e;
	Asignatura a;
	Matricula m;
	ArrayList<Asignatura> asig;
	ArrayList<Matricula> matricula;

	/**
	 * @throws java.lang.Exception java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		e = new Estudiante ("2592", "Mor", "Rosa", "Moreno", "Rosa.Moreno@esdu.es");
		asig = new ArrayList<Asignatura>();
		matricula = new ArrayList<Matricula>();
		e.setPendiente(true);
	}

	@Test
	public void testEstudiante() {
		assertEquals("2592", e.getNuma());
		assertEquals("Mor", e.getContrasenia());		
	}
	
		
	@Test
	public void testGetAsignatura(){
		ArrayList<Asignatura> asig = null;
		asig = e.getAsignaturas();
		assertEquals(asig, e.getAsignaturas());
	}
	
				
	@Test
	public void testSetBloqueado(){
		e.setBloqueado(true);
	}
	
	@Test
	public void testGetBloqueado(){
		e.setBloqueado(true);
		assertEquals(true, e.getBloqueado());
	}
	
	@Test
	public void testSetPendiente(){
		e.setPendiente(true);
		assertEquals(true, e.getPendiente());
	}
	
	@Test
	public void testGetPendiente(){
		assertEquals(true, e.getPendiente());
	}
	
	
	@Test
	public void testSolicitarMatricula(){
		@SuppressWarnings("unused")
		Asignatura a = new Asignatura ("Calculo");
		assertThat(matricula, containsString("Calculo"));
		e.setPendiente(true);
	}

	private void assertThat(ArrayList<Matricula> matricula2, Matcher<String> containsString) {
		// TODO Auto-generated method stub
		
	}
	

}
