package nonCTCI;

import java.util.Scanner;

public class LongestSequenceMatrix {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = s.nextInt(), ul = (int) Math.pow(n, 2), ll = 1;
		System.out.println("Enter the integers ranging from " + ll + " to " + ul + " in any order.");
		int[][] m = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				System.out.print("[" + i + "," + j + "]" + ":");
				m[i][j] = validateEntry(i, j, ll, ul, s, m);
			}
		s.close();
		longestPathMatrix(m);
	}

	private static int validateEntry(int i, int j, int ll, int ul, Scanner s, int[][] m) {
		int temp = entryInRange(i, j, ll, ul, s, m);
		if (uniqueEntry(temp, m, i, j))
			return temp;
		else
			validateEntry(i, j, ll, ul, s, m);
		return temp;
	}

	private static int entryInRange(int i, int j, int ll, int ul, Scanner s, int[][] m) {
		int temp = s.nextInt();
		while (temp < ll || temp > ul) {
			System.out.print("Invalid entry for [" + i + "," + j + "]. ");
			System.out.println("Please enter unique values from " + ll + " to " + ul + " only.");
			System.out.print("[" + i + "," + j + "]" + ":");
			temp = s.nextInt();
		}
		return temp;
	}

	private static boolean uniqueEntry(int temp, int[][] m, int i_ul, int j_ul) {
		for (int i = 0; i <= i_ul; i++)
			for (int j = 0; j <= j_ul; j++)
				if (m[i][j] == temp)
					return false;
		return true;
	}

	private static void longestPathMatrix(int[][] m) {
		int n = m.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int temp = m[i][j] + 1;
				if (j + 1 < n && m[i][j + 1] == temp) {

				} else if (j >= 1 && m[i][j - 1] == temp) {

				} else if (i + 1 < n && m[i + 1][j] == temp) {

				} else if (i >= 1 && m[i - 1][j] == temp) {

				} else {

				}
			}
		}
		return;
	}

}
