package hanoi3;
public class Disque2 extends Disque {

    private int val2;

    public Disque2() {
    }

    public void init(int v) {
	val = v; val2 = 2*v;
    }

    public String toString() {
	return "Disque2[" + val + ", " + val2 + "]";
    }

    /* Une redefinition de compareTo juste pour montrer dans les traces
     * qu'on appelle bien la bonne methode. La methode doit etre compatible
     * avec la version de la super-classe (par exemple si on travaille sur
     * une tour qui melange des instances de Disque et de Disque2)
     */
    public int compareTo(Disque d) {
    	System.out.println("disque2");
    	return val.compareTo(d.val);
    }
}
