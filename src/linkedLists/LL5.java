package linkedLists;

public class LL5 {

	public static void sum(Node one, Node two) {
		LL.printLL(makeReverseLLFromInt((makeIntFromReverseLL(one)) + makeIntFromReverseLL(two)), "Sum of lists:");
		padWithZerosForLength(one, two);
		LL.printLL(
				makeLLFromInt(makeIntFromArray(makeArrayfromLL(LL.copyLL(one)))
						+ (makeIntFromArray(makeArrayfromLL(LL.copyLL(two))))),
				"Sum of lists when digits are stored in forward order:");
	}

	private static void padWithZerosForLength(Node one, Node two) {
		int l1 = one.size(), l2 = two.size(), diff = Math.abs(l2 - l1);
		if (l1 < l2)
			padWithZeros(one, diff);
		else if (l2 < l1)
			padWithZeros(two, diff);
		else
			return;
	}

	private static void padWithZeros(Node n, int diff) {
		Node temp = null;
		while (diff != 0) {
			temp = new Node(0);
			temp.next = n;
			n = temp;
			diff--;
		}
		LL.printLL(n, "Padded linked list:");
	}

	private static Node makeReverseLLFromInt(int sum) {
		Node s = new Node(sum % 10);
		sum /= 10;
		while (sum != 0) {
			s.AppendToTail(sum % 10);
			sum /= 10;
		}
		return s;
	}

	private static Node makeLLFromInt(int res) {
		Node s = new Node(res % 10);
		res /= 10;
		while (res != 0) {
			Node temp = new Node(res % 10);
			temp.next = s;
			s = temp;
			res /= 10;
		}
		return s;
	}

	private static int makeIntFromReverseLL(Node n) {
		int val = 0, i = 1;
		while (n != null) {
			val += n.data * i;
			n = n.next;
			i *= 10;
		}
		return val;
	}

	private static int[] makeArrayfromLL(Node n) {
		int i = 0;
		int[] array = new int[n.size()];
		while (n != null) {
			array[i++] = n.data;
			n = n.next;
		}
		return array;
	}

	private static int makeIntFromArray(int[] array) {
		int val = 0;
		for (int i = array.length - 1, j = 1; i >= 0; i--, j *= 10) {
			val += array[i] * j;
		}
		return val;
	}

}
