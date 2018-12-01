package ontologie;

public class VehiculeTourismeEco extends VehiculeTourisme {
	private int prime;
	
	/**
	 * Constructeur de VehiculeTourismeEco
	 * @param marque
	 * @param modele
	 * @param emissionCO2
	 */
	VehiculeTourismeEco(String marque, String modele, int emissionCO2) {
		super(marque, modele,emissionCO2);
		setEmissionCO2(emissionCO2);
	}
	
	@Override
	public String toString() {
		return "VehiculeTourismeEco [prime=" + prime + ", toString()="
				+ super.toString() + "]";
	}
	
	/**
	 * met à jour les emissions et recalcule la prime à partir de celle-ci
	 */
	@Override
	public void setEmissionCO2(int emissionCO2) {
		//on essai de resoudre la mise à jour par les cas généraux et si on attrape une exception connu on la gère 
		try {
			super.setEmissionCO2(emissionCO2);
			setPrime(calculPrime());
		} catch (UnconformException e) {
			setEmissionCO2(130);
		}
	}
	
	public void setPrime(int prime) {
		this.prime = prime;
	}
	
	public int getPrime() {
		return new Integer(prime);
	}
	
	/**
	 * Calcule la prime à partir des emissions de CO2
	 * @return
	 * @throws UnconformException
	 */
	public int calculPrime() throws UnconformException {
		int emissionCO2=getEmissionCO2();
		// on traite les cas connu
		if (emissionCO2 > 0 && emissionCO2 <= 100) {
			return 1000;
		} else if (emissionCO2 > 100 && emissionCO2 <= 120) {
			return 700;
		} else if (emissionCO2 > 120 && emissionCO2 <= 130)
			return 200;
		else//sinon on envoi vers une exception
			throw new UnconformException();
	}
	
}