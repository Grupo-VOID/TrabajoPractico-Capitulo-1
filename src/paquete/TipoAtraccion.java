package paquete;

public enum TipoAtraccion {
	
	AVENTURA,
	PAISAJE,
	DEGUSTACIÓN;
	
	@Override
	public String toString() {
		return this.name();
	}
}

/*Dejo creado el enum con los nombres genericos para ir trabajando con 
 * ellos hasta armar la temática, luego podemos cambiar todos juntos 
 * usando el refactor
 */