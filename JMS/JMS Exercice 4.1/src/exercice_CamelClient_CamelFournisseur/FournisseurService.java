package exercice_CamelClient_CamelFournisseur;

import java.util.Scanner;

import javax.jms.ConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class FournisseurService {
	public static ConnectionFactory connectionFactory;

	public static void main(String[] args) {
		try {
			FournisseurService fc = new FournisseurService();
			fc.connect();
			
			CamelContext context = new DefaultCamelContext();
			
			context.addComponent("jms-test",
					JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
			context.addRoutes(new RouteBuilder() {
				public void configure() throws Exception {
					from("jms-test:fournisseur.requestQueue")
					.process(new Processor() {
						public void process(Exchange exchange) throws Exception {
							String text = exchange.getIn().getBody(String.class);
							
							System.out.println("Echange reçu : " + text);
							
							float prix = GetPrix(text.toString());
							
							exchange.getIn().setBody(Float.toString(prix));
							Message message = exchange.getIn();
							
							exchange.setOut(message);
							exchange.getOut().setHeader("JMSCorrelationID", exchange.getIn().getHeader("JMSCorrelationID"));;
							
							System.out.println("Message renvoyé " + message.getBody());
							System.out.println("Son correlationID est: " + exchange.getIn().getHeader("JMSCorrelationID"));
						}
					})
					.to("jms-test:fournisseur.responseQueue");
				}
			});
			context.start();
			
			Scanner sc = new Scanner(System.in);;
			sc.nextLine();
			sc.close();
			
			context.stop();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	/**
	 * Initialise les attributs connectionFactory et destination.
	 * @throws Exception
	 */
	private void connect() throws Exception {
		// Création d'un contexte JNDI
		Context jndiContext = new InitialContext();
		// Lookup de la fabrique de connexion et de la destination
		connectionFactory = (ConnectionFactory) jndiContext.lookup("connectionFactory");
	}
	
	public static float GetPrix(String idProduit) {
		return 5.0f;
	}
	
}
