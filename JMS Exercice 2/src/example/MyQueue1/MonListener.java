package example.MyQueue1;

import javax.jms.*;
public class MonListener implements MessageListener {
	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				String msgText = ((TextMessage) message).getText();
				traiterTexteMessage(msgText);
			}
		} catch (JMSException jmse) {
			jmse.printStackTrace();
		}
	}

	private void traiterTexteMessage(String m) {
		System.out.println("Message reçu : ");
		System.out.println(m);
	}
}
