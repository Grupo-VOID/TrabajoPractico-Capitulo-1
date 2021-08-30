package paquete;

public abstract class Promocion implements Adquiribles {

	protected Atraccion atraccionOfrecida;
	protected int costoTotal = 0;
	protected double duracionTotal = 0;

	public abstract String ofrecerPromocion();
	// aca no se si esta bien que sea String

	public int getCosto() {
		return this.costoTotal;
	}

	public double getTiempo() {
		return this.duracionTotal;
	}
}