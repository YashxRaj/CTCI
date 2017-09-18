package nonCTCI;

import java.util.Arrays;

public class AjAiGreaterThanJI {

	public static void main(String[] args) {
		int[] a = treesAndGraphs.TaG.makeArray(5);
		treesAndGraphs.TaG.printArray(a);
		System.out.println(maxFind(a));
	}

	public static int maxFind(int[] a) {
		int[] res = new int[a.length * a.length];
		for (int i = 0, k = 0; i < a.length; i++)
			for (int j = a.length - 1; j > 0; j--)
				if (a[j] > a[i])
					res[k++] = j - i;
		Arrays.sort(res);
		return res[res.length - 1];
	}
}
