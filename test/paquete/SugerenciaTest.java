package paquete;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SugerenciaTest {

	Usuario usuario1, usuarioRico, usuarioSinTiempo;
	Atraccion atr1, atr2, atr3, atr4, atr5;
	Promocion p1, p2;
	LinkedList<Adquirible> catalogo = new LinkedList<Adquirible>();

	@Before
	public void setUp() throws Exception {
		usuario1 = new Usuario("Mauro", TipoAtraccion.DRAMA, 120, 10);
		usuarioRico = new Usuario("Candela", TipoAtraccion.POLICIAL, 500, 50);
		usuarioSinTiempo = new Usuario("Federico", TipoAtraccion.MUSICAL, 100, 2);
		atr1 = new Atraccion("Breaking Bad", TipoAtraccion.DRAMA, 3, 6.5, 150);
		atr2 = new Atraccion("Dark", TipoAtraccion.DRAMA, 14, 2.5, 3);
		atr3 = new Atraccion("Black List", TipoAtraccion.POLICIAL, 5, 5.5, 10);
		atr4 = new Atraccion("Lupin", TipoAtraccion.POLICIAL, 4, 6, 22);
		atr5 = new Atraccion("Glee", TipoAtraccion.MUSICAL, 5, 5, 25);
		p1 = new PromocionAbsoluta(TipoAtraccion.DRAMA, atr1, atr2, 2);
		p2 = new PromocionPorcentual(TipoAtraccion.POLICIAL, atr3, atr4, 10);
		catalogo.add(atr1);
		catalogo.add(atr2);
		catalogo.add(atr3);
		catalogo.add(atr4);
		catalogo.add(atr5);
		catalogo.add(p1);
		catalogo.add(p2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void ordenaCatalogoSegunPreferencia() {
		Collections.sort(catalogo, new Sugerencia(usuario1));
		LinkedList<Adquirible> esperado = new LinkedList<Adquirible>();
		esperado.add(p1);
		esperado.add(atr2);
		esperado.add(atr1);
		esperado.add(p2);
		esperado.add(atr3);
		esperado.add(atr5);
		esperado.add(atr4);
		assertEquals(catalogo, esperado);
	}

	@Test
	public void puedeComprarTodasLasSugerencias() {
		Collections.sort(catalogo, new Sugerencia(usuarioRico));
		for (Adquirible adquirible : catalogo) {
			assertTrue(Sugerencia.validarSugerencia(usuarioRico, adquirible));
		}
	}
	
	@Test
	public void noSugierePorFaltaDeTiempoEnUsuario() {
		Collections.sort(catalogo, new Sugerencia(usuarioSinTiempo));
		for (Adquirible adquirible : catalogo) {
			assertFalse(Sugerencia.validarSugerencia(usuarioSinTiempo, adquirible));
		}
	}
}