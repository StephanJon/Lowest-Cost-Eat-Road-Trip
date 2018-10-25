package graph;


import java.io.FileNotFoundException;
import java.util.Vector;

import ReadWrite.EnumCity;
import ReadWrite.EnumRest;
import ReadWrite.Read;

/**
 * CreateGraph is a class that creates a digraph or edgeweighted digraph based with each city in USCities.csv represented as the nodes on the graph
 * with each corresponding to a vertex number based on the enum class EnumCity, and each connecting edge from the connected cities in 
 * connectedcities.txt. The weights for the edgeweighted digraph are represented as cost of a meal from menu.csv, and each cost of meal is only
 * a possible weight for an edge if there exists the type of restaurant offering that meal within 0.5 degrees of latitude and longitude from the city
 * the edge is going to. CreateGraph uses the  columns of and longitude UScities.csv, "burgerking.csv", "mcdonalds.csv", and "wendys.csv" to 
 * compare latitudes and longitudes.
 * 
 * @author Stephanus Jonatan
 */
public class CreateGraph {
	/**
	 * Finds one possible restaurant of every type of restaurant (i.e. McDonalds, Burger King, and Wendys) that is reachable 
	 * from each city and returns the restaurant name with its corresponding latitude and longitude
	 * e.g. Restaurant(latitude, longitude)
	 * 
	 * @param OnlyCities - String array of every city in "USCities.csv"
	 * @param RestLatLong - float 2D array of the Latitude and Longitude of every existing restaurant from csv files read from Read.readRestaurantsInfo()
	 * @param CitiesLatLong - float 2D array of the Latitude and Longitude of every existing city in "USCities.csv"
	 * @param RestaurantsInfo - String 2D array of every existing restaurant and their corresponding data from csv files read from Read.readRestaurantsInfo()
	 * 
	 * @return possibleRestaurants - Each row corresponds to each city in {@code OnlyCities}, and each row holds one possible restaurant of every type of restaurant that is reachable from each city.
	 */
	private static String[][] possibleRestaurants(String[] OnlyCities, float[][] RestLatLong, float[][] CitiesLatLong, String[][] RestaurantsInfo){
		String[][] possibleRestaurants = new String [OnlyCities.length][];
		for (int i = 0; i < possibleRestaurants.length; i++) {
			Vector<String> temp = new Vector<String>();
			for (int j = 0; j < RestLatLong.length; j++) {
				float a = CitiesLatLong[i][0] - RestLatLong[j][0];
				float b = CitiesLatLong[i][1] - RestLatLong[j][1];
				if((Math.abs(a) <= 0.5) && (Math.abs(b) <= 0.5)){
					if (temp.size() == 0) {
						temp.add(RestaurantsInfo[j][2] + "(" + Float.toString(RestLatLong[j][0]) + ", " + Float.toString(RestLatLong[j][1]) + ")");
					} else if (!temp.get(temp.size() - 1).substring(0, temp.get(temp.size() - 1).indexOf("(")).equals(RestaurantsInfo[j][2])) {
						temp.add(RestaurantsInfo[j][2] + "(" + Float.toString(RestLatLong[j][0]) + ", " + Float.toString(RestLatLong[j][1]) + ")");
					}
				}
			}
			String[] copy = new String[temp.size()];
			temp.copyInto(copy);
			possibleRestaurants[i] = copy;
		}
		return possibleRestaurants;
	}
	
//	/**
//	 * Returns all possible menu items for each city based on ever possible restaurant that can be reached for each city
//	 * 
//	 * @return possibleMenu - Each row corresponds to each city, and each row holds all possible menu items for each city
//	 */
//	public static String[][] possibleMenu(String[][] possibleRestaurants, String[][] MenuInfo) {
//		String[][] possibleMenu = new String [possibleRestaurants.length][];
//		for (int i = 0; i < possibleMenu.length; i++) {
//			Vector<String> temp = new Vector<String>();
//			for (int j = 0; j < possibleRestaurants[0].length; j++) {
//				String Restaurant = possibleRestaurants[i][j].substring(0, possibleRestaurants[i][j].indexOf("("));
//				if (Restaurant.equals(EnumRest.MCDONALDS.getRestaurant())) {
//					for (int j2 = 0; j2 < MenuInfo.length; j2++) {
//						if (MenuInfo[j2][0].equals(EnumRest.MCDONALDS.getMenu())) {
//							temp.add(EnumRest.MCDONALDS.getRestaurant());
//							temp.add(MenuInfo[j2][1]);
//							temp.add(MenuInfo[j2][2]);
//						}
//					}
//				} else if (Restaurant.equals(EnumRest.BURGERKING.getRestaurant())) {
//					for (int j2 = 0; j2 < MenuInfo.length; j2++) {
//						if (MenuInfo[j2][0].equals(EnumRest.BURGERKING.getMenu())) {
//							temp.add(EnumRest.BURGERKING.getRestaurant());
//							temp.add(MenuInfo[j2][1]);
//							temp.add(MenuInfo[j2][2]);
//						}
//					}
//				} else if (Restaurant.equals(EnumRest.WENDYS.getRestaurant())) {
//					for (int j2 = 0; j2 < MenuInfo.length; j2++) {
//						if (MenuInfo[j2][0].equals(EnumRest.WENDYS.getMenu())) {
//							temp.add(EnumRest.WENDYS.getRestaurant());
//							temp.add(MenuInfo[j2][1]);
//							temp.add(MenuInfo[j2][2]);
//						}
//					}
//				} 
//			}
//			String[] copy = new String[temp.size()];
//			temp.copyInto(copy);
//			possibleMenu[i] = copy;
//		}
//		return possibleMenu;
//	}
	
