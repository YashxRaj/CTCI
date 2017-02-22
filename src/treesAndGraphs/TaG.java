package treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class TaG {

	public static void main(String[] args) {
		// test();
		// routeBetweenNodes(makeGraph(true));
		// sortedArrayToBST(makeSortedArray(randomSize()));
		// listOfDepths(randomBST());
		// checkBalancedTree(randomBinaryTree());
		// checkBinaryTreeIsBST(randomBinaryTree());
		// successor(randomBST()); // Incomplete
		// buildOrder();
		// firstCommonAncestor(randomBinaryTree());
		// bstToSortedArray(randomBST());
		// checkSubTree(randomBinaryTree());
		pathsWithSum(randomBinaryTree());
	}

	private static void tree() {
		// test this.
	}

	private static void pathsWithSum(TreeNode root) {
		int sum = (int) (Math.random() * 50);
		TreeFunctions.print(root);
		System.out.println("Sum: "+sum);
		System.out.println("Number of paths: " + TreeFunctions.countPathsWithSum(root, sum));
		for (Vector<TreeNode> path : TreeFunctions.paths(root, sum))
			printTreeNodeVector(path, "Path: ");
	}

	static void printTreeNodeVector(Vector<TreeNode> x, String msg) {
		System.out.print(msg+" START->");
		for (TreeNode t : x)
			System.out.print(t.getData() + "->");
		System.out.println("END");
	}

	private static void checkSubTree(TreeNode root) {
		TreeNode subTreeNode = randomTreeNode(root);
		TreeFunctions.print(root);
		TreeFunctions.print(subTreeNode);
		if (TreeFunctions.checkSubTree2(root, subTreeNode) == TreeFunctions.checkSubTree(root, subTreeNode)
				&& TreeFunctions.checkSubTree2(root, subTreeNode) == true)
			System.out.println("SubTree is contained in the Binary Tree.");
		else
			System.out.println("SubTree is not contained in the Binary Tree.");
	}

	private static void bstToSortedArray(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> seq = TreeFunctions.bstToArrays(root);
		for (LinkedList<TreeNode> x : seq) {
			for (TreeNode t : x)
				System.out.print(t.getData() + " ");
			System.out.println();
		}
	}

	private static void firstCommonAncestor(TreeNode root) {
		// Possible to solve this given only 2 Traversals of the tree.
		TreeFunctions.print(root);
		TreeNode one = randomTreeNode(root);
		TreeNode two = randomTreeNodeOtherThan(one, root);
		System.out.println("One: " + one.getData());
		System.out.println("Two: " + two.getData());
		TreeNode ancestor = TreeFunctions.commonAncestorOf(one, two, root);
		if (ancestor == null)
			System.out.println("Common Ancestor not found.");
		else
			System.out.println("Ancestor: " + ancestor.getData());
	}

	private static TreeNode randomTreeNodeOtherThan(TreeNode one, TreeNode root) {
		Vector<TreeNode> v = TreeFunctions.traversal(root, "in");
		TreeNode two = v.get((int) (Math.random() * v.size() - 1));
		return one == two ? randomTreeNodeOtherThan(one, root) : two;
	}

	private static void buildOrder() {
		Vector<String> projects = new Vector<String>();
		Vector<Vector<String>> dependencies = new Vector<Vector<String>>();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Project:");
		String[] split = s.nextLine().split("\\s+");
		for (int i = 0; i < split.length; i++)
			projects.addElement(split[i]);
		System.out.println("Enter Dependencies:");
		for (int i = 0; i < projects.size(); i++) {
			System.out.print(projects.get(i) + " : ");
			String input = s.nextLine();
			if (input == null)
				input = " - ";
			split = input.split("\\s+");
			dependencies.addElement(new Vector<String>());
			for (int j = 0; j < split.length; j++)
				dependencies.get(i).add(split[j]);
		}
		s.close();
		GraphFunctions.buildOrder(projects, dependencies);
	}

	/*
	 * private static void successor(TreeNode root) {
	 * 
	 * TreeNode randomNode = randomTreeNode(root);
	 * TreeFunctions.print(root);
	 * System.out.println("Previous Node: " + randomNode.getData() +
	 * "\nSuccessor: "
	 * + TreeFunctions.successor(randomNode).getData());
	 * }
	 */
	private static TreeNode randomBST() {
		return TreeFunctions.createMinimalBST(makeSortedArray(randomSize()));
	}

	private static TreeNode randomBinaryTree() {
		return TreeFunctions.arrayToBinaryTree(makeArray(randomSize()));
	}

	private static void checkBinaryTreeIsBST(TreeNode root) {
		TreeFunctions.print(root);
		System.out.println("Min Max Method: " + (TreeFunctions.checkBST(root) == true ? "Is a BST" : "Is not a BST"));
	}

	private static void checkBalancedTree(TreeNode root) {
		if (Math.random() > 0.5) {
			TreeNode t = root;
			while (t.getLeft() != null)
				t = t.getLeft();
			t.setLeft(new TreeNode(Integer.toString(50)));
		}
		TreeFunctions.print(root);
		System.out.println(TreeFunctions.checkBalanced(root) == true ? "Balanced" : "Unbalanced");
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
		s.append(GraphFunctions.routeBetweenNodesDFS(directed, start, end) == GraphFunctions
				.routeBetweenNodesBFS(directed, start, end)
				&& GraphFunctions.routeBetweenNodesDFS(directed, start, end) == true ? "Route exists!"
						: "No route connecting them!");
		System.out.println(s.toString());
	}

	private static TreeNode sortedArrayToBST(int[] a) {
		printArray(a);
		TreeNode root = TreeFunctions.createMinimalBST(a);
		TreeFunctions.print(root);
		return root;
	}

	private static void printArray(int[] a) {
		System.out.print("[ ");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println("]");
	}

	private static int[] makeArray(int size) {
		int[] a = new int[size];
		for (int i = 0; i < size; i++)
			a[i] = (int) (Math.random() * 10);
		return a;
	}

	private static int[] makeSortedArray(int size) {
		int[] a = new int[size];
		int key1 = (int) (Math.random() * 10), key2 = (int) (Math.random() * 10);
		for (int i = 0; i < size; i++)
			a[i] = i * (key1 + key2 + i);
		return a;
	}

	private static int randomSize() {
		return 5 + (int) (Math.random() * 10);
	}

	private static TreeNode randomTreeNode(TreeNode root) {
		Vector<TreeNode> v = TreeFunctions.traversal(root, "in");
		return v.get((int) (Math.random() * v.size() - 1));
	}

	public static GraphNode randomGraphNode(Graph g) {
		return g.nodes.get((int) (Math.random() * (g.nodes.size() - 1)));
	}

	public static GraphNode randomGraphNodeOtherThan(Graph g, GraphNode n) {
		int randomInt = (int) (Math.random() * (g.nodes.size() - 1));
		return g.nodes.get(randomInt) == n ? randomGraphNodeOtherThan(g, n) : g.nodes.get(randomInt);
	}

	private static Graph makeGraph(boolean directed) {
		Graph g = new Graph(directed);
		g.generateRandomGraphNodes(randomSize());
		g.connectRandomGraphNodes(directed);
		g.printAdjacencyList();
		return g;
	}
}
