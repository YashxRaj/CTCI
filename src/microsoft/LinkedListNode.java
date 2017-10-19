package microsoft;

public class LinkedListNode {
	int data;
	LinkedListNode next;

	public LinkedListNode() {
		next = null;
	}

	public LinkedListNode(int data, LinkedListNode next) {
		this.data = data;
		this.next = next;
	}
	public LinkedListNode(int data) {
		this.data = data;
	}
}
