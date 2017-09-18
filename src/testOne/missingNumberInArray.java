package testOne;

import java.util.ArrayList;
import java.util.Scanner;

public class missingNumberInArray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tc = Integer.parseInt(s.nextLine().trim()), n;
		ArrayList<Integer> results = new ArrayList<Integer>();
		for (int i = 0; i < tc; i++) {
			n = Integer.parseInt(s.nextLine().trim()); // Unnecessary.
			results.add(findMissingNumber(stringsToNumbers(s.nextLine().trim().split(" "))));
		}
		s.close();
		for (Integer r : results)
			System.out.println(r);
	}

	private static int findMissingNumber(ArrayList<Integer> numbers) {
		int i = 1;
		for (Integer x : numbers) {
			if (x != i)
				return i;
			i++;
		}
		return i;
	}

	private static ArrayList<Integer> stringsToNumbers(String[] strings) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (String m : strings)
			numbers.add(Integer.parseInt(m));
		return numbers;
	}

}
