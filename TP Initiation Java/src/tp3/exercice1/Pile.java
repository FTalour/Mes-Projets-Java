/**
 * 
 */
/**
 * @author ftalou1
 *
 */
package TP3.exercice1;

public class Pile<T>{
	protected final int tailleMax;
	protected final int pointeur;
	protected final T[] donnees;
	
	private Pile(T[] tableau, int tailleMax){
		this.tailleMax=tailleMax;
		this.donnees = tableau;
		this.pointeur = 0;
	}
	
	public int getTaille(){
		int length = donnees.length;
		return length;
	}
	
	public int getTailleMax(){
		int tailleMax = this.tailleMax;
		return tailleMax;
	}
	
	public T pop(){
		T donneeRetour = donnees[donnees.length-1];
		donnees[donnees.length-1]=null;
		return donneeRetour;
	}
	
	public T[] push(T valeur){
		if(donnees.length != tailleMax){
			donnees[donnees.length]=valeur;
			return donnees;
		}
		return donnees;
	}
	
	public String toString(){
		int i;
		String stringRetour = "";
		System.out.println(donnees.length-1);
		for(i=donnees.length-1;i>=0;i--){
			stringRetour=stringRetour.concat(donnees[i]+"\n");
		}
		return stringRetour;
	}
	
	public static void main(String[] args){
		Integer Tab[]={1,2,3};
		Pile<Integer> ma_Pile = new Pile<Integer>(Tab,4);
		
		System.out.println(ma_Pile);
		System.out.println(ma_Pile.pop());
		System.out.println(ma_Pile.getTaille());
		System.out.println(ma_Pile.getTailleMax());
	}
}