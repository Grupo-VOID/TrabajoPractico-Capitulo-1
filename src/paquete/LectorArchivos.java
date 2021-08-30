package paquete;

import java.io.*;

public class LectorArchivos {

	private File archivo = null;
	private FileReader fr = null;
	private BufferedReader br = null;
	private int usuariosTotales = 0;
	private int atraccionesTotales = 0;
	protected Usuario[] listaUsuarios;
	protected Atraccion[] listaAtracciones;

	public int getUsuariosTotales() {
		return usuariosTotales;
	}

	public int getAtraccionesTotales() {
		return atraccionesTotales;
	}

	public void LeerGenerarUsuarios() {
		this.usuariosTotales = obtenerNumeroDatosEnArchivos("usuarios.txt");
		listaUsuarios = null;
		listaUsuarios = new Usuario[usuariosTotales];
		try {
			archivo = new File("usuarios.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea = br.readLine();
			for (int i = 0; linea != null; i++) {
				String[] datosUsuario = linea.split(",");
				String nombre = datosUsuario[0];
				TipoAtraccion tipo = TipoAtraccion.valueOf(datosUsuario[1].toUpperCase());
				int monedas = Integer.parseInt(datosUsuario[2]);
				double tiempo = Double.parseDouble(datosUsuario[3]);
				Usuario usuario = new Usuario(nombre, tipo, monedas, tiempo);
				listaUsuarios[i] = usuario;
				linea = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void LeerGenerarAtracciones() {
		this.atraccionesTotales = obtenerNumeroDatosEnArchivos("atracciones.txt");
		listaAtracciones = null;
		listaAtracciones = new Atraccion[atraccionesTotales];
		try {
			archivo = new File("atracciones.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea = br.readLine();
			for (int i = 0; linea != null; i++) {
				String[] datosAtracciones = linea.split(",");
				String nombre = datosAtracciones[0];
				int costo = Integer.parseInt(datosAtracciones[1]);
				double tiempo = Double.parseDouble(datosAtracciones[2]);
				int cupo = Integer.parseInt(datosAtracciones[3]);
				TipoAtraccion tipo = TipoAtraccion.valueOf(datosAtracciones[4].toUpperCase());
				Atraccion atraccion = new Atraccion(nombre, tipo, costo, tiempo, cupo);
				listaAtracciones[i] = atraccion;
				linea = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private int obtenerNumeroDatosEnArchivos(String nombreArchivo) {
		int numeroDatos = 0;
		try {
			archivo = new File(nombreArchivo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				numeroDatos++;
				linea = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return numeroDatos;
	}
}