package graph2;

import java.util.List;

public class TopologicalSort {
	
	int rank;
	
	public void tsort(List<Integer>[] graph) {
		rank = graph.length  - 1;
		int[] rankArr = new int[graph.length];
		boolean[] visited = new boolean[graph.length];
		for (int i = 1 ; i < graph.length ; i++) {
			dfs(graph, i, visited, rankArr);
		}		
	}
	
	public void dfs(List<Integer>[] graph, int vertex, boolean[] visited, int[] rankArr) {
		if (visited[vertex]) {
			return;
		}
		visited[vertex] = true;
		List<Integer> children = graph[vertex];
		if (children == null || children.isEmpty()) {
			rankArr[vertex] = rank;
			rank--;
			return;
		}
		for (Integer child : children) {
			dfs(graph, child, visited, rankArr);
		}
		rankArr[vertex] = rank;
		rank--;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
