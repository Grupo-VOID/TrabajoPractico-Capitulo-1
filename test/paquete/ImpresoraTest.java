package paquete;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class ImpresoraTest {

	@Test
	public void archivoSalidaCompraTest() throws IOException {
		Atraccion atraccion1 = new Atraccion("Modern Family", TipoAtraccion.COMEDIA, 20.5, 2, 50);
		Atraccion atraccion2 = new Atraccion("The Office", TipoAtraccion.COMEDIA, 12, 5, 40);
		Atraccion atraccion3 = new Atraccion("El Marginal", TipoAtraccion.ARGENTINA, 7.5, 6, 30);
		Atraccion atraccion4 = new Atraccion("Breaking Bad", TipoAtraccion.DRAMA, 7.5, 6, 30);

		Promocion promocionAbsoluta = new PromocionAbsoluta(TipoAtraccion.COMEDIA, atraccion1, atraccion2, 10);

		Usuario usuario1 = new Usuario("Juan Perez", TipoAtraccion.COMEDIA, 50, 25);

		if (Sugerencia.validarSugerencia(usuario1, promocionAbsoluta))
			usuario1.aceptarSugerencia(promocionAbsoluta);

		if (Sugerencia.validarSugerencia(usuario1, atraccion1))
			usuario1.aceptarSugerencia(atraccion1);

		if (Sugerencia.validarSugerencia(usuario1, atraccion2))
			usuario1.aceptarSugerencia(atraccion2);

		if (Sugerencia.validarSugerencia(usuario1, atraccion3))
			usuario1.aceptarSugerencia(atraccion3);

		if (Sugerencia.validarSugerencia(usuario1, atraccion4))
			usuario1.aceptarSugerencia(atraccion4);

		Impresora.imprimir(usuario1, "archivosSalidaTest");

		List<String> file1 = Files.readAllLines(Paths.get("archivosSalidaTest/salidaJuan Perez.txt"));
		List<String> file2 = Files.readAllLines(Paths.get("archivosSalidaTest/salidaJuan Perez Test.txt"));

		assertEquals(file1.size(), file2.size());

		for (int i = 0; i < file1.size(); i++) {
			System.out.println("Comparing line: " + i);
			assertEquals(file1.get(i), file2.get(i));
		}
	}

	@Test
	public void archivoSalidaNoCompraTest() throws IOException {
		Atraccion atraccion1 = new Atraccion("Modern Family", TipoAtraccion.COMEDIA, 20.5, 2, 50);
		Atraccion atraccion2 = new Atraccion("The Office", TipoAtraccion.COMEDIA, 12, 5, 40);
		Atraccion atraccion3 = new Atraccion("El Marginal", TipoAtraccion.ARGENTINA, 7.5, 6, 30);
		Atraccion atraccion4 = new Atraccion("Breaking Bad", TipoAtraccion.DRAMA, 7.5, 6, 30);

		Promocion promocionAbsoluta = new PromocionAbsoluta(TipoAtraccion.COMEDIA, atraccion1, atraccion2, 10);

		Usuario usuario1 = new Usuario("Pedro Marmol", TipoAtraccion.COMEDIA, 5, 25);

		if (Sugerencia.validarSugerencia(usuario1, promocionAbsoluta))
			usuario1.aceptarSugerencia(promocionAbsoluta);

		if (Sugerencia.validarSugerencia(usuario1, atraccion1))
			usuario1.aceptarSugerencia(atraccion1);

		if (Sugerencia.validarSugerencia(usuario1, atraccion2))
			usuario1.aceptarSugerencia(atraccion2);

		if (Sugerencia.validarSugerencia(usuario1, atraccion3))
			usuario1.aceptarSugerencia(atraccion3);

		if (Sugerencia.validarSugerencia(usuario1, atraccion4))
			usuario1.aceptarSugerencia(atraccion4);

		Impresora.imprimir(usuario1, "archivosSalidaTest");

		List<String> file1 = Files.readAllLines(Paths.get("archivosSalidaTest/salidaPedro Marmol.txt"));
		List<String> file2 = Files.readAllLines(Paths.get("archivosSalidaTest/salidaPedro Marmol Test.txt"));

		assertEquals(file1.size(), file2.size());

		for (int i = 0; i < file1.size(); i++) {
			System.out.println("Comparing line: " + i);
			assertEquals(file1.get(i), file2.get(i));
		}
	}
}
