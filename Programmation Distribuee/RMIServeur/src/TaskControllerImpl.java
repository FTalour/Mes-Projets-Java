import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import commun.StatusException;
import commun.StatusListener;
import commun.Task;
import commun.TaskID;

public class TaskControllerImpl extends UnicastRemoteObject {
	private static final long serialVersionUID = 5744008545767785446L;
	public TaskControllerImpl() throws RemoteException { super(); }
	public <T> TaskID submit(Task<T> task, StatusListener<T> listener) throws RemoteException {
		return null; 
	} 
	public void cancel (TaskID t) throws StatusException, RemoteException { } 
}

