package paquete;

public class PromocionPorcentual extends Promocion {

	private int porcentajeDescuento = 0;
	private Atraccion atraccionUno;
	private Atraccion atraccionDos;
	private Atraccion atraccionTres;

	public PromocionPorcentual(Atraccion atraccion1, Atraccion atraccion2, Atraccion atraccion3,
			int porcentajeDescuento) {
		this.atraccionUno = atraccion1;
		this.atraccionDos = atraccion2;
		this.atraccionTres = atraccion3;
		this.porcentajeDescuento = porcentajeDescuento;
	}

	@Override
	public int getCosto() {
		int costoAtracciones = this.atraccionUno.getCosto() + this.atraccionDos.getCosto()
				+ this.atraccionTres.getCosto();
		this.costoTotal = costoAtracciones * (1 - this.porcentajeDescuento);
		return this.costoTotal;
	}

	@Override
	public double getTiempo() {
		this.duracionTotal = atraccionUno.getTiempo() + atraccionDos.getTiempo() + atraccionTres.getTiempo();
		return duracionTotal;
	}

	@Override
	public String ofrecerPromocion() {
		String promocion;
		promocion = "Si compra la atraccion: " + this.atraccionUno + ", la atraccion: " + this.atraccionDos
				+ " y la atraccion: " + this.atraccionTres + " se ofrece un descuento del " + this.porcentajeDescuento
				+ "% sobre el costo total. Costo Total=" + this.getCosto() + ". Duracion Total=" + this.getTiempo();

		return promocion;
	}

	@Override
	public void comprar() {
		this.atraccionUno.comprar();
		this.atraccionDos.comprar();
		this.atraccionTres.comprar();

		// el método debería ser quizas: public void comprar(Usuario usuario1)
		// Entonces agregar:
		// usuario1.comprar(); no se bien como va el argumento pero debería disminuir su
		// costo con el costoTotal y su tiempo con tiempoTotal de esta promocion.
	}

}
