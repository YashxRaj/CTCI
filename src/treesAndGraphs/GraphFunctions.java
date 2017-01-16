package treesAndGraphs;

import stacksAndQueues.Queue;
import treesAndGraphs.GraphNode.state;

public class GraphFunctions {

	public static boolean routeBetweenNodesBFS(Graph g, GraphNode current, GraphNode target) {
		if (current == target)
			return true;
		stacksAndQueues.Queue<GraphNode> q = new Queue<GraphNode>();
		for (GraphNode n : g.nodes)
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

	public static boolean routeBetweenNodesDFS(Graph g, GraphNode current, GraphNode target) {
		if (current == null || target == null)
			return false;
		current.state = state.visited;
		if (current == target)
			return true;
		for (GraphNode x : g.getAdjacent(current)) {
			if (x == target)
				return true;
			if (x.state != state.visited && routeBetweenNodesDFS(g, x, target))
				return true;
		}
		return false;
	}
}
