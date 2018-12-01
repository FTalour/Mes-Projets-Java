package robotPorteur;

public class SacSable extends Inerte{
	private double tauxPerte;

	@Override
	public void translate(int dx, int dy){
		super.translate(dx, dy);
		if(masse>0){
			masse -= Math.max(0, tauxPerte*Math.sqrt((dx*dx)+(dy*dy))*masse);
		}
	}
}
