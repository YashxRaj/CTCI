package trees;

import trees.Miscellaneous;

import java.util.Vector;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Collections;

@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
public class Traversals {

	public static void main(String[] args) {
		int charRootSize = HelperFunctions.randomTreeSize();
		char[] rootChar = HelperFunctions.makeCharArray(charRootSize);
		Node<Character> charRoot = ConstructionsAndConversions.makeCharBinaryTree(rootChar);
		HelperFunctions.printTree(charRoot);

		// morrisInOrder(charRoot);
		// morrisPreOrder(charRoot);

		inOrderRecursive(charRoot);
		System.out.println();
		inOrderIterative(charRoot);
		// reverseInorderRecursive(charRoot);

		// preOrderRecursive(charRoot);
		// reversePreorderRecursive(charRoot);

		// postOrderRecursive(charRoot);
		// reversePostorderRecursive(charRoot);

		// levelOrder(charRoot);
		// reverseLevelOrder(charRoot);

		// vertical(charRoot);
		// boundary(charRoot);
		// diagonal(charRoot);

		// Requires a perfect Binary Tree
		// perfectBinaryTreeSpecificLevelOrder(charRoot);

		// TO DO:

		// preOrderIterative(charRoot);
		// postOrderIterative(charRoot);

		// reverseInorderIterative(charRoot);
		// reversePreorderIterative(charRoot);
		// reversePostorderIterative(charRoot);

	}

	
	
	protected static void inOrderIterative(Node root) {
		if (root == null)
			return;
		Stack<Node> stack = new Stack<Node>();
		Node n = root;
		while (n != null) {
			stack.push(n);
			n = n.left;
		}
		while (!stack.isEmpty()) {
			n = stack.pop();
			System.out.print(n.data + " ");
			if (n.right != null) {
				n = n.right;
				while (n != null) {
					stack.push(n);
					n = n.left;
				}
			}
		}
	}

	protected static void diagonal(Node root) {
		HashMap<Integer, Vector<Node>> map = diagonal(root, 0, new HashMap<Integer, Vector<Node>>());
		if (map.keySet() != null)
			for (Integer x : map.keySet())
				HelperFunctions.printVector(map.get(x));
		else
			System.out.println("Map is empty!");
	}

	private static HashMap<Integer, Vector<Node>> diagonal(Node root, int slope, HashMap<Integer, Vector<Node>> map) {
		if (root == null)
			return null;
		Vector<Node> k = map.get(slope);
		if (k == null) {
			k = new Vector<Node>();
			map.put(slope, k);
		}
		k.add(root);
		diagonal(root.left, slope + 1, map);
		diagonal(root.right, slope, map);
		return map;
	}

	// Prints all the boundary and leaf nodes.
	protected static void boundary(Node root) {
		System.out.println("Printing Tree Boundary: ");
		HelperFunctions.printVector(boundary(root, new Vector<Node>()));
	}

	private static Vector<Node> boundary(Node root, Vector<Node> v) {
		if (root == null)
			return null;
		v.add(root);
		Node left = root, right = root;

		// Left
		while (left != null && !left.isLeaf()) {
			if (!v.contains(left))
				v.add(left);
			left = left.left;
		}

		// Alternatively, v.addAll(Miscellaneous.getLeaves(root)) - Recursive;
		// Generalized DFS for trees.
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node current = q.pop();
			if (current.right != null)
				q.addFirst(current.right);
			if (current.left != null)
				q.addFirst(current.left);
			if (current.isLeaf() && !v.contains(current))
				v.add(current);
		}

