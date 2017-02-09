package ctci;

public class test {

	public static void main(String[] args) {
		int n[] = { 0, 1, 2, 2, 3, 4, 3, 4, 5, 6, 7, 8, 9, 10, 1 };
		int k = 4;
		// distinctK(n, k);
	}

	private static void print(int[] frame) {
		for (int x : frame)
			System.out.println(x);
	}

	private static void distinctK(int[] n, int k) {
		int div = n.length / k;
		for (int i = 0; i < div; i++) {
			int[] x = new int[k];
			for (int j = 0; j < k; j++)
				x[j] = n[(i * k) + j];
			eachK(x, k);
		}
	}

	private static void eachK(int[] x, int k) {
		boolean flag = false;
		for (int i = 0; i < x.length; i++) {
			for (int j = 1; j < x.length; j++)
				if (x[j] == x[i]) {
					flag = true;
					break;
				}
			if (flag == true) {
				flag = false;
			}
		}
		print(x);
	}
}
