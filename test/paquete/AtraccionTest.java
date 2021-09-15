package paquete;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AtraccionTest {

	Atraccion atraccion;

	@Before
	public void setup() {
		atraccion = new Atraccion("Barco Pirata", TipoAtraccion.COMEDIA, 20, 3.5, 20);
	}
	
	@Test
	public void seCreaCorrectamente() {
		assertNotNull(atraccion);
		assertEquals("Barco Pirata", atraccion.getNombre());
		assertEquals(TipoAtraccion.COMEDIA, atraccion.getTematica());
		assertEquals(20, atraccion.getCosto(), 0);
		assertEquals(3.5, atraccion.getTiempo(), 0.01);
		assertEquals(20, atraccion.getCupoMaximo());
		assertTrue(atraccion.estaDisponible());
	}

	@Test
	public void aumentaCupoAlComprar() {
		assertEquals(0, atraccion.getCupoActual());
		for (int i = 0; i < 10; i++) {
			atraccion.comprar();
		}
		assertEquals(10, atraccion.getCupoActual());
	}

	@Test
	public void noEstaDisponibleCuandoLlenaSuCupo() {
		assertEquals(20, atraccion.getCupoMaximo());
		assertEquals(0, atraccion.getCupoActual());
		for (int i = 0; i < 20; i++) {
			atraccion.comprar();
		}
		assertFalse(atraccion.estaDisponible());
	}

	@Test
	public void noEsPromocion() {
		assertFalse(atraccion.esPromocion());
	}
}
