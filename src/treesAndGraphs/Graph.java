package treesAndGraphs;

import java.util.Vector;

public class Graph {
	public GraphNode[] nodes;
	public int numNodes;
	boolean directed = false;

	public Graph(int numberOfNodes, Boolean directed) {
		if (directed == true)
			this.directed = true;
		numNodes = numberOfNodes;
		nodes = new GraphNode[numNodes];
	}

	public GraphNode[] generateNodes() {
		for (int i = 0; i < numNodes; i++)
			nodes[i] = new GraphNode(Integer.toString(i), numNodes);
		return nodes;
	}

	public GraphNode[] connectNodes() {
		for (int i = 0; i < nodes.length; i++) {
			if (0.85 > Math.random())
				do {
					nodes[i].add(generateRandomNodeNumber(i));
				} while (0.5 < Math.random());
			for (int j = 0; j < numNodes; j++)
				if (nodes[i].children[j] == true) {
					if (!directed)
						nodes[j].add(i);
					else if (0.5 < Math.random())
						nodes[j].add(i);
				}
		}
		return nodes;
	}

	private int generateRandomNodeNumber(int i) {
		int k = i;
		while (k == i)
			k = (int) (Math.random() * (nodes.length - 1));
		return k;
	}

	public void printAdjacencyMatrix() {
		StringBuffer s = new StringBuffer();
		print(s);
		s.append("  ");
		for (GraphNode n : nodes)
			s.append(n.name + " ");
		s.append(System.lineSeparator());
		for (GraphNode n : nodes) {
			s.append(n.name + " ");
			for (Boolean child : n.children)
				s.append((child == false ? "F" : "T") + " ");
			s.append(System.lineSeparator());
		}
		System.out.println(s.toString());
	}

	private void print(StringBuffer s) {
		s.append(directed == true ? "Printing Directed Graph:" : "Printing Undirected Graph:");
		s.append(System.lineSeparator());
	}

	public void printAdjacencyList() {
		StringBuffer s = new StringBuffer();
		print(s);
		for (GraphNode n : nodes) {
			s.append(n.name + " : ");
			int i = 0;
			for (Boolean child : n.children) {
				if (child == true)
					s.append(i + " ");
				i++;
			}
			s.append(System.lineSeparator());
		}
		System.out.println(s.toString());
	}

	public Vector<GraphNode> getAdjacent(GraphNode n) {
		Vector<GraphNode> adjacentNodes = new Vector<GraphNode>();
		for (int i = 0; i < n.children.length; i++)
			if (n.children[i] == true)
				adjacentNodes.addElement(nodes[i]);
		return adjacentNodes;
	}

}
