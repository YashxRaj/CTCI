package gfgMicrosoft;

import java.util.HashSet;

public class RemoveDuplicatesLinkedList {

	public static void main(String[] args) {
		Node head = new Node(1);
		generateRandomNodes(head, ((int) (Math.random() * 15)));
		printNodes(head);
		removeDuplicates(head);
		printNodes(head);
	}

	private static void printNodes(Node head) {
		Node root = head;
		while (root != null) {
			System.out.print(root.data);
			if (root.next != null)
				System.out.print(" -> ");
			root = root.next;
		}
		System.out.println();
	}

	private static Node generateRandomNodes(Node head, int k) {
		Node root = head;
		for (int i = 0; i < k; i++) {
			Node temp = new Node(((int) (Math.random() * 10)));
			root.next = temp;
			root = root.next; // root = temp would also work.
		}
		return head;
	}

	private static Node removeDuplicates(Node head) {
		Node current = head;
		Node previous = null;
		HashSet<Integer> hs = new HashSet<Integer>();
		while (current != null) {
			if (!hs.contains(current.data)) {
				hs.add(current.data);
				previous = current;
				current = current.next;
			} else {
				current = current.next;
				previous.next = current;
			}
		}
		return head;
	}

}
