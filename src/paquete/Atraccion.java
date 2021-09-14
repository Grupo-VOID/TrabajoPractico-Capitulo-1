package paquete;

public class Atraccion implements Adquirible {

	private final String NOMBRE;
	private final TipoAtraccion TEMATICA;
	private final double COSTO;
	private final double DURACION;
	private final int CUPO_MAXIMO;
	private int lugaresOcupados = 0;

	public Atraccion(String nombre, TipoAtraccion tematica, double costo, double duracion, int cupoMaximo) {
		this.NOMBRE = nombre;
		this.TEMATICA = tematica;
		this.COSTO = costo;
		this.DURACION = duracion;
		this.CUPO_MAXIMO = cupoMaximo;
	}

	public double getCosto() {
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

	public int getCupoMaximo() {
		return CUPO_MAXIMO;
	}
	
	public String getNombre() {
		return NOMBRE;
	}

	public boolean estaDisponible() {
		return lugaresOcupados < CUPO_MAXIMO;
	}

	public void comprar() {
		lugaresOcupados++;
	}

	public Atraccion[] atraccionesIncluidas() {
		Atraccion [] nombre = {this};
		return nombre;
	}
	
	@Override
	public boolean esPromocion() {
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("Atracción: " + this.NOMBRE 
				+ ". Temática: " + this.getTematica()
				+ "\n Costo Total= $" + this.getCosto()
				+ "\n Duracion Total= " + this.getTiempo() + " horas");
	}
}