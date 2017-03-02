package nonCTCI;

import java.util.Scanner;
import java.util.Vector;

public class ReverseStringNonSpecialCharacters {
	// http://www.geeksforgeeks.org/reverse-an-array-without-affecting-special-characters/
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("String to reverse: ");
		System.out.println("Reversed String  : " + reverseStringNotSpecialChars(s.nextLine()));
		s.close();
	}

	private static boolean isAlphabet(char c) {
		if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
			return true;
		else
			return false;
	}

	private static String reverseStringNotSpecialChars(String str) {
		StringBuffer buffer = new StringBuffer();
		Vector<Integer> specLoc = new Vector<Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (isAlphabet(str.charAt(i)))
				buffer.append(str.charAt(i));
			else
				specLoc.addElement(i);
		}
		buffer = buffer.reverse();
		for (int i = 0; i < str.length(); i++)
			if (specLoc.contains(i))
				buffer.insert(i, str.charAt(i));
		return buffer.toString();
	}

	private static String efficientReversal(String str) {
		for (int l = 0, r = str.length() - 1; l < r;) {
			if (!isAlphabet(str.charAt(l)))
				l++;
			else if (!isAlphabet(str.charAt(r)))
				r--;
			else {
				char temp = str.charAt(r);
				str.replace(str.charAt(r), str.charAt(l));
				str.replace(str.charAt(l), temp);
				l++;
				r--;
			}
		}
		return str;
	}
}
