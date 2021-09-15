package paquete;

public class PromocionAxB extends Promocion {

	private Atraccion atraccionGratis;
	private Atraccion atraccionUno;
	private Atraccion atraccionDos;

	public PromocionAxB(TipoAtraccion tematica, Atraccion atraccion1, Atraccion atraccion2, Atraccion atraccionGratis) {
		super(tematica);
		this.atraccionUno = atraccion1;
		this.atraccionDos = atraccion2;
		this.atraccionGratis = atraccionGratis;
	}

	@Override
	public double getCosto() {
		this.costoTotal = this.atraccionUno.getCosto() + this.atraccionDos.getCosto();
		return this.costoTotal;
	}

	@Override
	public double getTiempo() {
		this.duracionTotal = atraccionUno.getTiempo() + atraccionDos.getTiempo() + atraccionGratis.getTiempo();
		return duracionTotal;
	}
	
	@Override
	public boolean estaDisponible() {
		return (this.atraccionUno.estaDisponible() && this.atraccionDos.estaDisponible()
				&& this.atraccionGratis.estaDisponible());
	}
	
	@Override
	public Atraccion[] atraccionesIncluidas() {
		Atraccion[] atracciones = {this.atraccionUno, this.atraccionDos, this.atraccionGratis};
		return atracciones;
	}

	@Override
	public void comprar() {
		this.atraccionUno.comprar();
		this.atraccionDos.comprar();
		this.atraccionGratis.comprar();
	}

	@Override
	public String toString() {
		return (this.getNombre() +": Si se compra la atracción " + this.atraccionUno.getNombre() 
				+ " y la atracción " + this.atraccionDos.getNombre()
				+ ", se lleva la atracción " + this.atraccionGratis.getNombre() + " gratis." 
				+ "\n Temática: " + this.getTematica()
				+"\n Costo Total= $" + this.getCosto()
				+"\n Duración Total= " + this.getTiempo() + " horas");
	}
}
