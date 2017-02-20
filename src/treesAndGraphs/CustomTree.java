package treesAndGraphs;

import java.util.Random;

public class CustomTree {
	CustomTreeNode root = null;

	public int size() {
		return root == null ? 0 : root.size();
	}

	public CustomTreeNode getRandomNode() {
		if (root == null)
			return null;
		return root.getIthNode(new Random().nextInt(size()));
	}

	public void insertInOrder(int value) {
		if (root == null)
			root = new CustomTreeNode(Integer.toString(value));
		else
			root.insertInOrder(value);
	}
}
