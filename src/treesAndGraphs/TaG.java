package treesAndGraphs;

public class TaG {

	public static void main(String[] args) {
		RouteBetweenNodes();
	}

	private static void RouteBetweenNodes() {
		Graph g = new Graph(5 + (int) (Math.random() * 5));
		g.generateNodes();
		g.connectNodes();
		g.printAdjacencyList(); // g.printAdjacencyMatrix();

	}
}
