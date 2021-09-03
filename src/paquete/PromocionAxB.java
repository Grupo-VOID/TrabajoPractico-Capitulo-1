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
	public String toString() {
		return "AxB";
	}

	@Override
	public int getCosto() {
		this.costoTotal = this.atraccionUno.getCosto() + this.atraccionDos.getCosto();
		return this.costoTotal;
	}

	@Override
	public double getTiempo() {
		this.duracionTotal = atraccionUno.getTiempo() + atraccionDos.getTiempo() + atraccionGratis.getTiempo();
		return duracionTotal;
	}

	@Override
	public void comprar() {
		this.atraccionUno.comprar();
		this.atraccionDos.comprar();
		this.atraccionGratis.comprar();

		// el método debería ser quizas: public void comprar(Usuario usuario1)
		// Entonces agregar:
		// usuario1.comprar(); no se bien como va el argumento pero debería disminuir su
		// costo con el costoTotal y su tiempo con tiempoTotal de esta promocion.

	}

	@Override
	public String ofrecerPromocion() {
		String promocion;
		promocion = "Si se compra la atraccion: " + this.atraccionUno + " y la atraccion: " + this.atraccionDos
				+ ", se lleva la atraccion: " + this.atraccionGratis + " gratis. Costo Total=" + this.getCosto()
				+ ". Duracion Total=" + this.getTiempo();

		return promocion;
	}

}
