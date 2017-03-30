package nonCTCI;

import java.util.HashSet;
import java.util.Scanner;

public class StringCombinationsGenerator {
	public static void main(String[] args) {
		// Driver Code
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String str = s.nextLine();
		System.out.print("N: " + str.length() + "\nR: ");
		generateStrings(str.toCharArray(), str.toCharArray().length, s.nextInt());
		s.close();
	}

	public static void generateStrings(char[] baseSet, int n, int r) {
		print(combinationUtil(baseSet, new char[r], 0, n - 1, 0, r, new HashSet<String>()));
	}

	private static HashSet<String> combinationUtil(char[] a, char[] c, int strt, int end, int indx, int r,
			HashSet<String> set) {
		if (indx == r) {
			StringBuilder s = new StringBuilder();
			for (int j = 0; j < r; j++)
				s.append(c[j]);
			set.add(s.toString());
			return set;
		}
		for (int i = strt; i <= end && end - i + 1 >= r - indx; i++) {
			c[indx] = a[i];
			combinationUtil(a, c, i + 1, end, indx + 1, r, set);
		}
		return set;
	}

	public static void print(HashSet<String> set) {
		StringBuilder s = new StringBuilder();
		s.append("Size: " + set.size() + System.lineSeparator());
		for (String c : set)
			s.append(c + System.lineSeparator());
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
