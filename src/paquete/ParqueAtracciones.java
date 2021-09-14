package paquete;

import java.util.LinkedList;

public class ParqueAtracciones {

	private LinkedList<Adquirible> atracciones, promociones, catalogo = new LinkedList<Adquirible>();
	private LinkedList<Usuario> usuarios;

	public void agregarAtracciones(LinkedList<Adquirible> atracciones) {
		this.atracciones = atracciones;
	}

	public void agregarPromociones(LinkedList<Adquirible> promociones) {
		this.promociones = promociones;
	}
	
	public void agregarUsuarios(LinkedList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void mostrarUsuarios() {
		for (int i = 0; i < this.usuarios.size(); i++) {
			System.out.print(i+1 + ". " + this.usuarios.get(i).getNombre() + "\n");
		}
	}

	public void cargarCatalogo () {
		this.catalogo.addAll(this.promociones);
		this.catalogo.addAll(this.atracciones);
	}
	
	public void mostrarCatalogo() {
		for (Adquirible i : this.catalogo) {
			if(i.esPromocion()) {
				System.out.print(i.getNombre() + " ");
				System.out.print(i.getTematica() + " ");
				System.out.print(i.getCosto() + " ");
				System.out.println(i.getTiempo());
			}
			else {
				System.out.print(i.getNombre() + " ");
				System.out.print(i.getTematica() + " ");
				System.out.print(i.getCosto() + " ");
				System.out.println(i.getTiempo());
				System.out.print(((Atraccion) i).getCupoMaximo() + " ");
			}
		}
	}
	
	public Adquirible obtenerAtraccionPorNombre(String nombre) {
		for (Adquirible atraccion : atracciones) {
			if (atraccion.getNombre().equals(nombre)) {
				return atraccion;
			}
		}
		return null;
	}
	
	public LinkedList<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
	public LinkedList<Adquirible> getAtracciones(){
		return this.atracciones;
	}
	
	public LinkedList<Adquirible> getPromociones(){
		return this.promociones;
	}
	
	public LinkedList<Adquirible> getCatalogo() {
		return catalogo;
	}
}
