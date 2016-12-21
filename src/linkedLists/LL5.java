package linkedLists;

public class LL5 {

	public static void sum(Node one, Node two) {
		// Incomplete, you have to pad the arrays in case length is not same.
		LL.printLL(makeReverseLLFromInt((makeIntFromReverseLL(one)) + makeIntFromReverseLL(two)), "Sum of lists:");
		LL.printLL(makeLLFromInt(makeIntFromArray(makeArrayfromLL(LL.copyLL(one))) + (makeIntFromArray(makeArrayfromLL(LL.copyLL(two))))), "Sum of lists when digits are stored in forward order:");
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

	private static int makeIntFromReverseLL(Node n) {
		int val = 0, i = 1;
		while (n != null) {
			val += n.data * i;
			n = n.next;
			i *= 10;
		}
		return val;
	}

	private static Node makeLLFromInt(int res) {
		Node s = null;
		int k = (int) Math.pow(10, (String.valueOf(res).length() - 1));
		while (res != 0) {
			if (s == null)
				s = new Node(res % k);
			else {
				Node temp = new Node(res % k);
				temp.next = s;
				s = temp;
			}
			res /= 10;
			k /= 10;
		}
		return s;
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
