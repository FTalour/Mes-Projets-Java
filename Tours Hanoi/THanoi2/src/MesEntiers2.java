public class MesEntiers2 implements Empilable {
    Integer val;

    public MesEntiers2(){
    	val = 0;
    }
    
    public MesEntiers2(int v){
    	val = v;
    }
    
    public void init(int nb) {
	val = new Integer(nb);
    }

    public int compareTo(Object v) {
	MesEntiers2 m = (MesEntiers2) v;
	return val.compareTo(m.val);
    }

    public String toString() {
    	return "MesEntiers2[" + val.intValue() +"]";
     }
}

