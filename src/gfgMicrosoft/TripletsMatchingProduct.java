package gfgMicrosoft;

import java.util.HashMap;

public class TripletsMatchingProduct {

	public static void main(String[] args) {
		int[] a = { 1, 4, 6, 2, 3, 8 };
		int m = 24;
		System.out.println(triplets(a, m));
	}

	private static int triplets(int[] a, int m) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int l = 0, ctr = 0;
		for (int x : a)
			hm.put(x, l++);
		for (int i = 0; i < a.length - 1; i++)
			for (int j = i + 1; j < a.length; j++) {
				int t = a[i] * a[j];
				if (t != 0 && m % t == 0 && t <= m) {
					int k = m / t;
					if (k != a[i] && k != a[j] && hm.containsKey(k) && hm.get(k) > i && hm.get(k) > j)
						ctr++;
				}
			}
		return ctr;
	}
}
