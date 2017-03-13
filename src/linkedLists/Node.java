package linkedLists;

public class Node {
	public Node next = null;
	public int data;

	public Node(int d) {
		data = d;
	}

	void AppendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null)
			n = n.next;
		n.next = end;
	}

	Node AppendToHead(int d) {
		Node n = new Node(d);
		n.next = this;
		return n;
	}

	Node deleteNode(Node head, int d) {
		Node n = head;
		if (n.data == d)
			return head.next;
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}

	int size() {
		int l = 0;
		Node n = this;
		while (n != null) {
			l++;
			n = n.next;
		}
		return l;
	}
}