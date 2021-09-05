package paquete;

public class app {

	public static void main(String[] args) {

		ParqueAtracciones parque = new ParqueAtracciones();
		parque.agregarUsuarios(LectorArchivos.GenerarUsuarios());
		parque.agregarAtracciones(LectorArchivos.GenerarAtracciones());
		parque.agregarPromociones(LectorArchivos.GenerarPromociones(parque));

		// ______________________________________________________________________________________
		// ESTE BLOQUE SE BORRA, ES SOLO PARA QUE PUEDAN VER Q FUNCIONA Y CREA LAS
		// ATRACCIONES,
		// LOS USUARIOS Y LAS PROMOCIONES.

		for (int i = 0; i < parque.getUsuarios().size(); i++) {
			System.out.print(parque.getUsuarios().get(i).getNombre() + " ");
			System.out.print(parque.getUsuarios().get(i).getTematica() + " ");
			System.out.print(parque.getUsuarios().get(i).getMonedasDisponibles() + " ");
			System.out.println(parque.getUsuarios().get(i).getTiempoDisponible());
		}

		System.out.println(" ");

		for (int i = 0; i < parque.getAtracciones().size(); i++) {
			System.out.print(parque.getAtracciones().get(i).toString() + " ");
			System.out.print(parque.getAtracciones().get(i).getCosto() + " ");
			System.out.print(parque.getAtracciones().get(i).getTiempo() + " ");
			System.out.print(parque.getAtracciones().get(i).getCUPO_MAXIMO() + " ");
			System.out.println(parque.getAtracciones().get(i).getTematica());
		}

		System.out.println(" ");

		for (int i = 0; i < parque.getPromociones().size(); i++) {
			System.out.print(parque.getPromociones().get(i).toString() + " ");
			System.out.print(parque.getPromociones().get(i).getTematica() + " ");
			System.out.print(parque.getPromociones().get(i).getCosto() + " ");
			System.out.println(parque.getPromociones().get(i).getTiempo());

		}
		
		parque.cargarCatalogo();
		
		System.out.println(" ");
		
		parque.mostrarCatalogo();
	}
	// _____________________________________________________________________________________
	// _____________________________________________________________________________________

}
