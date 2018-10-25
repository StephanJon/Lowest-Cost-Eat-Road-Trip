package ReadWrite;

/**
 * EnumCity is an enum class that keeps track of each city in USCities.csv and is mainly used to support the classes graph.CreateGraph
 * and ReadWrite.read.
 * 
 * @author Stephanus Jonatan
 */
public enum EnumCity {
	BOSTON("BOSTON", "Boston", 0), 
	NEWYORKCITY("NEW YORK CITY", "New York City", 1), 
	PHILADELPHIA("PHILADELPHIA", "Philadelphia", 2),
	BALTIMORE("BALTIMORE", "Baltimore", 3),
	WASHINGTON("WASHINGTON", "Washington", 4),
	CHARLOTTE("CHARLOTTE", "Charlotte", 5),
	ATLANTA("ATLANTA", "Atlanta", 6),
	PITTSBURGH("PITTSBURGH", "Pittsburgh", 7),
	COLUMBUS("COLUMBUS", "Columbus", 8),
	INDIANAPOLIS("INDIANAPOLIS", "Indianapolis", 9),
	STLOUIS("ST. LOUIS", "St. Louis", 10),
	KANSASCITY("KANSAS CITY", "Kansas City", 11),
	DENVER("DENVER", "Denver", 12),
	OKLAHOMACITY("OKLAHOMA CITY", "Oklahoma City", 13),
	DALLAS("DALLAS", "Dallas", 14),
	HOUSTON("HOUSTON", "Houston", 15),
	NEWORLEANS("NEW ORLEANS", "New Orleans", 16),
	MEMPHIS("MEMPHIS", "Memphis", 17),
	JACKSONVILLE("JACKSONVILLE", "Jacksonville", 18),
	NASHVILLE("NASHVILLE", "Nashville", 19),
	CHICAGO("CHICAGO", "Chicago", 20),
	MINNEAPOLIS("MINNEAPOLIS", "Minneapolis", 21),
	SALTLAKECITY("SALT LAKE CITY", "Salt Lake City", 22),
	LASVEGAS("LAS VEGAS", "Las Vegas", 23),
	LOSANGELES("LOS ANGELES", "Los Angeles", 24),
	SANFRANCISCO("SAN FRANCISCO", "San Francisco", 25),
	PORTLAND("PORTLAND", "Portland", 26),
	SEATTLE("SEATTLE", "Seattle", 27),
	PHOENIX("PHOENIX", "Phoenix", 28),
	ALBUQUERQUE("ALBUQUERQUE", "Albuquerque", 29),
	SANANTONIO("SAN ANTONIO", "Denver", 30),
	MIAMI("MIAMI", "Miami", 31);
	
	private String USCity = "";
	private String connected = "";
	private int index;
	EnumCity(String UScity, String connect, int ind) {
		this.USCity = UScity;
		this.connected = connect;
		this.index = ind;
	}
	
	/**
	 * Returns the associated city name as it appears in USCities.csv
	 * 
	 * @return this.index - returns the associated city name as it appears in USCities.csv
	 * */
	public String getUSCity() {
		return this.USCity;
	}
	
	/**
	 * Returns the associated city name as it appears in connectedcities.txt
	 * 
	 * @return this.connected - returns the associated city name as it appears in connectedcities.txt
	 */
	public String getConnected() {
		return this.connected;
	}
	
	/**
	 * Returns the associated index number
	 * 
	 * @return this.index - returns the associated index number
	 */
	public int getIndex() {
		return this.index;
	}
	
	public static EnumCity getEnumCity(int index) {
		for (EnumCity city : EnumCity.values()) {
			if (city.getIndex() == index) { return city; }
		}
		throw new IllegalArgumentException("Ensure index is 0-31");
	}
}