	/**
	 * Returns all possible menu item prices for each city based on ever possible restaurant that can be reached for each city
	 * 
	 * @return possibleWeights - Each row corresponds to each city, and each row holds all possible menu item prices for each city
	 */
	private static float[][] possibleWeights(String[][] possibleRestaurants, String[][] MenuInfo) {
		float[][] possibleWeights = new float [possibleRestaurants.length][];
		for (int i = 0; i < possibleWeights.length; i++) {
			Vector<String> temp = new Vector<String>();
			for (int j = 0; j < possibleRestaurants[0].length; j++) {
				String Restaurant = possibleRestaurants[i][j].substring(0, possibleRestaurants[i][j].indexOf("("));
				if (Restaurant.equals(EnumRest.MCDONALDS.getRestaurant())) {
					for (int j2 = 0; j2 < MenuInfo.length; j2++) {
						if (MenuInfo[j2][0].equals(EnumRest.MCDONALDS.getMenu())) {
							temp.add(MenuInfo[j2][2].substring(1));
						}
					}
				} else if (Restaurant.equals(EnumRest.BURGERKING.getRestaurant())) {
					for (int j2 = 0; j2 < MenuInfo.length; j2++) {
						if (MenuInfo[j2][0].equals(EnumRest.BURGERKING.getMenu())) {
							temp.add(MenuInfo[j2][2].substring(1));
						}
					}
				} else if (Restaurant.equals(EnumRest.WENDYS.getRestaurant())) {
					for (int j2 = 0; j2 < MenuInfo.length; j2++) {
						if (MenuInfo[j2][0].equals(EnumRest.WENDYS.getMenu())) {
							temp.add(MenuInfo[j2][2].substring(1));
						}
					}
				} 
			}
			String[] copyString = new String[temp.size()];
			temp.copyInto(copyString);
			float[] copyFloat = new float[copyString.length];
			for (int k = 0; k < copyFloat.length; k++) {
				copyFloat[k] = Float.parseFloat(copyString[k]);
			}
			possibleWeights[i] = copyFloat;
		}
		return possibleWeights;
	}
	
