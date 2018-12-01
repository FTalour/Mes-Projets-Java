package ontologie;

public abstract class Vehicule extends Achetable implements Cloneable {
	private int noSerie;
	private String marque = null;
	private String modele = null;
	private static int idSuivant = 1;

	/**
	 * Constructeur de Vehicule
	 * @param marque
	 * @param modele
	 */
	Vehicule(String marque, String modele) {
		setMarque(marque);
		setModele(modele);
		setNoSerie();
	}

	/**
	 * verife l'egalité entre deux vehicule
	 */
	@Override
	public boolean equals(Object objet) {
		if (objet instanceof Vehicule) {
			Vehicule autrePersonne = (Vehicule) objet;
			if (this.getNoSerie() == autrePersonne.getNoSerie())
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Vehicule [noSerie=" + noSerie + ", marque=" + marque
				+ ", modele=" + modele + "]";
	}

	/**
	 * reourne un clone du Vehicule
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Vehicule vehiculeClone = (Vehicule) super.clone();
		vehiculeClone.setMarque(this.getMarque());
		vehiculeClone.setModele(this.getModele());
		vehiculeClone.noSerie = this.noSerie;

		return vehiculeClone;
	}

	public String getMarque() {
		return new String(marque);
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return new String(modele);
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getNoSerie() {
		return new Integer(noSerie);
	}

	/**
	 * met à jour le numero de serie et incrément idSuivant pour que chaque
	 * instance de Vehicule possede un numéro de serie different
	 */
	public void setNoSerie() {
		this.noSerie = idSuivant;
		idSuivant++;
	}


}
