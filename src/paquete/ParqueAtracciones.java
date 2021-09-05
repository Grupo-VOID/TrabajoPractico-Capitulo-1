package paquete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ParqueAtracciones {

	private LinkedList<Atraccion> atracciones;
	private LinkedList<Usuario> usuarios;
	private ArrayList<Promocion> promociones;
	private ArrayList<Adquirible> catalogo = new ArrayList<Adquirible>();

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
	
	public ArrayList<Adquirible> getCatalogo() {
		return catalogo;
	}

	public void agregarAtracciones(LinkedList<Atraccion> atracciones) {
		Collections.sort (atracciones, new AdquiribleComparator());
		this.atracciones = atracciones;
	}

	public void agregarUsuarios(LinkedList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void agregarPromociones(ArrayList<Promocion> promociones) {
		Collections.sort (promociones, new AdquiribleComparator());
		this.promociones = promociones;
		
	}
	
	public void cargarCatalogo () {
		this.catalogo.addAll(this.promociones);
		this.catalogo.addAll(this.atracciones);
	}

	public Atraccion obtenerAtraccionPorNombre(String nombre) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.toString().equals(nombre)) {
				return atraccion;
			}
		}
		return null;
	}
	
	public void mostrarCatalogo() {
		for (Adquirible i : this.catalogo) {
			if(i.esPromocion()) {
				System.out.print(i.toString() + " ");
				System.out.print(i.getTematica() + " ");
				System.out.print(i.getCosto() + " ");
				System.out.println(i.getTiempo());
			}
			else {
				System.out.print(i.toString() + " ");
				System.out.print(i.getCosto() + " ");
				System.out.print(i.getTiempo() + " ");
				System.out.print(((Atraccion) i).getCUPO_MAXIMO() + " ");
				System.out.println(i.getTematica());
			}
		}
	}
}
