package paquete;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AtraccionesTest {

	Atraccion atraccion;

	@Before
	public void setup() {
		atraccion = new Atraccion("Barco Pirata", TipoAtraccion.COMEDIA , 20, 3.5, 20);
	}

	@Test
	public void sePuedeCrear() {
		assertNotNull(atraccion);
	}

	@Test
	public void seAcumulanUsuariosEnCupo() {
		for (int i = 0; i < 10; i++) {
			atraccion.comprar();
		}
		assertEquals(10, atraccion.getCupoActual());
	}

	@Test
	public void hayLugarDisponible() {
		for (int i = 0; i < 19; i++) {
			atraccion.comprar();
		}
		assertTrue(atraccion.estaDisponible());

		atraccion.comprar();
		assertFalse(atraccion.estaDisponible());
	}
	
	@Test
	public void devuelveTipoAtraccion() {
		assertEquals(TipoAtraccion.COMEDIA, atraccion.getTematica());
	}
}
