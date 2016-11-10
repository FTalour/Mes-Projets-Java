public class Pile<T extends Empilable<T>> {
	private Object[] pile;
	private int id;
	
/* definit une pile d'Object de capacité fixee a l'instantiation */

    public Pile(int capacite) {
    	pile = new Object[capacite];
    	id = 0;
    }

    public void empiler(Object v) throws ErreurPile {
    	if(id >= pile.length){
    		throw new ErreurPile("pile pleine");
    	}else{
    		pile[id++] = v;
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

   /* sommet : renvoie l'element en sommet de pile * sans * le depiler
    * Leve ErreurPile si la pile est vide
    */
   public Object sommet() throws ErreurPile {
	   if(estVide()){
			throw new ErreurPile("pile vide");
   		}else{
   			return pile[id-1];
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
