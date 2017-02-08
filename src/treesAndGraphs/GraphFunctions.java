package treesAndGraphs;

import java.util.Vector;

import stacksAndQueues.Queue;
import treesAndGraphs.Graph.GraphNode;
import treesAndGraphs.Graph.state;

public class GraphFunctions {

	public static boolean routeBetweenNodesBFS(Graph g, GraphNode current, GraphNode target) {
		if (current == target)
			return true;
		stacksAndQueues.Queue<GraphNode> q = new Queue<GraphNode>();
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

	public static boolean routeBetweenNodesDFS(Graph g, GraphNode start, GraphNode end) {
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

	public static boolean buildOrder(Vector<String> projects, Vector<Vector<String>> dependencies) {
		Graph g = new Graph(true);
		for (String s : projects)
			g.createGraphNode(s);
		for (int i = 0; i < g.listOfNodes.size(); i++)
			for (String s : dependencies.get(i))
				System.out.println(g.connectGraphNodes(g.listOfNodes.get(i), g.getGraphNodeByName(s)));
		g.printAdjacencyList();
		return false;
	}
}
