package tourHanoiGen;

public class Disque implements Empilable<Disque> {
	protected Integer val;

	public Disque() {
	}

	public void init(int v) {
		val = v;
	}

	public String toString() {
		return "Disque[" + val + "]";
	}

	@Override
	public int compareTo(Disque d) {
		return val.compareTo(d.val);
	}
}
