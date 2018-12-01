package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AirportsData {
	private FileReader fr;
	private BufferedReader br;

	private String fileName = "airports.dat";
	
	private ArrayList<Airport> collectionAirport;
	
	private HashMap<String, ArrayList<Airport>> hashMapAirport = new HashMap<String, ArrayList<Airport>>();
	private HashMap<String, ArrayList<Airport>> hashMapCountry = new HashMap<String, ArrayList<Airport>>();
	private HashMap<String, ArrayList<Airport>> hashMapCity = new HashMap<String, ArrayList<Airport>>();
	private HashMap<Integer, Airport> hashMapId = new HashMap<Integer, Airport>();

	public AirportsData() {
		try {
			fr = new FileReader(new File(fileName));
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		parse();
		setHashMapAirport(collectionAirport);
		setHashMapCountry(collectionAirport);
		setHashMapCity(collectionAirport);
		setHashMapId(collectionAirport);
	}

	public void parse() {
		ArrayList<Airport> collectionAirport = new ArrayList<Airport>();
		ArrayList<String> listeAirport = new ArrayList<String>();
		ArrayList<String> listeCountry = new ArrayList<String>();
		ArrayList<String> listeCity = new ArrayList<String>();
		
		try {
			String line = br.readLine();
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

				Airport airport = new Airport();
				airport.setId(Integer.parseInt(att.get(0)));
				airport.setName(att.get(1));
				if(!airport.getName().equals(null)){
					String name = airport.getName();
					if(!listeAirport.contains(name))
						listeAirport.add(name);
				}
				airport.setCity(att.get(2));
				if(!airport.getCity().equals(null)){
					String city = airport.getCity();
					if(!listeCity.contains(city))
						listeCity.add(city);
				}
				airport.setCountry(att.get(3));
				if(!airport.getCountry().equals(null)){
					String country = airport.getCountry();
					if(!listeCountry.contains(country))
						listeCountry.add(country);
				}
				airport.setFFAouIATA(att.get(4));
				airport.setICAO(att.get(5));
				airport.setLatitude(Double.parseDouble(att.get(6)));
				airport.setLongitude(Double.parseDouble(att.get(7)));
				airport.setAltitude(Integer.parseInt(att.get(8)));
				airport.setTimeZone(Float.parseFloat(att.get(9)));
				airport.setDST(att.get(10));
				airport.setTzTimeZone(att.get(11));

				collectionAirport.add(airport);

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
		setCollectionAirport(collectionAirport);
		
	}

	public ArrayList<Airport> getCollectionAirport() {
		return collectionAirport;
	}

	public void setCollectionAirport(ArrayList<Airport> collectionAirport) {
		this.collectionAirport = collectionAirport;
	}
	
	public void setHashMapAirport(ArrayList<Airport> listeAirport){
		String tag, nom;
		
		for(Airport airport : listeAirport){
			nom = airport.getName();
			if(!nom.equals(null)){
				for(int i=0; i<4 && i<nom.length(); i++){
					
					tag = nom.substring(0,i+1);
					ArrayList<Airport> actualListeAirport;
					
					if (hashMapAirport.containsKey(tag)) {
						actualListeAirport = hashMapAirport.get(tag);
					} else {
						actualListeAirport = new ArrayList<Airport>();
					}
				
					actualListeAirport.add(airport);
					hashMapAirport.put(tag, actualListeAirport);
				}
			}
		}
	}
	
	public HashMap<String, ArrayList<Airport>> getHashMapAirport(){
		return this.hashMapAirport;
	}
	
	public void setHashMapCountry(ArrayList<Airport> listeAirport){
		String tag, nom;
		
		for(Airport airport : listeAirport){
			nom = airport.getCountry();
			if(!nom.equals(null)){
				for(int i=0; i<4 && i<nom.length(); i++){

					tag = nom.substring(0,i+1);
					ArrayList<Airport> actualListeAirport;
					
					if (hashMapCountry.containsKey(tag)) {
						actualListeAirport = hashMapCountry.get(tag);
					} else {
						actualListeAirport = new ArrayList<Airport>();
					}

					actualListeAirport.add(airport);
					hashMapCountry.put(tag, actualListeAirport);
				}
			}
		}
	}
	
	public HashMap<String, ArrayList<Airport>> getHashMapCountry(){
		return hashMapCountry;
	}
	
	public void setHashMapCity(ArrayList<Airport> listeAirport){
		String tag, nom;
		
		for(Airport airport : listeAirport){
			nom = airport.getCity();
			if(!nom.equals(null)){
				for(int i=0; i<4 && i<nom.length(); i++){

					tag = nom.substring(0,i+1);
					ArrayList<Airport> actualListeAirport;
					
					if (hashMapCity.containsKey(tag)) {
						actualListeAirport = hashMapCity.get(tag);
					} else {
						actualListeAirport = new ArrayList<Airport>();
					}
				
					actualListeAirport.add(airport);
					hashMapCity.put(tag, actualListeAirport);
				}
			}
		}
	}
	
	public HashMap<String, ArrayList<Airport>> getHashMapCity(){
		return hashMapCity;
	}
	
	public void setHashMapId(ArrayList<Airport> listeAirport){
		Integer id;
		
		for(Airport airport : listeAirport){
			id = airport.getId();
			hashMapId.put(id, airport);
		}
	}
	
	public HashMap<Integer, Airport> getHashMapId(){
		return hashMapId;
	}
	
	
}
