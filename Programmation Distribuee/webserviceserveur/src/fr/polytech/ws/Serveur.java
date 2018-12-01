package fr.polytech.ws;

import java.util.Date;
import java.util.Scanner;

import javax.xml.ws.Endpoint;

public class Serveur {

	public static void main(String[] args) {
		Envoi envoi = new Envoi();
		Endpoint e = Endpoint.create(envoi);
		e.publish("http://localhost:9516/envoi");
		
		Catalogue catalogue = envoi.getCatalogue();
		
		Article art = new Article(1,"Drill", 12.99, null);
		Article art2 = new Article(2,"Canard en plastique", 2.99, new Date(2016,4,9));
		Article art3 = new Article(3,"Bonbon", 0.99, null);
		catalogue.addArt(art);
		catalogue.addArt(art2);
		catalogue.addArt(art3);
		
		
		System.out.println("> Serveur prêt");
		System.out.println("  ------------");
		System.out.println("> Saisir n'importe quoi puis Entrée pour éteindre");
		System.out.println("  -----------------------------------------------");
		System.out.print(  "> ");
		
		new Scanner(System.in).next();
		e.stop();
	}

}
