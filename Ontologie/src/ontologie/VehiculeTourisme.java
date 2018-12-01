package ontologie;

public class VehiculeTourisme extends Vehicule {
	private int emissionCO2;

	/**
	 * Constructeur de VehiculeTourisme
	 * @param marque
	 * @param modele
	 * @param emissionCO2
	 */
	VehiculeTourisme(String marque, String modele, int emissionCO2) {
		super(marque, modele);
		setEmissionCO2(emissionCO2);
	}

	@Override
	public String toString() {
		return "VehiculeTourisme [emissionCO2=" + emissionCO2 + ", toString()="
				+ super.toString() + "]";
	}

	public int getEmissionCO2() {
		return new Integer(emissionCO2);
	}

	public void setEmissionCO2(int emissionCO2) {
		this.emissionCO2 = emissionCO2;
	}

}
