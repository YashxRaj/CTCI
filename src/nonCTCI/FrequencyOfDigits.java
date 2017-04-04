package nonCTCI;

import java.util.HashMap;
import java.util.Scanner;

public class FrequencyOfDigits {
	// http://www.geeksforgeeks.org/check-frequency-digit-less-digit/
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the integer: ");
		System.out.println(frequencyOfDigits(s.nextInt()));
		s.close();
	}

	public static boolean frequencyOfDigits(int n) {
		HashMap<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
		while (n != 0) {
			frequencies.put(n % 10, frequencies.containsKey(n % 10) ? frequencies.get(n % 10) + 1 : 1);
			n /= 10;
		}
		for (Integer i : frequencies.keySet())
			if (frequencies.get(i) > i)
				return false;
		return true;
	}
}