		// Right - to be done in reverse.
		Vector<Node> rightVector = new Vector<Node>();
		while (right != null && !right.isLeaf()) {
			if (!v.contains(right))
				rightVector.add(right);
			right = right.right;
		}
		for (int i = rightVector.size() - 1; i >= 0; i--)
			v.add(rightVector.get(i));
		return v;
	}

	protected static void vertical(Node root) {
		System.out.println("Vertical Traversal: ");
		HashMap<Integer, Vector<Node>> map = new HashMap<Integer, Vector<Node>>();
		vertical(root, map, 0);

		int min = Collections.min(map.keySet());
		int max = Collections.max(map.keySet());

		for (int i = min, j = 1; i <= max && !map.get(i).isEmpty(); i++) {
			System.out.print("Line: " + j++ + " - ");
			HelperFunctions.printVector(map.get(i));
		}
	}

	private static HashMap<Integer, Vector<Node>> vertical(Node root, HashMap<Integer, Vector<Node>> map, int i) {
		if (root == null)
			return null;
		if (!map.containsKey(i))
			map.put(i, new Vector<Node>());
		map.get(i).add(root);
		vertical(root.left, map, i - 1);
		vertical(root.right, map, i + 1);
		return map;
	}

	// Solved, but requires thorough understanding for follow up questions.
	protected static void perfectBinaryTreeSpecificLevelOrder(Node root) {
		if (root == null)
			return;
		else
			System.out.print(root.data + " ");

		LinkedList<Node> q = new LinkedList<Node>();
		q.add(root.left);
		q.add(root.right);

		while (!q.isEmpty()) {
			int size = q.size();
			if (size == 0)
				break;
			while (size > 0) {
				Node left = null, right = null;
				if (q.peekFirst() != null) {
					left = q.remove();
					System.out.print(left.data + " ");
					size--;
				}
				if (q.peekLast() != null) {
					right = q.remove();
					System.out.print(right.data + " ");
					size--;
				}

				if (left.left != null)
					q.add(left.left);
				if (right.right != null)
					q.add(right.right);
				if (left.right != null)
					q.add(left.right);
				if (right.left != null)
					q.add(right.left);
			}
		}
		System.out.println();
	}

	private static void levelOrderIterative(Node root) {
		if (root == null)
			return;
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(root);
		int i = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			if (size == 0)
				break;
			System.out.println("Level: " + i++);
			while (size > 0) {
				Node temp = q.pop();
				System.out.print(temp.data + " ");
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
				size--;
			}
			System.out.println();
		}
	}

	protected static void reverseInorderRecursive(Node root) {
		if (root == null)
			return;
		reverseInorderRecursive(root.right);
		System.out.print(root.data + " ");
		reverseInorderRecursive(root.left);
	}

	protected static void postOrderRecursive(Node root) {
		if (root == null)
			return;
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.data + " ");
	}

	protected static void preOrderRecursive(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
	}

	protected static void inOrderRecursive(Node root) {
		if (root == null)
			return;
		inOrderRecursive(root.left);
		System.out.print(root.data + " ");
		inOrderRecursive(root.right);
	}

	protected static void levelOrder(Node root) {
		int height = Miscellaneous.height(root);
		System.out.println("Height of tree: " + (height + 1));
		for (int i = 0; i <= height; i++) {
			System.out.println("\nLevel: " + i);
			levelOrder(root, i);
		}
	}

	protected static void reverseLevelOrder(Node root) {
		int height = Miscellaneous.height(root);
		System.out.println("Height of tree: " + (height + 1));
		for (int i = height; i >= 0; i--) {
			System.out.println("\nLevel: " + i);
			levelOrder(root, i);
		}
	}

	private static void levelOrder(Node root, int level) {
		if (root == null)
			return;
		if (level == 0)
			System.out.print(root.data + " ");
		levelOrder(root.left, level - 1);
		levelOrder(root.right, level - 1);
	}

	// Traverses tree iteratively to print PreOrder traversals.
	protected static void morrisPreOrder(Node node) {
		System.out.println("Morris PreOrder Traversal:");
		while (node != null) {
			if (node.left == null) {
				System.out.print(node.data + " ");
				node = node.right;
			} else {
				Node current = node.left;
				while (current.right != null && current.right != node)
					current = current.right;
				if (current.right == node) {
					current.right = null;
					node = node.right;
				} else {
					System.out.print(node.data + " ");
					current.right = node;
					node = node.left;
				}
			}
		}
		System.out.println();
	}

	// Traverses tree iteratively to print InOrder traversals.
	protected static void morrisInOrder(Node node) {
		System.out.println("Morris InOrder Traversal:");
		while (node != null) {
			if (node.left == null) {
				System.out.print(node.data + " ");
				node = node.right;
			} else {
				Node current = node.left;
				while (current.right != null && current.right != node)
					current = current.right;
				if (current.right == node) {
					System.out.print(node.data + " ");
					current.right = null;
					node = node.right;
				} else {
					current.right = node;
					node = node.left;
				}
			}
		}
		System.out.println();
	}
}