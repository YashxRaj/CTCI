package linkedLists;

public class LL4 {

	public static Node partition(Node n, int x) {
		Node head = n, tail = n;
		while (n != null) {
			Node next = n.next;
			if (n.data < x) {
				n.next = head;
				head = n;
			} else {
				tail.next = n;
				tail = n;
			}
			n = next;
		}
		tail.next = null;
		return head;
	}

	public static Node partitionSimple(Node n, int x) {
		Node head = null, tail = null;
		while (n != null) {
			Node next = n.next;
			if (n.data < x) {
				
			}
		}
	}
}