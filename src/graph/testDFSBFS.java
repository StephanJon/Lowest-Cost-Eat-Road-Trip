package graph;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Vector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ReadWrite.EnumCity;
import ReadWrite.Read;

public class testDFSBFS {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateDigraph() throws FileNotFoundException { 	//testCreateDigraph checks if the paths found from Boston to 
																	//every other city when DFS and BFS are applied to a digraph
																	//created by CreatGraph.CreateDigraph are existing paths
																	//in connectedcities.txt
		String[][] connectCities = Read.readConnectCity();
		String[] OnlyCites = Read.readOnlyCities();
		Digraph digraph = CreateGraph.CreateDigraph();
		DepthFirstDirectedPaths DFS = new DepthFirstDirectedPaths(digraph, 0);
		BreadthFirstDirectedPaths BFS = new BreadthFirstDirectedPaths(digraph, 0);

		/********Check DFS generated paths*********/
		for (int i = 1; i < OnlyCites.length; i++) { //accesses each path from Boston to every other city found By DFS
			Vector<Integer> path = new Vector<Integer>();
			
			for (int j : DFS.pathTo(i)) { //saves the path from Boston to city i
				path.add(j);
			}
			
			for (int j = 1; j < path.size(); j++) { /* accesses the path from Boston to city i, where i = associated 
													number for a city in EnumCity enum class*/
				
				EnumCity current = EnumCity.getEnumCity(path.get(j));
				EnumCity previous = EnumCity.getEnumCity(path.get(j-1)); 
				String temp = current.getUSCity();
				String temp1 = temp.replaceAll("\\s", "");
				String temp2 = temp1.replaceAll("\\.", "");
				boolean check = false; //reset check to false
				
				for (int k = 0; k < connectCities[previous.getIndex()].length; k++) { 	//accesses the connected cities
																						//Checks if any of connected cities of 
				 																		//compare exists along the path of Boston 
																						//to city i;
					
					System.out.println(connectCities[previous.getIndex()][k] + " " + temp2);
					if (connectCities[previous.getIndex()][k].equals(temp2)) {	
						System.out.println("+++++THERE EXISTS A VALID PATH \n");
						check = true;
						break;
					}
					System.out.println("-----NOT A VALID PATH\n");
				}
				assert(check); //assert check to see if it is an existing edge
			}
		}
		
		/********Check BFS generated paths*********/
		for (int i = 1; i < OnlyCites.length; i++) { //accesses each path from Boston to every other city found By BFS
			Vector<Integer> path = new Vector<Integer>();
			
			for (int j : BFS.pathTo(i)) { //saves the path from Boston to city i
				path.add(j);
			}
			
			for (int j = 1; j < path.size(); j++) { /* accesses the path from Boston to city i, where i = associated 
													number for a city in EnumCity enum class*/
				
				EnumCity current = EnumCity.getEnumCity(path.get(j));
				EnumCity previous = EnumCity.getEnumCity(path.get(j-1)); 
				String temp = current.getUSCity();
				String temp1 = temp.replaceAll("\\s", "");
				String temp2 = temp1.replaceAll("\\.", "");
				boolean check = false; //reset check to false
				for (int k = 0; k < connectCities[previous.getIndex()].length; k++) { 	//accesses the connected cities
																						//Checks if any of connected cities of 
																					 	//compare exists along the path of Boston 
																						//to city i;
					
					System.out.println(connectCities[previous.getIndex()][k] + " " + temp2);
					if (connectCities[previous.getIndex()][k].equals(temp2)) {	
						System.out.println("+++++THERE EXISTS A VALID PATH \n");
						check = true;
						break;
					}
					System.out.println("-----NOT A VALID PATH\n");
				}
				assert(check); //assert check to see if it is an existing edge
			
			}
				
		}
		
	}

}
