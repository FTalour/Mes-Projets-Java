package commun;
import java.rmi.*;

public interface TaskController extends Remote { 
	public <T> TaskID submit (Task<T> task, StatusListener<T> listener) throws RemoteException; 
	public void cancel (TaskID t) throws StatusException, RemoteException; 
}
