// Pile Homogene de <T>, de capacity fixee a l'instantiation

public class Pile<T> { 
	private T pile[];
	private int id;
	
    // suppose 'capa' strictement positif !
    //@SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	public Pile(int capacity) {
    	pile = (T[]) new Object[capacity];
    	id = 0;
    }

    public void empiler(T v) throws ErreurPile {
    	if(id >= pile.length){
    		throw new ErreurPile("pile pleine");
    	}else{
    		pile[id++] = v;
    	}
    }

    public T sommet() throws ErreurPile {
    	if(estVide()){
			throw new ErreurPile("pile vide");
   		}else{
   			return pile[id-1];
   		}
    }
    /* supprime l'element en sommet de pile. Leve ErreurPile si la pile est vide */
    public void depiler () throws ErreurPile {
    	if(estVide()){
    		throw new ErreurPile("pile vide");
    	}else{
    		id--;
    	}
    }

    public boolean estVide() {
    	return id <= 0;
    }

    /* renvoie le nombre actuel d'elements dans la pile */
    public int hauteur () {
    	return id;
    }

    /* renvoie la capacity de la pile */
    public int capacity () {
    	return pile.length;
    }

    /* Affiche les elements de la pile (un par ligne) dans l'ordre en commencant par 
	 * l'element en sommet de pile.
	 */
    public void affiche () { 
		for(int i = id-1; i >= 0; i--){
    		System.out.println(i+": "+pile[i]);
    	}
    }
}
