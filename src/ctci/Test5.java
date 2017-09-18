package ctci;

public class Test5 {
	public static void main(String[] args) {
		int a[] = treesAndGraphs.TaG.makeArray(8);
		treesAndGraphs.TaG.printArray(a);
		maxMinWindows(a);
	}

	public static void maxMinWindows(int[] a) {
		int windowSize = 1;
		int[] windows = new int[a.length];
		while (windowSize <= a.length) {
			for (int i = 0, k = 0; i < a.length; i++) {
				int[] elements = fillElements(a, i, windowSize);
				windows[k++] = min(elements);
			}
			System.out.println("Window Size: " + windowSize);
			System.out.println(maxOfMin(windows));
			windowSize++;
		}
	}

	private static int maxOfMin(int[] windows) {
		int max = 0;
		for (int i = 0; i < windows.length; i++)
			if (windows[i] > max)
				max = windows[i];
		return max;
	}

	private static int min(int[] elements) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < elements.length; i++)
			if (elements[i] < min)
				min = elements[i];
		return min;
	}

	private static int[] fillElements(int[] a, int i, int windowSize) {
		int[] elements = new int[windowSize];
			for (int j = 0; i < a.length && j < windowSize; j++) {
				elements[j] = a[i++];
			}
		return elements;
	}
}