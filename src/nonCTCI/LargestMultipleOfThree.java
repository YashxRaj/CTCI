package nonCTCI;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LargestMultipleOfThree {
	// http://www.geeksforgeeks.org/find-largest-multiple-3-array-digits-set-2-time-o1-space/
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter digits to store:\nExample: 4,5,3,7");
		String[] sDigits = s.nextLine().split(",");
		int[] digits = new int[sDigits.length];
		int i = 0;
		for (String d : sDigits)
			digits[i++] = Integer.parseInt(d);
		s.close();
		largest3digits(digits);
	}

	// Requires sorting the array.
	public static void largest3digits(int[] digits) {
		int l = digits.length;
		int[] set = new int[3];
		boolean flag = false;
		Arrays.sort(digits);
		// Reverse Sort.
		for (int i = 0; i < l / 2; i++) {
			int temp = digits[i];
			digits[i] = digits[l - i - 1];
			digits[l - i - 1] = temp;
		}
		for (int i = 0; i < l - 2; i++) {
			set[0] = digits[i];
			for (int j = i + 1; j < l; j++) {
				set[1] = digits[j];
				for (int k = j + 1; k < l; k++) {
					set[2] = digits[k];
					if (flag)
						break;
					if (divBy3(set))
						flag = true;
				}
				if (flag)
					break;
			}
			if (flag)
				break;
		}
		System.out.println(set[0] + "" + set[1] + "" + set[2]);
	}

	private static boolean divBy3(int[] set) {
		return (set[0] + set[1] + set[2]) % 3 == 0;
	}

}
