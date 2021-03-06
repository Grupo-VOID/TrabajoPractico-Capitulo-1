package paquete;

import java.io.*;
import java.util.*;

public class LectorArchivos {

	public static LinkedList<Usuario> GenerarUsuarios(String rutaEntrada) {
		LinkedList<Usuario> listaUsuarios = new LinkedList<Usuario>();
		Scanner archivo = null;
		try {
			archivo = new Scanner(new File(rutaEntrada));
			while (archivo.hasNext()) {
				String linea = archivo.nextLine();
				String datosUsuario[] = linea.split(",");
				String nombre = datosUsuario[0];
				TipoAtraccion tematica = TipoAtraccion.valueOf(datosUsuario[1].toUpperCase());
				int monedas = Integer.parseInt(datosUsuario[2]);
				double tiempo = Double.parseDouble(datosUsuario[3]);
				Usuario usuario = new Usuario(nombre, tematica, monedas, tiempo);
				listaUsuarios.add(usuario);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		archivo.close();
		return listaUsuarios;
	}

	public static LinkedList<Adquirible> GenerarAtracciones(String rutaEntrada) {
		LinkedList<Adquirible> listaAtracciones = new LinkedList<Adquirible>();
		Scanner archivo = null;
		try {
			archivo = new Scanner(new File(rutaEntrada));
			while (archivo.hasNext()) {
				String linea = archivo.nextLine();
				String datosAtracciones[] = linea.split(",");
				String nombre = datosAtracciones[0];
				int costo = Integer.parseInt(datosAtracciones[1]);
				double tiempo = Double.parseDouble(datosAtracciones[2]);
				int cupo = Integer.parseInt(datosAtracciones[3]);
				TipoAtraccion tematica = TipoAtraccion.valueOf(datosAtracciones[4].toUpperCase());
				Atraccion atraccion = new Atraccion(nombre, tematica, costo, tiempo, cupo);
				listaAtracciones.add(atraccion);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		archivo.close();
		return listaAtracciones;
	}

	public static LinkedList<Adquirible> GenerarPromociones(ParqueAtracciones parque, String rutaEntrada) {
		LinkedList<Adquirible> listaPromociones = new LinkedList<Adquirible>();
		Scanner archivo = null;
		try {
			archivo = new Scanner(new File(rutaEntrada));
			while (archivo.hasNext()) {
				String linea = archivo.nextLine();
				String datosPromociones[] = linea.split(",");
				TipoPromocion tipoPromo = TipoPromocion.valueOf(datosPromociones[0].toUpperCase());
				TipoAtraccion tematica = TipoAtraccion.valueOf(datosPromociones[1].toUpperCase());
				Atraccion atraccion1 = (Atraccion) parque.obtenerAtraccionPorNombre(datosPromociones[3]);
				Atraccion atraccion2 = (Atraccion) parque.obtenerAtraccionPorNombre(datosPromociones[4]);
				if (tipoPromo == TipoPromocion.ABSOLUTA) {
					int datoRelativo = Integer.parseInt(datosPromociones[2]);
					PromocionAbsoluta promocion = new PromocionAbsoluta(tematica, atraccion1, atraccion2, datoRelativo);
					listaPromociones.add(promocion);
				}
				if (tipoPromo == TipoPromocion.PORCENTUAL) {
					int datoRelativo = Integer.parseInt(datosPromociones[2]);
					PromocionPorcentual promocion = new PromocionPorcentual(tematica, atraccion1, atraccion2,
							datoRelativo);
					listaPromociones.add(promocion);
				}
				if (tipoPromo == TipoPromocion.AXB) {
					Atraccion atraccion3 = (Atraccion) parque.obtenerAtraccionPorNombre(datosPromociones[2]);
					PromocionAxB promocion = new PromocionAxB(tematica, atraccion3, atraccion1, atraccion2);
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