package paquete;

import java.util.LinkedList;
import java.util.Scanner;

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
			System.out.print(i+1 + ". " + this.usuarios.get(i).getNombre() + "\n");
		}
		System.out.println(this.usuarios.size()+1 +". Finalizar programa");
	}
	
	public void mostrarSugerencia(Usuario persona) {
		System.out.println("Sugerencias para: " + persona.getNombre() 
		+ "\nTematica favorita: " + persona.getTematica() + "\n");
		for (Adquirible lista : this.getCatalogo()) {
			if(Sugerencia.validarSugerencia(persona, lista)) {
				String op;
				Scanner sc = new Scanner(System.in);
				System.out.println(lista);
				do {
					System.out.println("Desea comprar la sugerencia? S/N");
					op = sc.nextLine().toUpperCase();
					
					switch (op) {
					case "S": 
						System.out.println(op);
						persona.aceptarSugerencia(lista);
						op = "N";
						break;
					case "N":
						op = "N";
						break;
					default:
						System.out.println("Introdujo una letra incorrecta");
						break;
					}
				}while (op != "N");
			}
		}
		System.out.println("\nCompra finalizada\nEl itinerario del usuario "
				+ persona.getNombre() + " es: ");
		persona.itinerarioUsuario.mostrarItinerario();
	}
	
	public void menuPrincipal () {
		System.out.println("::Bienvenido al Parque VOID\n");
		System.out.println("1. Mostrar Usuarios\n2. Mostrar Atracciones\n"
				+ "3. Mostrar Promociones\n4. Comprar atracciones\n5. "
				+ "Finalizar\n\n::Elija una opcion:");
	}
}
