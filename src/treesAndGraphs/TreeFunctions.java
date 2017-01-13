package treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

import stacksAndQueues.Queue;

public class TreeFunctions {

	public static ArrayList<ArrayList<TreeNode>> listOfDepthsDFS(TreeNode root) {
		ArrayList<ArrayList<TreeNode>> lists = new ArrayList<ArrayList<TreeNode>>();
		return ListOfDepthsDFS(root, lists, 0);
	}

	private static ArrayList<ArrayList<TreeNode>> ListOfDepthsDFS(TreeNode root, ArrayList<ArrayList<TreeNode>> lists,
			int level) {
		ArrayList<TreeNode> list = null;
		if (lists.size() == level) {
			list = new ArrayList<TreeNode>();
			lists.add(list);
		} else
			list = lists.get(level);
		list.add(root);
		if (root.getLeft() != null)
			ListOfDepthsDFS(root.getLeft(), lists, level + 1);
		if (root.getRight() != null)
			ListOfDepthsDFS(root.getRight(), lists, level + 1);
		return lists;
	}

	public static ArrayList<ArrayList<TreeNode>> listOfDepthsBFS(TreeNode root) {
		ArrayList<ArrayList<TreeNode>> lists = new ArrayList<ArrayList<TreeNode>>();
		ArrayList<TreeNode> current = new ArrayList<TreeNode>();
		Queue<TreeNode> q = new Queue<TreeNode>();
		q.enqueue(root);
		if (root != null)
			current.add(root);
		while (!current.isEmpty()) {
			lists.add(current);
			ArrayList<TreeNode> parent = current;
			current = new ArrayList<TreeNode>();
			for (TreeNode n : parent) {
				if (n.getLeft() != null)
					current.add(n.getLeft());
				if (n.getRight() != null)
					current.add(n.getRight());
			}
		}
		return lists;
	}

	public static TreeNode createMinimalBST(int[] a) {
		return createMinimalBST(a, 0, a.length - 1);
	}

	private static TreeNode createMinimalBST(int[] a, int start, int end) {
		if (end < start)
			return null;
		int mid = (start + end) / 2;
		return new TreeNode(Integer.toString(a[mid]), createMinimalBST(a, start, mid - 1),
				createMinimalBST(a, mid + 1, end));
	}

	// Not mine, tweaked a little though.
	public static void print(TreeNode root) {
		List<List<String>> lines = new ArrayList<List<String>>();
		List<TreeNode> level = new ArrayList<TreeNode>();
		List<TreeNode> next = new ArrayList<TreeNode>();
		level.add(root);
		int nn = 1, widest = 0;
		while (nn != 0) {
			List<String> line = new ArrayList<String>();
			nn = 0;
			for (TreeNode n : level) {
				if (n == null) {
					line.add(null);
					next.add(null);
					next.add(null);
				} else {
					String aa = n.getData();
					line.add(aa);
					if (aa.length() > widest)
						widest = aa.length();
					next.add(n.getLeft());
					next.add(n.getRight());
					if (n.getLeft() != null)
						nn++;
					if (n.getRight() != null)
						nn++;
				}
			}

			if (widest % 2 == 1)
				widest++;
			lines.add(line);
			List<TreeNode> tmp = level;
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

	public static void printListOfDepths(ArrayList<ArrayList<TreeNode>> lists, String str) {
		StringBuffer s = new StringBuffer();
		s.append(str);
		s.append(System.lineSeparator());
		int i = 0;
		for (ArrayList<TreeNode> list : lists) {
			s.append("Level " + i++ + ": ");
			for (TreeNode n : list)
				s.append(value(n) + " ");
			s.append(System.lineSeparator());
		}
		System.out.println(s.toString());
	}

	public static TreeNode arrayToBinaryTree(int[] a) {
		return arrayToBinaryTree(a, 1);
	}

	private static TreeNode arrayToBinaryTree(int[] a, int index) {
		if (index <= a.length)
			return new TreeNode(Integer.toString(a[index - 1]), arrayToBinaryTree(a, index * 2),
					arrayToBinaryTree(a, index * 2 + 1));
		else
			return null;
	}

	public static int height(TreeNode n) {
		if (n == null)
			return -1;
		else
			return Math.max(height(n.getLeft()), height(n.getRight())) + 1;
	}

	public static boolean checkBalanced(TreeNode root) {
		return heightIfBalanced(root) != Integer.MIN_VALUE;
	}

	private static int heightIfBalanced(TreeNode root) {
		if (root == null)
			return -1;
		int leftHeight = heightIfBalanced(root.getLeft());
		if (leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		int rightHeight = heightIfBalanced(root.getRight());
		if (rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		int heightDiff = Math.abs(leftHeight - rightHeight);
		if (heightDiff > 1)
			return Integer.MIN_VALUE;
		else
			return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void inOrderTraversal(TreeNode n) {
		if (n != null) {
			inOrderTraversal(n.getLeft());
			System.out.print(value(n) + " ");
			inOrderTraversal(n.getRight());
		}
	}

	public static void preOrderTraversal(TreeNode n) {
		if (n != null) {
			System.out.print(value(n) + " ");
			preOrderTraversal(n.getLeft());
			preOrderTraversal(n.getRight());
		}
	}

	public static void postOrderTraversal(TreeNode n) {
		if (n != null) {
			postOrderTraversal(n.getLeft());
			postOrderTraversal(n.getRight());
			System.out.print(value(n) + " ");
		}
	}

	public static int size(TreeNode root) {
		if (root == null)
			return 0;
		else
			return 1 + size(root.getLeft()) + size(root.getRight());
	}

	private static int value(TreeNode root) {
		return Integer.parseInt(root.getData());
	}
}
