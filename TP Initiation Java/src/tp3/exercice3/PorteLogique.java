package tp3.exercice3;

public abstract class PorteLogique {
	@SuppressWarnings("unused")
	private boolean e1,e2,s;
	
	public PorteLogique(Boolean entreeE1, Boolean entreeE2){
		e1=entreeE1;
		e2=entreeE2;
		s=sortie();
	}

	public boolean getE1(){
		return e1;
	}
	
	public boolean getE2(){
		return e2;
	}
	
	public void setE1(boolean nouvelleEntree){
		e1=nouvelleEntree;
		s=sortie();
	}
	
	public void setE2(boolean nouvelleEntree){
		e2=nouvelleEntree;
		s=sortie();
	}
	
	public abstract boolean sortie();
	
	@Override
	public String toString(){
		String stringRetour;
		stringRetour="Valeur de la premiere entree:"+e1+"\n";
		stringRetour+="Valeur de la deuxieme entree:"+e2+"\n";
		stringRetour+="Valeur de la sortie:"+sortie()+"\n";
		return stringRetour;
	}
	
	public static void main(String[] args){
		
	}
}
