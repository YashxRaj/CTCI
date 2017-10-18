package microsoft;

import java.util.ArrayList;
import java.util.List;

public class BT {

	public static void main(String[] args) {
		Node root = randomBinaryTree(randomArray(size()));
		printTree(root);

		System.out.print("InOrder Traversal: ");
		inOrderRecursive(root);
		// Do it in iterative.
		System.out.print("\nPreOrder Traversal: ");
		preOrderRecursive(root);

		System.out.println("\nPostOrder Traversal: ");
		postOrderRecursive(root);

	}

	private static void postOrderRecursive(Node root) {
		if (root == null)
			return;
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.data + " ");
	}

	private static void preOrderRecursive(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
	}

	private static void inOrderRecursive(Node root) {
		if (root == null)
			return;
		inOrderRecursive(root.left);
		System.out.print(root.data + " ");
		inOrderRecursive(root.right);
	}

	private static Node randomBinaryTree(int[] a) {
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

	private static int[] randomArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = randomNumber();
		return array;
	}

	private static int randomNumber() {
		int random = (int) (Math.random() * 10);
		return random;
	}

	private static int size() {
		int random = 0;
		do {
			random = randomNumber();
		} while (random == 0);
		return random;
	}

	private static void printTree(Node root) {
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
					String aa = Integer.toString(n.data);
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
