package paquete;

public class Atraccion implements Adquirible {

	private final String NOMBRE;
	private final TipoAtraccion TEMATICA;
	private final int COSTO;
	private final double DURACION;
	private final int CUPO_MAXIMO;
	private int lugaresOcupados = 0;

	public Atraccion(String nombre, TipoAtraccion tematica, int costo, double duracion, int cupoMaximo) {
		this.NOMBRE = nombre;
		this.TEMATICA = tematica;
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

	public TipoAtraccion getTematica() {
		return TEMATICA;
	}

	public int getCupoActual() {
		return lugaresOcupados;
	}

	public int getCUPO_MAXIMO() {
		return CUPO_MAXIMO;
	}

	public boolean hayLugar() {
		return lugaresOcupados < CUPO_MAXIMO;
	}

	// comprar no valida si hay lugar antes, ya q se deberia validar antes de
	// ofrecer la compra,
	// "no se puede ofrecer un producto ya adquirido, que este lleno y o no tenga el
	// tiempo o dinero suficiente".
	public void comprar() {
		lugaresOcupados++;
	}

	@Override
	public boolean esPromocion() {
		return false;
	}
	
	public String getNombre() {
		return NOMBRE;
	}
	
	@Override
	public String toString() {
		return String.format("Atracción: " + this.NOMBRE
				+ "\n Costo Total= $" + this.getCosto()
				+ "\n Duracion Total= " + this.getTiempo());
	}
}