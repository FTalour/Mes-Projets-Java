package robotPorteur;

import java.util.ArrayList;

public abstract class Objet {
	int masse;
	String id;
	int x, y;
	int niveau;
	
	ArrayList<Objet> porte = new ArrayList<>();

	protected void translate(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	public void deplacer(int dx, int dy) throws Exception{
		if(niveau==0){
			this.translate(dx, dy);
		}else{
			throw new Exception();
		}
	}

	public int masseTotale() {
		return masse;
	}

	public void incrNiveau() {
		niveau++;
		y++;
	}
	
	public void decrNiveau(){
		niveau--;
		y--;
	}
}
