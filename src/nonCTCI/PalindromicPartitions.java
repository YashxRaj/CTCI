package nonCTCI;

import java.util.Scanner;

public class PalindromicPartitions {
	// http://www.geeksforgeeks.org/given-a-string-print-all-possible-palindromic-partition/
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter String: ");
		String str = s.nextLine();
		System.out.println("Palindromes: ");
		palindromePartitions(str);
	}

	private static void palindromePartitions(String str) {
		char[] c = str.toCharArray();
		printAllChars(c);
		for (int i = 1; i < c.length - 1; i++) {
			if (c[i - 1] == c[i + 1]) {
				int j = 1;
				while (i + j < c.length && c[i + j] == c[i - j])
					j++;
				printPalindrome(c, i, j);
			} else if (c[i - 1] == c[i])
				printMirror(c, i);
		}
	}

	private static void printAllChars(char[] c) {
		for (char x : c)
			System.out.print(x + " ");
		System.out.println();
	}

	private static void printMirror(char[] c, int i) {
		StringBuilder s = new StringBuilder();
		s.append(c[i - 1]);
		s.append(c[i]);
		s.append(" ");
		System.out.println(s.toString());
	}

	private static void printPalindrome(char[] c, int i, int j) {
		StringBuilder s = new StringBuilder();
		String str = c[i] + "";
		for (int k = 1; k < j; k++) {
			s.append(c[i - k]);
			s.append(str);
			s.append(c[i + k]);
			str = s.toString();
			System.out.println(str);
			s.delete(0, s.length());
		}
	}
}