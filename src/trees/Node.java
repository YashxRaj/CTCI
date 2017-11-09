package trees;

public class Node<E> {
	protected E data;
	protected Node<E> left, right;
	protected Node<E> inOrderSuccessor;
	protected Node<E> nextRight;

	public Node() {
		this.left = null;
		this.right = null;
	}

	public Node(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public Node(E data, Node<E> left, Node<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public boolean isLeaf() {
		return this.left == null && this.right == null;
	}

	@Override
	public String toString() {
		return String.valueOf(this.data);
	}

}