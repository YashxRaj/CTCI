package trees;

@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
public class ConstructionsAndConversions {

	protected static void main(String[] args) {

	}

	/**
	private static Node mirror(Node root) {
		if (root == null)
			return null;
	
		Node left = mirror(root.left);
		Node right = mirror(root.right);
	
		root.left = right;
		root.right = left;
	
		return root;
	}
	*/
	// GFG: Above. Me: below. Learning opportunity.
	protected static Node convertMirrorTree(Node root) {
		if (root == null)
			return null;

		convertMirrorTree(root.left);
		convertMirrorTree(root.right);

		Node left = root.left;
		Node right = root.right;

		root.left = right;
		root.right = left;

		return root;
	}

	protected static void buildInOrderSuccessors(Node root) {
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

	protected static Node randomBinaryTree(int[] a) {
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
}