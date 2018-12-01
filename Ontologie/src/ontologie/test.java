package ontologie;

import java.lang.String;

public class test {
	public static void main(String[] args) {
		// deux personnes
		Personne anne = new Personne("anne");
		System.out.println(anne.toString());
		Personne jean = new Personne("jean");
		System.out.println(jean.toString());
		Personne pierre = new Personne("pierre");
		System.out.println(pierre.toString());

		
		TypeLogement _2_pieces = TypeLogement._2_PIECES;
		TypeLogement _3_pieces = TypeLogement._3_PIECES;
		TypeLogement maison = TypeLogement.MAISON;
		TypeLogement studio = TypeLogement.STUDIO;
		
		//quatre logements
		Logement logementAnne = new Logement(_2_pieces, "adresseAnne");
		Logement logementJean = new Logement(_3_pieces, "adresseJean");
		Logement logementJean2 = new Logement(maison, "adresseJean2");
		Logement logementPierre = new Logement(studio, "adressePierre");

		VehiculeTourismeEco v0 = new VehiculeTourismeEco("Volvo", "T0", 60);
		System.out.println(v0);
		VehiculeTourisme v1 = new VehiculeTourisme("Citroen", "T1", 120);
		System.out.println(v1);
		VehiculeTourismeEco v2 = new VehiculeTourismeEco("Volkswagen", "T2", -20);
		System.out.println(v2);
		VehiculeUtilitaire v3 = new VehiculeUtilitaire("Citroen", "T3", 150);
		System.out.println(v3);
		VehiculeTourisme v4 = new VehiculeTourisme("Volvo", "T4", 120);
		System.out.println(v4);
		VehiculeUtilitaire v5 = new VehiculeUtilitaire("Volkswagen", "T5", 180);
		System.out.println(v5);
		VehiculeTourisme v6 = new VehiculeTourisme("Volvo", "T6", 110);
		System.out.println(v6);

		System.out.println("anne et jean ont 1 logement");
		anne.setLogement(logementAnne);
		System.out.println(anne.toString());
		jean.setLogement(logementJean);
		System.out.println(jean.toString());
		
		System.out.println("jean essaie d'acheter un logement sans vendre celui qu'il possede");
		logementJean2.achat(jean);
		System.out.println(jean.toString());
		System.out.println("pierre a aussi un logement");
		pierre.setLogement(logementPierre);
		System.out.println(pierre.toString());
		
		System.out.println("anne a trois vehicules");
		anne.addVehicules(v0);
		anne.addVehicules(v1);
		anne.addVehicules(v3);
		System.out.println(anne.toString());
		
		System.out.println("jean a deux vehicules et partage v1 avec anne");
		jean.addVehicules(v1);
		jean.addVehicules(v2);
		System.out.println(jean.toString());
		
		System.out.println("pierre a trois vehicules");
		pierre.addVehicules(v4);
		pierre.addVehicules(v5);
		pierre.addVehicules(v6);
		System.out.println(pierre.toString());
		
		System.out.println("anne et pierre ont au moins un vehicule de tourisme et un vehicule utilitaire");
		System.out.println(Personne.getPersonneAvecAuMoinsUnVehiculeTourismeEtUnVehiculeUtilitaire());
		
		System.out.println("anne et pierre vendent v1 ils ne l'ont donc plus");
		System.out.println(v1.vente());
		System.out.println(anne.toString());
		System.out.println(jean.toString());
		
		System.out.println("anne essaie d'acheter sa propre voiture");
		v0.achat(anne);
		
		System.out.println("anne vend son logement, elle possede son logement seul");
		System.out.println(logementAnne.vente());
		
		System.out.println("jean vend son logement à anne");
		logementJean.vente(anne);
		System.out.println(anne);
		System.out.println(jean);
		System.out.println("jean achete logementjean2 qu'il n'avait pas pu acheter");
		logementJean2.achat(jean);
		System.out.println(anne);
		System.out.println(jean);
	};
}
