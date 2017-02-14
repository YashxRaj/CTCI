package treesAndGraphs;

import java.util.ArrayList;
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
		Graph g = buildGraph(projects, dependencies);
		ArrayList<GraphNode> buildOrder = new ArrayList<GraphNode>();
		while (buildOrder.size() != g.nodes.size()) {
			// queueIndependents
			for (GraphNode x : g.nodes)
				if (g.connections.get(x) == null)
					if (!buildOrder.contains(x))
						buildOrder.add(x);
			// removeDependencies
			for (GraphNode x : g.nodes) {
				if (g.connections.get(x) == null)
					continue;
				for (int i = 0; i < g.connections.get(x).size(); i++)
					if (buildOrder.contains(g.getGraphNodeByName(g.connections.get(x).get(i))))
						g.connections.get(x).remove(i);
				if (g.connections.get(x).isEmpty())
					g.connections.put(x, null);
			}
		}
		System.out.println("Build Order:");
		for (GraphNode x : buildOrder)
			System.out.print(x.name + " ");
		System.out.println();
		return true;
	}

	private static Graph buildGraph(Vector<String> projects, Vector<Vector<String>> dependencies) {
		Graph g = new Graph(true);
		for (String s : projects)
			g.createGraphNode(s);
		for (int i = 0; i < g.nodes.size(); i++)
			for (String s : dependencies.get(i)) {
				if (s.equals(""))
					continue;
				g.connectGraphNodes(g.nodes.get(i), g.getGraphNodeByName(s));
			}
		g.printAdjacencyList();
		return g;
	}
}