package linkedLists;

public class LL4 {

	public static Node partition(Node n, int x) {
		Node head = n, tail = n, next = n.next;
		while (n != null) {
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
}