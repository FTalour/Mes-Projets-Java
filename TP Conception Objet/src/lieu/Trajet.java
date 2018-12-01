package lieu;

import java.util.Collection;
import java.util.ArrayList;

public class Trajet {
	private String nom;
	private Lieu depart;
	private Lieu arrivee;
	private Heure dateDepart;
	private ArrayList<Etape> sesEtapes;

	public Trajet(String n, Lieu dep, Lieu arr, Heure d, ArrayList<Etape> etapes) {
		nom = n;
		depart = dep;
		arrivee = arr;
		dateDepart = d;
		sesEtapes = etapes;
	}

	public String nom() {
		return nom;
	}

	public Lieu depart() {
		return depart;
	}

	public Lieu arrivee() {
		return arrivee;
	}

	public void liste() throws ErreurTrajet, ErreurHeure {
		System.out.println(
				"Trajet " + nom + " de " + depart.nom() + " a " + arrivee.nom() + ", depart a " + dateDepart + " :");
		for (Etape e : sesEtapes)
			e.liste();
	}

	public boolean estCoherent() {
		for (Etape e : sesEtapes) {
			if(!e.estPossible())return false;
		}
		return true;
	}

	public Heure hArrivee() throws ErreurTrajet {
		if(sesEtapes.isEmpty()) return dateDepart;
		Heure hArrivee = new Heure();
		for (Etape etape : sesEtapes){
				hArrivee = etape.hArrivee();
		}
		return hArrivee;
	}

	public Heure duree() throws ErreurTrajet {
		int index=0;
		Heure duree=new Heure();
		for(index=0; index<sesEtapes.size(); index++){
			try {
				duree = duree.add(sesEtapes.get(index).duree());
			} catch (ErreurHeure e) {
				e.printStackTrace();
			}
		}
		return duree;
	}

	public Heure attente() throws ErreurTrajet {
		int index=0;
		Heure attente=new Heure();
		for(index=0; index<sesEtapes.size(); index++){
			try {
				attente = attente.add(sesEtapes.get(index).attente());
			} catch (ErreurHeure e) {
				throw new ErreurTrajet("Probleme avec les horaires");
			}
		}
		return attente;
	}
	
	public int nbChgt() throws ErreurTrajet {
		int i=0;
		int nbChg=1;
		for(i=0; i<sesEtapes.size()-1; i++){
			nbChg ++;
			if(sesEtapes.get(i).moyen() instanceof APieds)
				if(sesEtapes.get(i+1).moyen() instanceof APieds)
					nbChg --;
		}
		return nbChg;
	}

	public static Trajet meilleur(Collection<Trajet> col, Comparateur comp) throws ErreurTrajet {
		Object[] objCol = col.toArray();
		Trajet meilleurTrajet = (Trajet) objCol[0];
		for(Trajet t1 : col){
			for(Trajet t2 : col){
				if(!t1.equals(t2)){
					if(comp.compare(t1, meilleurTrajet)<0){
						meilleurTrajet = t1;
					}
				}
			}
		}
		return meilleurTrajet;
	}
}
