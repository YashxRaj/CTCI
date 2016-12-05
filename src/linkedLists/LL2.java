package linkedLists;

import java.util.LinkedList;

public class LL2 {

	public static LinkedList<Integer> returnKtoLast(LinkedList<Integer> l, int k, LinkedList<Integer> l2) {
		for (int i = k; i < l.size(); i++)
			l2.add(l.get(i));
		return l2;
	}
}
