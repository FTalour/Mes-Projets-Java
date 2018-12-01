package hanoi3;
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

