package treesAndGraphs;

import stacksAndQueues.Queue;
import treesAndGraphs.Graph.GraphNode;
import treesAndGraphs.Graph.GraphNode.state;

public class GraphFunctions {

	public static boolean routeBetweenNodesBFS(Graph g, Graph.GraphNode current, Graph.GraphNode target) {
		if (current == target)
			return true;
		stacksAndQueues.Queue<Graph.GraphNode> q = new Queue<Graph.GraphNode>();
		for (GraphNode n : g.listOfNodes)
			n.state = state.unvisited;
		current.state = state.visiting;
		q.enqueue(current);
		GraphNode temp;
		while (!q.isEmpty()) {
			temp = q.dequeue();
			if (temp != null) {
				for (GraphNode t : g.getAdjacent(temp))
					if (t.state == state.unvisited) {
						if (t == target)
							return true;
						else {
							t.state = state.visiting;
							q.enqueue(t);
						}
					}
				temp.state = state.visited;
			}
		}
		return false;
	}

	public static boolean routeBetweenNodesDFS(Graph g, Graph.GraphNode start, Graph.GraphNode end) {
		if (start == null || end == null)
			return false;
		start.state = state.visited;
		if (start == end)
			return true;
		for (GraphNode x : g.getAdjacent(start)) {
			if (x == end)
				return true;
			if (x.state != state.visited && routeBetweenNodesDFS(g, x, end))
				return true;
		}
		return false;
	}

	public static boolean buildOrder(int[] projects, int[] dependencies) {
		Graph g = new Graph();
		int nameInt = 65;
		GraphNode x = new GraphNode(Character.toString((char) nameInt));
		// x.children[]
		
		return false;
	}
}
