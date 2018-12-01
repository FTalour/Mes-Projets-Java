package database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Gestion {
	private static Scanner sc;

	public static void main(String[] args) {

		AirportsData dataAirports = new AirportsData();

		RoutesData dataRoutes = new RoutesData();

		AirlinesData dataAirlines = new AirlinesData();

		System.out.println(dataAirports.getCollectionAirport().size());
		System.out.println(dataRoutes.getCollectionRoute().size());
		System.out.println(dataAirlines.getCollectionAirlines().size());

		int entree = 0;
		do {
			sc = new Scanner(System.in);
			System.out.println("Tapez 0 pour quitter");
			System.out
					.println("Tapez 1 pour chercher les aeroports ou compagnies commeneant par un nom");
			System.out
					.println("Tapez 2 pour chercher les aeroports dans un pays");
			System.out
					.println("Tapez 3 pour chercher les aeroports dans une ville");
			System.out
					.println("Tapez 4 pour chercher les trajets d'une compagnie");
			System.out
					.println("Tapez 5 pour chercher les trajets d'une compagnie dans un lieu");
			System.out
					.println("Tapez 6 pour chercher les trajets directs entre deux lieux");
			System.out
					.println("Tapez 7 pour chercher les trajets entre deux lieux");

			entree = sc.nextInt();

			if (entree == 1) {
				System.out.println("Entrez la recherche (lieu nom):");
				String recherche = lireConsole();
				String[] elementRecherche = recherche.split(" ", 2);
				System.out.println(RechercheNoms(elementRecherche[0],
						elementRecherche[1], dataAirports, dataAirlines));
			} else if (entree == 2) {
				System.out.println("Entrez un nom de pays:");
				String recherche = lireConsole();
				for (Airport airport : RechercheVillesDesserviesPays(recherche,
						dataAirports, dataRoutes))
					System.out.println(airport);
			} else if (entree == 3) {
				System.out.println("Entrez un nom de ville:");
				String recherche = lireConsole();
				for (Airport airport : RechercheAeroportAppartenantVille(
						recherche, dataAirports))
					System.out.println(airport);
			} else if (entree == 4) {
				System.out.println("Entrez un nom de compagnie:");
				String recherche = lireConsole();
				RechercheRoutesParCompagnie(recherche, dataRoutes,
						dataAirports, dataAirlines);
			} else if (entree == 5) {
				System.out
						.println("Entrez un lieu, un nom et une compagnie (lieu nom):");
				String recherche = lireConsole();
				String[] elementRecherche = recherche.split(" ", 2);
				System.out.println("Entrez un nom de compagnie:");
				String recherche2 = lireConsole();
				RechercheCroiseeLieuCompagnie(elementRecherche[0],
						elementRecherche[1], recherche2, dataRoutes,
						dataAirports, dataAirlines);
			} else if (entree == 6) {
				System.out
						.println("Entrez un premier lieu puis un nom  (lieu nom):");
				String recherche = lireConsole();
				String[] elementRecherche1 = recherche.split(" ", 2);
				System.out
						.println("Entrez un deuxieme lieu puis un nom (lieu nom):");
				recherche = lireConsole();
				String[] elementRecherche2 = recherche.split(" ", 2);

				for (Route route : RechercheVolsDirects(elementRecherche1[0],
						elementRecherche1[1], elementRecherche2[0],
						elementRecherche2[1], dataRoutes, dataAirports,
						dataAirlines)) {
					System.out.println(route);
				}
			} else if (entree == 7) {
				System.out
						.println("Entrez un premier lieu puis un nom  (lieu nom):");
				String recherche = lireConsole();
				String[] elementRecherche1 = recherche.split(" ", 2);
				System.out
						.println("Entrez un deuxieme lieu puis un nom (lieu nom):");
				recherche = lireConsole();
				String[] elementRecherche2 = recherche.split(" ", 2);

				for (Route route : RechercheVolsDirects(elementRecherche1[0],
						elementRecherche1[1], elementRecherche2[0],
						elementRecherche2[1], dataRoutes, dataAirports,
						dataAirlines)) {
					System.out.println(route);
				}
			}

		} while (entree != 0);
	}

	/**
	 * converti les entrees clavier en string
	 * 
	 * @return
	 */
	static String lireConsole() {
		BufferedReader rea = new BufferedReader(
				new InputStreamReader(System.in));
		try {
			String lu = rea.readLine();
			return lu;
		} catch (IOException e) {
			e.printStackTrace();
			return "erreur de lecture";
		}
	}

	/**
	 * Donner la liste des compagnies aeriennes, des aeroports, des villes ou
	 * des pays commeneant par une lettre ou une chaine de caractere donnee (par
	 * exemple, "A" ou "Air F").
	 * 
	 * @param objetRecherche
	 * @param nomRecherche
	 * @param dataAirports
	 * @param dataAirlines
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <E> ArrayList<E> RechercheNoms(String objetRecherche,
			String nomRecherche, AirportsData dataAirports,
			AirlinesData dataAirlines) {

		if (nomRecherche.length() > 4)
			nomRecherche = nomRecherche.substring(0, 4);

		switch (objetRecherche) {
		case "city":
			return (ArrayList<E>) dataAirports.getHashMapCity().get(
					nomRecherche);

		case "country":
			return (ArrayList<E>) dataAirports.getHashMapCountry().get(
					nomRecherche);

		case "airport":
			return (ArrayList<E>) dataAirports.getHashMapAirport().get(
					nomRecherche);

		case "airline":
			return (ArrayList<E>) dataAirlines.getHashMapAirlines().get(
					nomRecherche);

		default:
			return null;
		}
	}

	/**
	 * Donner la liste des villes desservies pour un pays donne
	 * 
	 * @param pays
	 * @param dataAirports
	 * @param dataRoutes
	 * @return
	 */
	public static ArrayList<Airport> RechercheVillesDesserviesPays(String pays,
			AirportsData dataAirports, RoutesData dataRoutes) {
		ArrayList<Airport> listeCountry = dataAirports.getHashMapCountry().get(
				pays.substring(0, 4));
		ArrayList<Airport> listeVillesDesservies = new ArrayList<Airport>();

		for (Airport airport : listeCountry) {
			if (airport.getCountry().equals(pays)) {
				// on a trouve un aeroport du pays
				// il faut verifier qu'il y a une ligne qui part ou qui arrive e
				// celui-ci
				// si le numero IATA ou ICAO correspond au numero IATA ou ICAO
				// d'une ligne aerienne alors ajouter la ville
				// attention a ne l'ajouter qu'une seule fois
				for (Route route : dataRoutes.getCollectionRoute()) {
					// String codeRouteDestination =
					// route.getDestinationAirport();
					// String codeRouteSource = route.getSourceAirport();
					// String codeAirportICAO = airport.getICAO();
					// String codeAirportFFAouIATA = airport.getFFAouIATA();
					//
					// if (codeRouteDestination.equals(codeAirportICAO)
					// || codeRouteDestination
					// .equals(codeAirportFFAouIATA)
					// || codeRouteSource.equals(codeAirportICAO)
					// || codeRouteSource.equals(codeAirportFFAouIATA)) {
					// if (!listeVillesDesservies.contains(airport))
					// listeVillesDesservies.add(airport);
					// }

					if (route.getDestinationAirportID() == airport.getId()
							|| route.getSourceAirportID() == airport.getId()) {
						if (!listeVillesDesservies.contains(airport))
							listeVillesDesservies.add(airport);
					}
				}
			}
		}
		return listeVillesDesservies;
	}

	/**
	 * Donner la liste des aeroports deune ville donnee
	 * 
	 * @param ville
	 * @param dataAirports
	 * @return
	 */
	public static ArrayList<Airport> RechercheAeroportAppartenantVille(
			String ville, AirportsData dataAirports) {
		ArrayList<Airport> listeAirport = new ArrayList<Airport>();

		// liste des aeroports commencant par ville
		ArrayList<Airport> listeCity = dataAirports.getHashMapCity().get(
				ville.substring(0, 4));

		for (Airport airport : listeCity) {
			if (airport.getCity().toLowerCase().equals(ville.toLowerCase())) {
				listeAirport.add(airport);
			}
		}

		return listeAirport;
	}

	/**
	 * Donner la liste des vols effectues par une compagnie aerienne (afficher
	 * leaeroport de depart et leaeroport dearrive dans la console lors des
	 * tests)
	 * 
	 * @param airline
	 * @param dataRoutes
	 * @return
	 */
	public static ArrayList<Route> RechercheRoutesParCompagnie(Airline airline,
			RoutesData dataRoutes) {
		ArrayList<Route> listeRoute = new ArrayList<Route>();
		Integer airlineId = airline.getId();

		listeRoute = dataRoutes.getHashMapAirLineId().get(airlineId);

		return listeRoute;
	}

	/**
	 * Donner la liste des vols effectues par une compagnie aerienne (afficher
	 * leaeroport de depart et leaeroport dearrive dans la console lors des
	 * tests)
	 * 
	 * @param nomAirline
	 * @param dataRoutes
	 * @param dataAirports
	 * @param dataAirlines
	 * @return
	 */
	public static ArrayList<Route> RechercheRoutesParCompagnie(
			String nomAirline, RoutesData dataRoutes,
			AirportsData dataAirports, AirlinesData dataAirlines) {
		ArrayList<Route> listeRoute = new ArrayList<Route>();
		ArrayList<Airline> listeAirlineChercher = new ArrayList<Airline>();

		ArrayList<Airline> listeAirline = RechercheNoms("airline", nomAirline,
				dataAirports, dataAirlines);
		for (Airline airline : listeAirline) {
			if (airline.getName().equals(nomAirline)) {
				listeAirlineChercher.add(airline);
			}
		}
		if (listeAirlineChercher.size() == 1) {
			Integer airlineId = listeAirlineChercher.get(0).getId();
			listeRoute = dataRoutes.getHashMapAirLineId().get(airlineId);
		}

		// for (Route route : listeRoute) {
		// System.out.println(route.getId()
		// + "\nAeroport de depart:"
		// + dataAirports.getHashMapId().get(
		// route.getSourceAirportID())
		// + "\nAeroport d'arriver:"
		// + dataAirports.getHashMapId().get(
		// route.getDestinationAirportID()) + "\n");
		// }

		return listeRoute;
	}

	/**
	 * Donner la liste des vols au depart/e learrive deun lieu donne : aeroport,
	 * ville ou pays
	 */
	public static ArrayList<Route> RechercheRoutes(String lieuRecherche,
			String nomLieu, RoutesData dataRoutes, AirportsData dataAirports,
			AirlinesData dataAirlines) {
		ArrayList<Route> listeRoutes = new ArrayList<Route>();
		ArrayList<Airport> listeAirports = new ArrayList<Airport>();

		switch (lieuRecherche) {
		case "city":
			ArrayList<Airport> listeAirportsDeVille = RechercheAeroportAppartenantVille(
					nomLieu, dataAirports);
			ArrayList<Airport> listeAirportDesservies = RechercheVillesDesserviesPays(
					listeAirportsDeVille.get(0).getCountry(), dataAirports,
					dataRoutes);
			// on constitue la liste des aeroport qui sont Desservies
			for (Airport airport : listeAirportsDeVille) {
				if (listeAirportDesservies.contains(airport)) {
					listeAirports.add(airport);
				}
			}

			for (Airport airport : listeAirports) {
				ArrayList<Route> listeRouteAirport = dataRoutes
						.getHashMapAirportId().get(airport.getId());
				for (Route route : listeRouteAirport) {
					if (!listeRoutes.contains(route)) {
						listeRoutes.add(route);
					}
				}
			}
			break;

		case "country":
			listeAirports = RechercheVillesDesserviesPays(nomLieu,
					dataAirports, dataRoutes);

			for (Airport airport : listeAirports) {
				ArrayList<Route> listeRouteAirport = dataRoutes
						.getHashMapAirportId().get(airport.getId());
				for (Route route : listeRouteAirport) {
					if (!listeRoutes.contains(route)) {
						listeRoutes.add(route);
					}
				}
			}

			break;

		case "airport":
			listeAirports = RechercheNoms("airport", nomLieu, dataAirports,
					dataAirlines);

			for (Airport airport : listeAirports) {
				if (airport.getName().equals(nomLieu)) {
					listeRoutes.addAll(listeRoutes.size(), dataRoutes
							.getHashMapAirportId().get(airport.getId()));
				}
			}
			break;

		default:
			break;
		}

		return listeRoutes;
	}

	/**
	 * Donner la liste des vols en combinant les deux criteres : lieux
	 * (aeroport, ville ou pays) + compagnie aerienne
	 * 
	 * @param lieuRecherche
	 * @param nomLieu
	 * @param nomCompagnie
	 * @param dataRoutes
	 * @param dataAirports
	 * @param dataAirlines
	 * @return
	 */
	public static ArrayList<Route> RechercheCroiseeLieuCompagnie(
			String lieuRecherche, String nomLieu, String nomCompagnie,
			RoutesData dataRoutes, AirportsData dataAirports,
			AirlinesData dataAirlines) {

		ArrayList<Route> listeRoutes = new ArrayList<Route>();

		// Recherche des vols d'une compagnie
		ArrayList<Route> listeRoutesCompagnie = new ArrayList<Route>();
		ArrayList<Airline> listeNomsCompagnie = RechercheNoms("airline",
				nomCompagnie, dataAirports, dataAirlines);
		for (Airline airline : listeNomsCompagnie) {
			if (airline.getName().equals(nomCompagnie)) {
				Airline Compagnie = airline;
				listeRoutesCompagnie = RechercheRoutesParCompagnie(Compagnie,
						dataRoutes);
			}
		}

		// Recherche des vols depuis un lieu
		ArrayList<Route> listeRoutesLieu = new ArrayList<Route>();
		listeRoutesLieu = RechercheRoutes(lieuRecherche, nomLieu, dataRoutes,
				dataAirports, dataAirlines);

		for (Route route : listeRoutesCompagnie) {
			if (listeRoutesLieu.contains(route)) {
				listeRoutes.add(route);
			}
		}

		for (Route route : listeRoutes) {
			System.out.println(route.getId()
					+ "\nAeroport de depart:"
					+ dataAirports.getHashMapId().get(
							route.getSourceAirportID())
					+ "\nAeroport d'arriver:"
					+ dataAirports.getHashMapId().get(
							route.getDestinationAirportID()) + "\n");
		}

		return listeRoutes;
	}

	/**
	 * Donner la liste des vols directs deun lieu e un autre lieu (par exemple,
	 * deune ville a une ville ou deun pays  un pays)
	 * 
	 * @param lieuRecherche
	 * @param nomLieu1
	 * @param nomLieu2
	 * @param dataRoutes
	 * @param dataAirports
	 * @param dataAirlines
	 * @return
	 */
	public static ArrayList<Route> RechercheVolsDirects(String lieuRecherche1,
			String nomLieu1, String lieuRecherche2, String nomLieu2,
			RoutesData dataRoutes, AirportsData dataAirports,
			AirlinesData dataAirlines) {
		ArrayList<Route> listeRoutes = new ArrayList<Route>();

		ArrayList<Route> listeRoutes1 = RechercheRoutes(lieuRecherche1,
				nomLieu1, dataRoutes, dataAirports, dataAirlines);
		ArrayList<Route> listeRoutes2 = RechercheRoutes(lieuRecherche2,
				nomLieu2, dataRoutes, dataAirports, dataAirlines);

		for (Route route : listeRoutes1) {
			if (listeRoutes2.contains(route) && route.getStops() == 0) {
				listeRoutes.add(route);
			}
		}

		return listeRoutes;
	}

	/**
	 * Donner la liste des vols directs deun lieu e un autre lieu (par exemple,
	 * deune ville a une ville ou deun pays a un pays)
	 * 
	 * @param lieuRecherche
	 * @param nomLieu1
	 * @param nomLieu2
	 * @param dataRoutes
	 * @param dataAirports
	 * @param dataAirlines
	 * @return
	 */
	public static ArrayList<Route> RechercheVols(String lieuRecherche1,
			String nomLieu1, String lieuRecherche2, String nomLieu2,
			RoutesData dataRoutes, AirportsData dataAirports,
			AirlinesData dataAirlines) {
		ArrayList<Route> listeRoutes = new ArrayList<Route>();

		ArrayList<Route> listeRoutes1 = RechercheRoutes(lieuRecherche1,
				nomLieu1, dataRoutes, dataAirports, dataAirlines);
		ArrayList<Route> listeRoutes2 = RechercheRoutes(lieuRecherche2,
				nomLieu2, dataRoutes, dataAirports, dataAirlines);

		for (Route route : listeRoutes1) {
			if (listeRoutes2.contains(route)) {
				listeRoutes.add(route);
			}
		}

		return listeRoutes;
	}
}
