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
		for (char x : c)
			System.out.print(x + " ");
		System.out.println(); // Printing all characters.
		for (int i = 1; i < c.length - 1; i++) {
			StringBuilder s = new StringBuilder();
			if (c[i] == c[i - 1]) {
			} else if (false) {
				// write code to check for i-1 with i+1
			} else {
				int j = 1;
				while (i + j < c.length && c[i + j] == c[i - j])
					j++;
				print(c, i, j);
			}
		}
	}

	private static void print(char[] c, int i, int j) {
		StringBuilder s = new StringBuilder();
		String str = c[i] + "";
		for (int k = 1; k < j; k++) {
			s.append(c[i - j]);
			s.append(str);
			s.append(c[i + j]);
		}
	}
}
