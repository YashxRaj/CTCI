package nonCTCI;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		// Driver Code
		int[] a = new int[15];
		for (int i = 0; i < a.length; i++)
			a[i] = (int) (Math.random() * a.length);

		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();

		Arrays.sort(a);

		int key = (int) (Math.random() * a.length);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();

		System.out.println(binarySearch(a[key], a) + " for key: " + key);
	}

	public static boolean binarySearch(int key, int[] a) {
		int min = 0, max = a.length - 1;
		return binarySearch(key, a, min, max);
		/*
		 * int mid = (min + max) / 2;
		 * for (int i = 0; i < Math.log(a.length) / Math.log(2); i++) {
		 * if (key == a[mid])
		 * return true;
		 * else if (key > a[mid])
		 * min = mid + 1;
		 * else if (key < a[mid])
		 * max = mid - 1;
		 * }
		 * return false;
		 */
	}

	private static boolean binarySearch(int key, int[] a, int min, int max) {
		return key == a[(int) (min + max / 2)] ? true
				: key < a[(min + max) / 2] ? binarySearch(key, a, min, ((min + max) / 2) - 1)
						: binarySearch(key, a, ((min + max) / 2) + 1, max);
	}
}
