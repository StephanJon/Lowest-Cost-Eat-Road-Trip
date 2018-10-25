package ReadWrite;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/**
 * Read is a class that reads files UScities.csv, connectedcities.txt, burgerking.csv, mcdonalds.csv, wendys.csv, and menu.csv provided in the
 * folder 2XB3_A3_DataSets. Read consists of multiple functions that read and return any necessary information for each of the above files in
 * order to create a digraph or edgeweighted digraph in the CreatGraph class under the package graph.
 * 
 * @author Stephanus Jonatan
 */
public abstract class Read{
	
	/**
     * Reads a generic file, splits at every occurring comma, and returns as a 2D string array 
     *
     * @param  filename - the name of the csv file being read.
     * 
     * @return data - returns all rows and columns of the {@code filename}
     */
	private static String[][] readFile(String filename) throws FileNotFoundException{
		Scanner in  = new Scanner(new File(filename));
		List<String[]> lines = new ArrayList<String[]>();
		while(in.hasNextLine()) {
			String line = in.nextLine();
			String[] split = line.split(",");
			lines.add(split);
		} in.close();
		String[][] data = new String[lines.size()][];
		for(int i = 0; i < data.length; i++) { data[i] = lines.get(i); }
		return data;
	}
	
	/**
     * Reads a csv file named "USCities.csv" and returns the data in a 2D string array
     * 
     * @return cities - returns all information of every city
     */
	public static String[][] readCitiesInfo() throws FileNotFoundException {
		String[][] temp = readFile("2XB3_A3_DataSets/USCities.csv");
		String[][] cities = new String[temp.length - 1][];
		for (int i = 0; i < cities.length; i++) {
			cities[i] = temp[i+1];
		}
		return cities;
	}
	
	/**
     * Returns only the city names in USCities.csv
     * 
     * @return onlyCities - returns the city names in USCities.csv
     */
	public static String[] readOnlyCities() throws FileNotFoundException {
		String[][] cities = readCitiesInfo();
		String[] onlyCities = new String[cities.length];
		for (int i = 0; i < onlyCities.length; i++) {
			onlyCities[i] = cities[i][3];
		}
		return onlyCities;
	}
	
	/**
     * Reads csv files burgerking.csv, mcdonalds.csv, and wendys.csv, and returns
     * all information in a 2D string array.
     * 
     * @return restaurantsInfo - returns all exisiting restaurant and corresponding information from csv files burgerking.csv, mcdonalds.csv, and wendys.csv
     */
	public static String[][] readRestaurantsInfo()throws FileNotFoundException {
		String[][] BurgerKing = readFile("2XB3_A3_DataSets/burgerking.csv");
		String[][] McDonalds = readFile("2XB3_A3_DataSets/mcdonalds.csv");
		String[][] Wendys = readFile("2XB3_A3_DataSets/wendys.csv");
		
		String[][] temp = new String[BurgerKing.length + McDonalds.length + Wendys.length][];
		for (int i = 0; i < McDonalds.length; i++) {
			temp[i] = McDonalds[i];
		}
		int count1 = 0;
		for (int j = McDonalds.length; j < McDonalds.length + BurgerKing.length; j++) {
			temp[j] = BurgerKing[count1];
			count1++;
		}
		int count2 = 0;
		for (int k = McDonalds.length + BurgerKing.length; k < BurgerKing.length + McDonalds.length + Wendys.length; k++) {
			temp[k] = Wendys[count2];
			count2++;
		}
		
		String[][] restaurantsInfo = new String[temp.length][temp[0].length];
		for (int i = 0; i < restaurantsInfo.length; i++) {
			restaurantsInfo[i][0] = temp[i][0];
			restaurantsInfo[i][1] = temp[i][1];
			restaurantsInfo[i][2] = temp[i][2].substring(1, temp[i][2].indexOf("-"));
			restaurantsInfo[i][3] = temp[i][3];
			restaurantsInfo[i][4] = temp[i][4];
			restaurantsInfo[i][5] = temp[i][5];
			restaurantsInfo[i][6] = temp[i][6];
		}
		return restaurantsInfo;
	}
	
