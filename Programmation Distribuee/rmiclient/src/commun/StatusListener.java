package commun;
import java.rmi.*;

public interface StatusListener<T> extends Remote {
	public void taskExecStarted(TaskEvent<T> event) throws RemoteException; 
	public void taskExecEnded(TaskEvent<T> event) throws RemoteException; 
	public void taskExecCancelled(TaskEvent<T> event) throws RemoteException; 
	public void taskExecError(TaskEvent<T> event) throws RemoteException; 
}
