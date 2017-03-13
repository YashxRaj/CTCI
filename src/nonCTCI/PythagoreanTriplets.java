package nonCTCI;

import java.util.Arrays;

public class PythagoreanTriplets {
	// http://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/
	public static void main(String[] args) {
		// Driver code
		int a[] = { 3, 1, 4, 6, 5 };
		findPythagoreanTriplets(a);
	}

	private static void findPythagoreanTriplets(int[] a) {
		int b[] = a.clone();
		for (int i = 0; i < a.length; i++)
			b[i] = b[i] * b[i];
		Arrays.sort(b);
		for (int x : b)
			System.out.print(x + " ");
		System.out.println();
		for (int i = 0; i < b.length - 2; i++)
			for (int j = i + 1, k = j + 1; i < b.length - 1 && k < b.length;) {
				if (b[i] + b[j] == b[k]) {
					System.out.println(a[i] + " , " + a[j] + " , " + a[k]);
					break;
				} else if (b[i] + b[j] < b[k])
					j++;
				else
					k++;
			}
	}

}
