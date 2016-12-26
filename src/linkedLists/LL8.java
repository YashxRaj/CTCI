package linkedLists;

public class LL8 {

	public static Node loopDetection(Node one) {
		Node slow = one, fast = one;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		if (fast == null || fast.next == null)
			return null;
		slow = one;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

}
