package trees;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ConstructionsAndConversions {
	
	// For constructTreeFromInPre
	static int preIndex = 0;
	
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

		// char[] in = { 'D', 'B', 'E', 'A', 'F', 'C', 'G' };
		// char[] pre = { 'A', 'B', 'D', 'E', 'C', 'F', 'G' };
		// constructTreeFromInPre(in, pre);

		//
		
	}

	protected static void constructTreeFromInPre(char[] in, char[] pre) {
		HelperFunctions.printTree(constructTreeFromInPre(pre, in, 0, in.length - 1));
	}

	private static Node constructTreeFromInPre(char[] pre, char[] in, int inStart, int inEnd) {
		if (inStart > inEnd)
			return null;
		Node n = new Node(pre[preIndex++]);
		if (inStart == inEnd)
			return n;
		int inIndex = search(in, inStart, inEnd, (Character) n.data);
		n.left = constructTreeFromInPre(pre, in, inStart, inIndex - 1);
		n.right = constructTreeFromInPre(pre, in, inIndex + 1, inEnd);
		return n;
	}

	private static int search(char[] in, int inStart, int inEnd, char c) {
		int i;
		for (i = inStart; i <= inEnd; i++)
			if (in[i] == c)
				return i;
		return -1;
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