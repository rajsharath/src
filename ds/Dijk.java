package ds;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Dijk {
	
	public void dijk(Map<Integer, Map<Integer, Integer>> graph) {
		Map<Integer, Boolean> conqueredVerticesMap = new HashMap<Integer, Boolean>();
		int[] minDistancesArray = new int[graph.keySet().size() + 1];
		int count = graph.keySet().size() - 1;
		
		// init
		conqueredVerticesMap.put(1, true);
		minDistancesArray[1] = 0;
		// n - 1 iterations for n - 1 vertices
		while(count > 0) {
			int minDistance = 1000000;
			int minDistanceVertex = -1;
			// for each conquered vertex 
			for (int conqueredVertex : conqueredVerticesMap.keySet()) {
				// get all UN-conquered vertices from this conquered vertex
				Map<Integer, Integer> distancesMap = graph.get(conqueredVertex);
				for (Integer headVertex : distancesMap.keySet()) {
					if (!conqueredVerticesMap.containsKey(headVertex)) {
						int currentDistance = distancesMap.get(headVertex) + minDistancesArray[conqueredVertex];
						if (currentDistance < minDistance) {
							minDistance = currentDistance;
							minDistanceVertex = headVertex;
						}
					}
				}
			}
			System.out.println("vertex " + minDistanceVertex + "minDistance " + minDistance);
			if (minDistanceVertex != -1) {
				minDistancesArray[minDistanceVertex] = minDistance;
				conqueredVerticesMap.put(minDistanceVertex, true);
			} else {
				break;
			}
		}
		System.out.println(minDistancesArray[7] + "," + minDistancesArray[37] + "," 
				+ minDistancesArray[59] + "," + minDistancesArray[82] + "," + minDistancesArray[99] + ","
				+ minDistancesArray[115] + "," + minDistancesArray[133] + "," + minDistancesArray[165] + ","
				+ minDistancesArray[188] + ","  + minDistancesArray[197]);
	}
	
	private static void readFile(Map<Integer, Map<Integer, Integer>> graph) {
		try {
			FileInputStream fstream = new FileInputStream("C:\\dsaTextFiles\\dijkstraData.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				process(strLine, graph);
			}
			in.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	private static void process(String strLine, Map<Integer, Map<Integer, Integer>> graph) {
		String[] strs= strLine.split("\\s+");
		int processingNode = 0;
		int i = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (String str : strs) {
			if (i == 0) {
				i++;
				processingNode = new Integer(str);
				continue;
			}
			String[] strs2= str.split(",");
			map.put(new Integer(strs2[0]), new Integer(strs2[1]));					
		}
		graph.put(processingNode,  map);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Integer, Map<Integer, Integer>> graph = new HashMap<Integer, Map<Integer, Integer>>();		
		readFile(graph);
		new Dijk().dijk(graph);		
	}

}
