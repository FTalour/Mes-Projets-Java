package tp2.geometrie;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import tp2.exercice1.Cercle;

public class TestGeometrie {
	public static void main(String[] args) {
		Cercle cercle = new Cercle(new Point(0,0), 5, new Color(25,25,25));
		Rectangle rectangle = new Rectangle(new Color(25,25,25), new Point(0,0), 5, 10);
		Carre carre = new Carre(new Color(25,25,25), new Point(0,0) , 5);
		
		ArrayList<Forme> formes = new ArrayList<Forme>();
		
		formes.add(cercle);
		formes.add(rectangle);
		formes.add(carre);
		
		Iterator<Forme> it = formes.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

		
	}
}
