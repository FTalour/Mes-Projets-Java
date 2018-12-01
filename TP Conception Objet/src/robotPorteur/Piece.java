package robotPorteur;

import java.util.ArrayList;

public class Piece {
	int largeur, longueur;
	ArrayList<Objet> mesObjets = new ArrayList<>();
	
	public void lister(){
		for(Objet o : mesObjets){
			System.out.println(o);
		}
	}
}
