package paquete;

import java.util.LinkedList;

public class ParqueAtracciones {

	private LinkedList<Adquirible> atracciones, promociones, catalogo;
	private LinkedList<Usuario> usuarios;
	
	public ParqueAtracciones() {
	}
	
	public void agregarAtracciones(LinkedList<Adquirible> atracciones) {
		//Collections.sort (atracciones, new AdquiribleComparator());
		this.atracciones = atracciones;
	}

	public void agregarPromociones(LinkedList<Adquirible> promociones) {
		//Collections.sort (promociones, new AdquiribleComparator());
		this.promociones = promociones;
		
	}
	
	public void agregarUsuarios(LinkedList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void cargarCatalogo () {
		catalogo = new LinkedList<Adquirible>();
		this.catalogo.addAll(this.promociones);
		this.catalogo.addAll(this.atracciones);
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
	
	// Esta lista debería ofrecerse a los usuarios para que acepten atracciones
	public LinkedList<Adquirible> getCatalogo() {
		return catalogo;
	}

	public Adquirible obtenerAtraccionPorNombre(String nombre) {
		for (Adquirible atraccion : atracciones) {
			if (atraccion.getNombre().equals(nombre)) {
				return atraccion;
			}
		}
		return null;
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
				//System.out.print(((Atraccion) i).getCUPO_MAXIMO() + " ");
			}
		}
	}
	
	public void mostrarUsuarios() {
		for (int i = 0; i < this.usuarios.size(); i++) {
			System.out.print(i + ". " + this.usuarios.get(i).getNombre() + "\n");
		}
	}
}
