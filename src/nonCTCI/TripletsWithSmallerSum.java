package nonCTCI;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class TripletsWithSmallerSum {
	// http://www.geeksforgeeks.org/count-triplets-with-sum-smaller-that-a-given-value/
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of elements: ");
		int n = s.nextInt();
		System.out.println("Array size: " + n + ". Enter Elements: ");
		int[] data = new int[n];
		for (int i = 0; i < n; i++)
			data[i] = s.nextInt();
		System.out.print("Enter sum: ");
		int sum = s.nextInt();
		s.close();
		System.out.println("Simple Solution: " + tripletsCountSimple(data, sum));
		System.out.println("Efficient Solution: " + tripletsCountEfficient(data, sum));
	}

	private static int tripletsCountSimple(int[] data, int sum) {
		int count = 0;
		for (int i = 0; i < data.length - 2; i++)
			for (int j = i + 1; j < data.length - 1; j++)
				for (int k = j + 1; k < data.length; k++)
					if (data[i] + data[j] + data[k] < sum)
						count++;
		return count;
	}

	private static int tripletsCountEfficient(int[] data, int sum) {
		int count = 0;
		Arrays.sort(data);
		for (int i = 0; i < data.length - 2; i++)
			for (int j = i + 1, k = data.length - 1; j < k;) {
				if (data[i] + data[j] + data[k] >= sum)
					k--;
				else {
					count += (k - j);
					j++;
				}
			}
		return count;
	}
}