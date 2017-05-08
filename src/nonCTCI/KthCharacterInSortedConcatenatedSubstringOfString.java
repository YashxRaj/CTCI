package nonCTCI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KthCharacterInSortedConcatenatedSubstringOfString {
	// http://www.geeksforgeeks.org/print-kth-character-sorted-concatenated-substrings-string/
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.print("String: ");
		String str = s.nextLine();
		System.out.print("K: ");
		System.out.println("Kth Character in the substring: " + kthCharacter(str, s.nextInt()));
		s.close();
	}

	private static char kthCharacter(String str, int k) {
		ArrayList<Character> letters = new ArrayList<Character>();
		ArrayList<String> words = new ArrayList<String>();
		StringBuilder s = new StringBuilder();

		// Get unique letters list.
		for (char x : str.toCharArray())
			if (!letters.contains(x))
				letters.add(x);
		Collections.sort(letters);

		// For each letter, create a list of substrings.
		for (char x : letters)
			for (int j = str.indexOf(x); j <= str.length(); j++)
				words.add(str.substring(str.indexOf(x), j));
		// Concatenate All substrings.

		for (String word : words)
			s.append(word);

		// For your convenience.
		print(letters);
		printWords(words);

		// Return the character at the Kth position.
		return s.toString().charAt(k - 1);
	}

	private static void printWords(ArrayList<String> words) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < words.size(); i++) {
			if (i != 0 && words.get(i).length() < words.get(i - 1).length())
				s.append(System.lineSeparator());
			s.append(words.get(i) + " ");
		}
		System.out.println(s.toString());
	}

	private static void print(ArrayList<Character> letters) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < letters.size(); i++)
			s.append(letters.get(i) + "|");
		System.out.println(s.toString());
	}
}