	/**
	 * Adds edges to a digraph depending on every cities adjacency list and their corresponding index in the enum class EnumCity
	 * 
	 * @return digraph - return the resulting digraph with all adges added
	 */
	private static Digraph addEdgesToDigraph(String[][] ConnectCity, Digraph digraph) {
		for (int i = 0; i < ConnectCity.length; i++) {
			for (int j = 0; j < ConnectCity[i].length; j++) {
				digraph.addEdge(i, EnumCity.valueOf(ConnectCity[i][j]).getIndex());
			}
		}
		return digraph;
	}
	
	/**
	 * Adds edges to an edgeweighted digraph depending on every cities adjacency list and their corresponding index in the enum class EnumCity.
	 * Each weight is chosen randomly from all possible weights that each city to adjacent city can have, and implements a continue loop that 
	 * breaks when the previously connected edge has a different weight than the edge being added.
	 * 
	 * @return digraph - return the resulting edgeweighted digraph with all adges added
	 */
	private static EdgeWeightedDigraph addEdgesToEdgeWeightedDigraph(String[][] ConnectCity, float[][] possibleWeights, EdgeWeightedDigraph digraph) {
		boolean[][] marked = new boolean[ConnectCity.length][5];
		for (int i = 0; i < marked.length; i++) {
			for (int j = 0; j < marked[i].length; j++) {
				marked[i][j] = false;
			}
		}
		for (int i = 0; i < ConnectCity.length; i++) {
			for (int j = 0; j < ConnectCity[i].length; j++) {
				EnumCity cityTo = EnumCity.valueOf(ConnectCity[i][j]);
				if (!marked[i][j]) {
					DirectedEdge e = new DirectedEdge(i, cityTo.getIndex(), possibleWeights[cityTo.getIndex()][StdRandom.uniform(possibleWeights[i].length)]);
					Here:
						for (DirectedEdge E : digraph.edges()) {
							if (e.from() == E.to() && e.weight() == E.weight()) {
								e.setWeight(possibleWeights[i][StdRandom.uniform(possibleWeights[cityTo.getIndex()].length)]);
								continue Here;
							}
						}
					digraph.addEdge(e);
					marked[i][j] = true;
				}
			}
		}
		return digraph;
	}
	
	/**
	 * Creates a digraph with edges given an adjacency list
	 * 
	 * @return digraph - returns the finished digraph with all adges added
	 */
	public static Digraph CreateDigraph() throws FileNotFoundException {
		String[][] ConnectCity = Read.readConnectCity();
		
		Digraph digraph = new Digraph(ConnectCity.length);
		Digraph finishedDigraph = addEdgesToDigraph(ConnectCity, digraph);
		return finishedDigraph;
	}
	
	/**
	 * Creates an edgeweighted digraph with edges given an adjacency list
	 * 
	 * @return digraph - returns the finished edgeweighted digraph with all adges added
	 */
	public static EdgeWeightedDigraph CreateEdgeWeightedDigraph() throws FileNotFoundException {
		String[] OnlyCities = Read.readOnlyCities();
		String[][] RestaurantsInfo = Read.readRestaurantsInfo();
		String[][] MenuInfo = Read.readMenuInfo();
		float[][] CitiesLatLong = Read.readCitiesLatLong();
		float[][] RestLatLong = Read.readRestLatLong();
		String[][] ConnectCity = Read.readConnectCity();
		
		EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(OnlyCities.length);
		String[][] possibleRestaurants = possibleRestaurants(OnlyCities, RestLatLong, CitiesLatLong, RestaurantsInfo);
		float[][] possibleWeights = possibleWeights(possibleRestaurants, MenuInfo);
		
		EdgeWeightedDigraph finishedDigraph = addEdgesToEdgeWeightedDigraph(ConnectCity, possibleWeights,digraph);
		return finishedDigraph;
	}
}
