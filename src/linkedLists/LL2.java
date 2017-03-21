package linkedLists;

public class LL2 {

	public static void kthToLastElement(Node head, int k) {
		int size = head.size();
		if (k > size) {
			System.out.println("Entered value for K is larger than the size of the list. Printing list:");
		} else if (k == size) {
			System.out.println("Printing Head: " + head.data);
		} else {
			Node n = head, kth = head;
			int l = 0;
			while (l != k) {
				l++;
				n = n.next;
			}
			while (n.next != null) {
				kth = kth.next;
				n = n.next;
			}
			System.out.println(k + "-th Element from last: " + kth.data);
		}
	}
}
