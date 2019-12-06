package pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ejercicios.PreguntaVF;

import org.junit.Before;

public class PreguntaVFTest {

	private static final double DELTA = 0;
	PreguntaVF p;
	ArrayList<String> opciones;
	String o;
	
	@Before
	public void setUp() throws Exception {
		p = new PreguntaVF(2.0, "Pregunta 1: (2+2)/4", 0.5);
		opciones = new ArrayList<String>();
	}
	
	@Test
	public void testPregunta() {
		assertEquals(2.0, p.getNota(), DELTA);
		assertEquals("Pregunta 1: (2+2)/4", p.getEnunciado());
		assertEquals(0.5, p.getPenalizacion(), DELTA);
	}
	
	@Test
	public void testSetNota() {
		p.setNota(2.0);
		assertEquals(2.0, p.getNota(), DELTA);
	}
	
	@Test
	public void testGetNota() {
		assertEquals(2.0, p.getNota(), DELTA);
	}
	
	@Test
	public void testSetEnunciado() {
		p.setEnunciado("Pregunta 1: (2+2)/4");
		assertEquals("Pregunta 1: (2+2)/4", p.getEnunciado());
	}
	
	@Test
	public void testGetEnunciado() {
		assertEquals("Pregunta 1: (2+2)/4", p.getEnunciado());
	}
	
	@Test
	public void testSetPenalizacion() {
		p.setPenalizacion(0.5);
		assertEquals(0.5, p.getPenalizacion(), DELTA);
	}
	
	@Test
	public void testGetPenalizacion() {
		assertEquals(0.5, p.getPenalizacion(), DELTA);
	}
	
	@Test
	public void testSetOpciones() {
		opciones.add(o);
		p.setOpciones(opciones);
		assertEquals(opciones, p.getOpciones());
	}
	
	@Test
	public void testGetRespuestas() {
		ArrayList<String> opciones = null;
		opciones = p.getOpciones();
		assertEquals(opciones, p.getOpciones());
	}
	
	
	@Test
	public void testAniadirOpciones() {
		p.aniadirOpciones(o);
		
	}
	
	@Test
	public void testSetNumrespuestas() {
		p.setNumrespuestas(4);
		assertEquals(4, p.getNumrespuestas());
	}
	
	@Test
	public void testSetNumrespuestasCorrectas() {
		p.setNumrespuestas(4);
		assertEquals(4, p.getNumrespuestas());
	}
}