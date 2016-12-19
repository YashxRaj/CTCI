package linkedLists;

public class LL2 {

	public static void kthToLastElement(Node head, int k) {
		Node n = head;
		Node newHead = null;
		int l = 0;
		while (n != null) {
			l++;
			if (l == k) {
				head = newHead;
				newHead = head;
				LL.printLL(newHead, "K-th element to last element:");
			}
		}
	}

}
