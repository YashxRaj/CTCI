package microsoft;

public class InNode<E> extends Node<E> {
	E data;
	InNode<E> left, right, next;

	public InNode() {
		left = right = next = null;
	}

	public InNode(E data) {
		this.data = data;
		left = right = next = null;
	}

	public InNode(E data, InNode<E> left, InNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public InNode(E data, InNode<E> left, InNode<E> right, InNode<E> successor) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.next = successor;
	}
}