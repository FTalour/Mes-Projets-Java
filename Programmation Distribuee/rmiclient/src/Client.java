import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import commun.TaskController;
import commun.TaskID;

public class Client {
public static void main(String args[]) {
try {
	Registry registryClient = LocateRegistry.getRegistry("localhost", 1099);
	TaskController engine = (TaskController) registryClient.lookup("LeTaskController");
		System.out.println("TaskController recuperer");

		StatusListenerImpl<Integer> monStatusListener = new StatusListenerImpl<Integer>();
		TaskImpl<Integer> batch = new TaskImpl<Integer>();
		TaskID ticket = engine.submit(batch, monStatusListener);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
