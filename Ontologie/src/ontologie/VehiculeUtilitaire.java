package ontologie;

/**
 * classe heritant de Vehicule
 * @author Florian
 *
 */
public class VehiculeUtilitaire extends Vehicule {
	private int capacite;
	
	/**
	 * Constructeur de VehiculeUtilitaire
	 * @param marque
	 * @param modele
	 * @param capacite
	 */
	VehiculeUtilitaire(String marque, String modele, int capacite) {
		super(marque, modele);
		setCapacite(capacite);
	}

	@Override
	public String toString() {
		return "VehiculeUtilitaire [capacite=" + capacite + ", toString()="
				+ super.toString() + "]";
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	
}
