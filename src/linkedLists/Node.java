package linkedLists;

public class Node {
	Node next;
	Object data;

	public Node(Object d) {
		next = null;
		data = d;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Node getNext() {
		return this.next;
	}
	public void setNext(Node Next) {
		next = Next;
	}
}
