package linkedLists;

public class LL2 {

	public static void kthToLastElement(Node head, int k) {
		Node n = head, kth = head;
		for (int i = 0; i != k; i++)
			n = n.next;
		if (n == null)
			System.out.println("K > list size");
		else
			while (n.next != null) {
				kth = kth.next;
				n = n.next;
			}
		System.out.println(k + "-th Element from last: " + kth.data);
	}
}
