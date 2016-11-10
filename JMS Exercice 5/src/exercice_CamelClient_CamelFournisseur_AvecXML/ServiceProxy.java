package exercice_CamelClient_CamelFournisseur_AvecXML;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

public class ServiceProxy {
	public void call(Exchange exchange){
		String text = exchange.getIn().getBody(String.class);
		System.out.println("Message reçu " + text);
		
		float prix = GetPrix(text);
		
		exchange.getIn().setBody(Float.toString(prix));
		Message message = exchange.getIn();
		exchange.setOut(message);
		exchange.getOut().setHeader("JMSCorrelationID", exchange.getIn().getHeader("JMSCorrelationID"));;
		
		System.out.println("Message renvoyé " + message.getBody());
		System.out.println("Son correlationID est: " + exchange.getIn().getHeader("JMSCorrelationID"));
	}
	

	public static float GetPrix(String idProduit) {
		return 5.0f;
	}
}
