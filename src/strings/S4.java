package strings;

import java.util.HashMap;

class S4 {
	public static boolean PalindromePermutationCheck(String s) {
		HashMap<Character, Integer> m = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') continue;
			if (m.get(s.charAt(i)) == null) m.put(s.charAt(i), 1);
			else m.put(s.charAt(i), m.get(s.charAt(i)) + 1);
		}
		int ctr = 0;
		for (int i = 1; i < s.length(); i += 2) if (m.containsValue(i)) ctr++;
		return ctr<=1;
	}
}