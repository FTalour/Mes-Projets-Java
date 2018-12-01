package robotPorteur;

public abstract class Inerte extends Objet {
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
}
