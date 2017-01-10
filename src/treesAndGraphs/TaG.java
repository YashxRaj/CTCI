package treesAndGraphs;

import java.util.ArrayList;

public class TaG {

	public static void main(String[] args) {
		// routeBetweenNodes(makeGraph());
		// sortedArrayToBST(makeSortedArray(randomSize()));
		listOfDepths(makeGraph());
	}

	private static void listOfDepths(Graph makeGraph) {
		ArrayList<ArrayList<GraphNode>> a = new ArrayList<ArrayList<GraphNode>>();
		
	}

	private static void routeBetweenNodes(Graph directed) {
		GraphNode start = randomNode(directed);
		GraphNode end = randomNodeOtherThan(directed, start);
		System.out.println("Start node: " + start.name);
		System.out.println("End node: " + end.name);
		System.out.println(directed.search(start, end) == true ? "Route exists!" : "No route connecting them!");
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

	public static GraphNode randomNode(Graph g) {
		return g.nodes[(int) (Math.random() * (g.numNodes - 1))];
	}

	public static GraphNode randomNodeOtherThan(Graph g, GraphNode n) {
		int randomInt = (int) (Math.random() * (g.numNodes - 1));
		return g.nodes[randomInt] == n ? randomNodeOtherThan(g, n) : g.nodes[randomInt];
	}

	private static Graph makeGraph() {
		Graph g = new Graph(randomSize(), true);
		g.generateNodes();
		g.connectNodes();
		g.printAdjacencyList();
		return g;
	}
}
