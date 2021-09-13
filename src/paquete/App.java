package paquete;

import java.io.IOException;

public class App {
	

	public static void main(String[] args) throws IOException {
		
		ParqueAtracciones parque = new ParqueAtracciones();
		parque.agregarUsuarios(LectorArchivos.GenerarUsuarios());
		parque.agregarAtracciones(LectorArchivos.GenerarAtracciones());
		parque.agregarPromociones(LectorArchivos.GenerarPromociones(parque));
		parque.cargarCatalogo();

		UI.compraSucesiva(parque); //Método para que cada usuario compre en orden*/
		//UI.compraPorUsuario(parque); //Método para elegir qué usuario compra
		
		// Este for imprimir sólo se usa con el UI.compraSucesiva
		for (Usuario i : parque.getUsuarios()) {
			Impresora.imprimir(i);
		}
}
// ______________________________________________________________________________________
//	 ESTE BLOQUE SE BORRA, ES SOLO PARA QUE PUEDAN VER Q FUNCIONA Y CREA LAS
//	 ATRACCIONES,
//	 LOS USUARIOS Y LAS PROMOCIONES.
//	
//		for (int i = 0; i < parque.getUsuarios().size(); i++) {
//			System.out.print(parque.getUsuarios().get(i).getNombre() + " ");
//			System.out.print(parque.getUsuarios().get(i).getTematica() + " ");
//			System.out.print(parque.getUsuarios().get(i).getMonedasDisponibles() + " ");
//			System.out.println(parque.getUsuarios().get(i).getTiempoDisponible());
//		}
//	
//		System.out.println(" ");
//	
//		for (int i = 0; i < parque.getAtracciones().size(); i++) {
//			System.out.print(parque.getAtracciones().get(i).toString() + " ");
//			System.out.print(parque.getAtracciones().get(i).getCosto() + " ");
//			System.out.print(parque.getAtracciones().get(i).getTiempo() + " ");
//			//System.out.print(parque.getAtracciones().get(i).getCUPO_MAXIMO() + " ");
//			System.out.println(parque.getAtracciones().get(i).getTematica());
//		}
//	
//		System.out.println(" ");
//	
//		for (int i = 0; i < parque.getPromociones().size(); i++) {
//			System.out.print(parque.getPromociones().get(i).toString() + " ");
//			System.out.print(parque.getPromociones().get(i).getTematica() + " ");
//			System.out.print(parque.getPromociones().get(i).getCosto() + " ");
//			System.out.println(parque.getPromociones().get(i).getTiempo());
//	
//		}		
//	
//		System.out.println(" ");
//		
//		parque.mostrarCatalogo();
}