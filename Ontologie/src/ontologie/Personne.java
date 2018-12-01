package ontologie;

import java.util.ArrayList;

public class Personne {
	private int noPersonne;
	private String nom = null;
	private static int idSuivant = 1;

	private Logement possedeLogement = null;
	private ArrayList<Vehicule> possedeVehicules = new ArrayList<Vehicule>();

	protected static ArrayList<Personne> ensemblePersonnes = new ArrayList<Personne>();

	/**
	 * constructeur de Personne
	 * @param nom
	 */
	Personne(String nom) {
		setNom(nom);
		setNoPersonne();
		ensemblePersonnes.add(this);
	}

	/**
	 * met à jour le numero de personne et incrément idSuivant pour que chaque
	 * instance de Personne possede un numéro de personne different
	 */
	private void setNoPersonne() {
		noPersonne = idSuivant;
		idSuivant++;
	}

	/**
	 * verife l'egalité entre deux Personnes
	 */
	@Override
	public boolean equals(Object objet) {
		if (objet instanceof Personne) {
			Personne autrePersonne = (Personne) objet;
			if (this.getNoPersonne() == autrePersonne.getNoPersonne())
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Personne [noPersonne=" + noPersonne + ", nom=" + nom
				+ ", logement=" + possedeLogement + ", vehicules="
				+ possedeVehicules + "]";
	}

	public String getNom() {
		return new String(nom);
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNoPersonne() {
		return new Integer(noPersonne);
	}

	public void setNoPersonne(int noPersonne) {
		this.noPersonne = noPersonne;
	}

	public Logement getLogement() {
		return possedeLogement;
	}

	public void setLogement(Logement logement) {
		this.possedeLogement = logement;
	}

	public ArrayList<Vehicule> getVehicules() {
		return possedeVehicules;
	}

	public void setVehicules(ArrayList<Vehicule> vehicules) {
		this.possedeVehicules = vehicules;
	}
	
	
	/**
	 * ajoute un vehicule à la personne
	 * @param vehicule
	 */
	public void addVehicules(Vehicule vehicule) {
		this.possedeVehicules.add(vehicule);
	}
	
	/**
	 * renvoi le nombre de personnes possedant au moins un vehicule de tourisme et un vehicule utilitaire 
	 * @return
	 */
	public static ArrayList<Personne> getPersonneAvecAuMoinsUnVehiculeTourismeEtUnVehiculeUtilitaire() {
		//On crée une liste et deux booléen pour verifier
		ArrayList<Personne> personneAvecAuMoinsUnVehiculeTourismeEtUnVehiculeUtilitaire = new ArrayList<Personne>();
		boolean possedeVehiculeTourisme = false;
		boolean possedeVehiculeUtilitaire = false;
		
		//on parcours les personnes pour les trouver
		for (Personne psne : Personne.ensemblePersonnes) {

			//puis les vehicules pour les trouver
			for (Vehicule vehicule : psne.getVehicules()) {
				//si on trouve un vehicule de tourisme ou utilitaire on retient cette information
				if (vehicule instanceof VehiculeTourisme) {
					possedeVehiculeTourisme = true;
					
				} else if (vehicule instanceof VehiculeUtilitaire) {
					possedeVehiculeUtilitaire = true;
				}
			}
			//si la personne possede les deux types de vehicule on l'ajoute à la liste
			if (possedeVehiculeTourisme && possedeVehiculeUtilitaire) {
				personneAvecAuMoinsUnVehiculeTourismeEtUnVehiculeUtilitaire
						.add(psne);
			}
			
			//on reinitialise les deux indicateurs pour trouver toutes les personnes
			possedeVehiculeTourisme = false;
			possedeVehiculeUtilitaire = false;

		}

		return personneAvecAuMoinsUnVehiculeTourismeEtUnVehiculeUtilitaire;
	}
}
