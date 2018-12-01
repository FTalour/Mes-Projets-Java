package soapClientSide;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService 
public class Task<T> implements Runnable {
	Integer result;
	@WebMethod
	public void run() { 
	// ... traitements ...
	result = 1; 
	} 

	@WebMethod
	public Integer getResult() throws StatusException{ 
	 		if ( result == null ) throw new StatusException(); 
	 		return result;
	} 
}

