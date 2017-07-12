package ctci;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		String[] str = s.nextLine().split(" ");
		int r = Integer.parseInt(s.nextLine());
		s.close();

		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(str[i]);

		int[][] count = nCr(a, n, r);
	}

	private static int[][] nCr(int[] a, int n, int r) {
		int[][] ncr = new int[combinationsCount(n, r)][r];
		return generateNcR(ncr,n,r);
	}

	private static int[][] generateNcR(int[][] ncr, int n, int r) {
		
		return null;
	}

	private static int combinationsCount(int n, int r) {
		return factorial(n) / (factorial(r) * factorial(n - r));
	}

	private static int factorial(int n) {
		return n == 1 || n==0 ? 1 : n * factorial(n - 1);
	}

}
