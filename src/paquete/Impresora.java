package paquete;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Impresora {

	public void imprimir(Usuario persona) throws IOException {
		FileWriter archivo = new FileWriter("salida/salida"+persona.getNombre()+".txt");
		PrintWriter salida = new PrintWriter(archivo);
		
		if(persona.itinerarioUsuario.getListaAtracciones().isEmpty())
			salida.println("El usuario "+persona.getNombre()+" no ha realizado compras.");
		else {
			salida.println("Las atracciones compradas por el usuario "+ persona.getNombre() + " son:");
			for (Adquirible lista : persona.getListaAtracciones()) {
				salida.println("\t" + lista.getNombre());
			}
			salida.println("El tiempo total es: "+persona.itinerarioUsuario.getTiempoTotal());
			salida.println("El costo total es: "+persona.itinerarioUsuario.getCostoMonedas());
		}
		salida.close();
	}
}

//persona.itinerarioUsuario.getListaAtracciones()