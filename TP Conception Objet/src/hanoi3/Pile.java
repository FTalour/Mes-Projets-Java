package hanoi3;
// Pile Homogene de <T>, de capacite fixee a l'instantiation

public class Pile<T> { 
	private T pile[];
	private int id;
	
    // suppose 'capa' strictement positif !
    @SuppressWarnings("unchecked")
	public Pile(int capa) {
    	pile = (T[]) new Object[capa];
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

    /* renvoie la capacite de la pile */
    public int capacite () {
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