	/**
     * Reads a csv file "Menu.csv" and returns the two cheapest meals at McDonalds, BurgerKing, 
     * and Wendy's in a 2d string array.
     * 
     * @return menuInfo - returns all menu items and corresponding information in menu.csv
     */
	public static String[][] readMenuInfo()throws FileNotFoundException {
		String[][] menuInfo = Read.readFile("2XB3_A3_DataSets/Menu.csv");
		return menuInfo;
	}
	
	/**
     * Uses the 2D String array generated from readCitiesInfo(), and returns specific information 
     * on the latitude and longitude of each city from USCities.csv in a 2D float array
     * 
     * @return LatLong - returns the latitude and longitude of each city from USCities.csv where each row corresponds to a city in USCities.csv 
     */
	public static float[][] readCitiesLatLong() throws FileNotFoundException{
		String[][] citiesInfo = readCitiesInfo();
		float [][] LatLong = new float[citiesInfo.length][2];
		for (int i = 0; i < LatLong.length; i++) {
			LatLong[i][0] = Float.parseFloat(citiesInfo[i][4]);
			LatLong[i][1] = Float.parseFloat(citiesInfo[i][5]);
		}
		return LatLong;
	}
	
	/**
     * Uses the 2D String array generated from readRestaurants(), and returns specific information 
     * on the latitude and longitude of each Restaurant location from "burgerking.csv", 
     * "mcdonalds.csv", and "wendys.csv" in a 2D float array
     * 
     * @return LatLong - returns the latitude and longitude of each restaurant from burgerking.csv, mcdonalds.csv, and wendys.csv
     */
	public static float[][] readRestLatLong() throws FileNotFoundException{
		String[][] restaurantsInfo = readRestaurantsInfo();
		float [][] LatLong = new float[restaurantsInfo.length][2];
		for (int i = 0; i < LatLong.length; i++) {
			LatLong[i][0] = Float.parseFloat(restaurantsInfo[i][1]);
			LatLong[i][1] = Float.parseFloat(restaurantsInfo[i][0]);
		}
		return LatLong;
	}
	
	/**
     * Reads "connectedCities.txt", uses the 2D String array generated from readOnlyCities(), 
     * and returns the cities that are connected to each respective city in "USCities.csv"
     * in a 2D string array
     * 
     * @return adjacency - returns the adjacency list of each city where each row corresponds to a city
     */
	public static String[][] readConnectCity() throws FileNotFoundException{
		String[][] temp = Read.readFile("2XB3_A3_DataSets/connectedCities.txt");
		String[][] dataConnected = new String[temp.length][temp[0].length];
		for (int i = 0; i < dataConnected.length; i++) {
			dataConnected[i][0] = temp[i][0];
			dataConnected[i][1] = temp[i][1].substring(1);
		}
		String[] dataCities = Read.readOnlyCities();
		String[][] adjacency = new String[dataCities.length][];
		
		for (int i = 0; i < dataCities.length; i++) {
			Vector<String> lines = new Vector<String>();
			String st = dataCities[i];
			String newString = st.replaceAll("[\\s.]", "");
			EnumCity enumCity = EnumCity.valueOf(newString);
			for (int j = 0; j < dataConnected.length; j++) {
				if (dataConnected[j][0].equals(enumCity.getConnected()) && !(dataConnected[j][1].equals(enumCity.getConnected()))) {
					String newString2 = dataConnected[j][1].toUpperCase().replaceAll("[\\s.]", "");
					lines.add(newString2);
				}
			}
			String[] copy = new String[lines.size()];
			lines.copyInto(copy);
			adjacency[i] = copy;
		}
		return adjacency;
	}
	
}
