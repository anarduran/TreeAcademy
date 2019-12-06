package pruebas;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import treeAcademy.Asignatura;
import usuarios.Estudiante;
import usuarios.Matricula;
import usuarios.Profesor;

/**
 * JUnit de la clase Profesor
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class ProfesorTest {
	
	Profesor p;
	Estudiante e;
	Asignatura a;
	Matricula m;
	
	
	@Before
	public void setUp() throws Exception {
		p = new Profesor ("prof", "prof");
		e = new Estudiante ("2592", "Mor", "Rosa", "Moreno", "Rosa.Moreno@esdu.es");
		a = new Asignatura ("Algebra");
		m = new Matricula(e, a);	
		p.setIniciado(true); 
	}

	@Test
	public void testProfesor() {
		assertEquals("prof", p.getNuma());
		assertEquals("prof", p.getContrasenia());
	}
	
	@Test
	public void testSetInciado() {
		p.setIniciado(true);
		assertEquals(true, p.getIniciado());
	}

	@Test
	public void testGetInciado() {
		assertEquals(true, p.getIniciado());
	}

	@Test
	public void testAceptarSolicitud() {
		Matricula m1 = new Matricula(e, a);
		m.setAceptada(true);
		assertEquals(true, m.getAceptada());
		m.getAsignaturas().aniadirMatricula(m1);
		m.getEstudiante().aniadirMatricula(m1);
	}
	

	@Test
	public void testRechazarSolicitud() {
		m.setAceptada(false);
		assertEquals(false, m.getAceptada());

	}
	
	@Test
	public void testExpulsarEstudiante(){
		m.setBloqueada(true);
		assertEquals(true, m.getBloqueada());
		e.setBloqueado(true);
		assertEquals(true, e.getBloqueado());
		e.getMatriculas().remove(m);
		equals(e.getMatriculas().size(), e.getMatriculas());
	}
	
	private void equals(int size, ArrayList<Matricula> matriculas) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testReadmitirEstudiante(){
		m.setBloqueada(false);
		assertEquals(false, m.getBloqueada());
		e.setBloqueado(false);
		assertEquals(false, e.getBloqueado());
		e.getMatriculas().add(m);
		assertEquals(m, e.getMatriculas().get(0));
	}

}
