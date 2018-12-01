package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AirlinesData {
	private FileReader fr;
	private BufferedReader br;

	private String fileName = "airlines.dat";

	private ArrayList<Airline> collectionAirlines;
	
	private HashMap<String, ArrayList<Airline>> hashMapAirlines = new HashMap<String, ArrayList<Airline>>();
	private HashMap<Integer, Airline> hashMapId = new HashMap<Integer, Airline>();
	private HashMap<String, Airline> hashMapIATA = new HashMap<String, Airline>();
	private HashMap<String, Airline> hashMapICAO = new HashMap<String, Airline>();
	
	public AirlinesData() {
		try {
			fr = new FileReader(new File(fileName));
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		parse();
		setHashMapAirlines(collectionAirlines);
		setHashMapIATA(collectionAirlines);
		setHashMapICAO(collectionAirlines);
		setHashMapId(collectionAirlines);
	}

	public void parse() {
		ArrayList<Airline> collectionAirlines = new ArrayList<Airline>();
		ArrayList<String> listeAirlines = new ArrayList<String>();
		
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

				Airline airlines = new Airline();
				
				airlines.setId(Integer.parseInt(att.get(0)));
				airlines.setName(att.get(1));
				if (!airlines.getName().equals(null)) {
					String name = airlines.getName();
					if (listeAirlines.contains(name))
						listeAirlines.add(name);
				}
				airlines.setAlias(att.get(2));
				airlines.setIATA(att.get(3));
				airlines.setICAO(att.get(4));
				airlines.setCallSign(att.get(5));
				airlines.setCountry(att.get(6));
				airlines.setActive(att.get(7));

				collectionAirlines.add(airlines);

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

		setCollectionAirlines(collectionAirlines);

	}
	
	public void setHashMapAirlines(ArrayList<Airline> listeAirlines){
		String tag, nom;
		
		for(Airline airLines : listeAirlines){
			nom = airLines.getName();
			if(!nom.equals(null)){
				for(int i=0; i<4 && i<nom.length(); i++){

					tag = nom.substring(0,i+1);
					ArrayList<Airline> actualListeAirlines;
					
					if (hashMapAirlines.containsKey(tag)) {
						actualListeAirlines = hashMapAirlines.get(tag);
					} else {
						actualListeAirlines = new ArrayList<Airline>();
					}
				
					actualListeAirlines.add(airLines);
					hashMapAirlines.put(tag, actualListeAirlines);
				}
			}
		}
	}
	
	public HashMap<String, ArrayList<Airline>> getHashMapAirlines(){
		return hashMapAirlines;
	}

	public ArrayList<Airline> getCollectionAirlines() {
		return collectionAirlines;
	}

	public void setCollectionAirlines(ArrayList<Airline> collectionAirlines) {
		this.collectionAirlines = collectionAirlines;
	}

	public void setHashMapId(ArrayList<Airline> listeAirLine){
		Integer id;
		
		for(Airline airLine : listeAirLine){
			id = airLine.getId();
			hashMapId.put(id, airLine);
		}
	}
	
	public HashMap<Integer, Airline> getHashMapId(){
		return hashMapId;
	}
	
	public void setHashMapIATA(ArrayList<Airline> listeAirLine){
		String codeIATA;
		
		for(Airline airLine : listeAirLine){
			codeIATA = airLine.getIATA();
			hashMapIATA.put(codeIATA, airLine);
		}
	}
	
	public HashMap<String, Airline> getHashMapIATA(){
		return hashMapIATA;
	}
	
	public void setHashMapICAO(ArrayList<Airline> listeAirLine){
		String codeICAO;
		
		for(Airline airLine : listeAirLine){
			codeICAO = airLine.getICAO();
			hashMapICAO.put(codeICAO, airLine);
		}
	}
	
	public HashMap<String, Airline> getHashMapICAO(){
		return hashMapICAO;
	}
}
