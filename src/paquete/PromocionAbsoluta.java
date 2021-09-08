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

	public String getNombre() {
		return "Absoluta";
	}

	@Override
	public int getCosto() {
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

		// el método debería ser quizas: public void comprar(Usuario usuario1)
		// Entonces agregar:
		// usuario1.comprar(); no se bien como va el argumento pero debería disminuir su
		// costo con el costoTotal y su tiempo con tiempoTotal de esta promocion.
	}

	@Override
	public String toString() {
		return ("Si compra la atraccion: " + this.atraccionUno.getNombre()
				+ " y la atraccion: " + this.atraccionDos.getNombre()
				+ ", obtiene un descuento de " + this.descuento
				+ ".\n Costo Total= " + this.getCosto()
				+ ".\n Duracion Total= " + this.getTiempo());
	}


}