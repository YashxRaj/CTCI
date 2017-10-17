package microsoft;

// Given an array, find the element that appears only once.
// Time: O(n). Space: O(1)
// Hashing meets time, but not space.

public class SingleOccurringElement {

	public static void main(String args[]) {
		int[] arr = { 12, 1, 12, 3, 12, 1, 1, 2, 3, 3 };
		int once = getSingleOccurringElement(arr);
		System.out.println(once);
	}

	private static int getSingleOccurringElement(int[] arr) {
		int ones = 0, twos = 0;
		int common_bit_mask;

		for (int i = 0; i < arr.length; i++) {
			twos = twos | (ones & arr[i]);
			ones = ones ^ arr[i];
			common_bit_mask = ~(ones & twos);
			ones &= common_bit_mask;
			twos &= common_bit_mask;
		}
		return ones;
	}
}
