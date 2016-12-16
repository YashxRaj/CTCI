package linkedLists;

import java.util.HashMap;

public class LL1 {

	public static void removeDuplicates(Node head) {
		HashMap<Integer, Boolean> m = new HashMap<Integer, Boolean>();
		Node n = head;
		while (n.next != null) {
			if (m.get(n.data) == null) {
				m.put(n.data, true);
				n=n.next;
			} else {
				n.next = n.next.next;
			}
		}
	}

}
