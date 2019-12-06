package pruebas;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import treeAcademy.Apunte;
import treeAcademy.ItemAsig;
import treeAcademy.Tema;

/**
 * JUnit de la clase Tema
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class TemaTest {

	Tema t;
	
	@Before
	public void setUp() throws Exception{
		t = new Tema("Tema 1", true);
		t.setVisibilidad(true);
		t.setNombre("Tema 1");
	}
	
	@Test
	public void testTema() {
		assertEquals("Tema 1", t.getNombre());
		assertEquals(true, t.getVisibilidad());
	}
	
	@Test
	public void testAniadirItems(){
		Apunte apunte = new Apunte ("Apunte1", true);
		t.aniadirItem(apunte);
		assertEquals(apunte, t.getItems().get(0));
	}
	
	@Test
	public void testEliminarItems(){
		Apunte apunte = new Apunte ("Apunte1", true);
		t.aniadirItem(apunte);
		assertEquals(apunte, t.getItems().get(0));
		t.eliminarItem(apunte);
		equals(t.getItems().size(), t.getItems());
		
	}

	private void equals(int size, ArrayList<ItemAsig> items) {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	public void testSetVisbilidad(){
		t.setVisibilidad(true);
		assertEquals(true, t.getVisibilidad());
	}
	
	@Test
	public void testGetVisibilidad(){
		assertEquals(true, t.getVisibilidad());
	}
	
	@Test
	public void testSetNombre(){
		t.setNombre("Tema 1");
		assertEquals("Tema 1", t.getNombre());
	}
	
	@Test
	public void testGetNombre(){
		assertEquals("Tema 1", t.getNombre());
	}

}
