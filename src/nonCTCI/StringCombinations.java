package nonCTCI;

import java.util.HashSet;
import java.util.Scanner;

public class StringCombinations {
	public static void main(String[] args) {
		// Driver Code
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String str = s.nextLine();
		System.out.print("N: " + str.length() + "\nR: ");
		print(nCr(str.toCharArray(), str.toCharArray().length, s.nextInt()));
		s.close();
	}

	public static char[] hashSetToCharArray(HashSet<Character> set) {
		char[] c = new char[set.size()];
		
		return c;
	}

	public static HashSet<char[]> nCr(char[] baseSet, int n, int r) {
		return generate(baseSet, new char[r], 0, n - 1, 0, r, new HashSet<char[]>());
	}

	private static HashSet<char[]> generate(char[] a, char[] c, int strt, int end, int indx, int r,
			HashSet<char[]> set) {
		if (indx == r) {
			StringBuilder s = new StringBuilder();
			for (int j = 0; j < r; j++)
				s.append(c[j]);
			set.add(s.toString().toCharArray());
			return set;
		}
		for (int i = strt; i <= end && end - i + 1 >= r - indx; i++) {
			c[indx] = a[i];
			generate(a, c, i + 1, end, indx + 1, r, set);
		}
		return set;
	}

	public static void print(HashSet<char[]> set) {
		StringBuilder s = new StringBuilder();
		s.append("Size: " + set.size() + System.lineSeparator());
		for (char[] c : set)
			s.append(c.toString() + System.lineSeparator());
		System.out.println(s.toString());
	}
}
/*
 * arr[] ---> Input Array
 * data[] ---> Temporary array to store current combination
 * start & end ---> Staring and Ending indexes in arr[]
 * index ---> Current index in data[]
 * r ---> Size of a combination to be printed
 * replace index with all possible elements. The condition
 * "end-i+1 >= r-index" makes sure that including one element
 * at index will make a combination with remaining elements
 * at remaining positions
 */
