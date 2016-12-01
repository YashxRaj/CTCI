package strings;

import java.util.HashMap;

public class S2 {

	public static boolean permutationCheck(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> hm2 = new HashMap<Character, Integer>();
		for (int i = 0; i < str1.length(); i++) {
			if (hm1.get(str1.charAt(i)) == null)
				hm1.put(str1.charAt(i), 1);
			else
				hm1.put(str1.charAt(i), hm1.get(str1.charAt(i)) + 1);
		}
		for (int i = 0; i < str1.length(); i++) {
			if (hm2.get(str2.charAt(i)) == null)
				hm2.put(str2.charAt(i), 1);
			else
				hm2.put(str2.charAt(i), hm2.get(str2.charAt(i)) + 1);
		}

		for (int i = 0; i < str1.length(); i++) {
			if (hm1.get(str1.charAt(i)) != hm2.get(str1.charAt(i)))
				return false;
		}
		return true;
	}
}
