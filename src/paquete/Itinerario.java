package paquete;

import java.util.ArrayList;

public class Itinerario {
	private ArrayList<Atraccion> listaAtracciones;
	private double tiempoTotal = 0;
	private double costoMonedas = 0;
	
	public void agregarAtraccion (Atraccion nuevaAtraccion) {
		listaAtracciones.add (nuevaAtraccion);
		tiempoTotal += nuevaAtraccion.getTiempo();
		costoMonedas *= nuevaAtraccion.getCosto();
	}
	
	public double getCostoMonedas() {
		return costoMonedas;
	}
	
	public double getTiempoTotal() {
		return tiempoTotal;
	}
	
	public ArrayList<Atraccion> getListaAtracciones() {
		return listaAtracciones;
	}

}
