package linkedLists;

public class LL6 {

	public static Boolean palindromeCheck(Node head) {
		Node h = head;
		int a[] = new int[head.size()], i = 0;
		while (h != null) {
			a[i++] = h.data;
			h = h.next;
		}
		for (int j = 0; j < head.size() / 2; j++)
			if (a[j] != a[head.size() - 1 - j])
				return false;
		return true;
	}
}
