package hanoi1;

public class HanoiNommee extends Hanoi {

    public HanoiNommee(int nb) {
	super(nb); // On va ecraser le resultat. Il aurait fallu
		   // un constructeur sans argument !
	depart = new TourNommee(nb, "Depart");
	milieu = new TourNommee(nb, "Milieu");
	arrivee = new TourNommee(nb, "Arrivee");
	try {
	    depart.remplir(nb);
	} catch (ErreurPile e) {}
    }

    public void affiche() {
	depart.affiche(); milieu.affiche(); arrivee.affiche();
    }

    static public void main (String[] args) {

	HanoiNommee H = new HanoiNommee(6);
	H.jouer();
	System.out.println("Situation finale:"); H.affiche();
    }
}
