package lieu;

@SuppressWarnings("serial")
public class ErreurHeure extends Exception {
	public ErreurHeure() {
		super();
	}
	
	public ErreurHeure(String msg) {
		super(msg);
	}
}
