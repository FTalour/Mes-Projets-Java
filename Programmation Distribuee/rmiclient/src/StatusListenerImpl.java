import java.rmi.*;
import java.rmi.server.*;

import commun.StatusListener;
import commun.TaskEvent;

public class StatusListenerImpl<T> extends UnicastRemoteObject implements StatusListener<T> { 
	private static final long serialVersionUID = 1244008511467636346L; 
	public StatusListenerImpl() throws RemoteException { super(); }
	public void taskExecStarted(TaskEvent<T> event) throws RemoteException { } 
	public void taskExecEnded(TaskEvent<T> event) throws RemoteException { System.out.println(event .result); } 
	public void taskExecCancelled(TaskEvent<T> event) throws RemoteException { } 
	public void taskExecError(TaskEvent<T> event) throws RemoteException { } 
} 

