package nonCTCI;

import java.io.BufferedReader;
import java.util.Scanner;

public class LongestSequenceMatrix {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = s.nextInt(), ul = (int) Math.pow(n, 2), ll = 1;
		System.out.println("Enter the integers ranging from " + ll + " to " + ul + " in any order here.");
		int[][] m = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				System.out.print("[" + i + "," + j + "]" + ":");
				m[i][j] = validateEntry(i, j, ll, ul, s);
			}
		s.close();
		longestPathMatrix(n, m);
	}

	private static int validateEntry(int i, int j, int ll, int ul, Scanner s) {
		int temp = s.nextInt();
		if (temp < ll || temp > ul)
			return temp;
		while (temp < ll || temp > ul) {
			System.out.println("Invalid entry for [" + i + "," + "j].");
			System.out.println("Please enter values from " + ll + "to " + ul + " only.");
			System.out.print("[" + i + "," + j + "]" + ":");
			temp = s.nextInt();
		}
		return temp;
	}

	private static void longestPathMatrix(int n, int[][] m) {
		return;
	}

}
