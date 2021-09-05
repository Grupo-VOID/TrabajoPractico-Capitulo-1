package paquete;

import java.util.Collections;
import java.util.Scanner;


public class app {

public static void main(String[] args) {

	ParqueAtracciones parque = new ParqueAtracciones();
	parque.agregarUsuarios(LectorArchivos.GenerarUsuarios());
	parque.agregarAtracciones(LectorArchivos.GenerarAtracciones());
	parque.agregarPromociones(LectorArchivos.GenerarPromociones(parque));
	parque.cargarCatalogo();
	
	System.out.println("::Bienvenido al Parque VOID\n"
			+ "::Para obtener sugerencias seleccionar un usario:");
	
	for (int i = 0; i < parque.getUsuarios().size(); i++) {
		System.out.print(i + ". " + parque.getUsuarios().get(i).getNombre() + "\n");
	}
	
	// Scanner que recibe imput del usuario
	Scanner sc = new Scanner(System.in);
    int idUsuario = Integer.valueOf(sc.nextLine());
	
	if (idUsuario < parque.getUsuarios().size()) {
		Usuario usuarioTemp = parque.getUsuarios().get(idUsuario);
		System.out.println("Sugerencias para: " + usuarioTemp.getNombre() + "\n");
		
		// muestra el catalogo ordenado originalmente
		System.out.println("Catalogo original:\n");
		parque.mostrarCatalogo();

		/*
		 * Acá se debería llamar a la sugerencia según
		 * el usuarioTemp que se le pase, para que 
		 * ordene/filtre el array "catalogo"
		 * */
		
		Collections.sort(parque.getCatalogo(), new Sugerencia(usuarioTemp));
		
		System.out.println("\n" + "Ordenado:\n" + parque.getCatalogo());
		
	} else {
		System.out.println("Seleccionar una opción válida.");
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
 
/**
 Crear scanner
 variable usuario
 getUsuario con entrada por consola
 ofrecer sugerencias
 aceptar sugerencia por consola
 */

/*Sugerencia s1 = new Sugerencia(parque.getUsuarios().get(0));
System.out.println(s1.getAtraccion());
for (int i = 0; i < parque.generarCatalogo().size(); i++) {
}*/
	
