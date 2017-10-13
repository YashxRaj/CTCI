package gfgMicrosoft;

import java.util.Vector;

public class MinimumJumpsToReachArrayEnd {
	public static void main(String args[]) {
		int a[] = { 2, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		System.out.println(calculateMinJumps(a));
	}

	private static int calculateMinJumps(int[] a) {
		int i = 0, ctr = 0;
		while (i < a.length) {
			ctr++;
			System.out.println("i=" + i);
			i = maxJumps(a, i);
			if(i+a[i] >= a.length)
				return ctr;
		}
		return ctr;
	}

	private static int maxJumps(int[] a, int i) {
		int max = 0;
		for (int j = i + 1; j < i + 1 + a[i] && j < a.length; j++) {
			if (j + a[j] > a.length)
				return j;
			if (j + a[j] > max)
				max = j;
		}
		System.out.println("max=" + max);
		return max;
	}

}
