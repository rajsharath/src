package graph2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Bfs {
	
	public void bfs(List[] graph) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		List<Integer> nodesVisitedInCurrentIteration = new ArrayList<Integer>();
		int totalNodesVisited = 1;
		visited.put(1, true);
		queue.add(1);		
		System.out.println("visited nodes " + nodesVisitedInCurrentIteration);
		while (!queue.isEmpty()) {
			Integer parent = queue.poll();
			List<Integer> children = graph[parent];
			//nodesVisitedInCurrentIteration =  new ArrayList<Integer>();
			for (Integer child : children) {
				if (visited.containsKey(child) && visited.get(child)) {
					continue;
				}
				visited.put(child, true);
				queue.add(child);
				totalNodesVisited++;
				//nodesVisitedInCurrentIteration.add(child);
			}
			/*for (Integer child : nodesVisitedInCurrentIteration) {
				System.out.print(child + " " );
			}*/
			System.out.println("totalNodesVisited " + totalNodesVisited);
		}		
	}
	
	
	// graph search using bfs
	public int bfs2(List[] graph, int findVertex) {
		//init
		Queue<Integer> queue = new LinkedList<Integer>();
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		Map<Integer, Integer> level = new HashMap<Integer, Integer>();
		List<Integer> nodesVisitedInCurrentIteration = new ArrayList<Integer>();
		int totalNodesVisited = 1;
		
		// process source node
		int sourceNode = 1;
		if (sourceNode == findVertex) {
			return 0;
		}
		visited.put(sourceNode, true);
		queue.add(1);
		level.put(1, 1);
		//System.out.println("visited nodes " + nodesVisitedInCurrentIteration);
		
		while (!queue.isEmpty()) {
			Integer parent = queue.poll();
			List<Integer> children = graph[parent];
			//nodesVisitedInCurrentIteration =  new ArrayList<Integer>();
			for (Integer child : children) {
				if (visited.containsKey(child) && visited.get(child)) {
					continue;
				}
				visited.put(child, true);
				queue.add(child);
				level.put(child, level.get(parent) + 1);
				if (child == findVertex) {
					System.out.println(level.get(parent));
					return level.get(parent);
				}
				totalNodesVisited++;
				//nodesVisitedInCurrentIteration.add(child);
			}
			/*for (Integer child : nodesVisitedInCurrentIteration) {
				System.out.print(child + " " );
			}*/
			
		}
		System.out.println("totalNodesVisited " + totalNodesVisited);
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List[] graph= new GraphMaker().readGraph("c:\\dsaTextFiles\\simpleGraph.txt", 100, false);
		new Bfs().bfs2(graph, 8);
	}

}
