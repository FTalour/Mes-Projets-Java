import java.util.ArrayList;

// Pour le choix du parametre de genericite, voir le commentaire dans Tour.java
public class Hanoi<T extends Empilable<? super T>>{ 

	protected Tour<T> depart, milieu, arrivee;

	public Hanoi(ArrayList<? extends T> inits) {
		int nb = inits.size();
		depart = new Tour<T>(nb); 
		milieu = new Tour<T>(nb);
		arrivee = new Tour<T>(nb);
		// suppose que la collection a ete creee avec les elements dans l'ordre
		// dans lequel ils doivent etre empiles (du plus grand au plus petit)
		try {
			for(T o: inits) 
				depart.empiler(o);
		} catch (ErreurTour e) {
			System.out.println(e.getMessage());
		} catch (ErreurPile e) {
			System.out.println(e.getMessage());
		}

	}


	public void jouer() {
		try {
			oneStep(depart.capacity(), depart, arrivee, milieu);
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

	// Empiler nb Disque de D vers A en se servant de M comme Tour auxiliaire
	protected void oneStep(int nb, Tour<T> D, Tour<T> A, Tour<T> M) 
			throws ErreurPile {
		if (nb > 0) {
			oneStep(nb-1, D, M, A);
			T c = D.sommet(); /* cast ou pas cast ? */
			A.empiler(c);
			D.depiler();
			oneStep(nb-1, M, A, D);
		}
	}
}
