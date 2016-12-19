package linkedLists;

import java.util.HashSet;

public class LL1 {

	public static void removeDuplicates(Node n) {
		removeDuplicatesNoBuffer(LL.copyLL(n));
		removeDuplicatesBuffer(n);
	}

	private static void removeDuplicatesNoBuffer(Node head) {
		Node current = head;
		while (current != null) {
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data)
					runner.next = runner.next.next;
				else
					runner = runner.next;
			}
			current = current.next;
		}
		LL.printLL(head,"No Buffer: ");
	}

	private static void removeDuplicatesBuffer(Node head) {
		HashSet<Integer> set = new HashSet<Integer>();
		Node previous = null, n = head;
		while (n != null) {
			if (set.contains(n.data))
				previous.next = n.next;
			else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
		LL.printLL(head,"Buffer: ");
	}
}
