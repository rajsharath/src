package graph.old;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Dijk {

	private static class Node {
		int value;
		int id;

		public Node(int id, int value) {
			this.value = value;
			this.id = id;
		}
		
		public boolean equals(Object other) {
			if (this.id == (((Node) other).id)) {
				return true;
			}
			return false;
		}
	}

	@SuppressWarnings("unused")
	public static void dij(List<Node>[] adj, Integer[] distanceList, List<Integer> visited, List<Integer> unVisited) {
		visited.add(1);
		unVisited.remove(new Integer(1));
		distanceList[1] = 0;
		while (unVisited.size() > 0) {
			Map<Integer, Integer> currentMap = new HashMap<Integer, Integer>();
			for (int i = 0; i < visited.size(); i++) {
				Integer processingNode = visited.get(i);
				List<Node> children = adj[processingNode];
				if (children == null) {
					continue;
				}
				for (int x = 0; x < children.size(); x++) {
					Node child = children.get(x);
					if (visited.contains(child.id)) {
						continue;
					}
					int distance = distanceList[processingNode] + child.value;
					currentMap.put(child.id, distance);					
				}
			}
			Node n = findMax(currentMap);
			visited.add(n.id);
			boolean removed = unVisited.remove(new Integer(n.id));
			distanceList[n.id] = n.value;
		}
		System.out.println();
	}

	private static Node findMax(Map<Integer, Integer> currentMap) {
		int minId = 0;
		int minDist = 0;
		Iterator<Integer> iterator = currentMap.keySet().iterator();
		if (iterator.hasNext()) {
			minId = iterator.next();
			minDist = currentMap.get(minId);
		}
		iterator = currentMap.keySet().iterator();
		while (iterator.hasNext()) {
			int curId = iterator.next();
			int curDist = currentMap.get(curId);
			if (curDist < minDist) {
				minDist = curDist;
				minId = curId;
			}
		}
		return new Node(minId, minDist);
	}
		

	private static void readFile(List<Node>[] adj, List<Integer> unVisited) {
		try {
			FileInputStream fstream = new FileInputStream("C:\\Users\\sharath\\Documents\\dijk_latest.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				process(strLine, adj, unVisited);
			}
			in.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	private static void process(String strLine, List<Node>[] adj, List<Integer> unVisited) {
		List<Node> nodeList = new ArrayList<Node>();
		String[] strs= strLine.split("\\s+");
		int processingNode = 0;
		int i = 0;
		for (String str : strs) {
			if (i == 0) {
				i++;
				processingNode = new Integer(str);
				continue;
			}
			String[] strs2= str.split(",");
			nodeList.add(new Node(new Integer(strs2[0]), new Integer(strs2[1])));					
		}
		adj[processingNode] = nodeList;
		unVisited.add(processingNode);	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Node>[] adj = new ArrayList[201];
		Integer[] distanceList = new Integer[201];
		List<Integer> visited = new ArrayList<Integer>();
		List<Integer> unVisited = new ArrayList<Integer>();
		
		readFile(adj, unVisited);
		dij(adj, distanceList, visited, unVisited);
		System.out.println(distanceList[7] + "," + distanceList[37] + "," + distanceList[59] + "," + distanceList[82] + "," + distanceList[99] + ","
				+ distanceList[115] + "," + distanceList[133] + "," + distanceList[165] + "," + distanceList[188] + ","  + distanceList[197]);
		//System.out.println(distanceList[1] + ", " + distanceList[2] + ", " + distanceList[3] + ", " + distanceList[4] + ", " +  distanceList[5]);
	}
}
