package trees;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ConstructionsAndConversions {

	public static void main(String[] args) {

		// System.out.println("\nString Tree:");
		// int stringRootSize = HelperFunctions.randomTreeSize();
		// String[] rootString = HelperFunctions.makeStringArray(stringRootSize);
		// Node stringRoot = makeStringBinaryTree(rootString);
		// HelperFunctions.printTree(stringRoot);

		// System.out.println("\nInteger Tree:");
		// int intRootSize = HelperFunctions.randomTreeSize();
		// int[] rootInt = HelperFunctions.makeIntArray(intRootSize);
		// Node<Integer> intRoot = makeIntBinaryTree(rootInt);
		// HelperFunctions.printTree(intRoot);

		System.out.println("\nCharacter Tree:");
		int charRootSize = HelperFunctions.randomTreeSize();
		char[] rootChar = HelperFunctions.makeCharArray(charRootSize);
		Node<Character> charRoot = makeCharBinaryTree(rootChar);
		HelperFunctions.printTree(charRoot);

		constructInOrderSuccessors(charRoot);

		// HelperFunctions.printTree(convertMirrorTree(charRoot));
		
		
	}

	protected static Node convertMirrorTree(Node root) {
		if (root == null)
			return null;
		Node left = convertMirrorTree(root.left);
		Node right = convertMirrorTree(root.right);
		root.left = right;
		root.right = left;
		return root;
	}

	protected static void constructInOrderSuccessors(Node root) {
		constructInOrderSuccessors(root, null);
	}

	private static void constructInOrderSuccessors(Node root, Node inOrderSuccessor) {
		if (root == null)
			return;
		constructInOrderSuccessors(root.right);
		root.inOrderSuccessor = (Node) inOrderSuccessor;
		inOrderSuccessor = root;
		constructInOrderSuccessors(root.left);
	}

	protected static Node<Character> makeCharBinaryTree(char[] ch) {
		return makeCharBinaryTree(ch, 1);
	}

	private static Node<Character> makeCharBinaryTree(char[] ch, int index) {
		Node<Character> root = null;
		if (index < ch.length) {
			root = new Node<Character>(ch[index - 1]);
			root.left = makeCharBinaryTree(ch, index * 2);
			root.right = makeCharBinaryTree(ch, index * 2 + 1);
		}
		return root;
	}

	protected static Node<String> makeStringBinaryTree(String[] s) {
		return makeStringBinaryTree(s, 1);
	}

	private static Node<String> makeStringBinaryTree(String[] s, int index) {
		Node<String> root = null;
		if (index < s.length) {
			root = new Node<String>(s[index - 1]);
			root.left = makeStringBinaryTree(s, index * 2);
			root.right = makeStringBinaryTree(s, index * 2 + 1);
		}
		return root;
	}

	protected static Node<Integer> makeIntBinaryTree(int[] a) {
		return makeIntBinaryTree(a, 1);
	}

	private static Node<Integer> makeIntBinaryTree(int[] a, int index) {
		if (index < a.length) {
			Node<Integer> n = new Node(a[index - 1]);
			n.left = makeIntBinaryTree(a, index * 2);
			n.right = makeIntBinaryTree(a, index * 2 + 1);
			return n;
		} else
			return null;
	}
}