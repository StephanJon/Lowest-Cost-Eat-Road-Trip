package ReadWrite;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

import graph.BreadthFirstDirectedPaths;
import graph.CreateGraph;
import graph.DepthFirstDirectedPaths;
import graph.Digraph;
import graph.DijkstraSP;
import graph.DirectedEdge;
import graph.EdgeWeightedDigraph;

/**
 * Write is a class to write the results of DFS and BFS on a digraph, and Dijkstra's algorithm on an edgeweighted digraph 
 * into a file named a2_out.txt.
 * 
 * @author Stephanus Jonatan
 */
public class Write {
	
	/**
	 * Writes the results of DFS and BFS on a digraph, and Dijkstra's algorithm on an edgeweighted digraph 
	 * into a file named a2_out.txt.
	 */
	public static void Writer() throws FileNotFoundException, UnsupportedEncodingException{
		Digraph digraph = CreateGraph.CreateDigraph();
		EdgeWeightedDigraph digraph1 = CreateGraph.CreateEdgeWeightedDigraph();
		String[] outDFS = outDFS(digraph);
		String[] outBFS = outBFS(digraph);
		String[][] outDijkstra = outDijkstras(digraph1);
		PrintWriter writer = new PrintWriter("a2_out.txt", "UTF-8");
		writer.print("DFS: ");
		for (int i = 0; i < outDFS.length; i++) {
			if (i == outDFS.length - 1) {
				writer.print(outDFS[i]);
				break;
			}
			writer.print(outDFS[i] + ", ");
		}
		writer.println("\n");
		writer.print("BFS: ");
		for (int i = 0; i < outBFS.length; i++) {
			if (i == outBFS.length - 1) {
				writer.print(outBFS[i]);
				break;
			}
			writer.print(outBFS[i] + ", ");
		}
		writer.println("\n");

		writer.format("%-25s%-70s%-50s\n", "---CITY---", "---MEAL---", "---COST---");
		for (int i = 0; i < outDijkstra.length; i++) {
			writer.format("%-25s%-70s%-50s\n", outDijkstra[i][0], outDijkstra[i][1], outDijkstra[i][2]);
		}
		writer.close();
	}
	
	
	/**
	 * Performs DFS on a given digraph and returns the shortest path from Boston to Mineapolis found from DFS
	 * 
	 * @return outDFS - return the shortest path found by BFS
	 */
	private static String[] outDFS(Digraph digraph) {
		DepthFirstDirectedPaths DFS = new DepthFirstDirectedPaths(digraph, 0);
		Iterable<Integer> Path = DFS.pathTo(EnumCity.MINNEAPOLIS.getIndex());
		Vector<String> temp = new Vector<String>();
		for (int i : Path) {
			temp.add(EnumCity.getEnumCity(i).getUSCity());
		}
		String[] outDFS = new String[temp.size()];
		temp.copyInto(outDFS);
		return outDFS;
	}
	
	/**
	 * Performs BFS on a given digraph and returns the shortest path from Boston to Mineapolis found from BFS
	 * 
	 * @return outBFS - return the shortest path found by BFS
	 */
	private static String[] outBFS(Digraph digraph) {
		BreadthFirstDirectedPaths BFS = new BreadthFirstDirectedPaths(digraph, 0);
		Iterable<Integer> Path1 = BFS.pathTo(EnumCity.MINNEAPOLIS.getIndex());
		Vector<String> temp1 = new Vector<String>();
		for (int i : Path1) {
			temp1.add(EnumCity.getEnumCity(i).getUSCity());
		}
		String[] outBFS = new String[temp1.size()];
		temp1.copyInto(outBFS);
		return outBFS;
	}
	
	/**
	 * Performs Dijkstra's algorithm on a given edgeweighted digraph and returns the shortest path from Boston to Mineapolis found
	 * Dijkstra's algorithm
	 * 
	 * @return outFS - return the shortest path found by Dijkstra's algorithm
	 */
	private static String[][] outDijkstras(EdgeWeightedDigraph digraph1) throws FileNotFoundException {
		String[][] MenuInfo = Read.readMenuInfo();
		DijkstraSP Dijkstra = new DijkstraSP(digraph1, 0);
		Iterable<DirectedEdge> pathTo = Dijkstra.pathTo(EnumCity.MINNEAPOLIS.getIndex());
		int j = 0;
		for (DirectedEdge i : pathTo) {
			j++;
		}
		String[][] outDijkstra = new String [j][3];
		int count = 0;
		for (DirectedEdge i : pathTo) {
			int index = i.to();
			float cost = (float) i.weight();
			String costString = "$" + Float.toString(cost);
			String meal = new String();
			for (int k = 0; k < MenuInfo.length ; k++) {
				if (MenuInfo[k][2].equals(costString)) {
					meal = MenuInfo[k][1];
					break;
				}
			}
			outDijkstra[count][0] = EnumCity.getEnumCity(index).getUSCity();
			outDijkstra[count][1] = meal;
			outDijkstra[count][2] = costString;
			count++;
		}
		return outDijkstra;
	}
}
