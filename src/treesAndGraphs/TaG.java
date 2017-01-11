package treesAndGraphs;

public class TaG {

	public static void main(String[] args) {
		// routeBetweenNodes(makeGraph(true));
		// sortedArrayToBST(makeSortedArray(randomSize()));
		listOfDepths(TreeFunctions.createMinimalBST(makeSortedArray(randomSize())));

	}

	private static void listOfDepths(TreeNode root) {
		TreeFunctions.print(root);
		TreeFunctions.printListOfDepths(TreeFunctions.listOfDepthsBFS(root), "BFS:");
		TreeFunctions.printListOfDepths(TreeFunctions.listOfDepthsDFS(root), "DFS:");
	}

	private static void routeBetweenNodes(Graph directed) {
		GraphNode start = randomGraphNode(directed);
		GraphNode end = randomGraphNodeOtherThan(directed, start);
		StringBuffer s = new StringBuffer();
		s.append("Start node: " + start.name);
		s.append(System.lineSeparator());
		s.append("End node: " + end.name);
		s.append(System.lineSeparator());
		s.append(GraphFunctions.routeBetweenNodes(directed, start, end) == true ? "Route exists!"
				: "No route connecting them!");
		System.out.println(s.toString());
	}

	private static void sortedArrayToBST(int[] a) {
		printArray(a);
		TreeFunctions.print(TreeFunctions.createMinimalBST(a));
	}

	private static void printArray(int[] a) {
		System.out.print("[ ");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println("]");
	}

	private static int[] makeSortedArray(int size) {
		int[] a = new int[size];
		int key1 = (int) (Math.random() * 10), key2 = (int) (Math.random() * 10);
		for (int i = 0; i < size; i++)
			a[i] = i * (key1 + key2 + i);
		return a;
	}

	private static int randomSize() {
		return 10 + (int) (Math.random() * 5);
	}

	public static GraphNode randomGraphNode(Graph g) {
		return g.nodes[(int) (Math.random() * (g.numNodes - 1))];
	}

	public static GraphNode randomGraphNodeOtherThan(Graph g, GraphNode n) {
		int randomInt = (int) (Math.random() * (g.numNodes - 1));
		return g.nodes[randomInt] == n ? randomGraphNodeOtherThan(g, n) : g.nodes[randomInt];
	}

	private static Graph makeGraph(boolean directed) {
		Graph g = directed == true ? new Graph(randomSize(), true) : new Graph(randomSize(), false);
		g.generateNodes();
		g.connectNodes();
		g.printAdjacencyList();
		return g;
	}
}
