/**
 * 
 */
/**
 * @author ftalou1
 *
 */
package tp4.exercice1;

// Composant des n-uplet sont des int
@SuppressWarnings("hiding")
public interface N_uplet<Integer>{

	public Integer somme();
	public Integer produit();
	
	public N_uplet<Integer> ajouter(N_uplet<Integer> n_uplet);
	
}