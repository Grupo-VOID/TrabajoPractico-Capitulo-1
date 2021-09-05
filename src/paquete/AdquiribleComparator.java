package paquete;

import java.util.Comparator;

public class AdquiribleComparator implements Comparator<Adquirible>{

	@Override
	public int compare(Adquirible adquirible1, Adquirible adquirible2) {
		if (adquirible1.esPromocion() && !adquirible2.esPromocion())
			return 1;
		else if (!adquirible1.esPromocion() && adquirible2.esPromocion())
			return -1;
		if (adquirible1.getCosto() > adquirible2.getCosto())
			return -1;
		else if (adquirible1.getCosto() < adquirible2.getCosto())
			return 1;
		return (int) (adquirible2.getTiempo() - adquirible1.getTiempo());
	}
}
