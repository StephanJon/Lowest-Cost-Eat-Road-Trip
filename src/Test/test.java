package Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Vector;

import ReadWrite.EnumCity;
import ReadWrite.Read;
import ReadWrite.Write;
import graph.BreadthFirstDirectedPaths;
import graph.CreateGraph;
import graph.DepthFirstDirectedPaths;
import graph.Digraph;
import graph.DijkstraSP;
import graph.DirectedEdge;
import graph.EdgeWeightedDigraph;

public class test {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		/******ENUM TEST*******/
//		EnumCity city = EnumCity.valueOf("BOSTON");
//		for (EnumCity day : EnumCity.values()) { 
//		    System.out.println(day); 
//		}
//		int[] array = new int[10];
//		array[0] = 10;
//		if (array[city.getIndex()] == 10) {
//			System.out.println("works");
//		}

		
		/******Read.readConnectCity/OnlyCites TEST*******/
//		String[][] test = Read.readConnectCity();
//		int i = 0; 
//		for (EnumCity city1 : EnumCity.values()) {
//		    System.out.println("Source: " + city1 + "------------------- Row " + i );
//			for (int j = 0; j < test[i].length; j++) {
//				System.out.printf(test[i][j] + ", ");
//			}
//			System.out.println("\n");
//			i++;
//		}
		
		/******readRestaurants TEST*******/
//		String[][] test2 = Read.readRestaurantsInfo();
//		for (int i = 0; i < test2.length; i++) {
//			System.out.println(test2[i][2] + ", " + test2[i][0] + "    " + test2[i][1]);
//		}
		
		
		/******readCitiesLatLong TEST*******/
//		float[][] test3 = Read.readCitiesLatLong();
//		int i = 0;
//		for (EnumCity city1 : EnumCity.values()) {
//		    System.out.println(city1 + "-------------------");
//			System.out.printf(test3[i][0] + ", " + test3[i][1]);
//			System.out.println("\n");
//			i++;
//		}
		
		/******readRestLatLong TEST*******/
//		float[][] test4 = Read.readRestLatLong();
//		String[][] RestInfo = Read.readRestaurantsInfo();
//		for (int i = 0; i < test4.length; i++) {
//			if (RestInfo[i][2].equals("BurgerKing")) {
//				System.out.println(RestInfo[i][2] + "-------------------");
//				System.out.printf(test4[i][0] + ", " + test4[i][1]);
//				System.out.println("\n");
//			} else if (RestInfo[i][2].equals("McDonalds")) {
//				System.out.println(RestInfo[i][2] + "-------------------");
//				System.out.printf(test4[i][0] + ", " + test4[i][1]);
//				System.out.println("\n");
//			} else {
//				System.out.println(RestInfo[i][2] + "-------------------");
//				System.out.printf(test4[i][0] + ", " + test4[i][1]);
//				System.out.println("\n");
//			}
//		}
		
		/******readMenuInfo TEST*******/
//		String[][] test5 = Read.readMenuInfo();
//			for (int i = 0; i < test5.length; i++) {
//				System.out.println(test5[i][0] + ", " + test5[i][1] + ", " + test5[i][2]);
//			} 
		
		/******CreateGraph private functions TEST*******/
//		String[][] CitiesInfo = Read.readCitiesInfo();
//		String[] OnlyCities = Read.readOnlyCities();
//		String[][] RestaurantsInfo = Read.readRestaurantsInfo();
//		String[][] MenuInfo = Read.readMenuInfo();
//		float[][] CitiesLatLong = Read.readCitiesLatLong();
//		float[][] RestLatLong = Read.readRestLatLong();
//		String[][] ConnectCity = Read.readConnectCity();
//		
		/******possibleRestaurants  TEST*******/
//		String[][] possibleRestaurants = CreateGraph.possibleRestaurants(OnlyCities, RestLatLong, CitiesLatLong, RestaurantsInfo);
//		int i = 0;
//		for (EnumCity city1 : EnumCity.values()) {
//			System.out.println(city1 + "-------------------" + possibleRestaurants[i].length);
//			for (int j = 0; j < possibleRestaurants[i].length; j++) {
//				System.out.printf(possibleRestaurants[i][j] + ", ");
//			}
//			System.out.println("\n");
//			i++;
//		}
		/******possibleMenu TEST*******/
//		String[][] possibleMenu = CreateGraph.possibleMenu(possibleRestaurants, MenuInfo);
//		int i = 0;
//		for (EnumCity city1 : EnumCity.values()) {
//			System.out.println(city1 + "-------------------");
//			for (int j = 0; j < possibleMenu[i].length; j++) {
//				System.out.printf(possibleMenu[i][j] + ", ");
//			}
//			System.out.println("\n");
//			i++;
//		}
		/******possibleWeights TEST*******/
//		float[][] possibleWeights = CreateGraph.possibleWeights(OnlyCities, possibleRestaurants, MenuInfo);
//		int i = 0;
//		for (EnumCity city1 : EnumCity.values()) {
//			System.out.println(city1 + "-------------------");
//			for (int j = 0; j < possibleWeights[i].length; j++) {
//				System.out.printf(possibleWeights[i][j] + ", ");
//			}
//			System.out.println("\n");
//			i++;
//		}
		
		/******CreateDigraph TEST*******/
//		Digraph digraph = CreateGraph.CreateDigraph();
//		String result = digraph.toString();
//		System.out.println(result);
		/******DFS TEST*******/
//		DepthFirstDirectedPaths DFS = new DepthFirstDirectedPaths(digraph, 0);
//		Iterable<Integer> Path = DFS.pathTo(EnumCity.MINNEAPOLIS.getIndex());
//		Vector<String> temp = new Vector<String>();
//		for (int i : Path) {
//			System.out.println(EnumCity.getEnumCity(i).getUSCity());
//		}
		/******BFS TEST*******/
//		BreadthFirstDirectedPaths BFS = new BreadthFirstDirectedPaths(digraph, 0);
//		Iterable<Integer> Path1 = BFS.pathTo(EnumCity.MINNEAPOLIS.getIndex());
//		Vector<String> temp1 = new Vector<String>();
//		for (int i : Path1) {
//			System.out.println(EnumCity.getEnumCity(i).getUSCity());
//		}
		
		/******CreateEdgeWeightedDigraph TEST*******/
//		EdgeWeightedDigraph digraph1 = CreateGraph.CreateEdgeWeightedDigraph();
//		String result = digraph1.toString();
//		System.out.println(result);
		/******CreateEdgeWeightedDigraph TEST*******/
//		String[][] MenuInfo = Read.readMenuInfo();
//		DijkstraSP Dijkstra = new DijkstraSP(digraph1, 0);
//		Iterable<DirectedEdge> pathTo = Dijkstra.pathTo(EnumCity.MINNEAPOLIS.getIndex());
//		for (DirectedEdge i : pathTo) {
//			System.out.println(EnumCity.getEnumCity(i).getUSCity());
//		}
		
		/******Writer TEST*******/
		Write.Writer();
		

	}
}
