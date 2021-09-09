package paquete;

public abstract class Promocion implements Adquirible {

	//protected Atraccion atraccionOfrecida;
	protected final TipoAtraccion TEMATICA;
	protected int costoTotal = 0;
	protected double duracionTotal = 0;
	

	public Promocion(TipoAtraccion tematica) {
		this.TEMATICA = tematica;
	}

	public int getCosto() {
		return this.costoTotal;
	}

	public double getTiempo() {
		return this.duracionTotal;
	}

	public TipoAtraccion getTematica() {
		return TEMATICA;
	}
	
	@Override
	public boolean esPromocion() {
		return true;
	}
	
	public boolean estaDisponible() {
		return false;
	}
	
	public abstract Atraccion [] atraccionesIncluidas();
}