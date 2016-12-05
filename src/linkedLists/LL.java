package linkedLists;

import java.util.LinkedList;
import java.util.Scanner;

public class LL {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in());
		// LL1(s);
		// LL2(s);
	}

	private static void LL2(Scanner s) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		int n = 5 + (int) (Math.random() * 10), k = (int) (Math.random() * 5);
		generateRandomList(l, n);
		print(l);
		System.out.println(k);
		LL2.returnKtoLast(l, k);
		print(l);
	}

	private static void LL1(Scanner s) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		generateRandomList(l, 15);
		print(l);
		LL1.removeDuplicatesBuffer(l);
		print(l);

		l.clear();

		generateRandomList(l, 15);
		print(l);
		LL1.removeDuplicatesNoBuffer(l);
		print(l);
	}

	private static void print(LinkedList<Integer> l) {
		System.out.println("Printing Linked List:");
		for (int i = 0; i < l.size(); i++)
			System.out.print(l.get(i) + "\t");
		System.out.println();
	}

	private static void generateRandomList(LinkedList<Integer> l, int n) {
		System.out.println("Generating List.");
		for (int i = 0; i < n; i++)
			l.add((int) (Math.random() * 10));
	}
}
