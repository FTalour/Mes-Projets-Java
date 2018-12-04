package tp2.geometrie;

import java.awt.Color;
import java.awt.Point;

@SuppressWarnings("unused")
public class Rectangle extends Forme {
	
	private Point sommet;
	private int largeur, hauteur;
	
	public Rectangle(Color couleur, Point sommet, int largeur, int hauteur ) {
		super(new Point(sommet.x+(largeur)/2,sommet.y+(hauteur)/2), couleur);
		this.sommet=sommet;
		this.largeur=largeur;
		this.hauteur=hauteur;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void homothetie(int ratio) {
		// TODO Auto-generated method stub
		largeur*=ratio;
		hauteur*=ratio;
	}
	
	@Override
	public String toString() {
		return ("[Rectangle \n   [centre de gravite : x=" + super.getCentre().x + ", y=" + super.getCentre().y + "]\n   [hauteur : " + hauteur +"]\n   [largeur : "+ largeur +"]\n   [couleur : r=" + super.getCouleur().getRed() + " , g=" + super.getCouleur().getGreen() + " , b=" + super.getCouleur().getBlue() + "]\n]");
	}

	/**
	* Le programme principal.
	* @param args les arguments du programme principal
	*/
	public static void main(String[] args) {
		Point sommet = new Point(0, 0);
		Rectangle r= new Rectangle(new Color(25,25,25), sommet, 5, 5);
		System.out.println(r);
	}
}
