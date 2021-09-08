package paquete;

import java.util.Comparator;

public class Sugerencia implements Comparator<Adquirible> {
	private TipoAtraccion atraccionFavorita;

	public Sugerencia(Usuario usuarioRef) {
		atraccionFavorita = usuarioRef.getTematica();
	}
	
	public TipoAtraccion getAtraccion() {
		return atraccionFavorita;
	}
	
	public int compare(Adquirible adquirible1, Adquirible adquirible2) {
		if (adquirible1.getTematica() == atraccionFavorita && adquirible2.getTematica() != atraccionFavorita) {
			return -1;
		} else if (adquirible1.getTematica() != atraccionFavorita && adquirible2.getTematica() == atraccionFavorita)
			return 1;
		if (adquirible1.esPromocion() && !adquirible2.esPromocion())
			return -1;
		else if (!adquirible1.esPromocion() && adquirible2.esPromocion())
			return 1;
		if (adquirible1.getCosto() > adquirible2.getCosto())
			return -1;
		else if (adquirible1.getCosto() < adquirible2.getCosto())
			return 1;
		return (int) (adquirible1.getTiempo() - adquirible2.getTiempo());
	}
// Faltaria la validacion si el usuario tiene tiempo, dinero,, si ya se oferto y el cupo 
}