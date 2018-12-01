package lieuQ3;

import java.util.HashMap;

public final class EnBus extends MoyenTransport {
	private static HashMap<String, EnBus> mesInstances = new HashMap<>();

	private LigneBus saLigne;

	private EnBus(LigneBus l) {
		saLigne = l;
		mesInstances.put(l.nomLigne, this);
	}

	public String toString() {
		return "Ligne Bus [" + saLigne.nom() + "]";
	}

	public Heure attente(Lieu l1, Lieu l2, Heure dep) throws ErreurTrajet {
		if (l1 instanceof Arret && l2 instanceof Arret) {
			return saLigne.attente((Arret) l1, dep);
		}
		throw new ErreurTrajet("Les lieux donnés à attente dans EnBus ne sont pas des Arret");
	}

	public Heure duree(Lieu l1, Lieu l2, Heure dep) throws ErreurTrajet {
		if (l1 instanceof Arret && l2 instanceof Arret) {
			return saLigne.dureeEnBus((Arret) l1, (Arret) l2);
		}
		throw new ErreurTrajet("Les lieux donnés à duree dans EnBus ne sont pas des Arret");
	}

	public boolean estPossible(Lieu l1, Lieu l2, Heure dep) {
		if (l1 instanceof Arret && l2 instanceof Arret) {
			Arret a1 = (Arret) l1, a2 = (Arret) l2;
			return saLigne.estPossible(a1, a2, dep);
		} else
			return false;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (this == o) {
			return true;
		}
		if (o instanceof EnBus) {
			EnBus autreEnbus = (EnBus) o;
			if (saLigne.equals(autreEnbus.saLigne)) {
				return true;
			}
		}
		return false;
	}

	public static MoyenTransport getInstance(LigneBus l) {
		if (!mesInstances.containsKey(l.nomLigne)) {
			mesInstances.put(l.nomLigne, new EnBus(l));
		}
		return mesInstances.get(l.nomLigne);
	}
}
