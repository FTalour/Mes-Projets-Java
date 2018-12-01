package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class RoutesData {
	private FileReader fr;
	private BufferedReader br;

	private String fileName = "routes.dat";

	private ArrayList<Route> collectionRoute;
	//HashMap des numéros de compagnie
	private HashMap<Integer, ArrayList<Route>> hashMapAirLineId = new HashMap<Integer, ArrayList<Route>>();
	//HashMap des IATA ou ICAO des aeroports
	private HashMap<Integer, ArrayList<Route>> hashMapAirportId = new HashMap<Integer, ArrayList<Route>>();
	
	public RoutesData() {
		try {
			fr = new FileReader(new File(fileName));
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		setCollectionRoute(parse());
		setHashMapAirLineId(collectionRoute);
		setHashMapAirportId(collectionRoute);
	}

	public ArrayList<Route> parse() {
		ArrayList<Route> collectionRoute = new ArrayList<Route>();

		String line;
		try {
			line = br.readLine();
			String[] attributes = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

			while (line != null) {
				ArrayList<String> att = new ArrayList<String>();
				for (String s : attributes) {
					s = s.replaceAll("\"","");
					if (!s.equals("\\N"))
						att.add(s);
					else
						att.add(null);
				}

				Route route = new Route();
				route.setAirLine(att.get(0));
				if(att.get(1)==null) route.setId(0);
				else route.setId(Integer.parseInt(att.get(1)));
				route.setSourceAirport(att.get(2));
				if(att.get(3)==null)  route.setSourceAirportID(0);
				else route.setSourceAirportID(Integer.parseInt(att.get(3)));
				route.setDestinationAirport(att.get(4));
				if(att.get(5)==null)  route.setDestinationAirportID(0);
				else route.setDestinationAirportID(Integer.parseInt(att.get(5)));
				route.setCodeShare(att.get(6));
				route.setStops(Integer.parseInt(att.get(7)));
				if(att.size()==7){
					if (att.get(8)==null) route.setEquipment(null);
					else route.setEquipment(att.get(8));
				}
				collectionRoute.add(route);

				att.clear();
				attributes = null;

				line = br.readLine();
				if (line != null)
					attributes = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return collectionRoute;

	}

	public ArrayList<Route> getCollectionRoute() {
		return collectionRoute;
	}

	public void setCollectionRoute(ArrayList<Route> collectionRoute) {
		this.collectionRoute = collectionRoute;
	}
	
	public void setHashMapAirLineId(ArrayList<Route> listeRoute){
		Integer id;
		ArrayList<Route> actualListeRoute;
		
		for(Route route : listeRoute){
			id = route.getId();
			if(hashMapAirLineId.containsKey(id)){
				actualListeRoute = hashMapAirLineId.get(id);
			}
			else
			{
				actualListeRoute = new ArrayList<Route>();
			}
			actualListeRoute.add(route);
			hashMapAirLineId.put(id, actualListeRoute);
		}
	}
	
	public HashMap<Integer, ArrayList<Route>> getHashMapAirLineId(){
		return hashMapAirLineId;
	}
	
	public void setHashMapAirportId(ArrayList<Route> listeRoute){
		Integer idDest, idSource;
		ArrayList<Route> actualListeRoute;
		
		for(Route route : listeRoute){
			idDest = route.getDestinationAirportID();
			idSource = route.getSourceAirportID();
			
			if(hashMapAirportId.containsKey(idDest)){
				actualListeRoute = hashMapAirportId.get(idDest);
				actualListeRoute.add(route);
				hashMapAirportId.put(idDest, actualListeRoute);
			}
			else
			{
				actualListeRoute = new ArrayList<Route>();
				actualListeRoute.add(route);
				hashMapAirportId.put(idDest, actualListeRoute);
			}
			
			
			if(hashMapAirportId.containsKey(idSource)){
				actualListeRoute = hashMapAirportId.get(idSource);
				actualListeRoute.add(route);
				hashMapAirportId.put(idSource, actualListeRoute);
			}
			else
			{
				actualListeRoute = new ArrayList<Route>();
				actualListeRoute.add(route);
				hashMapAirportId.put(idSource, actualListeRoute);
			}
			
//			if(!hashMapAirportId.containsKey(idDest) && !hashMapAirportId.containsKey(idSource))
//			{
//				actualListeRoute = new ArrayList<Route>();
//				actualListeRoute.add(route);
//				hashMapAirportId.put(idDest, actualListeRoute);
//				hashMapAirportId.put(idSource, actualListeRoute);
//			}
//			else 
//			{
//				if(hashMapAirportId.containsKey(idDest)){
//					actualListeRoute = hashMapAirportId.get(idDest);
//					actualListeRoute.add(route);
//					hashMapAirportId.put(idDest, actualListeRoute);
//				}
//				if(hashMapAirportId.containsKey(idSource)){
//					actualListeRoute = hashMapAirportId.get(idSource);
//					actualListeRoute.add(route);
//					hashMapAirportId.put(idSource, actualListeRoute);
//				}
//			}
		}
	}
	
	public HashMap<Integer, ArrayList<Route>> getHashMapAirportId(){
		return hashMapAirportId;
	}
}