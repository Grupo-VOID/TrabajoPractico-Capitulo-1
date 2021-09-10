package paquete;

import java.util.Collections;
import java.util.Scanner;

public class app {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ParqueAtracciones parque = new ParqueAtracciones();
		parque.agregarUsuarios(LectorArchivos.GenerarUsuarios());
		parque.agregarAtracciones(LectorArchivos.GenerarAtracciones());
		parque.agregarPromociones(LectorArchivos.GenerarPromociones(parque));
		parque.cargarCatalogo();

		// Desde acá podríamos hacer una clase Menu
		int idUsuario=0;
		
		do {	//Menu principal
			try {
				parque.menuPrincipal();
				idUsuario = Integer.valueOf(sc.nextLine());
			}catch (NumberFormatException e) {
				System.out.println("Opcion incorrecta. Debe ingresar un numero\n"
						+ "Presione una tecla para continuar...");
				sc.nextLine();
			}
			switch (idUsuario) {
			case 1: {
				espaciar();
				break;
			}
			case 2: {
				espaciar();
				break;
			}
			case 3: {
				espaciar();
				break;
			}
			case 4: {
				espaciar();
				break;
			}
			case 5: {
				System.out.println("Hasta luego");
				break;
}
			default:
				System.out.println(" La opcion ingresada es incorrecta");
			}
		}while (idUsuario!=5);
		/*try {
			do {
				System.out.println("::Bienvenido al Parque VOID\n" 
						+ "::Para obtener sugerencias seleccionar un usario:");
				parque.mostrarUsuarios();

				// Scanner que recibe input del usuario
				Scanner sc = new Scanner(System.in);
				idUsuario = Integer.valueOf(sc.nextLine());
				idUsuario --;
				if (idUsuario < parque.getUsuarios().size()) {
					Usuario usuarioTemp = parque.getUsuarios().get(idUsuario);
					System.out.println("Sugerencias para: " + usuarioTemp.getNombre() 
							+ "\nTematica favorita: " + usuarioTemp.getTematica() + "\n");

					Collections.sort(parque.getCatalogo(), new Sugerencia(usuarioTemp));
					//parque.mostrarCatalogo();
					parque.mostrarSugerencia(usuarioTemp);
					System.out.println();
				} else {
					if(idUsuario == parque.getUsuarios().size()) {
						System.out.println("Muchas gracias por utilizar nuestro programa.");
						System.exit(idUsuario);
					}
					System.out.println("Seleccionar una opción válida.");
					
				}
			} while (idUsuario != parque.getUsuarios().size());
		}
		catch (NumberFormatException e) {
			System.out.println("Debe ingresar un numero");
		}*/
	}
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  //Este metodo borra la consola supuestamente pero solo con la de windows parece
	//No me funciono en eclipse
	
	public static void espaciar() {
		for (int i=0; i<7; i++) {
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