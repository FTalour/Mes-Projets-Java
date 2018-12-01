package example.MyQueue2;

import javax.jms.Connection ;
import javax.jms.ConnectionFactory ;
import javax.jms.Destination ;
import javax.jms.JMSException;
import javax.jms.Message ;
import javax.jms.MessageConsumer ;
import javax.jms.MessageProducer;
import javax.jms.Session ;
import javax.jms.TextMessage ;
import javax.naming.Context;
import javax.naming.InitialContext;

public class ServiceReverse {
	private ConnectionFactory connectionFactory;
	private Destination destination1;
	private Destination destination2;
	
	public static void main(String[] args) {
		try {
			ServiceReverse consumer = new ServiceReverse();
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
		MessageConsumer consumer = session.createConsumer(destination1);
		MessageProducer producer = session.createProducer(destination2);
		
		// Réception des messages jusqu’à obtention d’un message non texte
		while (true) {
			Message m = consumer.receive(); //recevoir les messages
			String reponse;
			if (m instanceof TextMessage) {
				reponse = traiterMessage(m); // traiterMessage( m : TextMessage ) : void
			} else {
				System.out.println("Message of wrong type received");
				break;
			}
			TextMessage message = session.createTextMessage(reponse);
			// Envoi d'un message
			producer.send(message);
		}
		// Fermeture de la connexion
		connection.close();
	}
	/**
	 * traiterMessage( m : TextMessage ) : void
	 * @param m
	 */
	private String traiterMessage(Message m) {
		System.out.println("Traitement du message reçu : ");
		String reponse = "";
		try {
			System.out.println(((TextMessage) m).getText());
			reponse = reverse(((TextMessage) m).getText());
			return reponse;
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reponse;
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
	
	/**
	 * renvoi la chaine reçu en inversée
	 * @param str
	 * @return
	 */
	public String reverse(String str){
		return new StringBuilder(str).reverse().toString();
	}
}

