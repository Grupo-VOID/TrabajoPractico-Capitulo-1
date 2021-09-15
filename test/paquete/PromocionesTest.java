package paquete;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PromocionesTest {

	Atraccion atraccion1;
	Atraccion atraccion2;
	Atraccion atraccionGratis;

	@Before
	public void setup() {
		atraccion1 = new Atraccion("unaAtraccion", TipoAtraccion.COMEDIA, 20.5, 2, 50);
		atraccion2 = new Atraccion("otraAtraccion", TipoAtraccion.COMEDIA, 12, 5, 40);
		atraccionGratis = new Atraccion("siguienteAtraccion", TipoAtraccion.COMEDIA, 7.5, 6, 30);
	}

	@Test
	public void costoYTiempoPromocionAbsoluta() {

		// descuento 15 monedas
		PromocionAbsoluta promocionAbsoluta = new PromocionAbsoluta(TipoAtraccion.COMEDIA, atraccion1, atraccion2, 15);

		assertEquals(promocionAbsoluta.getCosto(), atraccion1.getCosto() + atraccion2.getCosto() - 15, 0);
		assertEquals(promocionAbsoluta.getTiempo(), atraccion1.getTiempo() + atraccion2.getTiempo(), 0);

	}

	@Test
	public void DisponibilidadYCompraPromocionAbsoluta() {

		// descuento 15 monedas
		PromocionAbsoluta promocionAbsoluta = new PromocionAbsoluta(TipoAtraccion.COMEDIA, atraccion1, atraccion2, 15);

		assertTrue(promocionAbsoluta.estaDisponible());

		int i = 1;
		while (i <= 40) {
			promocionAbsoluta.comprar();
			i++;
		}

		assertFalse(promocionAbsoluta.estaDisponible());

		assertEquals(atraccion1.getCupoActual(), 40);
		assertEquals(atraccion2.getCupoActual(), 40);

	}

	@Test
	public void costoYTiempoPromocionPorcentual() {

		// descuento 20%
		PromocionPorcentual promocionPorcentual = new PromocionPorcentual(TipoAtraccion.COMEDIA, atraccion1, atraccion2,
				20);

		double costoPruebaPorcentual = atraccion1.getCosto() + atraccion2.getCosto();
		costoPruebaPorcentual = costoPruebaPorcentual * (1.00 - 20 / 100.00);

		assertEquals(promocionPorcentual.getCosto(), costoPruebaPorcentual, 0);
		assertEquals(promocionPorcentual.getTiempo(), atraccion1.getTiempo() + atraccion2.getTiempo(), 0);

	}

	@Test
	public void DisponibilidadYCompraPromocionPorcentual() {

		PromocionPorcentual promocionPorcentual = new PromocionPorcentual(TipoAtraccion.COMEDIA, atraccion1, atraccion2,
				15);

		assertTrue(promocionPorcentual.estaDisponible());

		int i = 1;
		while (i <= 40) {
			promocionPorcentual.comprar();
			i++;
		}

		assertFalse(promocionPorcentual.estaDisponible());

		assertEquals(atraccion1.getCupoActual(), 40);
		assertEquals(atraccion2.getCupoActual(), 40);

	}

	@Test
	public void costoYTiempoPromocionAxB() {

		// descuento 15 monedas
		PromocionAxB promocionAxB = new PromocionAxB(TipoAtraccion.COMEDIA, atraccion1, atraccion2, atraccionGratis);

		assertEquals(promocionAxB.getCosto(), atraccion1.getCosto() + atraccion2.getCosto(), 0);
		assertEquals(promocionAxB.getTiempo(),
				atraccion1.getTiempo() + atraccion2.getTiempo() + atraccionGratis.getTiempo(), 0);

	}

	@Test
	public void DisponibilidadYCompraPromocionAxB() {

		PromocionAxB promocionAxB = new PromocionAxB(TipoAtraccion.COMEDIA, atraccion1, atraccion2, atraccionGratis);

		assertTrue(promocionAxB.estaDisponible());

		int i = 1;
		while (i <= 30) {
			promocionAxB.comprar();
			i++;
		}

		assertFalse(promocionAxB.estaDisponible());

		assertEquals(atraccion1.getCupoActual(), 30);
		assertEquals(atraccion2.getCupoActual(), 30);
		assertEquals(atraccionGratis.getCupoActual(), 30);

	}

}
