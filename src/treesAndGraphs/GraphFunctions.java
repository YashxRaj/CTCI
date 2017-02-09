package treesAndGraphs;

import java.util.Vector;

import stacksAndQueues.Queue;
import treesAndGraphs.Graph.state;

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
				for (String x : g.getAdjacent(temp)) {
					GraphNode t = g.getGraphNodeByName(x);
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
		}
		return false;
	}

	public static boolean routeBetweenNodesDFS(Graph g, GraphNode start, GraphNode end) {
		if (start == null || end == null)
			return false;
		start.state = state.visited;
		if (start == end)
			return true;
		for (String x : g.getAdjacent(start)) {
			GraphNode t = g.getGraphNodeByName(x);
			if (t == end)
				return true;
			if (t.state != state.visited && routeBetweenNodesDFS(g, t, end))
				return true;
		}
		return false;
	}

	public static boolean buildOrder(Vector<String> projects, Vector<Vector<String>> dependencies) {
		Graph g = new Graph(true);
		Queue<GraphNode> q = new Queue<GraphNode>();
		for (String s : projects)
			g.createGraphNode(s);
		for (int i = 0; i < g.nodes.size(); i++)
			for (String s : dependencies.get(i)) {
				if (s.equals(""))
					continue;
				g.connectGraphNodes(g.nodes.get(i), g.getGraphNodeByName(s));
			}
		do {
			for (GraphNode gn : g.nodes) {
				if (g.getAdjacent(gn) == null) {
					q.enqueue(gn);
					g.nodes.remove(gn);
					for (GraphNode gn2 : g.nodes) {
						// if (g.connections.get(gn2) == null)
						g.connections.get(gn2).remove(gn.name);
						if (g.connections.get(gn2).isEmpty())
							g.connections.remove(gn2);
					}

				}
			}
		} while (!g.connections.isEmpty());
		g.printAdjacencyList();
		System.out.println(q);
		return false;
	}
}
