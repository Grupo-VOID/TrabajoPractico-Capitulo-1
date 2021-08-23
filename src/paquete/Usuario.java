package paquete;

public class Usuario {
	
	private String nombre;
	private String tematicaFavorita;
	private final int MONEDASINICIALES;
	private int monedasDisponibles;
	private double TIEMPOINICIAL;
	private double tiempoDisponible;
	
	public Usuario (String nombre, String tematica, int monedas, double tiempo) {
		this.nombre = nombre;
		this.tematicaFavorita = tematica;
		this.MONEDASINICIALES = monedas;
		this.monedasDisponibles = monedas;
		this.TIEMPOINICIAL = tiempo;
		this.tiempoDisponible = tiempo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTematicaFavorita() {
		return tematicaFavorita;
	}

	public int getMonedasDisponibles() {
		return monedasDisponibles;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}
	
	//---------------------------------------------------------------------------------------
	//estos dos metodos son para calcular el tiempo utilizado y las monedas gastadas,
	//para generar el itinerario final del usuario
	
	public int monedasUtilizadas() {
		return this.MONEDASINICIALES - this.monedasDisponibles;
	}
	
	public double tiempoUtilizado() {
		return this.TIEMPOINICIAL - this.tiempoDisponible;
	}
	
	//---------------------------------------------------------------------------------------
	
	public void comprar(Adquiribles compra) {
		this.monedasDisponibles -= compra.getCosto();
		this.tiempoDisponible -= compra.getTiempo();
		compra.comprar();
	}
	

}
