package exercice_CamelClient_CamelFournisseur_AvecXML;

import java.util.Scanner;

import org.apache.camel.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Server {
	static CamelContext context;
	
	public static void main(String[] args) {
		try {			
			@SuppressWarnings("resource")
			ApplicationContext appContext = new ClassPathXmlApplicationContext("camel-server.xml");
			context = (CamelContext) appContext.getBean("camel");
			context.start();
			
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			sc.close();
			
			context.stop();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
