package lieu;

public class CompAttente implements Comparateur {

	public int compare(Trajet arg0, Trajet arg1) {
		Heure tempsAttente0 = new Heure();
		Heure tempsAttente1 = new Heure();
		try {
			tempsAttente0 = arg0.attente();
			tempsAttente1 = arg1.attente();
		} catch (ErreurTrajet e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempsAttente0.compareTo(tempsAttente1);
	}
}