package linkedLists;

public class LL3 {

	public static void deleteMiddleNode(Node n) {
		Node t = n, prev = null;
		while (t.next != null) {
			t.data = t.next.data;
			prev = t;
			t = t.next;
		}
		prev.next = null;
	}
}