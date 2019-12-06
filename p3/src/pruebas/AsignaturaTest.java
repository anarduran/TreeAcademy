package pruebas;
import static org.junit.Assert.*;
import org.junit.*;
import treeAcademy.Asignatura;
import treeAcademy.Tema;
import usuarios.Estudiante;
import usuarios.Matricula;

/**
 * JUnit de la clase Asignatura
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class AsignaturaTest {

	Asignatura asignatura;

	@Before
	public void setUp() throws Exception {
		asignatura = new Asignatura ("Calculo");
		asignatura.setVisibilidad(true);
	}

	@Test
	public void testAsignatura() {
		assertEquals("Calculo", asignatura.getNombreAsignatura());
	}
	
	@Test
	public void testAniadirMatricula(){
		Estudiante e1 = new Estudiante("2592", "Mor", "Rosa", "Moreno", "Rosa.Moreno@esdu.es");
		Matricula matricula = new Matricula(e1, asignatura);
		asignatura.aniadirMatricula(matricula);
		assertEquals(matricula, asignatura.getMatricula().get(0));
		asignatura.setVisibilidad(true);
	}
	
	@Test
	public void testSetVisibilidad(){
		asignatura.setVisibilidad(true);
		assertEquals(true, asignatura.getVisibile());
	}
	
	@Test
	public void testGetVisibilidad(){
		assertEquals(true, asignatura.getVisibile());
	}
	
		
	@Test
	public void testAniadirTemas(){
		Tema t1 = new Tema("Tema1", false);
		asignatura.aniadirTema(t1);
		assertEquals(t1, asignatura.getTemas().get(0));
	}
	
	@Test
	public void testGetTemas(){
		Tema t1 = new Tema("Tema1", false);
		asignatura.aniadirTema(t1);
		assertEquals(t1, asignatura.getTemas().get(0));
		asignatura.getTemas();
	}
	
	

}
