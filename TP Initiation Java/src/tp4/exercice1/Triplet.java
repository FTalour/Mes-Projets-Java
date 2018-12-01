package TP4.exercice1;


public class Triplet extends Doublet {
	protected int z;
	
	public Triplet(int x, int y, int z){
		super(x,y);
		this.z=z;
	}
	
	public Triplet(Doublet doublet, int z){
		super(doublet);
		this.z=z;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Doublet composé de ");
		sb.append(this.x);
		sb.append("et");
		sb.append(this.y);
		sb.append("et");
		sb.append(this.z);
		sb.append(".");
		
		return  sb.toString();
	}

	public Integer somme() {
		// TODO Auto-generated method stub
		return super.somme()+this.z;
	}

	public Integer produit() {
		// TODO Auto-generated method stub
		return super.produit()*this.z;
	}

	public N_uplet<Integer> ajouter(N_uplet<Integer> n_uplet) {
		// TODO Auto-generated method stub
		Triplet triplet = (Triplet)n_uplet;
		this.x = this.x + triplet.x;
		this.y = this.y + triplet.y;
		this.z = this.z + triplet.z;
		return triplet;
	}

}
