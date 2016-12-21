package linkedLists;

public class LL5 {

	public static Node sum(Node one, Node two) {
		return makeReverseLLFromInt((makeIntFromLL(one)) + makeIntFromLL(two));
	}

	private static Node makeReverseLLFromInt(int sum) {
		Node s = null;
		while (sum != 0) {
			if (s == null)
				s = new Node(sum % 10);
			else
				s.AppendToTail(sum % 10);
			sum /= 10;
		}
		return s;
	}

	private static int makeIntFromLL(Node n) {
		int val = 0, i = 1;
		while (n != null) {
			val += n.data * i;
			n = n.next;
			i *= 10;
		}
		return val;
	}

	/*
	 * private static Node makeLLFromInt(int res) {
	 * Node s = null;
	 * while (res != 0) {
	 * int d = res % 10;
	 * if (s == null)
	 * s = new Node(d);
	 * else {
	 * Node temp = new Node(d);
	 * temp.next = s;
	 * s = temp;
	 * }
	 * res /= 10;
	 * }
	 * return s;
	 * }
	 * private static int[] makeArrayfromLL(Node n) {
	 * int i = 0;
	 * int[] a = new int[n.size()];
	 * while (n != null) {
	 * a[i++] = n.data;
	 * n = n.next;
	 * }
	 * return a;
	 * }
	 *
	 * private static int makeIntFromArray(int[] a) {
	 * int val = 0;
	 * for (int i = 0, j = 1; i < a.length; i++, j *= 10) {
	 * val += a[i] * j;
	 * }
	 * return val;
	 * }
	 */
}
