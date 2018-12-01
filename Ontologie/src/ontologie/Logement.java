package ontologie;

public class Logement extends Achetable implements Cloneable {
	private TypeLogement aPourType = null;
	private String adresse = null;

	/**
	 * Constructeur de Logement
	 * 
	 * @param type
	 * @param adresse
	 */
	Logement(TypeLogement type, String adresse) {
		setTypeLogement(type);
		setAdresse(adresse);
	}

	@Override
	public String toString() {
		return "Logement [type=" + aPourType + ", adresse=" + adresse + "]";
	}

	/**
	 * reourne un clone du logement
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Logement logementClone = (Logement) super.clone();
		logementClone.setAdresse(getAdresse());
		logementClone.setTypeLogement(aPourType);

		return logementClone;
	}

	/**
	 * retourne vrai si deux logements sont identiques
	 */
	@Override
	public boolean equals(Object objet) {
		if (objet instanceof Logement) {
			Logement autreLogement = (Logement) objet;
			if (this.getAdresse().equals(autreLogement.getAdresse())
					&& this.getTypeLogement() == autreLogement.getTypeLogement())
				return true;
		}
		return false;
	}

	public TypeLogement getTypeLogement() {
		return aPourType;
	}

	public void setTypeLogement(TypeLogement type) {
		this.aPourType = type;
	}

	public String getAdresse() {
		return new String(adresse);
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}
