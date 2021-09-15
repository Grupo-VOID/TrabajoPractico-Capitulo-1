package paquete;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Impresora {

	public static void imprimir(Usuario persona) throws IOException {
		imprimir(persona,"salida");
	}
	
	public static void imprimir(Usuario persona,String nombre) throws IOException {
		FileWriter archivo = new FileWriter (nombre +"/salida"+persona.getNombre() + ".txt");
		PrintWriter salida = new PrintWriter(archivo);

		salida.println("Usuario: " + persona.getNombre() + "\nTemática Favorita: " + persona.getTematica()
				+ "\nDinero inicial: $" + persona.getMonedasIniciales() + "\nTiempo inicial: "
				+ persona.getTiempoInicial() + " horas\n\n");

		if (persona.itinerarioUsuario.getListaAtracciones().isEmpty())
			salida.println("El usuario " + persona.getNombre() + " no ha realizado compras.");
		else {
			salida.println("Las atracciones compradas por el usuario " + persona.getNombre() + " son:");
			for (Adquirible lista : persona.itinerarioUsuario.getListaAtracciones()) {
				salida.println("\t" + lista.getNombre());
			}
			salida.println("El costo total es: $" + persona.itinerarioUsuario.getCostoMonedas());
			salida.println("El tiempo total es: " + persona.itinerarioUsuario.getTiempoTotal() + " horas");
		}
		salida.close();
	}
}