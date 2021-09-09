package paquete;

//Esta interface la deberian implementar las clases atracciones y promociones.

public interface Adquirible {

	public int getCosto();

	public double getTiempo();
	
	public TipoAtraccion getTematica();

	public void comprar();
	
	public boolean esPromocion();

	public String getNombre();
	
	public boolean estaDisponible();
	
	public abstract Atraccion [] atraccionesIncluidas();
}
