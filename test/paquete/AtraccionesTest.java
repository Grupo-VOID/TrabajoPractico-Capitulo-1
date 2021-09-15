package paquete;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AtraccionesTest {

	Atraccion atraccion;

	@Before
	public void setup() {
		atraccion = new Atraccion("Barco Pirata", TipoAtraccion.COMEDIA, 20, 3.5, 20);
	}

	@Test
	public void sePuedeCrear() {
		assertNotNull(atraccion);
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
	public void cupoMaximo() {
		assertEquals(20, atraccion.getCupoMaximo());
	}

	@Test
	public void hayLugarDisponible() {
		int lugaresDisponibles = atraccion.getCupoMaximo();
		for (int i = 0; i < lugaresDisponibles - 1; i++) {
			atraccion.comprar();
		}
		assertTrue(atraccion.estaDisponible());
	}

	@Test
	public void noHayLugarDisponible() {
		int lugaresDisponibles = atraccion.getCupoMaximo();
		for (int i = 0; i < lugaresDisponibles; i++) {
			atraccion.comprar();
		}
		assertFalse(atraccion.estaDisponible());
	}

	@Test
	public void devuelveTipoAtraccion() {
		assertEquals(TipoAtraccion.COMEDIA, atraccion.getTematica());
	}

	@Test
	public void noEsPromocion() {
		assertFalse(atraccion.esPromocion());
	}

	@Test
	public void devuelveCosto() {
		assertEquals(20, atraccion.getCosto(), 0);
	}

	@Test
	public void devuelveDuracion() {
		assertEquals(3.5, atraccion.getTiempo(), 0);
	}

	@Test
	public void devuelveNombre() {
		assertEquals("Barco Pirata", atraccion.getNombre());
	}
	
	@Test
	public void atraccionesIncluidasTest() {
		Atraccion[] atraccionEsperada = {atraccion};
		assertArrayEquals(atraccionEsperada, atraccion.atraccionesIncluidas());
	}
}
