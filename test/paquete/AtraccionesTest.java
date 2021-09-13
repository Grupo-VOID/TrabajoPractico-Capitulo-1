package paquete;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AtraccionesTest {

	Atraccion barco;

	@Before
	public void setup() {
		barco = new Atraccion("Barco Pirata", TipoAtraccion.COMEDIA , 20, 3.5, 20);
	}

	@Test
	public void sePuedeCrear() {
		assertNotNull(barco);
	}

	@Test
	public void seAcumulanUsuariosEnCupo() {
		for (int i = 0; i < 10; i++) {
			barco.comprar();
		}
		assertEquals(10, barco.getCupoActual());
	}

	@Test
	public void hayLugarDisponible() {
		for (int i = 0; i < 19; i++) {
			barco.comprar();
		}
		assertTrue(barco.estaDisponible());

		barco.comprar();
		assertFalse(barco.estaDisponible());
	}
	
	@Test
	public void devuelveTipoAtraccion() {
		assertEquals("AVENTURA", barco.getTematica());
	}
}
