package gfgMicrosoft;

import java.util.HashMap;
import java.util.Scanner;

public class RemoveDuplicatesFromString {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine().trim();
		String strDup = removeDuplicates(str);
		System.out.println(strDup);
		s.close();
	}

	/* 1. HashMap
	 * 2. Convert to char[], sort, eliminate by looking 1 behind.
	 */
	private static String removeDuplicates(String s1) {
		StringBuilder s2 = new StringBuilder();
		HashMap<Character, Boolean> hm = new HashMap<Character, Boolean>();
		for (char x : s1.toLowerCase().toCharArray())
			hm.put(x, hm.containsKey(x) ? false : true);
		for (char x : hm.keySet())
			s2.append(x);
		return s2.toString();
	}

}
