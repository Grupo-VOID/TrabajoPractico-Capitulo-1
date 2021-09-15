package paquete;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PromocionTest {

	Atraccion atraccion1;
	Atraccion atraccion2;
	Atraccion atraccionGratis;

	Promocion promocionAbsoluta;
	double descuento;

	Promocion promocionPorcentual;
	double porcentajeDescuento;

	Promocion promocionAxB;

	@Before
	public void setup() {
		atraccion1 = new Atraccion("unaAtraccion", TipoAtraccion.COMEDIA, 20.5, 2, 50);
		atraccion2 = new Atraccion("otraAtraccion", TipoAtraccion.COMEDIA, 12, 5, 40);
		atraccionGratis = new Atraccion("siguienteAtraccion", TipoAtraccion.COMEDIA, 7.5, 6, 30);

		descuento = 15;
		promocionAbsoluta = new PromocionAbsoluta(TipoAtraccion.COMEDIA, atraccion1, atraccion2, descuento);

		porcentajeDescuento = 20;
		promocionPorcentual = new PromocionPorcentual(TipoAtraccion.COMEDIA, atraccion1, atraccion2,
				porcentajeDescuento);

		promocionAxB = new PromocionAxB(TipoAtraccion.COMEDIA, atraccion1, atraccion2, atraccionGratis);
	}

//////////////// PROMOCION ABSOLUTA///////////////////////

	@Test
	public void crearPromocionAbsolutaTest() {
		assertNotNull(promocionAbsoluta);
	}

	@Test
	public void costoPromocionAbsoluta() {
		assertEquals(promocionAbsoluta.getCosto(), atraccion1.getCosto() + atraccion2.getCosto() - descuento, 0);
	}

	@Test
	public void tiempoPromocionAbsoluta() {
		assertEquals(promocionAbsoluta.getTiempo(), atraccion1.getTiempo() + atraccion2.getTiempo(), 0);
	}

	@Test
	public void atraccionesIncluidasPromocionAbsolutaTest() {
		Atraccion[] atraccionesEsperadas = { atraccion1, atraccion2 };
		assertArrayEquals(atraccionesEsperadas, promocionAbsoluta.atraccionesIncluidas());
	}

	@Test
	public void disponibilidadPromocionAbsoluta() {
		assertEquals(atraccion1.getCupoActual(), 0);
		assertEquals(atraccion2.getCupoActual(), 0);
		assertTrue(promocionAbsoluta.estaDisponible());

		int lugaresDisponibles1 = atraccion1.getCupoMaximo();
		int lugaresDisponibles2 = atraccion2.getCupoMaximo();

		int lugaresDisponiblesPromocion = Math.min(lugaresDisponibles1, lugaresDisponibles2);

		int i = 1;
		while (i <= lugaresDisponiblesPromocion - 1) {
			promocionAbsoluta.comprar();
			i++;
		}

		assertTrue(promocionAbsoluta.estaDisponible());

		assertEquals(atraccion1.getCupoActual(), lugaresDisponiblesPromocion - 1);
		assertEquals(atraccion2.getCupoActual(), lugaresDisponiblesPromocion - 1);
	}

	@Test
	public void noDisponibilidadPromocionAbsoluta() {
		assertEquals(atraccion1.getCupoActual(), 0);
		assertEquals(atraccion2.getCupoActual(), 0);
		assertTrue(promocionAbsoluta.estaDisponible());

		int lugaresDisponibles1 = atraccion1.getCupoMaximo();
		int lugaresDisponibles2 = atraccion2.getCupoMaximo();

		int lugaresDisponiblesPromocion = Math.min(lugaresDisponibles1, lugaresDisponibles2);

		int i = 1;
		while (i <= lugaresDisponiblesPromocion) {
			promocionAbsoluta.comprar();
			i++;
		}

		assertFalse(promocionAbsoluta.estaDisponible());

		assertEquals(atraccion1.getCupoActual(), lugaresDisponiblesPromocion);
		assertEquals(atraccion2.getCupoActual(), lugaresDisponiblesPromocion);
	}

	@Test
	public void esPromocionPromocionAbsoluta() {
		assertTrue(promocionAbsoluta.esPromocion());
	}

	@Test
	public void nombrePromocionAbsolutaTest() {
		assertEquals("Pack COMEDIA", promocionAbsoluta.getNombre());
	}

////////////////PROMOCION PORCENTUAL///////////////////////

	@Test
	public void crearPromocionPorcentualTest() {
		assertNotNull(promocionPorcentual);
	}

	@Test
	public void costoPromocionPorcentual() {
		double costoSinDescuento = atraccion1.getCosto() + atraccion2.getCosto();
		double descuentoPorcentual = costoSinDescuento * porcentajeDescuento / 100.00;

		assertEquals(promocionPorcentual.getCosto(), costoSinDescuento - descuentoPorcentual, 0);
	}

	@Test
	public void tiempoPromocionPorcentual() {
		assertEquals(promocionPorcentual.getTiempo(), atraccion1.getTiempo() + atraccion2.getTiempo(), 0);
	}

	@Test
	public void atraccionesIncluidasPromocionPorcentualTest() {
		Atraccion[] atraccionesEsperadas = { atraccion1, atraccion2 };
		assertArrayEquals(atraccionesEsperadas, promocionPorcentual.atraccionesIncluidas());
	}

	@Test
	public void disponibilidadPromocionPorcentual() {
		assertEquals(atraccion1.getCupoActual(), 0);
		assertEquals(atraccion2.getCupoActual(), 0);
		assertTrue(promocionPorcentual.estaDisponible());

		int lugaresDisponibles1 = atraccion1.getCupoMaximo();
		int lugaresDisponibles2 = atraccion2.getCupoMaximo();

		int lugaresDisponiblesPromocion = Math.min(lugaresDisponibles1, lugaresDisponibles2);

		int i = 1;
		while (i <= lugaresDisponiblesPromocion - 1) {
			promocionPorcentual.comprar();
			i++;
		}

		assertTrue(promocionPorcentual.estaDisponible());

		assertEquals(atraccion1.getCupoActual(), lugaresDisponiblesPromocion - 1);
		assertEquals(atraccion2.getCupoActual(), lugaresDisponiblesPromocion - 1);
	}

	@Test
	public void noDisponibilidadPromocionPorcentual() {
		assertEquals(atraccion1.getCupoActual(), 0);
		assertEquals(atraccion2.getCupoActual(), 0);
		assertTrue(promocionPorcentual.estaDisponible());

		int lugaresDisponibles1 = atraccion1.getCupoMaximo();
		int lugaresDisponibles2 = atraccion2.getCupoMaximo();

		int lugaresDisponiblesPromocion = Math.min(lugaresDisponibles1, lugaresDisponibles2);

		int i = 1;
		while (i <= lugaresDisponiblesPromocion) {
			promocionPorcentual.comprar();
			i++;
		}

		assertFalse(promocionPorcentual.estaDisponible());

		assertEquals(atraccion1.getCupoActual(), lugaresDisponiblesPromocion);
		assertEquals(atraccion2.getCupoActual(), lugaresDisponiblesPromocion);
	}

	@Test
	public void esPromocionPromocionPorcentual() {
		assertTrue(promocionPorcentual.esPromocion());
	}

	@Test
	public void nombrePromocionPorcentualTest() {
		assertEquals("Pack COMEDIA", promocionPorcentual.getNombre());
	}

////////////////PROMOCION AXB ///////////////////////

	@Test
	public void crearPromocionAxBTest() {
		assertNotNull(promocionAxB);
	}

	@Test
	public void costoPromocionAxB() {
		assertEquals(promocionAxB.getCosto(), atraccion1.getCosto() + atraccion2.getCosto(), 0);
	}

	@Test
	public void tiempoPromocionAxB() {
		assertEquals(promocionAxB.getTiempo(),
				atraccion1.getTiempo() + atraccion2.getTiempo() + atraccionGratis.getTiempo(), 0);
	}

	@Test
	public void atraccionesIncluidasPromocionAxBTest() {
		Atraccion[] atraccionesEsperadas = { atraccion1, atraccion2, atraccionGratis };
		assertArrayEquals(atraccionesEsperadas, promocionAxB.atraccionesIncluidas());
	}

	@Test
	public void disponibilidadPromocionAxB() {
		assertEquals(atraccion1.getCupoActual(), 0);
		assertEquals(atraccion2.getCupoActual(), 0);
		assertEquals(atraccionGratis.getCupoActual(), 0);
		assertTrue(promocionAxB.estaDisponible());

		int lugaresDisponibles1 = atraccion1.getCupoMaximo();
		int lugaresDisponibles2 = atraccion2.getCupoMaximo();
		int lugaresDisponibles3 = atraccionGratis.getCupoMaximo();

		int lugaresDisponiblesPromocion = Math.min(lugaresDisponibles1, lugaresDisponibles2);
		lugaresDisponiblesPromocion = Math.min(lugaresDisponibles3, lugaresDisponiblesPromocion);

		int i = 1;
		while (i <= lugaresDisponiblesPromocion - 1) {
			promocionAxB.comprar();
			i++;
		}

		assertTrue(promocionAxB.estaDisponible());

		assertEquals(atraccion1.getCupoActual(), lugaresDisponiblesPromocion - 1);
		assertEquals(atraccion2.getCupoActual(), lugaresDisponiblesPromocion - 1);
		assertEquals(atraccionGratis.getCupoActual(), lugaresDisponiblesPromocion - 1);
	}

	@Test
	public void noDisponibilidadPromocionAxB() {
		assertEquals(atraccion1.getCupoActual(), 0);
		assertEquals(atraccion2.getCupoActual(), 0);
		assertEquals(atraccionGratis.getCupoActual(), 0);
		assertTrue(promocionAxB.estaDisponible());

		int lugaresDisponibles1 = atraccion1.getCupoMaximo();
		int lugaresDisponibles2 = atraccion2.getCupoMaximo();
		int lugaresDisponibles3 = atraccionGratis.getCupoMaximo();

		int lugaresDisponiblesPromocion = Math.min(lugaresDisponibles1, lugaresDisponibles2);
		lugaresDisponiblesPromocion = Math.min(lugaresDisponibles3, lugaresDisponiblesPromocion);

		int i = 1;
		while (i <= lugaresDisponiblesPromocion) {
			promocionAxB.comprar();
			i++;
		}

		assertFalse(promocionAxB.estaDisponible());

		assertEquals(atraccion1.getCupoActual(), lugaresDisponiblesPromocion);
		assertEquals(atraccion2.getCupoActual(), lugaresDisponiblesPromocion);
		assertEquals(atraccionGratis.getCupoActual(), lugaresDisponiblesPromocion);
	}

	@Test
	public void esPromocionPromocionAxB() {
		assertTrue(promocionAxB.esPromocion());
	}

	@Test
	public void nombrePromocionAxBTest() {
		assertEquals("Pack COMEDIA", promocionAxB.getNombre());
	}

}
