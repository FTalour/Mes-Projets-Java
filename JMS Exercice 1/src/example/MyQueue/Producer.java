package example.MyQueue;
import java.util.Scanner ;

import javax.jms.Connection ;
import javax.jms.ConnectionFactory;
import javax.jms.Destination ;
import javax.jms.MessageProducer ;
import javax.jms.Session ;
import javax.jms.TextMessage ;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Producer {
	private ConnectionFactory connectionFactory;
	private Destination destination;
	
	public static void main(String[] args) {
		try {
			Producer producer = new Producer();
			producer.connect();
			producer.sendMessages();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	/**
	 * Créer une connexion au système de messagerie
	 * Emet des messages au fur et à mesure que l’utilisateur les saisit
	 * @throws Exception
	 */
	private void sendMessages() throws Exception {
		// Création d'une Connexion et d'une Session:
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// Création d'un MessageProducer et d'un message de type Text
		MessageProducer producer = session.createProducer(destination);
		
		Scanner sc;
		while(true){
			System.out.println("Entrez un message à envoyer ('Q' pour quitter):");
			sc =  new Scanner(System.in);
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
		destination = (Destination) jndiContext.lookup("MyQueue1");
	}
}