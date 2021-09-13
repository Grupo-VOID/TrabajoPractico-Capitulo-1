package paquete;

public class PromocionAbsoluta extends Promocion {

	private int descuento = 0;
	private Atraccion atraccionUno;
	private Atraccion atraccionDos;

	public PromocionAbsoluta(TipoAtraccion tematica, Atraccion atraccion1, Atraccion atraccion2, int descuento) {
		super(tematica);
		this.atraccionUno = atraccion1;
		this.atraccionDos = atraccion2;
		this.descuento = descuento;
	}

	@Override
	public double getCosto() {
		this.costoTotal = this.atraccionUno.getCosto() + this.atraccionDos.getCosto() - descuento;
		return this.costoTotal;
	}

	@Override
	public double getTiempo() {
		this.duracionTotal = atraccionUno.getTiempo() + atraccionDos.getTiempo();
		return duracionTotal;
	}

	@Override
	public void comprar() {
		this.atraccionUno.comprar();
		this.atraccionDos.comprar();
	}

	@Override
	public String toString() {
		return ("Si compra la atraccion " + this.atraccionUno.getNombre()
				+ " y la atraccion " + this.atraccionDos.getNombre()
				+ ", obtiene un descuento de " + this.descuento + " sobre el costo total."
				+ "\n Costo Total= " + this.getCosto()
				+ "\n Duracion Total= " + this.getTiempo());
	}

	@Override
	public boolean estaDisponible() {
		return (this.atraccionUno.estaDisponible() && this.atraccionDos.estaDisponible());
	}
	
	@Override
	public Atraccion[] atraccionesIncluidas() {
		Atraccion[] atracciones = {this.atraccionUno, this.atraccionDos};
		return atracciones;
	}
}