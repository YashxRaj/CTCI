package nonCTCI;

import linkedLists.LL;
import linkedLists.Node;

public class ReverseLL {

	public static void main(String[] args) {
		Node head = LL.MakeLL(LL.randomLength());
		LL.printLL(reverseLinkedList(head), "Reverse:");
	}

	private static Node reverseLinkedList(Node head) {
		Node previous = null, current = head;
		while (current != null) {
			Node temp = current;
			current.next = previous;
			previous = current;
			if (temp.next != null)
				current = temp.next;
			else
				break;
		}
		return current;
	}

}
