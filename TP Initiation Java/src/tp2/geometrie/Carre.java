package TP2.geometrie;

import java.awt.Color;
import java.awt.Point;

@SuppressWarnings("unused")
public final class Carre extends Rectangle {
	
	private Point sommet;
	private int cote;
	
	public Carre(Color couleur, Point sommet, int cote) {
		super(couleur,sommet,cote,cote);
		this.sommet=sommet;
		this.cote=cote;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void homothetie(int ratio) {
		// TODO Auto-generated method stub
		cote*=ratio;
	}
	
	@Override
	public String toString() {
		return ("[Carre \n   [centre de gravite : x=" + super.getCentre().x + " , y=" + super.getCentre().y +"]\n   [cote : " + cote +"]\n   [couleur : r=" + super.getCouleur().getRed() + " , g=" + super.getCouleur().getGreen() + " , b=" + super.getCouleur().getBlue() + "]\n]");
	}
	
	/**
	* Le programme principal.
	* @param args les arguments du programme principal
	*/
	public static void main(String[] args) {
		Point sommet = new Point(0, 0);
		Carre c= new Carre(new Color(25,25,25), sommet, 5);
		System.out.println(c);
	}
	
}
