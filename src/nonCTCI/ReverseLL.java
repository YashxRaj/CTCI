package nonCTCI;

import linkedLists.LL;
import linkedLists.Node;

public class ReverseLL {

	public static void main(String[] args) throws CloneNotSupportedException {
		LL.printLL(reverseLinkedList(LL.MakeLL(LL.randomLength())), "Reverse:");
	}

	private static Node reverseLinkedList(Node head) throws CloneNotSupportedException {
		Node previous = null, current = head.clone();
		while (current != null) {
			Node temp = current.clone();
			current.next = previous;
			previous = current;
			current = temp.next;
		}
		return previous;
	}
}
