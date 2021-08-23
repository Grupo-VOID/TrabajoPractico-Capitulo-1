package paquete;

public class Atracciones implements Adquiribles {

	//La variable tematica la cree como String ya que nose como lo vamos a hacer al final.
	private String tematica;
	private int costo;
	private double tiempo;
	private int cupoMaximo;
	private int cupoActual = 0;

	public Atracciones(String tematica, int costo, double tiempo, int cupoMaximo) {
		this.tematica = tematica;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupoMaximo = cupoMaximo;
	}

	public int getCosto() {
		return costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public String getTematica() {
		return tematica;
	}

	public int getCupoActual() {
		return cupoActual;
	}
	
	public boolean hayLugar() {
		return cupoActual < cupoMaximo;
	}

	//comprar no valida si hay lugar antes, ya q se deberia validar antes de ofrecer la compra, 
	//"no se puede ofrecer un producto ya adquirido, que este lleno y o no tenga el tiempo o dinero suficiente".
	public void comprar() {
		cupoActual++;
	}

}
