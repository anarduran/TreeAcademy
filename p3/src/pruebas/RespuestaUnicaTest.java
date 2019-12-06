package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import ejercicios.Pregunta;
import ejercicios.RespuestaUnica;

import org.junit.Before;

public class RespuestaUnicaTest {

	RespuestaUnica r;
	Pregunta p;
	
	@Before
	public void setUp() throws Exception {
		r = new RespuestaUnica(p,"Cuatro");		
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