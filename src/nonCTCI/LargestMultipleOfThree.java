package nonCTCI;

import java.util.Arrays;
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
		System.out.println(largest3digits(digits));
	}

	public static String largest3digits(int[] digits) {
		Arrays.sort(digits);
		for (int i = 0, j = i + 1, k = i + 2; i < digits.length - 2; i++) {
			int one = digits[i], two = digits[j], three = digits[k];
			if (divisibleBy3(one, two, three))
				return makeString(one, two, three);
			else {
				int l = k;
				while (l < digits.length) {
					three = digits[l++];
					if (divisibleBy3(one, two, three))
						return makeString(one, two, three);
					
				}

			}
		}
		return null;
	}

	private static int getNextNumber(int[] digits, int l) {
		if (l < digits.length)
			return l;
		else
			return -1;
	}

	private static String makeString(int one, int two, int three) {
		return new String(one + "" + two + "" + three);
	}

	private static boolean divisibleBy3(int one, int two, int three) {
		return (one + two + three) % 3 == 0;
	}

}
