package paquete;

import java.util.ArrayList;
import java.util.LinkedList;

public class ParqueAtracciones {

	private LinkedList<Atraccion> atracciones;
	private LinkedList<Usuario> usuarios;
	private ArrayList<Promocion> promociones;

	public ParqueAtracciones() {
	}
	
	public LinkedList<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
	public LinkedList<Atraccion> getAtracciones(){
		return this.atracciones;
	}
	
	public ArrayList<Promocion> getPromociones(){
		return this.promociones;
	}

	public void agregarAtracciones(LinkedList<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public void agregarUsuarios(LinkedList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void agregarPromociones(ArrayList<Promocion> promociones) {
		this.promociones = promociones;
	}

	public Atraccion obtenerAtraccionPorNombre(String nombre) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.toString().equals(nombre)) {
				return atraccion;
			}
		}
		return null;
	}
}
