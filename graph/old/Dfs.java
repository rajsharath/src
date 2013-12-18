package graph.old;

import java.util.List;

public class Dfs {
	
	public static void dfs(GraphOld g, Integer source, boolean[] visited) {
		List<Integer> children = g.adj[source];
		for (int child : children) {
			if (visited[child]) {
				continue;
			}
			System.out.println("visiting " + child);
			visited[child] = true;
			dfs(g, child, visited);
		}
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean[] visited = new boolean[13];
		visited[0] = true;
		dfs(new graph.old.GraphOld(), 0, visited);

	}

}
