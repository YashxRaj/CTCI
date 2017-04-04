package nonCTCI;

import java.util.HashMap;
import java.util.Scanner;

public class StringShuffling {
	// http://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the string to rearrange: ");
		System.out.println(rearrange(s.nextLine()));
		s.close();
	}

	public static String rearrange(String str) {
		HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
		char[] ch = str.toCharArray();
		for (char x : ch)
			charCount.put(x, charCount.containsKey(x) ? charCount.get(x) + 1 : 1);
		StringBuilder s = new StringBuilder();
		for (Character x : charCount.keySet()) {
			
		}
		return null;
	}

}
