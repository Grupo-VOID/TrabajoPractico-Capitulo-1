package paquete;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class App {
	

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Impresora imp = new Impresora();
		ParqueAtracciones parque = new ParqueAtracciones();
		parque.agregarUsuarios(LectorArchivos.GenerarUsuarios());
		parque.agregarAtracciones(LectorArchivos.GenerarAtracciones());
		parque.agregarPromociones(LectorArchivos.GenerarPromociones(parque));
		parque.cargarCatalogo();

		parque.sistemaCompras(); //Metodo para que cada usuario compre en orden
		
		for (Usuario i : parque.getUsuarios()) {
			imp.imprimir(i);
		}
		
		/*int idUsuario=0; //Metodo para elegir que usuario compra
					
		try {
			do {
				System.out.println("::Sistema de compra\n" 
						+ "::Para obtener sugerencias seleccionar un usuario:");
				parque.mostrarUsuarios();
				idUsuario = Integer.valueOf(sc.nextLine());
				idUsuario --;
				if (idUsuario < parque.getUsuarios().size()) {
					espaciar();
					Usuario usuarioTemp = parque.getUsuarios().get(idUsuario);
					System.out.println("Sugerencias para: " + usuarioTemp.getNombre() 
							+ "\nTematica favorita: " + usuarioTemp.getTematica() + "\n");

					Collections.sort(parque.getCatalogo(), new Sugerencia(usuarioTemp));
					//parque.mostrarCatalogo();
					parque.mostrarSugerencia(usuarioTemp);
					System.out.println();
				} else {
					if(idUsuario != parque.getUsuarios().size()) 
						System.out.println("Seleccionar una opción válida.");
					else
						System.out.println("Muchas gracias por utilizar nuestro programa.");
				}
			} while (idUsuario != parque.getUsuarios().size());
		}
		catch (NumberFormatException e) {
			System.out.println("Debe ingresar un numero");
		}*/
}
		
	
	public static void espaciar() {
		for (int i=0; i<3; i++) {
			System.out.println("");
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