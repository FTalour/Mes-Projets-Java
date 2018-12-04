package tp4.exercice1;

import java.util.Comparator;

public class ComparateurSomme implements Comparator<DoubletComparable>{

	public int compare(DoubletComparable d1, DoubletComparable d2) {
		// TODO Auto-generated method stub
		int s1 = d1.somme();
		int s2 = d2.somme();
		if(s1>s2)
			return 1;
		else if(s1<s2)
			return -1;
		else 
			return 0;
	}
	
}