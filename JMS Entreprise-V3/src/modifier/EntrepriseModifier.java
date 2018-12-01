package modifier;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import entreprise.Departement;
import entreprise.Entreprise;
import entreprise.ObjectFactory;

public class EntrepriseModifier {

	public EntrepriseModifier() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JAXBContext context = null;
		Entreprise entreprise = null;
		try {
			context = JAXBContext.newInstance("entreprise");
			Unmarshaller u = context.createUnmarshaller();
			Source source = new StreamSource("entreprise_xsd_V3.xml");
			JAXBElement<Entreprise> root = u.unmarshal(source, Entreprise.class);
			entreprise = root.getValue();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Département sans ajoint:");
		for (Departement dep : entreprise.getDepartements().getDepartement()){
			if(dep.getAdjoint() == null){
				System.out.println(dep.getIntitule());
				dep.setAdjoint("Boule");
			}
		}
		System.out.println("Ajout des ajoints effectués");
		System.out.println("Départements contenant au moins un adjoint:");
		for (Departement dep : entreprise.getDepartements().getDepartement()){
			if(dep.getAdjoint() != null){
				System.out.println(dep.getIntitule());
			}
		}
		
		try {
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.example.org/entreprise entreprise_V3.xsd");
			m.setSchema(
					SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema").newSchema(new File("entreprise_V3.xsd")));
			
			ObjectFactory of = new ObjectFactory();
			JAXBElement<Entreprise> je = of.createEntreprise(entreprise);
			m.marshal(je, new File("newEntreprise.xml"));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
	}

}
