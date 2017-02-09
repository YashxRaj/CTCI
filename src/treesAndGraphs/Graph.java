package treesAndGraphs;

import java.util.HashMap;
import java.util.Vector;

public class Graph {
	enum state {
		unvisited, visiting, visited;
	}

	public Vector<GraphNode> nodes = null;
	public HashMap<GraphNode, Vector<String>> connections = null;
	public boolean directed;

	public Graph(boolean directed) {
		super();
		this.nodes = new Vector<GraphNode>();
		this.connections = new HashMap<GraphNode, Vector<String>>();
		this.directed = directed;
	}

	public void createGraphNode(String name) {
		GraphNode gn = new GraphNode(name);
		nodes.add(gn);
		connections.put(gn, null);
	}

	public boolean connectGraphNodes(GraphNode gn, GraphNode gn2) {
		if (nodes.contains(gn) && nodes.contains(gn2)) {
			Vector<String> x = connections.get(gn);
			if (x == null)
				x = new Vector<String>();
			x.add(gn2.name);
			connections.put(gn, x);
			if (!directed) {
				x = connections.get(gn2);
				x.add(gn.name);
				connections.put(gn2, x);
			}
			return true;
		} else {
			System.out.println("No connection made for : " + gn.name);
			return false;
		}
	}

	public Vector<String> getAdjacent(GraphNode gn) {
		if (nodes.contains(gn) == false)
			return null;
		else
			return connections.get(gn);
	}

	public void generateRandomGraphNodes(int numberOfNodes) {
		int nameInt = 65;
		for (int i = 0; i < numberOfNodes; i++)
			createGraphNode(Character.toString((char) nameInt++));
	}

	public void connectRandomGraphNodes(boolean directed) {
		for (int i = 0; i < nodes.size(); i++) {
			if (0.85 > Math.random())
				do {
					GraphNode x = randomGraphNode(i);
					if (!connections.get(nodes.get(i)).contains(x.name))
						connections.get(nodes.get(i)).add(x.name);
				} while (0.5 < Math.random());
			for (int j = 0; j < nodes.size(); j++)
				if (connections.get(nodes.get(i)).contains(connections.get(nodes.get(j)))) {
					if (!directed)
						connections.get(nodes.get(j)).add(nodes.get(i).name);
					else if (0.5 < Math.random() && !connections.get(nodes.get(j)).contains(nodes.get(i)))
						connections.get(nodes.get(j)).add(nodes.get(i).name);
				}
		}
	}

	public GraphNode randomGraphNode(int i) {
		int e = (int) (Math.random() * nodes.size());
		return e == i ? randomGraphNode(i) : nodes.get(e);
	}

	public void printAllNodes() {
		StringBuffer s = new StringBuffer();
		for (GraphNode n : nodes)
			s.append(n.name + " ");
		System.out.println(s.toString());
	}

	public void printAdjacencyList() {
		StringBuffer s = new StringBuffer();
		for (GraphNode n : nodes) {
			s.append(n.name + " : ");
			if (connections.get(n) == null) {
				s.append("-");
				s.append(System.lineSeparator());
				continue;
			}
			for (String child : connections.get(n))
				s.append(child + " ");
			s.append(System.lineSeparator());
		}
		System.out.println(s.toString());
	}

	public GraphNode getGraphNodeByName(String name) {
		for (GraphNode gn : nodes)
			if (gn.name.equals(name)) // NEVER COMPARE WITH '==' JESUS FUCK.
				return gn;
		return null;
	}
}
