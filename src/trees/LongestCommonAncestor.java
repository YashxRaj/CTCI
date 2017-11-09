package trees;

import java.util.Vector;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class LongestCommonAncestor {

	public static void main(String[] args) {
		System.out.println("\nCharacter Tree:");
		int charRootSize = HelperFunctions.randomTreeSize();
		char[] rootChar = HelperFunctions.makeCharArray(charRootSize);
		Node<Character> charRoot = ConstructionsAndConversions.makeCharBinaryTree(rootChar);

		HelperFunctions.printTree(charRoot);

		Node x = new Node(HelperFunctions.randomChar(rootChar));
		Node y = new Node(HelperFunctions.otherRandomChar(rootChar, (Character) x.data));
		lowestCommonAncestor(charRoot, x, y);
	}

	// Not printing the final answer. Investigate.
	protected static void lowestCommonAncestor(Node root, Node x, Node y) {
		Vector<Node> xPath = new Vector<Node>(), yPath = new Vector<Node>();
		rootToNode(root, x, xPath);
		rootToNode(root, y, yPath);
		int smaller = xPath.size() > yPath.size() ? yPath.size() : xPath.size();

		System.out.println("Nodes: " + x.data + ", " + y.data + "\nPaths:");
		HelperFunctions.printVector(xPath);
		HelperFunctions.printVector(yPath);

		for (int i = 0; i < smaller; i++)
			if (xPath.get(i).data != yPath.get(i).data) {
				System.out.println("Least Common Ancestor: " + (xPath.get(i == 0 ? i : i - 1)));
				break;
			}
	}

	protected static Vector<Node> rootToNode(Node root, Node leaf, Vector<Node> path) {
		char[] buffer = new char[Miscellaneous.size(root)];
		rootToNode(root, buffer, 0, leaf, path);
		return path;
	}

	private static void rootToNode(Node root, char[] buffer, int index, Node x, Vector<Node> xPath) {
		if (root == null)
			return;
		buffer[index++] = (char) root.data;
		if (root.data == x.data)
			for (int i = 0; i < index; i++)
				xPath.add(new Node<Character>(buffer[i]));
		rootToNode(root.left, buffer, index, x, xPath);
		rootToNode(root.right, buffer, index, x, xPath);
	}
}
