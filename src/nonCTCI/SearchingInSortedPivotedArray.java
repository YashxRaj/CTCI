package nonCTCI;

public class SearchingInSortedPivotedArray {

	public static void main(String[] args) {
		int[] a = { 3, 4, 5, 6, 7, 1, 2 };

	}

	public static boolean binarySearch(int key, int[] a) {
		int min = 0, max = a.length - 1;
		int mid = (min + max) / 2;
		for (int i = 0; i < Math.log(a.length) / Math.log(2); i++) {
			if (key == a[mid])
				return true;
			else if (key > a[mid])
				min = mid + 1;
			else if (key < a[mid])
				max = mid - 1;
		}
		return false;

	}
}
