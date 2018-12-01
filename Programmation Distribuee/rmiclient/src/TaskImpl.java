
import java.rmi.*;
import java.rmi.server.*;

import commun.StatusException;
import commun.Task;

public class TaskImpl<T> extends UnicastRemoteObject implements Task<T>, Runnable {
	protected TaskImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 7154008772467626546L;
	Integer result;
	
	public void run() { 
		// ... traitements ...
		result = 1; 
	}

	public Integer getResult() throws RemoteException, StatusException {
		if ( result == null ) throw new StatusException(); 
		return result;
	} 

}

