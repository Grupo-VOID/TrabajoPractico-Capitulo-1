package paquete;

public enum TipoPromocion {

	PORCENTUAL, ABSOLUTA, AXB;

	@Override
	public String toString() {
		return this.name();
	}
}