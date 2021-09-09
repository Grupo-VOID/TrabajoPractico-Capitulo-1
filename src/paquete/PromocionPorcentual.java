package paquete;

public class PromocionPorcentual extends Promocion {

	private float porcentajeDescuento = 0;
	private Atraccion atraccionUno, atraccionDos;

	public PromocionPorcentual(TipoAtraccion tematica, Atraccion atraccion1, Atraccion atraccion2, int porcentajeDescuento) {
		super(tematica);
		this.atraccionUno = atraccion1;
		this.atraccionDos = atraccion2;
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public String getNombre() {
		return "Porcentual";
	}

	@Override
	public int getCosto() {
		int costoAtracciones = this.atraccionUno.getCosto() + this.atraccionDos.getCosto();
		return (int)Math.round(costoAtracciones * (1 - porcentajeDescuento/100));
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

		// el método debería ser quizas: public void comprar(Usuario usuario1)
		// Entonces agregar:
		// usuario1.comprar(); no se bien como va el argumento pero debería disminuir su
		// costo con el costoTotal y su tiempo con tiempoTotal de esta promocion.
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
