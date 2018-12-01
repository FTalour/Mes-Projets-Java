package database;

public class Airport implements Comparable<Airport> {
	private int id;
	private String name;
	private String city;
	private String country;
	private String FFAouIATA;
	private String ICAO;
	private double latitude;
	private double longitude;
	private int altitude;
	private float timeZone;
	private String DST;
	private String TzTimeZone;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFFAouIATA() {
		return FFAouIATA;
	}

	public void setFFAouIATA(String fFAouIATA) {
		FFAouIATA = fFAouIATA;
	}

	public String getICAO() {
		return ICAO;
	}

	public void setICAO(String iCAO) {
		ICAO = iCAO;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getAltitude() {
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	public float getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(float timeZone) {
		this.timeZone = timeZone;
	}

	public String getDST() {
		return DST;
	}

	public void setDST(String dST) {
		DST = dST;
	}

	public String getTzTimeZone() {
		return TzTimeZone;
	}

	public void setTzTimeZone(String tzTimeZone) {
		TzTimeZone = tzTimeZone;
	}

	@Override
	public String toString() {
		return "Airport [id=" + id + ", name=" + name + ", city=" + city
				+ ", country=" + country + ", FFAouIATA=" + FFAouIATA
				+ ", ICAO=" + ICAO + ", latitude=" + latitude + ", longitude="
				+ longitude + ", altitude=" + altitude + ", timeZone="
				+ timeZone + ", DST=" + DST + ", TzTimeZone=" + TzTimeZone
				+ "]";
	}

	@Override
	public int compareTo(Airport arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId() == this.id)
			return 0;
		else return -1;
	}

}
