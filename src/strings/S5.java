package strings;

import java.util.HashMap;

public class S5 {

	public static Boolean OneAway(String one, String two) {
		int l = one.length() - two.length() > 0 ? one.length() : two.length(), ctr = 0;
		if (Math.abs(l) > 1)
			return false;
		HashMap<Character, Integer> m = new HashMap<Character, Integer>();
		String s1 = one, s2 = two;
		if (l == two.length()) {
			s1 = two;
			s2 = one;
		}
		for (int i = 0; i < l; i++) {
			if (m.get(s1.charAt(i)) == null)
				m.put(s1.charAt(i), 1);
			else
				m.put(s1.charAt(i), m.get(s1.charAt(i)) + 1);
		}
		for (int i = 0; i < s2.length(); i++) {
			if (!(m.containsKey(s2.charAt(i))))
				ctr++;
		}
		return ctr < 2;
	}
}