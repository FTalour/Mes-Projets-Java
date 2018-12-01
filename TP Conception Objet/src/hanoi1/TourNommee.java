package hanoi1;

public class TourNommee extends Tour {

    protected String nom;

    public TourNommee(int nb, String n) {
    	super(nb);
    	nom = n;
    }

    /* trace l'empilement de l'element sur la Tour */
    public void empiler(Object d) throws ErreurPile {
    	System.out.println("Empiler sur "+nom+" l'Object "+d);
    	super.empiler(d);
    }

    /* trace le depilement de l'element de la Tour */
    public void depiler() throws ErreurPile {
    	System.out.println("Depiler "+nom);
    	super.depiler();
    }

    public void affiche() {
	System.out.println(nom + ":"); super.affiche();
    }
}
