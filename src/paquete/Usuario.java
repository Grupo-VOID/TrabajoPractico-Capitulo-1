package paquete;

import java.util.ArrayList;

public class Usuario {

	private final String NOMBRE;
	private final TipoAtraccion TEMATICA_FAVORITA;
	private final double MONEDAS_INICIALES;
	private double monedasDisponibles;
	private final double TIEMPO_INICIAL;
	private double tiempoDisponible;
	protected Itinerario itinerarioUsuario;
	private ArrayList<Atraccion> listaAtracciones = new ArrayList<Atraccion>();

	public Usuario(String nombre, TipoAtraccion tematica, double monedas, double tiempo) {
		this.NOMBRE = nombre;
		this.TEMATICA_FAVORITA = tematica;
		this.MONEDAS_INICIALES = monedas;
		this.monedasDisponibles = monedas;
		this.TIEMPO_INICIAL = tiempo;
		this.tiempoDisponible = TIEMPO_INICIAL;
		this.itinerarioUsuario = new Itinerario();
	}

	public String getNombre() {
		return NOMBRE;
	}

	public TipoAtraccion getTematica() {
		return TEMATICA_FAVORITA;
	}

	public double getMonedasDisponibles() {
		return monedasDisponibles;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public ArrayList<Atraccion> getListaAtracciones() {
		return listaAtracciones;
	}

	public double monedasUtilizadas() {
		return this.MONEDAS_INICIALES - this.monedasDisponibles;
	}

	public void aceptarSugerencia(Adquirible sugerencia) {
		this.monedasDisponibles -= sugerencia.getCosto();
		this.tiempoDisponible -= sugerencia.getTiempo();
		this.itinerarioUsuario.agregarAdquirible(sugerencia);
		for (Atraccion i : sugerencia.atraccionesIncluidas()) {
			listaAtracciones.add(i);
		}
		sugerencia.comprar();
	}

	public double getMonedasIniciales() {
		return MONEDAS_INICIALES;
	}

	public double getTiempoInicial() {
		return TIEMPO_INICIAL;
	}
}
