package CTCI;

import java.util.HashMap;
import java.util.Scanner;

public class C1P3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Strings:");
		System.out.println("Permutation Check: " + permutationCheck(s.next(), s.next()));
	}

	// Given 2 strings, determine if one string is a permutation of the other.
	private static boolean permutationCheck(String one, String two) {
		if (one.length() != two.length())
			return false;
		else {
			HashMap<Character, Integer> m1 = new HashMap<Character, Integer>();
			HashMap<Character, Integer> m2 = new HashMap<Character, Integer>();
			for (int i = 0; i < one.length(); i++) {
				if (m1.get(one.charAt(i)) == null)
					m1.put(one.charAt(i), 1);
				else
					m1.put(one.charAt(i), m1.get(one.charAt(i)) + 1);
				if (m2.get(two.charAt(i)) == null)
					m2.put(two.charAt(i), 1);
				else
					m2.put(two.charAt(i), m2.get(two.charAt(i)) + 1);
			}
			for (int i = 0; i < one.length(); i++)
				if (m1.get(one.charAt(i)) != m2.get(one.charAt(i)))
					return false;
		}
		return true;
	}
}