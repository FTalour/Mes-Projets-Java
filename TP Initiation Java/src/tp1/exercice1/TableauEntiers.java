package TP1.exercice1;

import java.lang.String;
import java.util.Arrays;

public class TableauEntiers
{
	
	public static int[] tableauDeChaineEnEntier(String[] tableauChaine) {

		int [] tableauEntier=new int[tableauChaine.length];
		
		for(int i=0; i<tableauChaine.length ;i++){
			try{
				tableauEntier[i]=Integer.parseInt(tableauChaine[i]);
			}
			catch(NumberFormatException e){
				System.err.println("Valeur incorrecte convertie en 0: ('"
						+tableauChaine[i]+"')");
				tableauEntier[i]=0;
			}
		}
		return tableauEntier;
	}
	
	public static int getValeurMaximale (int[] tableauEntier){
		if(tableauEntier.length==0){
			System.err.println("tableau vide ! Retourne : " + Integer.MIN_VALUE);
			return Integer.MIN_VALUE;
		}
		int valMax=tableauEntier[0];
		for(int i=1; i<tableauEntier.length; i++)
			valMax=Math.max(valMax,tableauEntier[i]);
		
		return valMax;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = TableauEntiers.tableauDeChaineEnEntier(args);
		System.out.println(Arrays.toString(test));
	/*	test.getChaine();
		test.getTableauEntier();
		System.out.print(test.getChaine());
		System.out.print(test.getTableauEntier());*/
	}
	
}
