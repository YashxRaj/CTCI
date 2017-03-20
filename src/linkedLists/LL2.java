package linkedLists;

public class LL2 {

	public static void kthToLastElement(Node head, int k) {
		if (k > head.size()) {
			LL.printLL(head, "Entered value for K is larger than the size of the list. Printing list:");
			return;
		}
		Node n = head, kth = null;
		int l = 0;
		while (n != null) {
			if (l < k) {
				l++;
				n = n.next;
				continue;
			} else if (l == k) {
				kth = n;
				l++;
				n = n.next;
				continue;
			} else if (l > k) {
				kth = kth.next;
				n = n.next;
			}
		}
		System.out.println(k + "-th Element from last: " + kth.data);
	}
}
