package microsoft;

public class Node<E> {
	protected E data;
	protected Node<E> left, right;
	protected Node<E> inOrderSuccessor;

	public Node() {
		this.left = null;
		this.right = null;
	}

	public Node(E data) {
		this.data = data;
		left = null;
		right = null;
	}

	public Node(E data, Node<E> left, Node<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}