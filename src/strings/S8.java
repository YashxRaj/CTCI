package strings;

public class S8 {
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
