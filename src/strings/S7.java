package strings;

public class S7 {
	// not even in 3 hours...
	public static boolean Rotate(int[][] m, int n) {
		if (n == 0 || n != m[0].length)
			return false;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer, last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first,top = m[first][i];
				m[first][i] = m[last-offset][first];
				m[last-offset][first] = m[last][last-offset];
				m[last][last-offset] = m[i][last];
				m[i][last] = top;
			}
		}
		return true;
	}
}