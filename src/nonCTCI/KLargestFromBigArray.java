package nonCTCI;

import java.util.Arrays;

public class KLargestFromBigArray {
	// http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
	public static void main(String[] args) {
		int a[] = generateRandomValuesForSize(1000);
		int[] top = findLargest(10, a);
		print(top);
	}

	private static void print(int[] top) {
		for (int i = 0; i < top.length; i++)
			System.out.print(top[i] + " ");
		System.out.println();
	}

	private static int[] findLargest(int k, int[] a) {
		int[] top = new int[10];
		for (int i = 0; i < top.length; i++)
			top[i] = a[i];
		Arrays.sort(top);
		for (int i = top.length; i < a.length; i++) {
			if (a[i] > top[top.length - 1]) {
				for (int j = top.length - 2; j >= 0; j--) {
					if (a[i] < top[j]) {
						top[j - 1] = a[i];
						break;
					} else if (a[i] > top[0]) {
						top[0] = a[i];
					}
				}
			}
		}
		return top;
	}

	private static int[] generateRandomValuesForSize(int size) {
		int[] a = new int[size];
		for (int i = 0; i < size; i++)
			a[i] = (int) (Math.random() * 1000);
		return a;
	}

}
