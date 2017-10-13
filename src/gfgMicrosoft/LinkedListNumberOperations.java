package gfgMicrosoft;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class LinkedListNumberOperations {
	public static void main(String args[]) {
		LinkedList<Integer> ll1;
		LinkedList<Integer> ll2;

		Scanner s = new Scanner(System.in);
		System.out.println("Enter LinkedList One:");
		String[] linkedStringOne = s.nextLine().trim().split(" ");
		ll1 = StringArrayToLinkedList(linkedStringOne);
		System.out.println("Enter LinkedList Two:");
		String[] linkedStringTwo = s.nextLine().trim().split(" ");
		ll2 = StringArrayToLinkedList(linkedStringTwo);

		System.out.println("Before Padding:");
		printLL(ll1);
		printLL(ll2);

		if (ll1.size() > ll2.size())
			addPadding(ll2, ll1.size());
		else
			addPadding(ll1, ll2.size());

		System.out.println("After Padding:");
		printLL(ll1);
		printLL(ll2);

		System.out.println("1 - Add");
		System.out.println("2 - Subtract");
		System.out.println("3 - Multiply");
		int n = Integer.parseInt(s.nextLine().trim());
		switch (n) {
		case 1:
			printLL(addLL(ll1, ll2));
			break;
		case 2:
			printLL(isGreater(ll1, ll2) ? subtractLL(ll1, ll2) : subtractLL(ll2, ll1));
			break;
		case 3:
			printLL(multiplyLL(ll1, ll2));
			break;
		}

		s.close();
	}

	private static LinkedList<Integer> StringArrayToLinkedList(String[] linkedStringOne) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for (String x : linkedStringOne)
			ll.add(Integer.parseInt(x));
		return ll;
	}

	private static void addPadding(LinkedList<Integer> ll, int paddedSize) {
		int currentSize = ll.size();
		for (int i = 0; i < paddedSize - currentSize; i++)
			ll.addFirst(0);
	}

	private static boolean isGreater(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
		int i = 0, one = ll1.get(i), two = ll2.get(i);
		while (one != two) {
			if (one != two)
				return one > two;
			else
				i++;
			one = ll1.get(i);
			two = ll2.get(i);
		}
		return false;
	}

	private static LinkedList<Integer> multiplyLL(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
		Vector<LinkedList<Integer>> results = new Vector<LinkedList<Integer>>();
		for (int i = 0; i < ll2.size(); i++) {
			LinkedList<Integer> result = copyLL(ll2);
			for (int j = ll1.size() - 1; j > 0; j--) {
				for (int k = 0; k < ll1.get(j); k++)
					result = addLL(result, ll2);
				for (int k = 0; k < i; k++)
					result.add(0);
			}
			results.add(result);
		}
		LinkedList<Integer> base = results.get(0);
		for (int i = 1; i < results.size(); i++)
			base = addLL(base, results.get(i));
		return base;
	}

	// Deep copy.
	private static LinkedList<Integer> copyLL(LinkedList<Integer> ll2) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for (Integer x : ll2)
			ll.add(x);
		return ll;
	}

	private static LinkedList<Integer> subtractLL(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
		LinkedList<Integer> ll3 = new LinkedList<Integer>();
		for (int i = ll1.size() - 1; i >= 0; i--) {
			int subtract = ll1.get(i) - ll2.get(i);
			if (subtract < 0) {
				ll1.set(i, ll1.get(i) + 10);
				ll1.set(i - 1, ll1.get(i - 1) - 1);
				subtract = ll1.get(i) - ll2.get(i);
			}
			ll3.add(subtract);
		}
		return removePadding(reverseLL(ll3));
	}

	private static LinkedList<Integer> removePadding(LinkedList<Integer> ll) {
		while (ll.peek() == 0)
			ll.remove();
		return ll;
	}

	private static LinkedList<Integer> addLL(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
		LinkedList<Integer> ll3 = new LinkedList<Integer>();
		int remainder = 0;
		for (int i = ll1.size() - 1; i >= 0; i--) {
			int add = ll1.get(i) + ll2.get(i) + remainder;
			if (add > 9) {
				ll3.add(add % 10);
				remainder = add / 10;
			} else {
				remainder = 0;
				ll3.add(add);
			}
		}
		if (remainder != 0)
			ll3.add(remainder);
		return reverseLL(ll3);
	}

	private static void printLL(LinkedList<Integer> ll) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ll.size(); i++)
			sb.append(ll.get(i) + " ");
		System.out.println(sb.toString());
	}

	private static LinkedList<Integer> generateLL() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		int n = largeRandomNumber();
		for (int i = 0; i < n; i++)
			ll.add(randomNumber());
		return ll;
	}

	private static int largeRandomNumber() {
		return (int) (Math.random() * 100);
	}

	private static int randomNumber() {
		return (int) (Math.random() * 9);
	}

	private static LinkedList<Integer> reverseLL(LinkedList<Integer> ll3) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for (int i = ll3.size() - 1; i >= 0; i--)
			ll.add(ll3.get(i));
		return ll;
	}

	private static LinkedList<Integer> toLinkedList(String s) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for (char x : s.toCharArray())
			ll.add(Integer.parseInt(Character.toString(x)));
		return ll;
	}
}
