package trees;

import java.util.List;
import java.util.Stack;
import java.util.Vector;
import java.util.ArrayList;
import java.util.LinkedList;

@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
public class Miscellaneous {

	protected static Vector<Vector<Node>> getLevelVectors(Node root) {
		int height = Miscellaneous.height(root);
		// Must initialize before using otherwise what are we getting from called function?
		Vector<Vector<Node>> levelVectors = new Vector<Vector<Node>>(height);
		for (int i = 0; i <= height; i++)
			levelVectors.add(new Vector<Node>());

		getLevelVectors(root, levelVectors, height);

		System.out.println("Printing each level:");
		for (int i = height; i >= 0; i--)
			HelperFunctions.printVector(levelVectors.get(i));
		return levelVectors;
	}

	private static int getLevelVectors(Node root, Vector<Vector<Node>> levelVectors, int height) {
		if (root == null)
			return 0;
		levelVectors.get(height).add(root);
		getLevelVectors(root.left, levelVectors, height - 1);
		getLevelVectors(root.right, levelVectors, height - 1);
		return height;
	}

	public static void connectNodesSameLevel(Node root) {
		int height = height(root);
		System.out.println("Height of tree: " + height);
		Vector<Node> levelVector = null;

		for (int i = 0; i <= height; i++) {
			levelVector = getLevelVector(root, i, new Vector<Node>());
			for (int j = 0; j < levelVector.size(); j++)
				levelVector.get(j).nextRight = j == (levelVector.size() - 1) ? null : levelVector.get(j + 1);
		}
		System.out.println("Proof:");
		for (Node n : levelVector)
			System.out.print(n.data + " -> " + ((n.nextRight == null) ? "null " : (n.nextRight.data + "|")));
		System.out.println();
	}

	private static Vector<Node> getLevelVector(Node root, int level, Vector<Node> levelVector) {
		if (root == null)
			return null;
		if (level == 0)
			levelVector.add(root);
		getLevelVector(root.left, level - 1, levelVector);
		getLevelVector(root.right, level - 1, levelVector);
		return levelVector;
	}

	public static boolean sameLeaves(Node root1, Node root2) {
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();

		s1.push(root1);
		s2.push(root2);

		while (!s1.isEmpty() || !s2.isEmpty()) {
			if (s1.isEmpty() || s2.isEmpty())
				return false;

			// Finds next leaf node in the tree.
			Node temp1 = s1.pop();
			while (temp1 != null && !(temp1.left == null && temp1.right == null)) {
				if (temp1.left != null)
					s1.push(temp1.left);
				if (temp1.right != null)
					s1.push(temp1.right);
				temp1 = s1.pop();
			}
			// Finds next leaf node in the tree.
			Node temp2 = s2.pop();
			while (temp2 != null && !(temp2.left == null && temp2.right == null)) {
				if (temp2.left != null)
					s1.push(temp2.left);
				if (temp2.right != null)
					s1.push(temp2.right);
				temp2 = s2.pop();
			}

			if ((temp1 == null && temp2 != null) || (temp2 == null && temp1 != null))
				return false;
			else if (temp1 != null && temp2 != null && temp1.data != temp2.data)
				return false;
		}
		return true;
	}

	public static boolean printAncestors(Node root, Node key) {
		if (root == null)
			return false;
		if (root.data == key.data)
			return true;
		if (printAncestors(root.left, key) || printAncestors(root.right, key)) {
			System.out.print(root.data + " ");
			return true;
		}
		return false;
	}

	public static void doubleTree(Node root) {
		if (root == null)
			return;
		doubleTree(root.left);
		doubleTree(root.right);
		Node left = root.left, temp = new Node(root.data);
		root.left = temp;
		temp.left = left;
	}

	public static Vector<Node> getLeaves(Node root) {
		return getLeaves(root, new Vector<Node>());
	}

