package main;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService 
public class StatusListener<T> {  
	public StatusListener() { super(); }
	
	@WebMethod
	public void taskExecStarted(TaskEvent<T> event) { } 
	
	@WebMethod
	public void taskExecEnded(TaskEvent<T> event) { System.out.println(event .result); } 
	
	@WebMethod
	public void taskExecCancelled(TaskEvent<T> event) { } 
	
	@WebMethod
	public void taskExecError(TaskEvent<T> event) { } 
} 
