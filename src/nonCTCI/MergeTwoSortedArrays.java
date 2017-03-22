package nonCTCI;

import java.util.Arrays;

import linkedLists.LL;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		int[] a = randomSortedArray();
		int[] b = randomSortedArray();
		treesAndGraphs.TaG.printArray(a);
		treesAndGraphs.TaG.printArray(b);
		treesAndGraphs.TaG.printArray(mergeTwoArrays(a, b));
	}

	public static int[] mergeTwoArrays(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		for (int i = 0, j = 0, k = 0; i < c.length; i++)
			c[i] = j < a.length && k < b.length ? a[j] <= b[k] ? a[j++] : b[k++] : j >= a.length ? b[k++] : a[j++];
		return c;
	}

	public static int[] randomSortedArray() {
		int x[] = new int[LL.randomLength()];
		for (int i = 0; i < x.length; i++)
			x[i] = ((int) (Math.random() * 100));
		Arrays.sort(x);
		return x;
	}

}
