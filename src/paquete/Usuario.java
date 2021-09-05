package paquete;

public class Usuario {

	private final String NOMBRE;
	private final TipoAtraccion TEMATICA_FAVORITA;
	private final int MONEDAS_INICIALES;
	private int monedasDisponibles;
	private final double TIEMPO_INICIAL;
	private double tiempoDisponible;
	public Itinerario itinerarioUsuario;

	public Usuario(String nombre, TipoAtraccion tematica, int monedas, double tiempo) {
		this.NOMBRE = nombre;
		this.TEMATICA_FAVORITA = tematica;
		this.MONEDAS_INICIALES = monedas;
		this.monedasDisponibles = monedas;
		this.TIEMPO_INICIAL = tiempo;
		this.tiempoDisponible = tiempo;
		this.itinerarioUsuario = new Itinerario();
	}

	public String getNombre() {
		return NOMBRE;
	}

	public TipoAtraccion getTematica() {
		return TEMATICA_FAVORITA;
	}

	public int getMonedasDisponibles() {
		return monedasDisponibles;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	// ---------------------------------------------------------------------------------------
	// estos dos metodos son para calcular el tiempo utilizado y las monedas
	// gastadas,
	// para generar el itinerario final del usuario

	public int monedasUtilizadas() {
		return this.MONEDAS_INICIALES - this.monedasDisponibles;
	}

	// ---------------------------------------------------------------------------------------

	public void aceptarSugerencia(Adquirible sugerencia) {
		this.monedasDisponibles -= sugerencia.getCosto();
		this.tiempoDisponible -= sugerencia.getTiempo();
		sugerencia.comprar();
	}

}
