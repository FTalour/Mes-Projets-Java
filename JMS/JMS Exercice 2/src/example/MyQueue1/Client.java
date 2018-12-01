package example.MyQueue1;

import java.util.Scanner;

import javax.jms.Connection ;
import javax.jms.ConnectionFactory ;
import javax.jms.Destination ;
import javax.jms.MessageConsumer ;
import javax.jms.MessageProducer;
import javax.jms.Session ;
import javax.jms.TextMessage ;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Client {
	private ConnectionFactory connectionFactory;
	private Destination destination1;
	private Destination destination2;
	
	public static void main(String[] args) {
		try {
			Client client = new Client();
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
		// Création d'une Connexion et d'une Session
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		// Création d'un MessageConsumer
		MessageConsumer consumer = session.createConsumer(destination2); // réponse
		MessageProducer producer = session.createProducer(destination1); // envoi
		
		// Création du listener
		MonListener listener = new MonListener();
		// Mise en liaison
		consumer.setMessageListener(listener);
		
		Scanner sc;
		// Réception des messages jusqu’à obtention d’un message non texte
		while (true) {
			System.out.println("Entrez un message à envoyer ('Q' pour quitter):");
			sc = new Scanner(System.in);
			String msg = sc.nextLine();
			
			if(msg.equalsIgnoreCase("q")){
				break;
			}
			
			TextMessage message = session.createTextMessage(msg);
			// Envoi d'un message
			producer.send(message);
		}
		sc.close();
		
		// Fermeture de la connexion
		connection.close();
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
		destination1 = (Destination) jndiContext.lookup("MyQueue1");
		destination2 = (Destination) jndiContext.lookup("MyQueue2");
	}
}