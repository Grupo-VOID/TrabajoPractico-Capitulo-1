package paquete;

public class Atracciones implements Adquiribles {

	private final String NOMBRE;
	private final TipoAtracciones TEMATICA;
	private final int COSTO;
	private final double DURACION;
	private final int CUPO_MAXIMO;
	private int cupoActual = 0;

	public Atracciones(String nombre, String tematica, int costo, double duracion, int cupoMaximo) {
		this.NOMBRE = nombre;
		this.TEMATICA = TipoAtracciones.valueOf(tematica.toUpperCase());
		this.COSTO = costo;
		this.DURACION = duracion;
		this.CUPO_MAXIMO = cupoMaximo;
	}

	public int getCosto() {
		return COSTO;
	}

	public double getTiempo() {
		return DURACION;
	}
	
	public String getTematica() {
		return TEMATICA.toString();
	}

	@Override
	public String toString() {
		return NOMBRE;
	}

	public int getCupoActual() {
		return cupoActual;
	}

	public boolean hayLugar() {
		return cupoActual < CUPO_MAXIMO;
	}

	// comprar no valida si hay lugar antes, ya q se deberia validar antes de
	// ofrecer la compra,
	// "no se puede ofrecer un producto ya adquirido, que este lleno y o no tenga el
	// tiempo o dinero suficiente".
	public void comprar() {
		cupoActual++;
	}

}
