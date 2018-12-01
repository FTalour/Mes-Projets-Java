package modifier;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.SchemaFactory;

import commande.Commande;

public class CommandeModifier {

	public CommandeModifier() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JAXBContext context = null;
		Commande c = null;
		try {
			context = JAXBContext.newInstance("commande");
			Unmarshaller u = context.createUnmarshaller();
			c = (Commande) u.unmarshal(new File("maCommande.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Nombre de Produits: " + c.getProduits().getProduit().size());
		
		c.getProduits().getProduit().get(0).setPrix(5);
		c.getProduits().getProduit().get(1).setPrix(2);
		System.out.println("Prix du premier produit: " + c.getProduits().getProduit().get(0).getPrix());
		System.out.println("Prix du deuxième produit: " + c.getProduits().getProduit().get(1).getPrix());
		
		try {
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.example.org/commande commande.xsd");
			m.setSchema(
					SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema").newSchema(new File("commande.xsd")));
			m.marshal(c, System.out);
					
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
	}

}
