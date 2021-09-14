package paquete;

public enum TipoAtraccion {

	DRAMA, COMEDIA, MUSICAL, POLICIAL, ARGENTINA;

	@Override
	public String toString() {
		return this.name();
	}
}