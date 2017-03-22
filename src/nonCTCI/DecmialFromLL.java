package nonCTCI;

import linkedLists.LL;
import linkedLists.Node;

public class DecmialFromLL {
	// given a singly linked list of 0s and 1s find its decimal equivalent
	public static void main(String[] args) {
		System.out.println(binaryToDecimal(MakeDecimalLL(LL.randomLength())));
	}

	public static Node MakeDecimalLL(int len) {
		Node head = new Node(LL.chance() ? 0 : 1);
		for (int i = 0; i < len; i++)
			head.AppendToTail(LL.chance() ? 0 : 1);
		LL.printLL(head, "Printing linked list:");
		return head;
	}

	private static int binaryToDecimal(Node n) {
		Node temp = n;
		StringBuffer s = new StringBuffer();
		while (temp != null) {
			s.append(temp.data);
			temp = temp.next;
		}
		char[] str = s.toString().toCharArray();
		int l = str.length, result = 0;
		for (int i = 0; i < l; i++)
			if (str[i] == '1')
				result += Math.pow(2, l - i - 1);
		return result;
	}
}
