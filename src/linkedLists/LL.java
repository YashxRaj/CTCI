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
		// LL7(MakeLL(randomLength()));
		// LL8(MakeLL(randomLength()));
	}

	private static void LL8(Node one) {
		if (chance())
			generateRandomCircularLL(one);
		Node loopHead = LL8.loopDetection(one);
		if (loopHead == null)
			System.out.println("No loops detected.");
		else
			printCircularLL(loopHead, "Circular loop:");
	}

	private static void generateRandomCircularLL(Node one) {
		Node temp = one;
		while (temp.next != null)
			temp = temp.next;
		temp.next = randomNodeBetweenLL(one, randomNodeNumberBetweenLL(one));
	}

	private static void LL7(Node one) {
		Node two = null;
		if (chance()) {
			two = randomNodeBetweenLL(one, randomNodeNumberBetweenLL(one));
			if (chance())
				two = maybePadded(two, one.size() - two.size());
		} else
			two = MakeLL(randomLength());
		LL7.checkIntersection(one, two);
	}

	private static Node maybePadded(Node two, int l) {
		while (l > 0) {
			two = two.AppendToHead((int) (Math.random() * 10));
			l--;
		}
		LL.printLL(two, "After padding:");
		return two;
	}

	private static void LL6(Node head) {
		System.out.println("Palindrome Check: " + LL6.palindromeCheck(head));
	}

	private static void LL5(Node one, Node two) {
		LL5.sum(one, two);
	}

	private static void LL4(Node head) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter partition value x: ");
		head = LL4.partition(head, s.nextInt());
		printLL(head, "Partitioned linked list:");
		s.close();
	}

	private static void LL3(Node head) {
		int r = randomNodeNumberBetweenLL(head);
		LL3.deleteMiddleNode(randomNodeBetweenLL(head, r));
		printLL(head, "Printing after deleting node number: " + r);
	}

	private static void LL2(Node head) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter k for k-th to last element: ");
		LL2.kthToLastElement(head, s.nextInt());
		s.close();
	}

	private static void LL1(Node head) {
		System.out.println("Removing duplicates from linked list:");
		LL1.removeDuplicates(head);
	}

	public static boolean chance() {
		Boolean chance = true;
		if (Math.random() > 0.5)
			chance = false;
		return chance;
	}

	private static void printCircularLL(Node loopHead, String msg) {
		System.out.println(msg);
		System.out.print(loopHead.data + "\t");
		Node temp = loopHead.next;
		while (temp != loopHead) {
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
		System.out.println();
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

	public static Node MakeLL(int len) {
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
		for (int i = 1; n.next != null && i != r; i++)
			n = n.next;
		printLL(n, "Linked list randomly generated from given linked list:");
		return n;
	}

	public static int randomNodeNumberBetweenLL(Node head) {
		return 2 + (int) (Math.random() * (head.size() - 3));
	}

	public static int randomLength() {
		return (4 + ((int) (Math.random() * 5)));
	}
}
