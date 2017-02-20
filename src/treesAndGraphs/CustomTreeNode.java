package treesAndGraphs;

public class CustomTreeNode {

	private String data;
	private CustomTreeNode left;
	private CustomTreeNode right;
	private int size = 0;

	public CustomTreeNode() {
		data = null;
		left = null;
		right = null;
		size = 1;
	}

	public CustomTreeNode(String data) {
		this.data = data;
		left = null;
		right = null;
		size = 1;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public CustomTreeNode getLeft() {
		return left;
	}

	public void setLeft(CustomTreeNode left) {
		this.left = left;
	}

	public CustomTreeNode getRight() {
		return right;
	}

	public void setRight(CustomTreeNode right) {
		this.right = right;
	}

	public void insertInOrder(int d) {
		if (d <= Integer.parseInt(this.data)) {
			if (left == null)
				left = new CustomTreeNode(Integer.toString(d));
			else
				left.insertInOrder(d);
		} else {
			if (right == null)
				right = new CustomTreeNode(Integer.toString(d));
			else
				right.insertInOrder(d);
		}
		size++;
	}

	public int size() {
		return size;
	}

	public CustomTreeNode find(int d) {
		if (d == Integer.parseInt(data))
			return this;
		else if (d <= Integer.parseInt(data))
			return left != null ? left.find(d) : null;
		else if (d > Integer.parseInt(data))
			return right != null ? right.find(d) : null;
		return null;
	}

	public CustomTreeNode getIthNode(int i) {
		int leftSize = left == null ? 0 : left.size;
		if (i < leftSize)
			return left.getIthNode(i);
		else if (i == leftSize)
			return this;
		else
			return right.getIthNode(i - (leftSize + 1));
	}
}
