package exercice_CamelClient_CamelFournisseur_AvecXML;

import org.apache.camel.Exchange;

public class Logger {
	public void log(Exchange exchange){
		System.out.println(exchange.getIn().getBody());
	}
}
