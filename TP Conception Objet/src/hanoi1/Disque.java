package hanoi1;

// On utilise la version "non generique" de Comparable

@SuppressWarnings("rawtypes")
public class Disque implements Comparable {
    private int val;

    public Disque (int v) {
	val = v;
    }

    public String toString() {
	return "Disque[" + val + "]";
    }

    public int compareTo(Object v) {
		Disque d = (Disque) v;
		if(val > d.val)
			return 1;
		else if(val < d.val)
			return -1;
		else
			return 0;
    }
}
