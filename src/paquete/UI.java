package paquete;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public abstract class UI {

	@SuppressWarnings("resource")
	public static void eleccionDeMenu(ParqueAtracciones parque) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("::Bienvenido al Parque VOID::\n");
		System.out.println("::Menú Principal::\n");
		System.out.println(
				"Seleccionar método para Sistema de Compras:\n Presione 1 para que cada usuario compre en orden de llegada. \n"
						+ " Presione 2 para poder seleccionar qué usuario compra.");
		String op;
		do {
			op = sc.nextLine();

			switch (op) {
			case "1":
				UI.compraSucesiva(parque);
				op = "1";
				break;
			case "2":
				UI.compraPorUsuario(parque);
				op = "1";
				break;
			default:
				System.out.println("Introdujo una opción no válida.");
				System.out.println("Presione 1 para que cada usuario compre en orden de llegada "
						+ "o Presione 2 para seleccionar que usuario compra.");
				break;
			}
		} while (op != "1");
	}

	public static void compraSucesiva(ParqueAtracciones parque) throws IOException {
		System.out.println("::Bienvenido al Parque VOID::\n");
		System.out.println("::Sistema de compras::\n");
		for (Usuario i : parque.getUsuarios()) {
			System.out.println("Sugerencias para el usuario: " + i.getNombre());
			System.out.println("_Temática preferida: " + i.getTematica());
			System.out.println("_Dinero disponible: $" + i.getMonedasDisponibles());
			System.out.println("_Tiempo disponible: " + i.getTiempoDisponible() + " horas\n");
			Collections.sort(parque.getCatalogo(), new Sugerencia(i));
			mostrarSugerencia(parque, i);
			System.out.println("\n\n\n");
		}
		for (Usuario i : parque.getUsuarios()) {
			Impresora.imprimir(i);
		}
		System.out.println("Todos los usuarios realizaron sus compras");
		System.out.println("Muchas gracias por utilizar nuestro programa.");
	}

	public static void compraPorUsuario(ParqueAtracciones parque) throws IOException {
		Scanner sc = new Scanner(System.in);
		try {
			sistemaDeCompra(parque, sc);
		} catch (NumberFormatException e) {
			System.out.println("Debe ingresar un número");
			compraPorUsuario(parque);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Seleccionar una opción válida.");
			compraPorUsuario(parque);
		}
	}

	private static void sistemaDeCompra(ParqueAtracciones parque, Scanner sc) throws IOException {
		int idUsuario;
		System.out.println("::Bienvenido al Parque VOID::\n");
		do {
			System.out.println("::Sistema de compra::\n" + "Para obtener sugerencias seleccionar un usuario:");
			parque.mostrarUsuarios();
			idUsuario = Integer.valueOf(sc.nextLine());
			idUsuario--;
			if (idUsuario < parque.getUsuarios().size()) {
				Usuario usuarioTemp = parque.getUsuarios().get(idUsuario);
				System.out.println("Sugerencias para: " + usuarioTemp.getNombre() + "\n_Temática favorita: "
						+ usuarioTemp.getTematica() + "\n_Dinero disponible: $" + usuarioTemp.getMonedasDisponibles()
						+ "\n_Tiempo disponible: " + usuarioTemp.getTiempoDisponible() + " horas\n");
				Collections.sort(parque.getCatalogo(), new Sugerencia(usuarioTemp));
				mostrarSugerencia(parque, usuarioTemp);
				Impresora.imprimir(usuarioTemp);
				parque.getUsuarios().remove(usuarioTemp);
				System.out.println();
				idUsuario = 0;
			} else {
				System.out.println("Seleccionar una opción válida.");
				idUsuario = 0;
			}
		} while (idUsuario != parque.getUsuarios().size());
		System.out.println("Todos los usuarios realizaron sus compras");
		System.out.println("Muchas gracias por utilizar nuestro programa.");
	}

//// MOSTRAR SUGERENCIA ES USADO POR AMBAS OPCIONES DE MENÚ ////	
	@SuppressWarnings("resource")
	public static void mostrarSugerencia(ParqueAtracciones parque, Usuario persona) {
		Scanner sc = new Scanner(System.in);
		for (Adquirible lista : parque.getCatalogo()) {
			if (Sugerencia.validarSugerencia(persona, lista)) {
				String op;
				System.out.println(lista);
				do {
					System.out.println("Desea comprar la sugerencia? Presione S para" + " Si o N para No");
					op = sc.nextLine().toUpperCase();

					switch (op) {
					case "S":
						persona.aceptarSugerencia(lista);
						op = "N";
						break;
					case "N":
						op = "N";
						break;
					default:
						System.out.println("Introdujo una letra incorrecta");
						break;
					}
				} while (op != "N");
			}
		}
		System.out.println("\nCompra finalizada\n**Itinerario del usuario " + persona.getNombre() + "**\n");
		persona.itinerarioUsuario.mostrarItinerario();
		System.out.println("\nPresione ENTER para continuar...");
		sc.nextLine();
	}
}
