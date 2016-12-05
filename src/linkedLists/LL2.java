package linkedLists;

import java.util.LinkedList;

public class LL2 {

	public static void returnKtoLast(LinkedList<Integer> l, int k) {
		for (int i = 0; i < k; i++)
			l.remove();
	}
}
