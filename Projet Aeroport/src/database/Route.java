package database;

public class Route implements Comparable<Route>{
	private String airLine;
	private int id;
	private String sourceAirport;
	private int sourceAirportID;
	private String destinationAirport;
	private int destinationAirportID;
	private String codeShare;
	private int stops;
	private String equipment;
	
	public String getAirLine() {
		return airLine;
	}
	public void setAirLine(String airLine) {
		this.airLine = airLine;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSourceAirport() {
		return sourceAirport;
	}
	public void setSourceAirport(String sourceAirport) {
		this.sourceAirport = sourceAirport;
	}
	public int getSourceAirportID() {
		return sourceAirportID;
	}
	public void setSourceAirportID(int sourceAirportID) {
		this.sourceAirportID = sourceAirportID;
	}
	public String getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public int getDestinationAirportID() {
		return destinationAirportID;
	}
	public void setDestinationAirportID(int destinationAirportID) {
		this.destinationAirportID = destinationAirportID;
	}
	public String getCodeShare() {
		return codeShare;
	}
	public void setCodeShare(String codeShare) {
		this.codeShare = codeShare;
	}
	public int getStops() {
		return stops;
	}
	public void setStops(int stops) {
		this.stops = stops;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	
	@Override
	public String toString() {
		return "Route [airLine=" + airLine + ", id=" + id + ", sourceAirport="
				+ sourceAirport + ", sourceAirportID=" + sourceAirportID
				+ ", destinationAirport=" + destinationAirport
				+ ", destinationAirportID=" + destinationAirportID
				+ ", codeShare=" + codeShare + ", stops=" + stops
				+ ", equipment=" + equipment + "]";
	}
	
	@Override
	public int compareTo(Route arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId() == this.id)
			return 0;
		else return -1;
	}
	
}
