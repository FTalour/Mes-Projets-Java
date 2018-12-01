package lieu;

import java.util.ArrayList;

public class LigneBus {
	protected String nomLigne;
	protected ArrayList<Arret> sesArrets;
	protected Heure[] sesDeparts;
	protected Heure[] sesTemps;

	public LigneBus(String nom) {
		nomLigne = nom;
	}

	public void addArrets(Arret[] lesArrets) {
		sesArrets = new ArrayList<Arret>();
		for (Arret a : lesArrets) {
			a.ajoutLigne(this);
			sesArrets.add(a);
		}
	}

	public String nom() {
		return nomLigne;
	}

	/*
	 * pour simplifier on suppose que les durees de deplacement sont
	 * independantes de l'heure. Pour definir les horaires il suffit de donner
	 * les heures de depart ainsi que les durees entre 2 arrets successifs. La
	 * dimension du tableau des horaires doit etre egale au nombre d'arrets de
	 * la ligne moins 1.
	 * 
	 * Attention: une ligne de bus est orientee. Les horaires sont donnes dans
	 * le sens de parcours. Si on veut aussi pouvoir parcourir une ligne dans
	 * l'autre sens, il faut creer une deuxieme ligne ! On suppose enfin que les
	 * lignes ne sont pas circulaires,
	 */
	public void ajoutHoraires(Heure[] horaire, Heure[] hdepart) throws ErreurTrajet {
		if (horaire.length != sesArrets.size() - 1) {
			throw new ErreurTrajet("Horaire mal formatte");
		}
		sesDeparts = hdepart;
		sesTemps = horaire;
	}

	public boolean estPossible(Arret a1, Arret a2, Heure dep) {
		for (int i = 0; i < sesDeparts.length - 1; i++) {
			if (sesDeparts[i].compareTo(sesDeparts[i + 1]) > 0) {
				return false;
			}
		}
		return (sesArrets.contains(a1)) && (sesArrets.contains(a2))
				&& (sesDeparts[sesDeparts.length - 1].compareTo(dep) >= 0) && (this != null) && (a1 != a2);
	}

	// On suppose que la duree de transport entre deux arrets ne depend pas
	// de l'heure et qu'on n'arrive jamais le lendemain du jour de depart.
	public Heure dureeEnBus(Arret a1, Arret a2) throws ErreurTrajet {
		Heure duree = new Heure();

		int indexA1 = sesArrets.indexOf(a1);
		int indexA2 = sesArrets.indexOf(a2);

		if (indexA1 == -1 || indexA2 == -1) {
			throw new ErreurTrajet("Un des arrets n'appartient pas aux arrets de la ligne.");
		}

		try {
			for (int index = indexA1; index < indexA2; index++) {
				duree = duree.add(sesTemps[index]);
			}
		} catch (ErreurHeure e) {
			throw new ErreurTrajet("Probleme avec les horaires");
		}
		return duree;
	}

	public Heure attente(Arret a, Heure h) throws ErreurTrajet {
		int indexA = sesArrets.indexOf(a);
		if (indexA == -1)
			throw new ErreurTrajet("L'arret n'appartient pas aux arrets de la ligne.");

		Heure delaiArriverBus = new Heure();
		int i = 0;

		try {
			for (i = 0; i < indexA; i++) {
				delaiArriverBus = delaiArriverBus.add(sesTemps[i]);
			}

			i = 0;
			while (sesDeparts[i].compareTo(h) < 0) {
				i++;
			}
			delaiArriverBus = sesDeparts[i].add(delaiArriverBus);
			return h.delaiAvant(delaiArriverBus);
		} catch (ErreurHeure e) {
			throw new ErreurTrajet("Problème avec les heures");
		}
	}

	public static LigneBus getInstance(String string) {
		LigneBus nouvelleLigneBus = new LigneBus(string);
		return nouvelleLigneBus;
	}
}
