package microsoft;

public class Node {
	protected int data;
	protected Node left, right;

	public Node() {
		this.left = null;
		this.right = null;
	}

	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	public Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}