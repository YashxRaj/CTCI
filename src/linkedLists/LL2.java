package linkedLists;

public class LL2 {

	public static void kthToLastElement(Node head, int k) {
		if (k > head.size()) {
			LL.printLL(head, "Entered value for K is larger than the size of the list. Printing list:");
			return;
		}
		Node n = head, newHead = null;
		int l = 0;
		while (n != null) {
			if (l != (k - 1)) {
				l++;
				n = n.next;
				continue;
			}
			newHead = n;
			LL.printLL(newHead, "K-th element to last element:");
			break;
		}
	}
}
