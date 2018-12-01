package lieu;

@SuppressWarnings("serial")
public class ErreurTrajet extends Exception {
	public ErreurTrajet() {
		super();
	}
	
	public ErreurTrajet(String msg) {
		super(msg);
	}
}
