/**
 * 
 */
/**
 * @author ftalou1
 *
 */
package tp2.geometrie;

import java.awt.Color;
import java.awt.Point;

public abstract class Forme{
	private Point centre;
	private Color couleur;
	
	public Forme(Point centreGravite, Color couleur) {
		this.centre = centreGravite;
		this.couleur = new Color(25,25,25);
	}

	public void translation(int deplassement_horizontale, int deplassement_verticale){
		centre.x+=deplassement_horizontale;
		centre.y+=deplassement_verticale;
	}
	
	public abstract void homothetie(int ratio);
	
	public Point getCentre(){
		return new Point(centre.x,centre.y);
	}
	
	public Color getCouleur(){
		return new Color(couleur.getRGB());
	}
	
}