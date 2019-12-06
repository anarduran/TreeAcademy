package pruebas;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ejercicios.Pregunta;
import ejercicios.RespuestaMulti;

public class RespuestaMultiTest {

	RespuestaMulti r;
	Pregunta p;
	
	@Before
	public void setUp() throws Exception {
		r = new RespuestaMulti(p,"Cuatro");		
	}
	
	@Test
	public void testRespuesta() {
		assertEquals("Cuatro", r.getRespuesta());
	}
	
	@Test
	public void testSetRespuesta() {
		r.setRespuesta("Cuatro");
		assertEquals("Cuatro", r.getRespuesta());
	}
	
	@Test
	public void testGetRespuesta() {
		assertEquals("Cuatro", r.getRespuesta());
	}
}