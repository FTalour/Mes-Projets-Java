

public class Tour extends Pile {
	
    public Tour(int capa) {
    	super(capa);
    }

    public void remplir(int nb) throws ErreurPile {
	for(; nb > 0; nb--) 
	    this.empiler(new Disque(nb));
    }

    public void empiler(Object v) throws ErreurPile{
    	try{
    		Disque d = (Disque) v;
    		if(hauteur() == 0){
    			super.empiler(v);
    		}else if (d.compareTo(sommet()) <= 0){
    			super.empiler(v);
    		}else{
    			throw new ErreurTour("Element en dessous plus petit");
    		}
    	}catch(ClassCastException e){
    		throw new ErreurTour("Mauvais objet");
    	}
    }
}
