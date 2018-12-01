package point;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class TestePoint {

    // On pourrait faire col2.containsAll(col1). Cette version permet
    // d'afficher un message si besoin.
    public static boolean testeInclusion(Collection<Point> col1,
					 Collection<Point> col2) {
	for(Point p: col1) {
	    if (! col2.contains(p)) {
		System.out.println("Le point " + p
				   + " est absent de la collection");
		return false;
	    }
	}
	return true;
    }

    public static void main (String[] args) {
	/* TreeSet et HashSet sont deux implementations de l'interface Set.
	 * Un element ne peut donc apparaitre qu'une fois dans un Set
	 * Des instances de classes qui implementent Set sont egales si elles
	 * ont meme taille et si tout element qui apparait dans l'une apparait
	 * aussi dans l'autre.
	 * Ceci est faux pour des collections en general (un 'set' ne peut etre
	 * egal qu'a un autre 'set', de meme qu'une 'list' ne peut etre egale
	 * qu'a une autre 'list')
	 * On utilise aussi une auyre sorte de collection (ArrayList) qui
	 * n'impose pas qu'un element n'apparaisse qu'une fois.
         */
	Collection <Point> col1 = new TreeSet<Point>();
	Collection <Point> col2 = new HashSet<Point>();
	Collection <Point> col3 = new ArrayList<Point>();
	Point[] tab = {
	    new Point(),
	    new Point(3.0, 2.0),
	    new Point(2.0, 5.0),
	    new Point(5.0, 2.0),
	    new Point(3.0, 2.0),
	    new Point()
	};

	/* ajout des Points aux deux collections. L'ajout a col1 oblige a 
	 * utiliser compareTo si la collection n'est pas vide.
	 * Comme tous les points de tab ont des valeurs de hachage differentes
	 * on n'a pas besoin d'utiliser equals de Point. En consequence, col2
	 * aura 6 elements la ou col1 n'en a que 4. Par contre, comme le test
	 * d'appartenance a col1 utilise le compareTo de Point, chacun des 6
	 * elements aura son "equivalent" dans col1.
	 */
	for(Point p : tab) {
	    System.out.println("ajout dans TreeSet");
	    col1.add(p);
	    System.out.println("ajout dans HashSet");
	    col2.add(p);
	    col3.add(p);
	}

	System.out.println("Taille de col1: " + col1.size());
	System.out.println("Taille de col2: " + col2.size());
	System.out.println("Taille de col3: " + col3.size());
	System.out.println(col1);
	System.out.println(col2);
	System.out.println(col3);

	System.out.println("Test d'inclusion du TreeSet dans le HashSet: ");
	System.out.println(testeInclusion(col1, col2) ? "OK" : "KO");

	System.out.println("Test d'inclusion du HashSet dans le TreeSet: ");
	System.out.println(testeInclusion(col2, col1) ? "OK" : "KO");

	System.out.println("Test d'inclusion de HashSet dans ArrayList: ");
	System.out.println(testeInclusion(col2, col3) ? "OK" : "KO");

	System.out.println("Test d'inclusion du ArrayList dans le HashSet: ");
	System.out.println(testeInclusion(col3, col2) ? "OK" : "KO");

	System.out.println("Test d'inclusion de TreeSet dans ArrayList: ");
	System.out.println(testeInclusion(col1, col3) ? "OK" : "KO");

	System.out.println("Test d'inclusion du ArrayList dans le TreeSet: ");
	System.out.println(testeInclusion(col3, col1) ? "OK" : "KO");

	System.out.println("Egalite entre HashSet et TreeSet: ");
	System.out.println(col1.equals(col2) && col2.equals(col1) ? "OK" : "KO");
    }
}

