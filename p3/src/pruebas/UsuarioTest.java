package pruebas;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import usuarios.Usuario;

/**
 * JUnit de la clase Usuario
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero
 */
public class UsuarioTest {
	Usuario u;

	@Before
	public void setUp() throws Exception{
		u = new Usuario("Marta", "Martita123");
	}
	
	@Test
	public void testUsuario(){
		assertEquals("Marta", u.getNuma());
		assertEquals("Martita123", u.getContrasenia());
	}
	
	@Test
	public void testGetUsuario() {
		assertEquals("Marta", u.getNuma());
	}
	
	@Test
	public void testGetContrasenia(){
		assertEquals("Martita123", u.getContrasenia());
	}

}


