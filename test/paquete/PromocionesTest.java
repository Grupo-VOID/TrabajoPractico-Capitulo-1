package paquete;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PromocionesTest {

	ParqueAtracciones parque;

	@Before
	public void setup() {
		parque = new ParqueAtracciones();
		parque.agregarUsuarios(LectorArchivos.GenerarUsuarios());
		parque.agregarAtracciones(LectorArchivos.GenerarAtracciones());
		parque.agregarPromociones(LectorArchivos.GenerarPromociones(parque));
	}

	@Test
	public void costoDeLasPromociones() {

		//Procentual
		
		double costoPromoPorcentual = parque.getPromociones().get(0).getCosto();
		double costoPruebaPorcentual = parque.getAtracciones().get(9).getCosto() + parque.getAtracciones().get(10).getCosto();
		costoPruebaPorcentual = costoPruebaPorcentual * (1.00 - 20 / 100.00);

		assertEquals(costoPromoPorcentual, costoPruebaPorcentual, 0);
		
		//AxB
		
		double costoPromoAxB = parque.getPromociones().get(2).getCosto();
		double costoPruebaAxB = parque.getAtracciones().get(8).getCosto() + parque.getAtracciones().get(2).getCosto();

		assertEquals(costoPromoAxB, costoPruebaAxB, 0);
		
	}

}
