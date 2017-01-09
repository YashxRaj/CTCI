package treesAndGraphs;

public class Graph {
	public static Node[] nodes;
	private static int numNodes = 0;

	public Graph(int numberOfNodes) {
		numNodes = numberOfNodes;
		nodes = new Node[numNodes];
	}

	public static Node[] generateNodes() {
		for (int i = 0; i < numNodes; i++)
			nodes[i] = new Node(Integer.toString(i), numNodes);
		return nodes;
	}

	public static Node[] connectNodes() {
		for (int i = 0; i < nodes.length; i++) {
			if (0.85 > Math.random())
				do {
					nodes[i].add(generateRandomNodeNumber(i));
				} while (0.5 < Math.random());
			for (int j = 0; j < numNodes; j++)
				if (nodes[i].children[j] == true && 0.5 < Math.random())
					nodes[j].children[i] = true;
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

	public void printAdjacencyList() {
		StringBuffer s = new StringBuffer();
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
