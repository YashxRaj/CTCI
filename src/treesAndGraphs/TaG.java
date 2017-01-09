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

		RouteBetweenNodes(directed);
	}

	private static void RouteBetweenNodes(Graph directed) {

	}

	private static int randomSize() {
		return 5 + (int) (Math.random() * 5);
	}
}
