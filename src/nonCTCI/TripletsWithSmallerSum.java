package nonCTCI;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class TripletsWithSmallerSum {
	// http://www.geeksforgeeks.org/count-triplets-with-sum-smaller-that-a-given-value/
	public static void main(String[] args) {
		System.out.println("Array size: 10. Enter Elements: ");
		int[] data = new int[10];
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < 10; i++)
			data[i] = s.nextInt();
		System.out.print("Enter sum: ");
		int sum = s.nextInt();
		Arrays.sort(data);
		Vector<Vector<Integer>> triplets = generateTriplets(data, sum);
		printTriplets(triplets);
	}

	private static void printTriplets(Vector<Vector<Integer>> triplets) {

	}

	/*
	 * 1) Sort the input array in increasing order.
	 * 2) Initialize result as 0.
	 * 3) Run a loop from i = 0 to n-2. An iteration of this loop finds all
	 * triplets with arr[i] as first element.
	 * a) Initialize other two elements as corner elements of subarray
	 * arr[i+1..n-1], i.e., j = i+1 and k = n-1
	 * b) Move j and k toward each other until they meet, i.e., while (j < k)
	 * (i) if (arr[i] + arr[j] + arr[k] >= sum), then do k--
	 * 
	 * Else for current i and j, there can (k-j) possible third elements that
	 * satisfy the constraint.
	 * (ii) Else Do ans += (k - j) followed by j++
	 */
	private static Vector<Vector<Integer>> generateTriplets(int[] data, int sum) {
		Vector<Vector<Integer>> triplets = new Vector<Vector<Integer>>();
		Vector<Integer> triplet = new Vector<Integer>();
		for (int i = 0; i < data.length - 2; i++) {
			int s = sum;
			s -= data[i];
			if (s > 0) {

			}
		}
		return triplets;
	}

}
