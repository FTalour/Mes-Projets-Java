package tp4.exercice1;


import java.util.Set;
import java.util.TreeSet;


//Comparable<T> -> Comparable<DoubletComparable>
//Comparator<T> -> Comparator<DoubletComparable>
public class DoubletComparable extends Doublet implements Comparable<DoubletComparable>{

	public DoubletComparable(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public int compareTo(DoubletComparable doubletComparable) {
		// TODO Auto-generated method stub
		if(this.produit()>doubletComparable.produit())
			return 1;
		else if(this.produit()<doubletComparable.produit())
			return -1;
		else
			return 0;
	}

	public static void main(String[] args) {
		DoubletComparable d1 = new DoubletComparable(2,2);
		DoubletComparable d2 = new DoubletComparable(1,2);
		DoubletComparable d3 = new DoubletComparable(3,2);
		DoubletComparable d4 = new DoubletComparable(6,1);
		DoubletComparable d5 = new DoubletComparable(1,2);
		DoubletComparable d6 = new DoubletComparable(1,9);
		DoubletComparable d7 = new DoubletComparable(4,4);
		
		Set<DoubletComparable> d = new TreeSet<DoubletComparable>(); 
		
		System.out.println(d.add(d1));
		System.out.println(d.add(d2));
		System.out.println(d.add(d3));
		System.out.println(d.add(d4));
		System.out.println(d.add(d5));
		System.out.println(d.add(d6));
		System.out.println(d.add(d7));
		
		/**
		 * true
		 * true
		 * true
		 * false
		 * false
		 * true
		 * true
		 */
		
		System.out.println(d);
		//[( 1,2 ), ( 2,2 ), ( 3,2 ), ( 1,9 ), ( 4,4 )]

		TreeSet<DoubletComparable> ensemble2= new TreeSet<DoubletComparable>(new ComparateurSomme());
		ensemble2.clear();
		System.out.println(ensemble2.add(d1));
		System.out.println(ensemble2.add(d2));
		System.out.println(ensemble2.add(d3));
		System.out.println(ensemble2.add(d4));
		System.out.println(ensemble2.add(d5));
		System.out.println(ensemble2.add(d6));
		System.out.println(ensemble2.add(d7));
		
		System.out.println(d);
		
		return;
	}
	
}
