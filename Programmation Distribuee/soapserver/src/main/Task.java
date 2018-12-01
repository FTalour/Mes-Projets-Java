package main;


public class Task<T> implements Runnable { 
	Integer result;
	
	protected Task() {
		// TODO Auto-generated constructor stub
	}
	
	public void run() { 
		// ... traitements ...
		result = 1; 
	} 
	
	public Integer getResult() throws StatusException {
		if ( result == null ) throw new StatusException(); // StatusException est levée si résultat non disponible 
	 	return result;
	}
	
}
