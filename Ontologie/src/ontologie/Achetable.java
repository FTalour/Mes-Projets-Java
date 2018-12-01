package ontologie;

import java.util.ArrayList;

/**
 * Classe regroupant les methodes pour Logement et Vehicule
 * 
 * @author Florian
 *
 */
public abstract class Achetable {
	/**
	 * l'acheteur acquiert le bien Achetable
	 * 
	 * @param acheteur
	 */
	protected void achat(Personne acheteur) {
		if (this instanceof Logement) {
			if (acheteur.getLogement() != null) {
				System.out.println(acheteur.getNom()
						+ " possède déjà un logement");
			} else {
				acheteur.setLogement((Logement) this);
			}
		} else if (this instanceof Vehicule) {
			if (acheteur.getVehicules().contains((Vehicule) this)) {
				System.out.println(acheteur.getNom()
						+ " possède déjà cette voiture");
			} else {
				acheteur.addVehicules((Vehicule) this);
			}
		}
	}

	/**
	 * vend le bien Achetable et retourne le nombre de personnes qui possedaient
	 * ce bien
	 * 
	 * @return
	 */
	protected int vente() {
		int nbPersonne = 0;
		//on verifie ce que l'on vend
		if (this instanceof Logement) {
			//on parcours les personnes
			for (Personne psne : Personne.ensemblePersonnes) {
				//si la personne possede le logement
				if (this.equals(psne.getLogement())) {
					//le logement est vendu et on incrémente le nombre de personnes qui ont vendu ce bien
					psne.setLogement(null);
					nbPersonne++;
				}
			}
		//même chose pour un vehicule
		} else if (this instanceof Vehicule) {
			for (Personne psn : Personne.ensemblePersonnes) {
				ArrayList<Vehicule> psnVehicules = psn.getVehicules();
				if (psnVehicules.contains(this)) {
					psnVehicules.remove((Vehicule) this);
					nbPersonne++;
				}
				
			}
		}

		return nbPersonne;
	}

	public int vente(Personne acheteur) {
		int valeurRetour = vente();
		achat(acheteur);
		return valeurRetour;
	}
}
