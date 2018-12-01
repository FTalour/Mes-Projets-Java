package lieu;

import java.util.ArrayList;

public class Arret extends Lieu {
	protected ArrayList<LigneBus> sesLignes;

	public Arret(String nom) {
		super(nom);
		sesLignes = new ArrayList<LigneBus>();
	}

	public void ajoutLigne(LigneBus l) {
		sesLignes.add(l);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (this == o) {
			return true;
		}
		if (o instanceof Arret) {
			Arret autreArret = (Arret) o;
			return autreArret.sesLignes.containsAll(this.sesLignes) && super.equals(autreArret);
		}
		return false;
	}
}
