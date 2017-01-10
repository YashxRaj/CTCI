package treesAndGraphs;

public class TaG {

	public static void main(String[] args) {
		Graph directed = new Graph(randomSize(), true);
		directed.generateNodes();
		directed.connectNodes();
		directed.printAdjacencyList();

		// RouteBetweenNodes(directed);
		sortedArrayToBST(makeSortedArray(randomSize()));
	}

	private static void sortedArrayToBST(int[] makeSortedArray) {
		
	}

	private static int[] makeSortedArray(int size) {
		int[] a = new int[size];
		int key1 = (int) (Math.random() * 1000), key2 = (int) (Math.random() * 1000);
		for (int i = 0; i < size; i++)
			a[i] = i * key1 * key2;
		return a;
	}

	private static void RouteBetweenNodes(Graph directed) {
		GraphNode start = randomNode(directed);
		GraphNode end = randomNodeOtherThan(directed, start);
		System.out.println("Start node: " + start.name);
		System.out.println("End node: " + end.name);
		System.out.println(directed.search(start, end) == true ? "Route exists!" : "No route connecting them!");
	}

	private static int randomSize() {
		return 5 + (int) (Math.random() * 5);
	}

	public static GraphNode randomNode(Graph g) {
		return g.nodes[(int) (Math.random() * (g.numNodes - 1))];
	}

	public static GraphNode randomNodeOtherThan(Graph g, GraphNode n) {
		int randomInt = (int) (Math.random() * (g.numNodes - 1));
		return g.nodes[randomInt] == n ? randomNodeOtherThan(g, n) : g.nodes[randomInt];
	}

}
