package paquete;

import java.io.*;

public class LectorArchivos {

	private File archivo = null;
	private FileReader fr = null;
	private BufferedReader br = null;
	private int usuariosTotales = 0;
	private Usuario[] listaUsuarios = new Usuario[100];

	public void LeerGenerarUsuarios() {
		try {
			archivo = new File("usuarios.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datosUsuario = linea.split(",");
				String nombre = datosUsuario[0];
				TipoAtraccion tipo = TipoAtraccion.valueOf(datosUsuario[1].toUpperCase());
				int monedas = Integer.parseInt(datosUsuario[2]);
				double tiempo = Double.parseDouble(datosUsuario[3]);
				Usuario usuario = new Usuario(nombre, tipo, monedas, tiempo);
				listaUsuarios[usuariosTotales] = usuario;
				usuariosTotales++;
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
}