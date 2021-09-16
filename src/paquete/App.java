package paquete;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {

		ParqueAtracciones parque = new ParqueAtracciones();
		parque.agregarUsuarios(LectorArchivos.GenerarUsuarios("entrada/usuarios.txt"));
		parque.agregarAtracciones(LectorArchivos.GenerarAtracciones("entrada/atracciones.txt"));
		parque.agregarPromociones(LectorArchivos.GenerarPromociones(parque, "entrada/promociones.txt"));
		parque.cargarCatalogo();

		UI.eleccionDeMenu(parque); // M�todo para elegir modo de compra
	}
}