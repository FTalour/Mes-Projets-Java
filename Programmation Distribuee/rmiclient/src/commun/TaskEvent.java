package commun;
import java.util.Date;
import java.io.Serializable;

public class TaskEvent<T> implements Serializable { 
	public final TaskID id; 
	public final Date date; 
	public final T result; 
 
	
	private static final long serialVersionUID = 321L;
	
	public TaskEvent( TaskID id, Date date, T result) { 
		this.id = id; 
		this.date = date;
		this.result = result;
	} 
} 
