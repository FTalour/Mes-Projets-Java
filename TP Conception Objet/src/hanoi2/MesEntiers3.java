package hanoi2;
// MesEntiers3 n'implemente *pas* l'interface Empilable. On ne doit donc pas pouvoir s'en servir
// comme disques pour la classe Hanoi.

public class MesEntiers3  {
    Integer val;

    public void init(int nb) {
	val = new Integer(nb);
    }

    public int compareTo(Object v) {
	MesEntiers m = (MesEntiers) v;
	return val.compareTo(m.val);
    }

    public String toString() {
	return "MesEntiers[" + val.intValue() +"]";
    }
}

