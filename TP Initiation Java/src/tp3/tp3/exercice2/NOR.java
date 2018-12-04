package tp3.exercice2;

import tp3.exercice3.PorteLogique;

public class NOR extends PorteLogique{
	
	public NOR(boolean entree1, boolean entree2) {
		// TODO Auto-generated constructor stub
		super(entree1, entree2);
	}
	
	public boolean sortie(){
		if(getE1()==true && getE2()==true)
			return true;
		else return false;
	}
	
}
