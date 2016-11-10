package tourHanoiGen;
// La classe Tour est elle-meme generique et sous-classe de Pile 
public class Tour<T extends Empilable<? super T>> extends Pile<T> {

	public Tour(int capa) {
		super(capa);
	}

	public void remplir(int nb, Class<T> c) throws ErreurPile {
		for(; nb > 0; nb--)
			try {
				T e = (T) c.newInstance();
				e.init(nb);
				this.empiler((e));
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | SecurityException e) {
				throw new ErreurPile("�a a merd�:" + e.getStackTrace());
			}
	}

	public void empiler(T e) throws ErreurPile{
		try{
			if(hauteur() == 0){
				super.empiler(e);
			}else if (e.compareTo(sommet()) <= 0){
				super.empiler(e);
			}else{
				throw new ErreurTour("Element en dessous plus petit");
			}
		}catch(ClassCastException e2){
			throw new ErreurTour("Mauvais objet");
		}
	}
}
