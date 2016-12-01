package CTCI;

import java.util.HashMap;
import java.util.Scanner;

public class S1 {
	// Using a Hash Map.
	public static boolean check(String str) {
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
	public static boolean check2(String str) {
		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j))
					return false;
			}
		}
		return true;
	}
}