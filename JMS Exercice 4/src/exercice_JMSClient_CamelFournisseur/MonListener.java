package exercice_JMSClient_CamelFournisseur;


import javax.jms.*;
public class MonListener implements MessageListener {
	public void onMessage(Message message) {
		try {
			System.out.println("J'ai un message du type : " + getMessageType(message));
			if (message instanceof TextMessage) {
				String msgText = ((TextMessage) message).getText();
				traiterTexteMessage(msgText);
			}
			else if (message instanceof ObjectMessage) {
				Float monMessage = (Float) ((ObjectMessage) message).getObject();
				String msgText = monMessage.toString();
				traiterTexteMessage(msgText);
			}
			System.out.println("Son CorrelationID est: " + message.getJMSCorrelationID());
		} catch (JMSException jmse) {
			jmse.printStackTrace();
			System.out.println("erreur jmse");
		}
	}

	private void traiterTexteMessage(String m) {
		System.out.println("Message reçu : ");
		System.out.println(m);
		System.out.println("Entrez le code du produit ('Q' pour quitter):");
	}
	
	/**
     * Gives you a string identifying the message type
     * @param m a message
     * @return String describing the message type or Message by default
     */
    private String getMessageType(Message m){
            if(m instanceof TextMessage){
                    return "TextMessage";
            }
            else if (m instanceof MapMessage){
                    return "MapMessage";
            }
            else if (m instanceof  BytesMessage){
                    return "BytesMessage";
            }
            else if (m instanceof StreamMessage){
                    return "StreamMessage";
            }
            else if (m instanceof ObjectMessage){
                    return "ObjectMessage";
            }
            else {
                    return "Message";
            }
    }

}
