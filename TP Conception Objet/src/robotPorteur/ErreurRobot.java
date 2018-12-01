package robotPorteur;

@SuppressWarnings("serial")
public class ErreurRobot extends Exception {
	public ErreurRobot(){
		super();
	}
	
	public ErreurRobot(String msg){
		super(msg);
	}
}
