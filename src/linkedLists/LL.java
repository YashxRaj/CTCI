package linkedLists;

import java.util.Scanner;

public class LL {

	public static void main(String[] args) {
		// LL1(MakeLL(randomLength()));
		// LL2(MakeLL(randomLength()));
		// LL3(MakeLL(randomLength()));
		// LL4(MakeLL(randomLength()));
		// LL5(MakeLL(randomLength()), MakeLL(randomLength()));
		// LL6(MakeLL(randomLength()));
		LL7(MakeLL(randomLength()));
	}

	private static void LL7(Node one) {
		Node two = null;
		Boolean chance = true;
		if (Math.random() > 0.5)
			chance = false;
		if (chance)
			two = randomNodeBetweenLL(one, randomNodeNumberBetweenLL(one));
		LL7.checkIntersection(one,two);	

	}

	private static void LL6(Node head) {
		System.out.println("Palindrome Check: " + LL6.palindromeCheck(head));
	}

	private static void LL5(Node one, Node two) {
		LL5.sum(one, two);
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
		// LL.printLL(head, "Copied linked list:");
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

	private static int randomLength() {
		return (4 + ((int) (Math.random() * 5)));
	}
}
