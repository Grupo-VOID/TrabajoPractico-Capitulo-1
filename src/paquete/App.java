package paquete;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {

		ParqueAtracciones parque = new ParqueAtracciones();
		parque.agregarUsuarios(LectorArchivos.GenerarUsuarios());
		parque.agregarAtracciones(LectorArchivos.GenerarAtracciones());
		parque.agregarPromociones(LectorArchivos.GenerarPromociones(parque));
		parque.cargarCatalogo();

		/* UI.compraSucesiva(parque); //M�todo para que cada usuario compre en orden */
		UI.compraPorUsuario(parque); // M�todo para elegir qu� usuario compra*/

		// Este for imprimir s�lo se usa con el UI.compraSucesiva
		for (Usuario i : parque.getUsuarios()) {
			Impresora.imprimir(i);
		}
	}
}