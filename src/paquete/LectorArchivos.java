package paquete;

import java.io.*;
import java.util.*;

public class LectorArchivos {

	public static LinkedList<Usuario> GenerarUsuarios() {
		LinkedList<Usuario> listaUsuarios = new LinkedList<Usuario>();
		Scanner archivo = null;
		try {
			archivo = new Scanner(new File("entrada/usuarios.txt"));
			while (archivo.hasNext()) {
				String linea = archivo.nextLine();
				String datosUsuario[] = linea.split(",");
				String nombre = datosUsuario[0];
				TipoAtraccion tipo = TipoAtraccion.valueOf(datosUsuario[1].toUpperCase());
				int monedas = Integer.parseInt(datosUsuario[2]);
				double tiempo = Double.parseDouble(datosUsuario[3]);
				Usuario usuario = new Usuario(nombre, tipo, monedas, tiempo);
				listaUsuarios.add(usuario);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		archivo.close();
		return listaUsuarios;
	}

	public static LinkedList<Atraccion> GenerarAtracciones() {
		LinkedList<Atraccion> listaAtracciones = new LinkedList<Atraccion>();
		Scanner archivo = null;
		try {
			archivo = new Scanner(new File("entrada/atracciones.txt"));
			while (archivo.hasNext()) {
				String linea = archivo.nextLine();
				String datosAtracciones[] = linea.split(",");
				String nombre = datosAtracciones[0];
				int costo = Integer.parseInt(datosAtracciones[1]);
				double tiempo = Double.parseDouble(datosAtracciones[2]);
				int cupo = Integer.parseInt(datosAtracciones[3]);
				TipoAtraccion tipo = TipoAtraccion.valueOf(datosAtracciones[4].toUpperCase());
				Atraccion atraccion = new Atraccion(nombre, tipo, costo, tiempo, cupo);
				listaAtracciones.add(atraccion);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		archivo.close();
		return listaAtracciones;
	}

	public static ArrayList<Promocion> GenerarPromociones(ParqueAtracciones parque) {
		ArrayList<Promocion> listaPromociones = new ArrayList<Promocion>();
		Scanner archivo = null;
		try {
			archivo = new Scanner(new File("entrada/promociones.txt"));
			while (archivo.hasNext()) {
				String linea = archivo.nextLine();
				String datosPromociones[] = linea.split(",");
				TipoPromocion tipoPromo = TipoPromocion.valueOf(datosPromociones[0].toUpperCase());
				TipoAtraccion tipo = TipoAtraccion.valueOf(datosPromociones[1].toUpperCase());
				Atraccion atraccion1 = parque.obtenerAtraccionPorNombre(datosPromociones[3]);
				Atraccion atraccion2 = parque.obtenerAtraccionPorNombre(datosPromociones[4]);
				if (tipoPromo == TipoPromocion.ABSOLUTA) {
					int datoRelativo = Integer.parseInt(datosPromociones[2]);
					PromocionAbsoluta promocion = new PromocionAbsoluta(tipo, atraccion1, atraccion2, datoRelativo);
					listaPromociones.add(promocion);
				}
				if (tipoPromo == TipoPromocion.PORCENTUAL) {
					int datoRelativo = Integer.parseInt(datosPromociones[2]);
					PromocionPorcentual promocion = new PromocionPorcentual(tipo, atraccion1, atraccion2, datoRelativo);
					listaPromociones.add(promocion);
				}
				if (tipoPromo == TipoPromocion.AXB) {
					Atraccion atraccion3 = parque.obtenerAtraccionPorNombre(datosPromociones[2]);
					PromocionAxB promocion = new PromocionAxB(tipo, atraccion1, atraccion2, atraccion3);
					listaPromociones.add(promocion);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		archivo.close();
		return listaPromociones;
	}
}