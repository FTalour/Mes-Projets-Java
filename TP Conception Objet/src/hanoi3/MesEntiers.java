package hanoi3;
class MesEntiers implements Empilable<MesEntiers> {
    Integer val;

    public MesEntiers() {
    }

    public void init(int nb) {
	val = nb;
    }

    public int compareTo(MesEntiers m) {
        System.out.println("MesEntiers.compareTo");
	return val.compareTo(m.val); // compareTo de Integer :-)
    }

    public String toString() {
	return "MesEntiers[" + val +"]";
    }
}

