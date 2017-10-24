package microsoft;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree {

	public static void main(String[] args) {
		Node root = makeCharBinaryTree(randomCharArray(size()));
		printTree(root);
		// Do it in iterative.
		System.out.print("InOrder Recursive Traversal:\n");
		inOrderRecursive(root);
		/**
		 * System.out.print("\nPreOrder Recursive Traversal:\n");
		 * preOrderRecursive(root);
		 * 
		 * System.out.println("\nPostOrder Recursive Traversal:");
		 * postOrderRecursive(root);
		 */
		char[] pre = { 'a', 'b', 'd', 'e', 'c', 'f', 'g' };
		char[] in = { 'd', 'b', 'e', 'a', 'f', 'c', 'g' };
		char[] post = { 'd', 'e', 'b', 'f', 'g', 'c', 'a' };
		/**
		 * 
		 * System.out.println("\nMorris Iterative Traversal:");
		 * morrisTraversal(root, "pre");
		 * morrisTraversal(root, "in");
		 * 
		 * System.out.println("\nLevel Order Recursive Traversal:");
		 * levelOrderTraversal(root);
		 * 
		 * System.out.println("\nReverse Level Order Recursive Traversal:");
		 * reverseLevelOrderTraversal(root);
		 * 
		 * Node root2 = buildTreeInPre(in,pre, 0, in.length-1, 0);
		 * Node root3 = buildFullBinaryTree(pre, post,0, pre.length-1, pre.length, 0);
		 * printTree(root2);
		 * printTree(root3);
		 * 
		 * LinkedListNode head = LinkedListFunctions.generateLinkedList(10);
		 * LinkedListFunctions.printLinkedList(head);
		 * buildCompleteBinaryTreeFromLinkedList(head);
		 * 
		 */
		System.out.println();
		// printTree(buildComepleteBinaryTreeFromPreorderAndPostOrder(pre,post));
		// rootToLeaves(root);
		// System.out.println("Reverse Recursive InOrder Traversal");
		// reverseInorderRecursive(root);
		// printLeaves(getLeaves(root));
		// connectNodesSameLevel(root);
		// getLevelVectors(root);

		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		s.close();
		printNodesK(root, data);
	}
	// Work In Progress.
	public static boolean isFoldable(Node root) {
		if(root == null)
			return true;
		
		return false;
	}

	public static void printNodesK(Node root, int k) {
		if (root == null)
			return;
		if (k == 0)
			System.out.print(root.data + " ");
		printNodesK(root.left, k - 1);
		printNodesK(root.right, k - 1);
	}

	public static Node makeCharBinaryTree(char[] ch) {
		return makeCharBinaryTree(ch, 1);
	}

	private static Node makeCharBinaryTree(char[] ch, int index) {
		Node root = null;
		if (index < ch.length) {
			root = new Node(ch[index - 1]);
			root.left = makeCharBinaryTree(ch, index * 2);
			root.right = makeCharBinaryTree(ch, index * 2 + 1);
		}
		return root;
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

	/**
	 * Forbidden code.
	 * Do not use this, otherwise what is the point of being clever about it?
	 */
	public static Vector<Vector<Node>> getLevelVectors(Node root) {
		int height = height(root);
		// Must initialize before using otherwise what are we getting from called function?
		Vector<Vector<Node>> levelVectors = new Vector<Vector<Node>>(height);
		for (int i = 0; i <= height; i++)
			levelVectors.add(new Vector<Node>());

		getLevelVectors(root, levelVectors, height);

		System.out.println("Printing each level:");
		for (int i = height; i >= 0; i--)
			printVector(levelVectors.get(i));
		return levelVectors;
	}

	private static void printVector(Vector<Node> vector) {
		for (Node n : vector)
			System.out.print(n.data + " ");
		System.out.println();
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
			/**
			System.out.println("Proof:");
			for (Node n : levelVector)
				System.out.print(n.data + " -> " + ((n.nextRight == null) ? "null " : (n.nextRight.data + "|")));
			System.out.println();
			*/
		}
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

	private static void printLeaves(Vector<Node> leaves) {
		for (Node leaf : leaves)
			System.out.println(leaf.data + " ");
		System.out.println();
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

	public static void buildInOrderSuccessors(Node root) {
		buildInOrderSuccessors(root, null);
	}

	private static void buildInOrderSuccessors(Node root, Node inOrderSuccessor) {
		if (root == null)
			return;
		buildInOrderSuccessors(root.right);
		root.inOrderSuccessor = (Node) inOrderSuccessor;
		inOrderSuccessor = root;
		buildInOrderSuccessors(root.left);
	}

	private static void reverseInorderRecursive(Node root) {
		if (root == null)
			return;
		reverseInorderRecursive(root.right);
		System.out.print(root.data + " ");
		reverseInorderRecursive(root.left);
	}

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
			printArray(buffer, index);
		rootToLeaves(root.left, buffer, index);
		rootToLeaves(root.right, buffer, index);
	}

	private static void printArray(int[] buffer, int index) {
		for (int i = 0; i < index; i++)
			System.out.print(buffer[i] + " ");
		System.out.println();
	}

	public static int countLeafNodes(Node root) {
		return root == null ? 0
				: (root.left == null && root.right == null) ? 1
						: (countLeafNodes(root.left) + countLeafNodes(root.right));
	}

	// Root must be equal to sum of left and right child (not subtree).
	public static boolean childrenSumProperty(Node<Integer> root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		if (root.left == null)
			return root.data == root.right.data;
		if (root.right == null)
			return root.data == root.left.data;
		if (root.data != (root.left.data + root.right.data))
			return false;
		return childrenSumProperty(root.left) && childrenSumProperty(root.right);
	}

	// O(n^2)
	private static int longestPathInefficient(Node root) {
		return root == null ? 0
				: Math.max((height(root.left) + height(root.right) + 1),
						Math.max(longestPathInefficient(root.left), longestPathInefficient(root.right)));
	}

	public static int longestPath(Node root) {
		return longestPath(root, 0);
	}

	/**
	 * Similar to calculating height of tree.
	 * if(root == null)
	 * 		return -1;
	 * int lh = height(root.left);
	 * int rh = height(root.right);
	 * return 1 +Math.max(lh,rh);
	 *
	 * O(n)
	 */
	private static int longestPath(Node root, int pathCount) {
		if (root == null)
			return 0;
		int leftHeight = longestPath(root.left, pathCount);
		int rightHeight = longestPath(root.right, pathCount);
		pathCount = Math.max(1 + leftHeight + rightHeight, pathCount);
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public static boolean isAVL(Node root) {
		return root == null ? true
				: (Math.abs(height(root.left) - height(root.right)) <= 1 && isAVL(root.left) && isAVL(root.right));
	}

	public static int size(Node root) {
		return root == null ? 0 : (size(root.left) + 1 + size(root.right));
	}

	public static Node<Character> buildComepleteBinaryTreeFromPreorderAndPostOrder(char[] pre, char[] post) {
		return buildCBTPrePost(pre, post, 0, 0, post.length - 1);
	}

	// Something wrong here.
	private static Node<Character> buildCBTPrePost(char[] pre, char[] post, int preIndex, int postStart, int postEnd) {
		if (preIndex >= pre.length || postStart > postEnd)
			return null;
		Node<Character> root = new Node<Character>(pre[preIndex++]);
		if (preIndex >= pre.length || postStart == postEnd)
			return root;
		int i = postStart;
		for (; i < postEnd; i++)
			if (post[i] == pre[preIndex])
				break;
		if (i <= postEnd) {
			root.left = buildCBTPrePost(pre, post, preIndex, postStart, i);
			root.right = buildCBTPrePost(pre, post, preIndex, i + 1, postEnd);
		}
		return root;
	}

	// Doubt about using head directly instead of using it as copy variable.
	private static void buildCompleteBinaryTreeFromLinkedList(LinkedListNode head) {
		LinkedListNode h = head;
		Node<Integer> root = new Node<Integer>(h.data);
		LinkedList<Node<Integer>> q = new LinkedList<Node<Integer>>();

		q.add(root);
		while (!q.isEmpty() && h.next != null && h.next.next != null) {
			Node<Integer> current = q.remove();

			h = h.next;
			current.left = new Node<Integer>(h.data);
			q.add(current.left);

			h = h.next;
			current.right = new Node<Integer>(h.data);
			q.add(current.right);
		}
		printTree(root);
	}

	public static void reverseLevelOrderTraversal(Node root) {
		int height = height(root);
		for (int i = height; i >= 0; i--) {
			System.out.println("\nLevel: " + i);
			levelOrderTraversal(root, i);
		}
	}

	public static Node<Character> buildFullBinaryTree(char[] preOrder, char[] postOrder) {
		return buildFullBinaryTree(preOrder, postOrder, 0, preOrder.length - 1, preOrder.length);
	}

	private static Node<Character> buildFullBinaryTree(char[] preOrder, char[] postOrder, int low, int high,
			int preIndex) {
		if (low > high || preIndex > preOrder.length)
			return null;
		Node<Character> n = new Node<Character>(preOrder[preIndex++]);
		if (low == high || preIndex >= preOrder.length)
			return n;
		int i;
		for (i = low; i < high; i++)
			if (postOrder[i] == preOrder[preIndex])
				break;
		if (i <= high) {
			n.left = buildFullBinaryTree(preOrder, postOrder, low, i, preOrder.length);
			n.right = buildFullBinaryTree(preOrder, postOrder, i + 1, high, preOrder.length);
		}
		return n;
	}

	public static Node<Character> buildTreeFromInorderPreorder(char[] inOrder, char[] preOrder) {
		return buildTreeInPre(inOrder, preOrder, 0, inOrder.length - 1, 0);
	}

	// Constructs a tree from In-Order and Pre-Order traversals.
	private static Node<Character> buildTreeInPre(char[] inOrder, char[] preOrder, int inStart, int inEnd,
			int preIndex) {
		if (inStart < inEnd)
			return null;
		Node<Character> n = new Node<Character>(preOrder[preIndex++]);
		if (inStart == inEnd)
			return n;
		int inIndex = searchInOrder(inOrder, inStart, inEnd, (int) n.data);
		n.left = buildTreeInPre(inOrder, preOrder, inStart, inIndex - 1, preIndex);
		n.right = buildTreeInPre(inOrder, preOrder, inIndex + 1, inEnd, preIndex);
		return n;
	}

	// Returns index of given data in In-Order traversal.
	private static int searchInOrder(char[] inOrder, int inStart, int inEnd, int data) {
		int i;
		for (i = inStart; i < inEnd; i++)
			if (inOrder[i] == data)
				return i;
		return i;
	}

	// Traverses tree iteratively to print In-Order/Pre-Order traversals.
	private static void morrisTraversal(Node<Integer> node, String type) {
		if ("in".equalsIgnoreCase(type)) {
			System.out.println("InOrder Traversal:");
			while (node != null) {
				if (node.left == null) {
					System.out.print(node.data + " ");
					node = node.right;
				} else {
					Node<Integer> current = node.left;
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
		} else if ("pre".equalsIgnoreCase(type)) {
			System.out.println("PreOrder Traversal:");
			while (node != null) {
				if (node.left == null) {
					System.out.print(node.data + " ");
					node = node.right;
				} else {
					Node<Integer> current = node.left;
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
	}

	public static void levelOrderTraversal(Node root) {
		int height = height(root);
		System.out.println("Height of tree: " + (height + 1));
		for (int i = 0; i <= height; i++) {
			System.out.println("\nLevel: " + i);
			levelOrderTraversal(root, i);
		}
	}

	public static int height(Node root) {
		return root == null ? -1 : (Math.max(height(root.left), height(root.right)) + 1);
	}

	private static void levelOrderTraversal(Node root, int level) {
		if (root == null)
			return;
		if (level == 0)
			System.out.print(root.data + " ");
		levelOrderTraversal(root.left, level - 1);
		levelOrderTraversal(root.right, level - 1);
	}

	public static void postOrderRecursive(Node root) {
		if (root == null)
			return;
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.data + " ");
	}

	public static void preOrderRecursive(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
	}

	public static void inOrderRecursive(Node root) {
		if (root == null)
			return;
		inOrderRecursive(root.left);
		System.out.print(root.data + " ");
		inOrderRecursive(root.right);
	}

	public static Node randomBinaryTree(int[] a) {
		return makeBinaryTree(a, 1);
	}

	private static Node makeBinaryTree(int[] a, int index) {
		if (index < a.length) {
			Node n = new Node(a[index - 1]);
			n.left = makeBinaryTree(a, index * 2);
			n.right = makeBinaryTree(a, index * 2 + 1);
			return n;
		} else
			return null;

	}

	public static char[] randomCharArray(int size) {
		char[] ch = new char[size];
		char a = 'A';
		for (int i = 0; i < size; i++)
			ch[i] = a++;
		return ch;
	}

	public static int[] randomArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = randomNumber();
		return array;
	}

	public static int randomNumber() {
		int random = (int) (Math.random() * 10);
		return random;
	}

	public static int size() {
		int random = 0;
		do {
			random = randomNumber();
		} while (random == 0);
		return random;
	}

	public static void printTree(Node root) {
		List<List<String>> lines = new ArrayList<List<String>>();
		List<Node> level = new ArrayList<Node>();
		List<Node> next = new ArrayList<Node>();
		level.add(root);
		int nn = 1, widest = 0;
		while (nn != 0) {
			List<String> line = new ArrayList<String>();
			nn = 0;
			for (Node n : level) {
				if (n == null) {
					line.add(null);
					next.add(null);
					next.add(null);
				} else {
					String aa = String.valueOf(n.data);
					line.add(aa);
					if (aa.length() > widest)
						widest = aa.length();
					next.add(n.left);
					next.add(n.right);
					if (n.left != null)
						nn++;
					if (n.right != null)
						nn++;
				}
			}

			if (widest % 2 == 1)
				widest++;
			lines.add(line);
			List<Node> tmp = level;
			level = next;
			next = tmp;
			next.clear();
		}
		int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
		for (int i = 0; i < lines.size(); i++) {
			List<String> line = lines.get(i);
			int hpw = (int) Math.floor(perpiece / 2f) - 1;
			if (i > 0) {
				for (int j = 0; j < line.size(); j++) {
					char c = ' ';
					if (j % 2 == 1) {
						if (line.get(j - 1) != null)
							c = (line.get(j) != null) ? '^' : '/';
						else if (j < line.size() && line.get(j) != null)
							c = '\\';
					}
					System.out.print(c);
					if (line.get(j) == null)
						for (int k = 0; k < perpiece - 1; k++)
							System.out.print(" ");
					else {
						for (int k = 0; k < hpw; k++)
							System.out.print(j % 2 == 0 ? " " : "_");
						System.out.print(" ");
						for (int k = 0; k < hpw; k++)
							System.out.print(j % 2 == 0 ? "_" : " ");
					}
				}
				System.out.println();
			}
			for (int j = 0; j < line.size(); j++) {
				String f = line.get(j);
				if (f == null)
					f = "";
				int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
				int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);
				for (int k = 0; k < gap1; k++)
					System.out.print(" ");
				System.out.print(f);
				for (int k = 0; k < gap2; k++)
					System.out.print(" ");
			}
			System.out.println();
			perpiece /= 2;
		}
	}

}
