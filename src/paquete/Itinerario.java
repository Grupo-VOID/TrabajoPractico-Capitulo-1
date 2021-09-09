package paquete;

import java.util.ArrayList;

public class Itinerario {
	private ArrayList<Adquirible> listaAtracciones = new ArrayList<Adquirible>();
	private double tiempoTotal = 0;
	private double costoMonedas = 0;
	
	public void agregarAdquirible (Adquirible nuevaAtraccion) {
		listaAtracciones.add (nuevaAtraccion);
		tiempoTotal += nuevaAtraccion.getTiempo();
		costoMonedas += nuevaAtraccion.getCosto();
	}
	
	public ArrayList<Adquirible> getListaAtracciones() {
		return listaAtracciones;
	}

	public void mostrarItinerario () {
		if (listaAtracciones.isEmpty())
			System.out.println("El usuario no ha realizado compras");
		else {
			System.out.println("Las compras realizadas son:");
			for (Adquirible lista : listaAtracciones) {
				System.out.println(lista.getNombre());
			}
			System.out.println("El tiempo total es: " + this.tiempoTotal);
			System.out.println("El costo total es: " + this.costoMonedas);
		}
	}
}
