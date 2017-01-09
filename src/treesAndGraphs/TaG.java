package treesAndGraphs;

public class TaG {

	public static void main(String[] args) {
		Graph directed = new Graph(randomSize(), true);
		directed.generateNodes();
		directed.connectNodes();
		directed.printAdjacencyList();

		// Graph undirected = new Graph(randomSize(), false);
		// undirected.generateNodes();
		// undirected.connectNodes();
		// undirected.printAdjacencyMatrix();

		// RouteBetweenNodes(directed);
	}

	private static void RouteBetweenNodes(Graph directed) {
		Node start = randomNode(directed);
		Node end = randomNodeOtherThan(directed, start);
		System.out.println("Start node: " + start.name);
		System.out.println("End node: " + end.name);
		System.out.println(directed.search(start, end) == true ? "Route exists!" : "No route connecting them!");
	}

	private static int randomSize() {
		return 5 + (int) (Math.random() * 5);
	}

	public static Node randomNode(Graph g) {
		return g.nodes[(int) (Math.random() * (g.numNodes - 1))];
	}

	public static Node randomNodeOtherThan(Graph g, Node n) {
		int randomInt = (int) (Math.random() * (g.numNodes - 1));
		return g.nodes[randomInt] == n ? randomNodeOtherThan(g, n) : g.nodes[randomInt];
	}

}
