package paquete;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {

		ParqueAtracciones parque = new ParqueAtracciones();
		parque.agregarUsuarios(LectorArchivos.GenerarUsuarios("entrada/usuarios.txt"));
		parque.agregarAtracciones(LectorArchivos.GenerarAtracciones("entrada/atracciones.txt"));
		parque.agregarPromociones(LectorArchivos.GenerarPromociones(parque,"entrada/promociones.txt"));
		parque.cargarCatalogo();

		//UI.compraSucesiva(parque); //M�todo para que cada usuario compre en orden */
		/*UI.compraPorUsuario(parque); // M�todo para elegir qu� usuario compra*/
		UI.eleccionDeMenu(parque); // M�todo para elegir modo de compra

	}
}