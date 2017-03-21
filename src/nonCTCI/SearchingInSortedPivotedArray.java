package nonCTCI;

import java.util.Scanner;

public class SearchingInSortedPivotedArray {
	// http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
	public static void main(String[] args) {
		int[] a = { 3, 4, 5, 6, 7, 1, 2 };
		binarySearch(a);
	}

	private static void binarySearch(int[] a) {
		int i;
		for (i = 1; i < a.length; i++)
			if (a[i] < a[i - 1])
				break;
		int[] b = new int[i];
		int[] c = new int[a.length - i];
		for (int j = 0; j < i; j++)
			b[j] = a[j];
		for (int j = i, k = 0; j < a.length; j++, k++)
			c[k] = a[j];
		Scanner s = new Scanner(System.in);
		System.out.print("Enter key to search: ");
		int key = s.nextInt();
		System.out.println(BinarySearch.binarySearch(key, b) ? "Present in first array"
				: BinarySearch.binarySearch(key, c) ? "Present in second array" : "Not Present");
		s.close();
	}
}
