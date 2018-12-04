package tp2.geometrie;
	
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import tp2.exercice1.Cercle;

public class FormeCollection extends ArrayList<Forme>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Forme> formes = new ArrayList<Forme>();
	
	public FormeCollection(){
	};
	
	public void translation(int deplassement_horizontale, int deplassement_verticale){
		Iterator<Forme> it = formes.iterator();
		while(it.hasNext()){
			it.next().translation(deplassement_horizontale, deplassement_verticale);
		}
	}
	
	public void homothetie(int ratio) {
		Iterator<Forme> it = formes.iterator();
		while(it.hasNext()){
			it.next().homothetie(ratio);
		}
	}
		
	public String toString(){
		String chaineRetour = "";

		Iterator<Forme> it = formes.iterator();
		while(it.hasNext()){
			chaineRetour=chaineRetour.concat(it.next().toString());
		}
		return chaineRetour;
	}
	
	public static void main(String[] args) {
		
		Forme cercle = new Cercle(new Point(0,0), 5, new Color(25,25,25));
		Forme rectangle = new Rectangle(new Color(25,25,25), new Point(0,0), 5, 10);
		Forme carre = new Carre(new Color(25,25,25), new Point(0,0) , 5);
		FormeCollection list = new FormeCollection();
		list.add(cercle);
		list.add(rectangle);
		list.add(carre);
		
		Iterator<Forme> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

		
	}
}
