package paquete;

public class PromocionPorcentual extends Promocion {

	private double porcentajeDescuento = 0;
	private Atraccion atraccionUno, atraccionDos;

	public PromocionPorcentual(TipoAtraccion tematica, Atraccion atraccion1, Atraccion atraccion2, int porcentajeDescuento) {
		super(tematica);
		this.atraccionUno = atraccion1;
		this.atraccionDos = atraccion2;
		this.porcentajeDescuento = porcentajeDescuento;
	}

	@Override
	public double getCosto() {
		double costoAtracciones = this.atraccionUno.getCosto() + this.atraccionDos.getCosto();
		this.costoTotal = costoAtracciones * (1 - porcentajeDescuento/100);
		//Con lo de abajo se trunca en s�lo dos decimales
		this.costoTotal = this.costoTotal * 100;
		return (Math.floor(this.costoTotal))/100;
	}

	@Override
	public double getTiempo() {
		this.duracionTotal = atraccionUno.getTiempo() + atraccionDos.getTiempo();
		return duracionTotal;
	}

	@Override
	public String toString() {
		return ("Si compra la atraccion: " + this.atraccionUno.getNombre() 
				+ " y la atraccion: " + this.atraccionDos.getNombre()
				+ ", se ofrece un descuento del " + this.porcentajeDescuento
				+ "% sobre el costo total"
				+ ".\n Costo Total con descuento= " + this.getCosto()
				+ ".\n Duracion Total= " + this.getTiempo());
	}

	@Override
	public void comprar() {
		this.atraccionUno.comprar();
		this.atraccionDos.comprar();
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
