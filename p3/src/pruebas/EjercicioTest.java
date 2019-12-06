package pruebas;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

import ejercicios.Pregunta;

import org.junit.Before;

import treeAcademy.Ejercicio;

public class EjercicioTest {
	
	private static final double DELTA = 0;
	Ejercicio ej;
	Pregunta p;
	ArrayList<Pregunta> pregunta;
	
	@Before
	public void setUp() throws Exception {
		ej = new Ejercicio("Ejercicio 1:", 1.5, true, true);
		pregunta = new ArrayList<Pregunta>();
	}
	
	@Test
	public void testPregunta() {
		assertEquals("Ejercicio 1:", ej.getNombre());
		assertEquals(1.5, ej.getPonderacion(), DELTA);
		assertEquals(true, ej.getVisibilidad());
	}
	
	@Test
	public void testSetEnunciado() {
		ej.setNombre("Ejercicio 1:");
		assertEquals("Ejercicio 1:", ej.getNombre());
	}
	
	@Test
	public void testGetEnunciado() {
		assertEquals("Ejercicio 1:", ej.getNombre());
	}
	
	@Test
	public void testSetPonderacion() {
		ej.setPonderacion(1.5);
		assertEquals(1.5, ej.getPonderacion(), DELTA);
	}
	
	@Test
	public void testGetPonderacion() {
		assertEquals(1.5, ej.getPonderacion(), DELTA);
	}
	
	@Test
	public void testSetPreguntas() {
		pregunta.add(p);
		ej.setPreguntas(pregunta);
		assertEquals(pregunta, ej.getPreguntas());
	}
	
	@Test
	public void testGetRespuestas() {
		ArrayList<Pregunta> pregunta = null;
		pregunta = ej.getPreguntas();
		assertEquals(pregunta, ej.getPreguntas());
	}
	
	@Test
	public void testSetOrden() {
		ej.setOrden();
		assertEquals(true, ej.getOrden());
	}
	
	@Test
	public void testGetOrden() {
		assertEquals(true, ej.getOrden());
	}
	
}