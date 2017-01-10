package treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class TreeFunctions {

	public static ArrayList<ArrayList<TreeNode>> listOfDepths(TreeNode root) {
		ArrayList<ArrayList<TreeNode>> a = new ArrayList<ArrayList<TreeNode>>();
		ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
		
		return null;
	}

	public static TreeNode createMinimalBST(int[] a) {
		return createMinimalBST(a, 0, a.length - 1);
	}

	private static TreeNode createMinimalBST(int[] a, int start, int end) {
		if (end < start)
			return null;
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(Integer.toString(a[mid]));
		n.setLeft(createMinimalBST(a, start, mid - 1));
		n.setRight(createMinimalBST(a, mid + 1, end));
		return n;
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
							c = (line.get(j) != null) ? '^' : 'J';
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
