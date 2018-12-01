package example.MyQueue;

import javax.jms.Connection ;
import javax.jms.ConnectionFactory ;
import javax.jms.Destination ;
import javax.jms.JMSException;
import javax.jms.Message ;
import javax.jms.MessageConsumer ;
import javax.jms.Session ;
import javax.jms.TextMessage ;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Consumer {
	private ConnectionFactory connectionFactory;
	private Destination destination;
	
	public static void main(String[] args) {
		try {
			Consumer consumer = new Consumer();
			consumer.connect();
			consumer.waitForMessage();
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
		MessageConsumer consumer = session.createConsumer(destination);
		// Réception des messages jusqu’à obtention d’un message non texte
		while (true) {
			Message m = consumer.receive(); //recevoir les messages
			if (m instanceof TextMessage) {
				traiterMessage(m); // traiterMessage( m : TextMessage ) : void
			} else {
				System.out.println("Message of wrong type received");
				break;
			}
		}
		// Fermeture de la connexion
		connection.close();
	}
	/**
	 * traiterMessage( m : TextMessage ) : void
	 * @param m
	 */
	private void traiterMessage(Message m) {
		System.out.println("Message reçu : ");
		try {
			System.out.println(((TextMessage) m).getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		destination = (Destination) jndiContext.lookup("MyQueue1");
	}
}