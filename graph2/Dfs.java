package graph2;

import java.util.List;

public class Dfs {
	
	//Boolean[] visited = new Boolean[];
	
	public int dfs(List[] graph, int currentVertex, boolean[] visited) {	
		if (visited[currentVertex]) {
			return 0;
		}
		int count = 1;
		//System.out.println("currentVertex " + currentVertex);
		visited[currentVertex] =  true;
		List<Integer> children = graph[currentVertex];
		if (children == null) {
			return count;
		}
		for (Integer child : children) {			
			count += dfs(graph, child, visited);
		}
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List[] graph= new GraphMaker().readGraph("c:\\dsaTextFiles\\SCC.txt", 875714, true);
		boolean[] visited = new boolean[graph.length];
		System.out.println(new Dfs().dfs(graph, 8, visited));

	}

}
