package paquete;

public abstract class Promocion implements Adquirible {

	protected final TipoAtraccion TEMATICA;
	protected double costoTotal = 0;
	protected double duracionTotal = 0;

	public Promocion(TipoAtraccion tematica) {
		this.TEMATICA = tematica;
	}
	
	public String getNombre() {
		return "Pack "+this.TEMATICA;
	}
	
	public TipoAtraccion getTematica() {
		return TEMATICA;
	}

	public abstract double getCosto();

	public abstract double getTiempo();

	@Override
	public boolean esPromocion() {
		return true;
	}

	public abstract boolean estaDisponible();
	
	public abstract Atraccion[] atraccionesIncluidas();
}