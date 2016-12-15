package strings;

public class S5 {
	// FYI you did this drunk, so next time, BELIEVE IN YOURSELF!
	public static Boolean OneAway(String one, String two) {
		int onel = one.length(), twol = two.length(), l = onel - twol, ctr = 0;
		boolean flag = true;
		if (l < 0)
			flag = false;
		if (l == 0) {
			for (int i = 0; i < onel; i++) {
				if (one.charAt(i) != two.charAt(i)) {
					ctr++;
				}
			}
			return ctr < 2;
		} else if (Math.abs(l) == 1) {
			String s1 = one, s2 = two;
			if (flag == false) {
				s1 = two;
				s2 = one;
			}
			for (int i = 0; i < s2.length(); i++) {
				if(s1.charAt(i)==s2.charAt(i))
					ctr++;
				else if(s1.charAt(i+1) == s2.charAt(i))
					ctr++;
			}
			return ctr == s2.length();
		} else
			return false;
	}
}
