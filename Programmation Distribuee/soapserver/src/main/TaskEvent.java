package main;
import java.util.Date;
public class TaskEvent<T> { 
public final TaskID id; 
public final Date date; 
public final T result; 

public TaskEvent( TaskID id, Date date, T result) { 
this.id = id; 
this.date = date;
this.result = result;
} 
} 
