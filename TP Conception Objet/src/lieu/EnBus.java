package lieu;

public class EnBus extends MoyenTransport {
    private LigneBus saLigne;

    public EnBus(LigneBus l) { saLigne = l; }

    public String toString() {
    	return "Ligne Bus [" + saLigne.nom() + "]";
    }
    
    public Heure attente(Lieu l1, Lieu l2, Heure dep) throws ErreurTrajet {
    	if(l1 instanceof Arret && l2 instanceof Arret){
        	return saLigne.attente((Arret)l1, dep);
    	}
    	throw new ErreurTrajet("Les lieux donnés à attente dans EnBus ne sont pas des Arret");
    }

    public Heure duree(Lieu l1, Lieu l2, Heure dep) throws ErreurTrajet {
    	if(l1 instanceof Arret && l2 instanceof Arret){
    		return saLigne.dureeEnBus((Arret)l1, (Arret)l2);
    	}
    	throw new ErreurTrajet("Les lieux donnés à duree dans EnBus ne sont pas des Arret");
    }

    public boolean estPossible(Lieu l1, Lieu l2, Heure dep) {
    	if(l1 instanceof Arret && l2 instanceof Arret){
    		Arret a1 = (Arret)l1, a2 = (Arret)l2;
    		return saLigne.estPossible(a1, a2, dep);
    	}
    	else return false;
    }

	public static MoyenTransport getInstance(LigneBus l2) {
		MoyenTransport nouveauMoyenTransport = new EnBus(l2);
		return nouveauMoyenTransport;
	}
}
