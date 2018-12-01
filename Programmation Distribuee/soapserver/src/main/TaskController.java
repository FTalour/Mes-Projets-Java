package main;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService 
public class TaskController { 
	public TaskController() { }
	
	@WebMethod
	public <T> TaskID submit(Task<T> task, StatusListener<T> listener) {
		return null; 
	}
	
	@WebMethod
	public void cancel (TaskID t) throws StatusException { } 
	}
