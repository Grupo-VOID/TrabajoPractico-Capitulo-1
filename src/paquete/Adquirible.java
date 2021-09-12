package paquete;

public interface Adquirible {

	public double getCosto();

	public double getTiempo();
	
	public TipoAtraccion getTematica();

	public void comprar();
	
	public boolean esPromocion();

	public String getNombre();
	
	public boolean estaDisponible();
	
	public Atraccion [] atraccionesIncluidas();
}
