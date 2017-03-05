package nonCTCI;

public class zigZag {

	public static void main(String[] args) {
		int[] a = { 4, 3, 7, 8, 6, 2, 1 };
		convertZigZag(a);
	}

	private static void convertZigZag(int[] a) {
		boolean flag = true;
		for (int i = 0; i < a.length - 2; i++) {
			int temp;
			if (flag && (a[i] > a[i + 1])) {
				temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
			} else if (!flag && a[i] < a[i + 1]) {
				temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
			}
			flag = !flag;
		}
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
	}
}
