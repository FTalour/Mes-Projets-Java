package robotPorteur;

public class Robot extends Mobile {
	int capacite;

	public int masseTotale() {
		int masseTotale = masse;
		for (Objet o : porte) {
			masseTotale += o.masseTotale();
		}
		return masseTotale;
	}

	@Override
	public void deplacer(int dx, int dy) {
		super.translate(dx, dy);
		for (Objet o : porte) {
			o.translate(dx, dy);
		}
	}

	public int charge() {
		int res = 0;
		for (Objet o : porte) {
			res += o.masseTotale();
		}
		return res;
	}
	
	@Override
	public void incrNiveau(){
		super.incrNiveau();
		for(Objet o : porte){
			o.incrNiveau();
		}
	}
	
	@Override
	public void decrNiveau(){
		super.decrNiveau();
		for(Objet o : porte){
			o.decrNiveau();
		}
	}

	public void charger(Objet o) throws ErreurRobot {
		if ((o.niveau == 0) && (this.niveau == 0) && (o != this) && (capacite >= (o.masseTotale() + this.charge()))) {
			o.incrNiveau();
			porte.add(o);
		} else {
			throw new ErreurRobot("pas possible de charger");
		}
	}
	
	public void decharger(Objet o) throws ErreurRobot {
		if ((o.niveau == 1) && (this.niveau == 0) && (o != this)) {
			o.decrNiveau();
			porte.remove(o);
		} else {
			throw new ErreurRobot("pas possible de decharger");
		}
	}
}
