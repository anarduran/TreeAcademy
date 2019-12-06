package pruebas;
import static org.junit.Assert.*;
import org.junit.*;
import treeAcademy.Apunte;

/**
 * JUnit de la clase Apunte
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class ApunteTest {
	
	Apunte apunte;
	

	/**
	 * @throws java.lang.Exception java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		apunte = new Apunte ("Apunte 1", true);
	}
	
	@Test
	public void testApunte() {
		assertEquals("Apunte 1", apunte.getNombre());
	}
	
	@Test
	public void testSetandGetContenido(){
		apunte.setContenido("Contenido del apunte 1");
		assertEquals("Contenido del apunte 1", apunte.getContenido());
	}
	
	

}
