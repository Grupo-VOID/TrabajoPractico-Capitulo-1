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
}