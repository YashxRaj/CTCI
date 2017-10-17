package microsoft;

import java.util.Scanner;
import java.util.Vector;

public class ReverseWords {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String sentence = s.nextLine().trim();
		s.close();
		System.out.println(reverseSentence(sentence));
		System.out.println(reverse(sentence));
	}

	private static String reverse(String s) {
		s = s.trim();
		String rev = "";
		Vector<String> v = new Vector<String>();
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (s.charAt(i) == '.') {
				v.add(reverseWord(s.substring(j, i)));
				j = i + 1;
			} else if (i == s.length() - 1)
				v.add(reverseWord(s.substring(j, s.length())));
		}
		for (int i = 0; i < v.size(); i++)
			rev += v.get(i) + ".";
		rev = reverseWord(rev).substring(1, rev.length());
		return rev;
	}

	private static String reverseSentence(String sentence) {
		String[] split = sentence.split("\\.");
		StringBuilder sb = new StringBuilder(), word = null;
		for (int i = 0; i < split.length; i++) {
			word = new StringBuilder(split[i]);
			sb.append(word.reverse().toString() + (i + 1 != split.length ? "." : ""));
		}
		return sb.reverse().toString();
	}

	private static String reverseWord(String word) {
		char[] reversedCharArray = new char[word.length()];
		for (int i = 0; i < word.length(); i++)
			reversedCharArray[i] = word.charAt(word.length() - 1 - i);
		return new String(reversedCharArray);
	}
}
