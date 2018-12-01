package lieuQ3;

public class CompChgt implements Comparateur {

	public int compare(Trajet arg0, Trajet arg1) {
		Integer nbChg0 = 0;
		Integer nbChg1 = 0;
		try {
			nbChg0 = arg0.nbChgt();
			nbChg1 = arg1.nbChgt();
		} catch (ErreurTrajet e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nbChg0.compareTo(nbChg1);
	}
	
}

