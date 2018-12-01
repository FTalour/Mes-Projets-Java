package soapClientSide;

import main.TaskController;
import main.TaskControllerService;
import main.TaskID;

public class Client {
public static void main(String args[]) {
try {
	TaskControllerService service = new TaskControllerService();
	TaskController engine = (TaskController) service.getPort(TaskController.class);	

		System.out.println("Serveur atteint");

		StatusListener<Integer> monStatusListener = new StatusListener<Integer>();
		Task<Integer> batch = new Task<Integer>();
		TaskID ticket = engine.submit(batch, monStatusListener);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}}
