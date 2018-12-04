/**
 * 
 */
/**
 * @author ftalou1
 *
 */
package tp2.exercice1;

import java.awt.Point;
import java.awt.Color;

/**
* Un cercle defini par son centre et son rayon
*/
public class Cercle extends tp2.geometrie.Forme{
	private double rayon;
	/**
	 * Construit un Cercle.
	 * @param c
	 * @param rayon
	 * @param couleur
	 */
	public Cercle(Point c, double rayon, Color couleur) {
		super(c,couleur);
		this.rayon = rayon;
	}
	
	/**
	* Renvoie le centre de ce cercle.
	* @return le centre du cercle.
	*/
	public Point getCentre() {
		Point centre = new Point(super.getCentre());
		return centre;
		//return (Point)this.centre.clone();
	}
	
	/**
	* Renvoie le rayon de ce cercle.
	* @return le rayon de ce cercle.
	*/
	public double getRayon() {
		return rayon;
	}
	
	/**
	* Change le rayon de ce cercle.
	* @param rayon le nouveau rayon
	*/
	public void setRayon(double rayon) {
		this.rayon = rayon;
	}
	
	/**
	* Une description textuelle de ce cercle.
	* @return une chaine de caractere decrivant ce cercle.
	*/
	@Override
	public String toString() {
		return ("[Cercle \n   [centre de gravite : x=" + super.getCentre().x + ", y=" + super.getCentre().y + "]\n   [rayon : " + rayon +"]\n   [couleur : r=" + super.getCouleur().getRed() + " , g=" + super.getCouleur().getGreen() + " , b=" + super.getCouleur().getBlue() + "]\n]");
	}
	
	public void homothetie(int ratio){
		rayon*=ratio;
	}
	
	public void translation(int deplassement_horizontale, int deplassement_verticale){
		super.getCentre().x+=deplassement_horizontale;
		super.getCentre().y+=deplassement_verticale;
	}
	
	/**
	* Le programme principal.
	* @param args les arguments du programme principal
	*/
	public static void main(String[] args) {
		Point p = new Point(0, 0);
		Cercle c= new Cercle(p, 20, new Color(25,25,25));
		System.out.println(c);
	}
	
}