package graph2;


import java.util.ArrayList;
import java.util.List;

public class StronglyConnectedComponents {

	int currentRank = 1;

	// returns the total no of nodes in the highest SCC
	public int findScc(List<Integer>[] graph) {
		List<Integer>[] revGraph = createReverseGraph(graph);
		boolean[] visited = new boolean[graph.length];
		int[] rank = new int[graph.length];
		dfsFirstLoop(revGraph, visited, rank);
		return dfsSecondLoop(graph, rank);
	}

	private List<Integer>[] createReverseGraph(List<Integer>[] graph) {
		List<Integer>[] revGraph = new List[graph.length];
		for (int  i = 1 ; i < graph.length ; i++) {
			revGraph[i] = new ArrayList<Integer>();
		}
		for (int i = 1 ; i < graph.length ; i++) {
			List<Integer> list = graph[i];
			for (Integer vertex : list) {
				revGraph[vertex].add(i);
			}
		}
		return revGraph;
	}

	public void dfsFirstLoop(List<Integer>[] graph, boolean[] visited, int[] rank) {
		for (int i = 1; i < graph.length; i++) {
			dfsFirst(graph, i, visited, rank);
		}
	}

	public void dfsFirst(List<Integer>[] graph, int currentVertex, boolean[] visited,	int[] rank) {
		if (visited[currentVertex]) {
			return;
		}
		System.out.println("currentRank " + currentRank);
		visited[currentVertex] = true;
		List<Integer> children = graph[currentVertex];
		if (children == null) {
			rank[currentRank] = currentVertex;
			currentRank++;
			return;
		}
		for (Integer child : children) {			
			dfsFirst(graph, child, visited, rank);
		}
		rank[currentRank] = currentVertex;
		currentRank++;
	}
	
	public int dfsSecondLoop(List<Integer>[] graph, int[] rank) {
		boolean[] visited = new boolean[graph.length];
		int maxSize = 0;
		for (int i = rank.length - 1; i >= 1; i--) {
			int size = dfsSecond(graph, rank[i], visited);
			if (size > maxSize) {
				maxSize = size;
			}
		}
		return maxSize;
	}
	
	public int dfsSecond(List<Integer>[] graph, int currentVertex, boolean[] visited) {
		visited[currentVertex] = true;
		List<Integer> children = graph[currentVertex];
		int count = 1;
		if (children == null) {
			return count;
		}
		for (Integer child : children) {
			if (visited[child]) {
				continue;
			}
			count += dfsSecond(graph, child, visited);
		}
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List[] graph= new GraphMaker().readGraph("c:\\dsaTextFiles\\SCC.txt", 875714, true);
		System.out.println(new StronglyConnectedComponents().findScc(graph));
	}
}