	// Prints only the leaves in the tree.
	private static Vector<Node> getLeaves(Node root, Vector<Node> v) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null)
			v.add(root);
		getLeaves(root.left, v);
		getLeaves(root.right, v);
		return v;
	}

	// Find maximum width using queue for BFS
	public static int maxmimumWidth(Node root) {
		if (root == null)
			return 0;

		int counter = 0, maxCounter = 0;
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			if (size == 0)
				break;
			while (size > 0) {
				Node temp = q.pop();
				counter++;
				if (temp.right != null)
					q.add(temp.right);
				if (temp.left != null)
					q.add(temp.left);
				size--;
			}
			maxCounter = counter > maxCounter ? counter : maxCounter;
			counter = 0;
		}
		return maxCounter;
	}

	public static void printNodesK(Node root, int k) {
		if (root == null)
			return;
		if (k == 0)
			System.out.print(root.data + " ");
		printNodesK(root.left, k - 1);
		printNodesK(root.right, k - 1);
	}

	// Yeah, baby. - You won't find this on GFG.
	public static boolean isFoldable(Node root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(root.left);
		q.add(root.right);
		while (!q.isEmpty()) {
			Node real = q.pop();
			Node mirror = q.pop();

			if ((real == null && mirror != null) || (real != null && mirror == null))
				return false;
			if ((real.left == null && mirror.right != null) || (real.right == null && mirror.left != null))
				return false;

			if (real.left != null && mirror.right != null) {
				q.add(real.left);
				q.add(mirror.right);
			} else if ((real.left == null && mirror.right != null) || (real.left != null && mirror.right == null))
				return false;

			if (real.right != null && mirror.left != null) {
				q.add(real.right);
				q.add(mirror.left);
			} else if ((real.right == null && mirror.left != null) || (real.right != null && mirror.left == null))
				return false;
		}
		return true;
	}

	public static boolean getLevelOfNode(Node root, Node key) {
		return getLevelOfNode(root, key, 1);
	}

	private static boolean getLevelOfNode(Node root, Node key, int level) {
		if (root == null)
			return false;
		if (root.data == key.data) {
			System.out.println(level);
			return true;
		}
		return getLevelOfNode(root.left, key, level + 1) || getLevelOfNode(root.right, key, level + 1);
	}

	// Using level order traversal
	public static int maximumWidthSlow(Node root) {
		int height = height(root), maxWidth = 0, width = 0;
		for (int i = 0; i <= height; i++)
			maxWidth = (width = getWidth(root, i)) > maxWidth ? width : maxWidth;
		return maxWidth;
	}

	private static int getWidth(Node root, int height) {
		if (root == null)
			return 0;
		if (height == 1)
			return 1;
		return getWidth(root.left, height - 1) + getWidth(root.right, height - 1);
	}

	// Prints all root to leaf paths.
	public static void rootToLeaves(Node root) {
		System.out.println("Printing root to leaf paths:");
		int[] buffer = new int[size(root)];
		rootToLeaves(root, buffer, 0);
	}

	private static void rootToLeaves(Node root, int[] buffer, int index) {
		if (root == null)
			return;
		buffer[index++] = (int) root.data;
		if (root.left == null && root.right == null)
			HelperFunctions.printIntArray(buffer, index);
		rootToLeaves(root.left, buffer, index);
		rootToLeaves(root.right, buffer, index);
	}

	// Returns count of leaf nodes in tree.
	public static int countLeafNodes(Node root) {
		if (root == null)
			return 0;
		if (root.isLeaf())
			return 1;
		return countLeafNodes(root.left) + countLeafNodes(root.right);
	}

	// Root must be equal to sum of left and right child (not subtree).
	public static boolean ischildrenSumProperty(Node<Integer> root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		if (root.left == null)
			return root.data == root.right.data;
		if (root.right == null)
			return root.data == root.left.data;
		if (root.data != (root.left.data + root.right.data))
			return false;
		return ischildrenSumProperty(root.left) && ischildrenSumProperty(root.right);
	}

	// O(n^2)
	private static int longestPathSlow(Node root) {
		if (root == null)
			return 0;
		int height = 1 + height(root.left) + height(root.right);
		return Math.max(height, Math.max(longestPathSlow(root.left), longestPathSlow(root.right)));

	}

	// Returns the length of the longest path
	public static int longestPath(Node root) {
		return longestPath(root, 0);
	}

	private static int longestPath(Node root, int pathCount) {
		/** 
		Similar to calculating height of tree. O(n)
		  if(root == null) return -1;
		  int lh = height(root.left);
		  int rh = height(root.right);
		  return 1 +Math.max(lh,rh);
		*/
		if (root == null)
			return 0;
		int leftHeight = longestPath(root.left, pathCount);
		int rightHeight = longestPath(root.right, pathCount);
		pathCount = Math.max(1 + leftHeight + rightHeight, pathCount);
		return 1 + Math.max(leftHeight, rightHeight);
	}

	// Returns total number of nodes in the tree.
	public static int size(Node root) {
		return root == null ? 0 : (size(root.left) + 1 + size(root.right));
	}

	public static int height(Node root) {
		if (root == null)
			return 0;
		else
			return 1 + Math.max(height(root.left), height(root.right));
	}

	// AVL tree - difference between left subtree and right subtree <= 1
	public static boolean isAVL(Node root) {
		if (root == null)
			return true;
		return (Math.abs(height(root.left) - height(root.right)) <= 1 && isAVL(root.left) && isAVL(root.right));
	}

}