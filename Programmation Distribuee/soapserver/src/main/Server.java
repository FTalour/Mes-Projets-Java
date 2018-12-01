package main;
import java.util.Scanner;
import javax.xml.ws.*; 

public class Server {
public static void main(String args[]) {
	try {
		TaskController taskContr = new TaskController();

		Endpoint e = Endpoint.create(taskContr);
		e.publish("http://localhost:8080/taskController");

		System.out.println("Serveur Ok");
		new Scanner(System.in).next();
		
		e.stop();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
