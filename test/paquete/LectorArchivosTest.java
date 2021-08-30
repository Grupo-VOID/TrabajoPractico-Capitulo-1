package paquete;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("unused")
public class LectorArchivosTest {

	@Before
	public void inicio() {
		LectorArchivos inicio = new LectorArchivos();
		inicio.LeerGenerarUsuarios();
		inicio.LeerGenerarAtracciones();
	}

	@Test
	public void pruebaLectorUsuarios() {
	}

}
