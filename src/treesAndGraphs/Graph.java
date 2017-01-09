package treesAndGraphs;

public class Graph {
	public static Node[] nodes;
	private static int numNodes = 0;
	boolean directed = false;

	public Graph(int numberOfNodes, Boolean directed) {
		if (directed == true)
			this.directed = true;
		numNodes = numberOfNodes;
		nodes = new Node[numNodes];
	}

	public Node[] generateNodes() {
		for (int i = 0; i < numNodes; i++)
			nodes[i] = new Node(Integer.toString(i), numNodes);
		return nodes;
	}

	public Node[] connectNodes() {
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

	private static int generateRandomNodeNumber(int i) {
		int k = i;
		while (k == i)
			k = (int) (Math.random() * (nodes.length - 1));
		return k;
	}

	public void printAdjacencyMatrix() {
		StringBuffer s = new StringBuffer();
		print(s);
		s.append("  ");
		for (Node n : nodes)
			s.append(n.name + " ");
		s.append(System.lineSeparator());
		for (Node n : nodes) {
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
		for (Node n : nodes) {
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
}
