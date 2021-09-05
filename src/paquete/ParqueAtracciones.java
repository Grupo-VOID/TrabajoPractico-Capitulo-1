package paquete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ParqueAtracciones {

	private ArrayList<Adquirible> atracciones, promociones;
	private LinkedList<Usuario> usuarios;
	private ArrayList<Adquirible> catalogo;

	public ParqueAtracciones() {
	}
	
	public void agregarAtracciones(ArrayList<Adquirible> atracciones) {
		Collections.sort (atracciones, new AdquiribleComparator());
		this.atracciones = atracciones;
	}

	public void agregarPromociones(ArrayList<Adquirible> promociones) {
		Collections.sort (promociones, new AdquiribleComparator());
		this.promociones = promociones;
		
	}
	
	public void agregarUsuarios(LinkedList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void cargarCatalogo () {
		catalogo = new ArrayList<Adquirible>();
		this.catalogo.addAll(this.promociones);
		this.catalogo.addAll(this.atracciones);
	}
	
	public LinkedList<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
	public ArrayList<Adquirible> getAtracciones(){
		return this.atracciones;
	}
	
	public ArrayList<Adquirible> getPromociones(){
		return this.promociones;
	}
	
	public ArrayList<Adquirible> getCatalogo() {
		return catalogo;
	}

	
	public Adquirible obtenerAtraccionPorNombre(String nombre) {
		for (Adquirible atraccion : atracciones) {
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
