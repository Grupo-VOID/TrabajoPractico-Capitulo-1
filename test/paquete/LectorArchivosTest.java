package paquete;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class LectorArchivosTest {

	ParqueAtracciones parque = new ParqueAtracciones();
	LinkedList<Usuario> listaDeUsuarios;
	LinkedList<Adquirible> listaDeAtracciones;
	LinkedList<Adquirible> listaDePromociones;

	@Before
	public void setup() {
		listaDeUsuarios = LectorArchivos.GenerarUsuarios("entrada/usuarios.txt");
		listaDeAtracciones = LectorArchivos.GenerarAtracciones("entrada/atracciones.txt");
		parque.agregarAtracciones(listaDeAtracciones);
		parque.agregarUsuarios(listaDeUsuarios);
		listaDePromociones = LectorArchivos.GenerarPromociones(parque, "entrada/promociones.txt");
	}

	// Pruebas de lista Usuarios

	@Test
	public void seCreaListaUsuarios() {

		assertNotNull(listaDeUsuarios);
	}

	@Test
	public void comparacionDosListasIgualesUsuarios() {

		LinkedList<Usuario> listaUsuariosPrueba = LectorArchivos.GenerarUsuarios("archivosEntradaTest/Usuarios.txt");

		for (int i = 0; i < listaDeUsuarios.size(); i++) {
			Usuario usuario1 = listaDeUsuarios.get(i);
			Usuario usuario2 = listaUsuariosPrueba.get(i);
			assertEquals(usuario1.getNombre(), usuario2.getNombre());
			assertEquals(usuario1.getMonedasIniciales(), usuario2.getMonedasIniciales(), 0);
			assertEquals(usuario1.getTiempoInicial(), usuario2.getTiempoInicial(), 0);
			assertEquals(usuario1.getTematica(), usuario2.getTematica());
		}
	}

	// Pruebas de lista Atracciones

	@Test
	public void seCreaListaAtracciones() {

		assertNotNull(listaDeAtracciones);
	}

	@Test
	public void comparacionDosListasIgualesAtracciones() {

		LinkedList<Adquirible> listaAtraccionesPrueba = LectorArchivos
				.GenerarAtracciones("archivosEntradaTest/Atracciones.txt");

		for (int i = 0; i < listaDeUsuarios.size(); i++) {
			Adquirible atraccion1 = listaDeAtracciones.get(i);
			Adquirible atraccion2 = listaAtraccionesPrueba.get(i);
			assertEquals(atraccion1.getNombre(), atraccion2.getNombre());
			assertEquals(atraccion1.getTematica(), atraccion2.getTematica());
			assertEquals(atraccion1.getCosto(), atraccion2.getCosto(), 0);
			assertEquals(atraccion1.getTiempo(), atraccion2.getTiempo(), 0);
		}
	}

	// Pruebas de lista Promociones

	@Test
	public void seCreaListaPromociones() {

		assertNotNull(listaDePromociones);
	}

	@Test
	public void comparacionDosListasIgualesPromociones() {

		ParqueAtracciones parquePrueba = new ParqueAtracciones();
		parquePrueba.agregarAtracciones(listaDeAtracciones);
		LinkedList<Adquirible> listaPromocionesPrueba = LectorArchivos.GenerarPromociones(parquePrueba,
				"archivosEntradaTest/Promociones.txt");

		for (int i = 0; i < listaDePromociones.size(); i++) {
			Adquirible promo1 = listaDePromociones.get(i);
			Adquirible promo2 = listaPromocionesPrueba.get(i);
			assertEquals(promo1.getNombre(), promo2.getNombre());
			assertEquals(promo1.getTematica(), promo2.getTematica());
			assertEquals(promo1.getCosto(), promo2.getCosto(), 0);
			assertEquals(promo1.getTiempo(), promo2.getTiempo(), 0);

		}
	}
}
