package hanoi2;
@SuppressWarnings("rawtypes")
public class Tour extends Pile {
	
    public Tour(int capa) {
    	super(capa);
    }

    public void remplir(int nb, Class c) throws ErreurPile {
	for(; nb > 0; nb--)
		try {
			Empilable e = (Empilable) c.newInstance();
			e.init(nb);
			this.empiler((e));
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | SecurityException e) {
			throw new ErreurPile("ça a merdé:" + e.getStackTrace());
		}
    }

    @SuppressWarnings("unchecked")
	public void empiler(Object v) throws ErreurPile{
    	try{
    		Empilable e = (Empilable) v;
    		if(hauteur() == 0){
    			super.empiler(v);
    		}else if (e.compareTo(sommet()) <= 0){
    			super.empiler(v);
    		}else{
    			throw new ErreurTour("Element en dessous plus petit");
    		}
    	}catch(ClassCastException e){
    		throw new ErreurTour("Mauvais objet");
    	}
    }
}
