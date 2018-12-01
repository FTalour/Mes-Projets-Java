package database;

public class Airline implements Comparable<Airline>{
	private int id;
	private String name;
	private String alias;
	private String IATA;
	private String ICAO;
	private String callSign;
	private String country;
	private String active;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getIATA() {
		return IATA;
	}
	public void setIATA(String iata) {
		IATA = iata;
	}
	public String getICAO() {
		return ICAO;
	}
	public void setICAO(String icao) {
		ICAO = icao;
	}
	public String getCallSign() {
		return callSign;
	}
	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "AirLine [id=" + id + ", name=" + name + ", alias=" + alias
				+ ", IATA=" + IATA + ", ICAO=" + ICAO + ", callSign="
				+ callSign + ", country=" + country + ", active=" + active
				+ "]";
	}
	
	@Override
	public int compareTo(Airline arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId() == this.id)
			return 0;
		else return -1;
	}
	
}
