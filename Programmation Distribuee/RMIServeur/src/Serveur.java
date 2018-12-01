import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import commun.TaskController;

public class Serveur {
public static void main(String args[]) {
try {
		Registry registryServer = LocateRegistry.createRegistry(1099);

		TaskControllerImpl taskContr = new TaskControllerImpl ();
		TaskController stub = (TaskController) UnicastRemoteObject.exportObject(taskContr,0);

		registryServer.rebind("LeTaskController",stub);

		System.out.println("Serveur Ok");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
