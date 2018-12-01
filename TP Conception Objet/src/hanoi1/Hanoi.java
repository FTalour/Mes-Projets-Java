package hanoi1;
public class Hanoi {

    protected Tour depart, milieu, arrivee;

    public Hanoi(int nb) {
	depart = new Tour(nb); milieu = new Tour(nb); arrivee = new Tour(nb);
	try {
	    depart.remplir(nb);
	} catch (ErreurPile e) {}
    }

    public void jouer() {
	try {
	    oneStep(depart.capacite(), depart, arrivee, milieu);
	} catch (ErreurTour e) {
	    System.out.println("Erreur de manipulation des Tours: "
			       + e.getMessage());
	} catch (ErreurPile e) {
	    System.out.println("Erreur de manipulation des Piles: "
			       + e.getMessage());
	}
    }

    public void affiche() {
	System.out.println("Depart:"); depart.affiche();
	System.out.println("Milieu:"); milieu.affiche();
	System.out.println("Arrivee:"); arrivee.affiche();
    }

    /* Empiler nb Disque de D vers A en se servant de M comme Tour auxiliaire
     * Le code ci-dessous suppose que la methode sommet() ne depile pas l'element
     * qu'elle renvoie, sinon le depiler qui suit n'a plus lieu d'etre
     */
    protected void oneStep(int nb, Tour D, Tour A, Tour M) throws ErreurPile, ErreurTour {
	if (nb > 0) {
	    oneStep(nb-1, D, M, A);
	    Disque d = (Disque) D.sommet();
	    D.depiler();
	    A.empiler(d);
	    oneStep(nb-1, M, A, D);
	}
    }


    static public void main (String[] args) {
	Hanoi H = new Hanoi(6);
	H.affiche();
	H.jouer();
	System.out.println("Situation finale:"); H.affiche();
    }
}
