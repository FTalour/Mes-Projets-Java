package tour.hanoi.gen;
public class TourNommee<T extends Empilable<? super T>> extends Tour<T> {

	protected String nom;

	public TourNommee(int nb, String n) {
		super(nb); nom = n;
	}

	public void affiche() {
		System.out.println(nom + ":"); super.affiche();
	}
}
