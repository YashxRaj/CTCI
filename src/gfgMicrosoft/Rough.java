package gfgMicrosoft;

//Java program to remove duplicates, the order of
//characters is not maintained in this program

import java.util.Arrays;

public class Rough {
	/* Method to remove duplicates in a sorted array */
	static String removeDupsSorted(String s) {
		int r = 1, p = 1;
		char a[] = s.toCharArray();

		/* In place removal of duplicate characters */
		while (p != a.length) {
			if (a[p] != a[p - 1]) {
				a[r] = a[p];
				r++;
			}
			p++;
		}
		s = new String(a);
		return s.substring(0, r);
	}

	/*
	 * Method removes duplicate characters from the string This function work
	 * in-place and fills null characters in the extra space left
	 */
	static String removeDups(String str) {
		char temp[] = str.toCharArray();
		Arrays.sort(temp);
		str = new String(temp);

		// Remove duplicates from sorted
		return removeDupsSorted(str);
	}

	// Driver Method
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		System.out.println(removeDups(str));
	}
}