package linkedLists;

import java.util.Scanner;

public class LL {

	public static void main(String[] args) {
		int len = 4 + ((int) (Math.random() * 5));
		// LL1(MakeLL(len));
		// LL2(MakeLL(len));
		// LL3(MakeLL(len));
		// LL4(MakeLL(len));
		// LL5(MakeLL(len), MakeLL(len));
		// LL6();
	}

	private static void LL5(Node one, Node two) {
		printLL(LL5.sum(one, two), "Sum:");
	}

	private static void LL4(Node head) {
		System.out.print("Enter partition value x: ");
		int x = new Scanner(System.in).nextInt();
		head = LL4.partition(head, x);
		printLL(head, "Partitioned linked list:");
	}

	private static void LL3(Node head) {
		int r = randomNodeNumberBetweenLL(head);
		LL3.deleteMiddleNode(randomNodeBetweenLL(head, r));
		printLL(head, "Printing after deleting node number: " + r);
	}

	private static void LL2(Node head) {
		System.out.print("Enter k for k-th to last element: ");
		LL2.kthToLastElement(head, new Scanner(System.in).nextInt());
	}

	private static void LL1(Node head) {
		System.out.println("Removing duplicates from linked list:");
		LL1.removeDuplicates(head);
	}

	public static void printLL(Node head, String msg) {
		System.out.println(msg);
		Node n = head;
		while (n != null) {
			System.out.print(n.data + "\t");
			n = n.next;
		}
		System.out.println();
	}

	private static Node MakeLL(int len) {
		Node head = new Node((int) (Math.random() * 10));
		for (int i = 0; i < len; i++)
			head.AppendToTail((int) (Math.random() * 10));
		printLL(head, "Printing linked list:");
		return head;
	}

	public static Node copyLL(Node n) {
		Node head = new Node(n.data);
		n = n.next;
		while (n != null) {
			head.AppendToTail(n.data);
			n = n.next;
		}
		LL.printLL(head, "Copied linked list:");
		return head;
	}

	public static Node randomNodeBetweenLL(Node head, int r) {
		Node n = head;
		for (int i = 1; n != null && i != r; i++)
			n = n.next;
		return n;
	}

	public static int randomNodeNumberBetweenLL(Node head) {
		return 2 + (int) (Math.random() * (head.size() - 3));
	}
}
