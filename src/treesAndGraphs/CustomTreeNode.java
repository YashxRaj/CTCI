package treesAndGraphs;

public class CustomTreeNode {

	private String data;
	private CustomTreeNode left;
	private CustomTreeNode right;
	private int leftCount;
	private int rightCount;

	public int getLeftCount() {
		return leftCount;
	}

	public void setLeftCount(int leftCount) {
		this.leftCount = leftCount;
	}

	public int getRightCount() {
		return rightCount;
	}

	public void setRightCount(int rightCount) {
		this.rightCount = rightCount;
	}

	public CustomTreeNode() {
		data = null;
		left = null;
		right = null;
		leftCount = 0;
		rightCount = 0;
	}

	public CustomTreeNode(String data) {
		this.data = data;
		left = null;
		right = null;
		leftCount = 0;
		rightCount = 0;
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
}
