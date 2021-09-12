package paquete;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

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

	public void cargarCatalogo () {
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
				System.out.print(((Atraccion) i).getCupoMaximo() + " ");
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
		Scanner sc = new Scanner(System.in);
		for (Adquirible lista : this.getCatalogo()) {
			if(Sugerencia.validarSugerencia(persona, lista)) {
				String op;
				System.out.println(lista);
				do {
					System.out.println("Desea comprar la sugerencia? Presione S para"
							+ " Si o N para No");
					op = sc.nextLine().toUpperCase();
					
					switch (op) {
					case "S": 
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
		System.out.println("\nCompra finalizada\n**Itinerario del usuario "
				+ persona.getNombre() + "**\n\n");
		persona.itinerarioUsuario.mostrarItinerario();
		System.out.println("Presione una tecla para continuar...");
		sc.nextLine();
		
	}
	
	public void menuPrincipal () {
		System.out.println("::Bienvenido al Parque VOID\n");
		System.out.println("1. Mostrar Usuarios\n2. Mostrar Atracciones\n"
				+ "3. Mostrar Promociones\n4. Comprar atracciones\n5. "
				+ "Finalizar\n\n::Elija una opcion:");
	}
	
	public void sistemaCompras() {
		System.out.println("::Sistema de compra\n");
		for (Usuario i : this.usuarios) {
			System.out.println(":Sugerencias para el usuario " + i.getNombre());
			Collections.sort(this.getCatalogo(), new Sugerencia(i));
			this.mostrarSugerencia(i);
			System.out.println("\n\n\n");
		}
		System.out.println("Todos los usuarios realizaron sus compras");
	}
	
}
