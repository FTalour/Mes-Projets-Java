package hanoi2;
@SuppressWarnings("rawtypes")
public class Disque implements Empilable {
	private Integer val;
	
	public Disque(){
		val = 0;
	}
	public Disque(int t){
		val = t;
	}
	
    @Override
    public int compareTo(Object v) {
    	Disque m = (Disque) v;
    	return val.compareTo(m.val);
    }

	@Override
	public void init(int a) {
		val = a;
	}

	public String toString() {
		return "Disque[" + val.intValue() +"]";
	    }

}
