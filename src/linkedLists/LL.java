package linkedLists;

public class LL {

	public static void main(String[] args) {
		Node head = new Node((int) (Math.random() * 10));
		MakeLinkedList(head);
		LL1(head);
	}

	private static void LL1(Node head) {
		System.out.println("Printing linked list...");
		printLL(head);
		LL1.removeDuplicates(head);
		System.out.println("Removing duplicates from the linked list...");
		printLL(head);
	}

	private static void printLL(Node head) {
		Node n = head;
		while (n.next != null) {
			System.out.print(n.data + "\t");
			n = n.next;
		}
		System.out.println();
	}

	private static void MakeLinkedList(Node head) {
		int len = 4 + ((int) (Math.random() * 10));
		for (int i = 0; i < len; i++)
			head.AppendToTail((int) (Math.random() * 10));
	}

}
