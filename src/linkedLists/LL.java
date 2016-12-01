package linkedLists;

import java.util.LinkedList;

public class LL {

	public static void main(String[] args) {
		//LL21
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		generateRandomList(l1, 15);
		print(l1);
		LL1.removeDuplicatesBuffer(l1);
		print(l1);
		l1.clear();
		generateRandomList(l1, 15);
		print(l1);
		LL1.removeDuplicatesNoBuffer(l1);
		print(l1);
		
		//LL22
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		int n = 5 + (int) (Math.random() * 10);
		int k = (int) (Math.random() * 5);
		generateRandomList(l2, n);
		print(l2);
		System.out.println(k);
		LL2.returnKtoLast(l2, k);
		print(l2);
	}

	private static void print(LinkedList<Integer> l) {
		System.out.println("Printing Linked List:");
		for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i) + "\t");
		}
		System.out.println();
	}

	private static void generateRandomList(LinkedList<Integer> l, int n) {
		System.out.println("Generating List.");
		for (int i = 0; i < n; i++) {
			l.add((int) (Math.random() * 10));
		}
	}

}
