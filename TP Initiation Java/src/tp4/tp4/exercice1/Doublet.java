package tp4.exercice1;


public class Doublet implements N_uplet<Integer> {
	protected int x,y;
	
	public Doublet(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public Doublet(Doublet doublet){
		this(doublet.x,doublet.y);
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("( ");
		sb.append(this.x);
		sb.append(",");
		sb.append(this.y);
		sb.append(" )");
		
		return  sb.toString();
	}

	public Integer somme() {
		// TODO Auto-generated method stub
		return x+y;
	}

	public Integer produit() {
		// TODO Auto-generated method stub
		return x*y;
	}

	public N_uplet<Integer> ajouter(N_uplet<Integer> n_uplet) {
		// TODO Auto-generated method stub
		Doublet doublet = (Doublet)n_uplet;
		return new Doublet(this.x + doublet.x, this.y + doublet.y);
	}

}
