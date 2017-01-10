package treesAndGraphs;

import stacksAndQueues.Queue;
import treesAndGraphs.GraphNode.state;

public class GraphFunctions {

	public static boolean routeBetweenNodes(Graph g, GraphNode start, GraphNode end) {
		if (start == end)
			return true;
		stacksAndQueues.Queue<GraphNode> q = new Queue<GraphNode>();
		for (GraphNode n : g.nodes)
			n.state = state.unvisited;
		start.state = state.visiting;
		q.enqueue(start);
		GraphNode temp;
		while (!q.isEmpty()) {
			temp = q.dequeue();
			if (temp != null) {
				for (GraphNode t : g.getAdjacent(temp))
					if (t.state == state.unvisited) {
						if (t == end)
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
}
