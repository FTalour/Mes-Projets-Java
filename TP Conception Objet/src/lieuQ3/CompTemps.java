package lieuQ3;

public class CompTemps implements Comparateur {

	public int compare(Trajet arg0, Trajet arg1) {
		Heure hArrivee0 = new Heure();
		Heure hArrivee1 = new Heure();
		try {
			hArrivee0 = arg0.hArrivee();
			hArrivee1 = arg1.hArrivee();
		} catch (ErreurTrajet e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hArrivee0.compareTo(hArrivee1);
	}
	

}