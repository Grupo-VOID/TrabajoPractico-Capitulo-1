package paquete;

public enum TipoAtraccion {
	
	ATRACCION1,
	ATRACCION2,
	ATRACCION3,
	ATRACCION4;
	
	@Override
	public String toString() {
		return this.name();
	}
}

/*Dejo creado el enum con los nombres genericos para ir trabajando con 
 * ellos hasta armar la temática, luego podemos cambiar todos juntos 
 * usando el refactor
 */