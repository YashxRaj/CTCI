package microsoft;

public class LinkedListFunctions {

	public static void main(String[] args) {
		LinkedListNode head = generateLinkedList((int) (Math.random() * 20));
		printLinkedList(head);
		LinkedListNode reverseHead = ReverseLinkedList(head);
		printLinkedList(reverseHead);
		findMiddleLinkedList(reverseHead);
	}

	private static void findMiddleLinkedList(LinkedListNode head) {
		LinkedListNode slow = head, fast = head;
		int ctr = 0;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			ctr += 2;
		}
		System.out.println("Middle Element: " + slow.data);
		System.out.println("Count: " + ctr);
	}

	private static LinkedListNode ReverseLinkedList(LinkedListNode head) {
		LinkedListNode current = head, previous = null, temp = null;
		while (current != null) {
			temp = previous;
			previous = current;
			current = current.next;
			previous.next = temp;
		}
		return previous;
	}

	private static void printLinkedList(LinkedListNode head) {
		LinkedListNode root = head;
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.next;
		}
		System.out.println();
	}

	private static LinkedListNode generateLinkedList(int n) {
		LinkedListNode head = new LinkedListNode((int) (Math.random() * 50)), root = head;
		for (int i = 0; i < n; i++) {
			LinkedListNode temp = new LinkedListNode((int) (Math.random() * 50));
			head.next = temp;
			head = temp;
		}
		return root;
	}
}
