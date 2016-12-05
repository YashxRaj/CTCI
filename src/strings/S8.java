package strings;

import java.util.Scanner;

public class S8 {
//	private static void S8(Scanner s) {
//		System.out.print("Enter M: ");
//		int m = s.nextInt();
//		System.out.print("Enter N: ");
//		int n = s.nextInt();
//		int[][] a = new int[m][n];
//		System.out.println("Enter matrix:");
//		for (int i = 0; i < m; i++)
//			for (int j = 0; j < n; j++) {
//				System.out.print(i + "\t" + j+" : ");
//				a[i][j] = s.nextInt();
//			}
//		S8.ZeroMatrix(a, m, n);
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++)
//				System.out.print(a[i][j] + "\t");
//			System.out.println();
//		}
//	}

	public static void ZeroMatrix(int[][] a, int m, int n) {
		boolean[] z = new boolean[n];
		boolean flag = false;
		for (int i = 0, j; i < m; i++) {
			for (j = 0; j < n; j++)
				if (a[i][j] == 0) {
					z[j] = true;
					flag = true;
				}
			if (flag == true) {
				flag = false;
				for (int k = 0; k < n; k++)
					a[i][k] = 0;
			}
		}
		for (int j = 0; j < n; j++)
			if (z[j] == true)
				for (int i = 0; i < m; i++)
					a[i][j] = 0;
	}
}
