/**
 * 
 */
/**
 * @author ftalou1
 *
 */
package morpion;

/**
 * 
 * @author ftalou1 contient les méthode pour un joueur quelconque
 */
public interface Joueur {

	public abstract String getNom();

	public abstract char getSymbole();

	public abstract int getNumero();

	public abstract void afficherJoueur();

	public abstract int[] tourJoueur(Jeu jeu);

}