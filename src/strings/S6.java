package strings;

public class S6 {
	// You did this in 20 minutes drunk.
	public static String Compress(String s) {
		StringBuilder str = new StringBuilder();
		int ctr, i;
		for (i = 0, ctr = 1; i < s.length() - 1 && isAlphabet(s.charAt(i)); i++) {
			if (s.charAt(i) == s.charAt(i + 1))
				ctr++;
			else {
				str.append(s.charAt(i));
				str.append(ctr);
				ctr = 1;
			}
		}
		str.append(s.charAt(i));
		str.append(ctr);
		return s.length() < str.toString().length() ? s : str.toString();
	}

	private static boolean isAlphabet(char c) {
		int x = (int) c;
		return (x >= 65 && x < 122);
	}
}