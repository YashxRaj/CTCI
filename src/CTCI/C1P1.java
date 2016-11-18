package CTCI;

import java.util.HashMap;
import java.util.Scanner;

public class C1P1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter String: ");
		String str =s.next();
		System.out.println("Using Hashmap: " + check(str.trim()));
		System.out.println("Using No Additional Data Structures: " + check2(str.trim()));
	}

	// Using hashmap.
	private static boolean check(String str) {
		HashMap<Character, Boolean> m = new HashMap<Character, Boolean>();
		for (int i = 0; i < str.length(); i++) {
			if (m.get(str.charAt(i)) == null)
				m.put(str.charAt(i), true);
			else
				return false;
		}
		return true;
	}
	// Using no additional data structures.
	private static boolean check2(String str) {
		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j))
					return false;
			}
		}
		return true;
	}
}