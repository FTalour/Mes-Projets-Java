package commun;
import java.rmi.*;

public interface Task<T> extends Remote { 
	public Integer getResult() throws RemoteException, StatusException;
// StatusException est lev�e si r�sultat non disponible 
}
