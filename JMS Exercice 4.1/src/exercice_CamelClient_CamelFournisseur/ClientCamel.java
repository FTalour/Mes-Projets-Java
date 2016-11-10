package exercice_CamelClient_CamelFournisseur;

import java.util.Scanner;
import java.util.UUID;

import javax.jms.ConnectionFactory ;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.component.jms.JmsConsumer;
import org.apache.camel.component.jms.JmsEndpoint;
import org.apache.camel.impl.DefaultCamelContext;

public class ClientCamel {
	private ConnectionFactory connectionFactory;
	private CamelContext context;
	
	public static void main(String[] args) {
		try {
			ClientCamel client = new ClientCamel();
			client.connect();
			client.waitForMessage();
		} catch (Throwable t) {
			t.printStackTrace() ;
		}
	}
	/**
	 * Créer une connexion au système de messagerie
	t affiche les messages au fur et à mesure de leur arrivée dans la queue
	 * @throws Exception
	 */
	private void waitForMessage() throws Exception {		
		context = new DefaultCamelContext();
		context.addComponent("jms-test",
				JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		context.start();
		ProducerTemplate pt = context.createProducerTemplate();
		pt.start();
		
		JmsEndpoint responseEndPoint = (JmsEndpoint)
				context.getEndpoint("jms-test:fournisseur.responseQueue");
		JmsConsumer consumer = responseEndPoint.createConsumer(new Processor() {
			public void process(Exchange e) throws Exception {
				System.out.println("Réponse reçue : " + e.getIn().getBody());
				System.out.println("Son correlationID est: " + e.getIn().getHeader("JMSCorrelationID").toString());
			}});
		consumer.start();
		
		Scanner sc;
		String msg;
		// Réception des messages jusqu’à obtention d’un message non texte
		while (true) {			
			System.out.println("Entrez le code du produit ('Q' pour quitter):");
			sc = new Scanner(System.in);
			msg = sc.nextLine();
			
			if(msg.equalsIgnoreCase("q")){
				break;
			}
			
			pt.sendBodyAndHeader("jms-test:fournisseur.requestQueue", msg, "JMSCorrelationID", UUID.randomUUID().toString());
		}
		sc.close();
		consumer.stop();
		pt.stop();
		context.stop();
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
}