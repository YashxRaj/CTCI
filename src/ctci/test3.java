package ctci;

import java.util.Scanner;
import java.util.Vector;

public class test3 {
	static String solve(int year) {
		String date = null;
		int[] days = null;
		if (year >= 1700 && year < 1918) {
			days = fillDays(year, 1);
		} else if (year == 1918) {
			days = fillDays(year, 2);
		} else if (year > 1918 && year <= 2700) {
			days = fillDays(year, 3);
		}
		return date;
	}

	private static int[] fillDays(int year, int j) {
		Vector<Integer> d31 = new Vector<Integer>();
		Vector<Integer> d30 = new Vector<Integer>();
		d31.add(1);
		d31.add(3);
		d31.add(5);
		d31.add(7);
		d31.add(8);
		d31.add(10);
		d31.add(12);
		d30.add(4);
		d30.add(6);
		d30.add(9);
		d30.add(11);
		int[] days = new int[12];
		if (j == 1)
			for (int i = 0; i < 12; i++)
				days[i] = (i == 2) ? (year % 4 == 0) ? 29 : 28 : d30.contains(i) ? d30.get(i) : d31.get(i);
		else if (j == 2)
			for (int i = 0; i < 12; i++)
				days[i] = (i == 2) ? 28 : d30.contains(i) ? d30.get(i) : d31.get(i);
		else if (j == 3)
			for (int i = 0; i < 12; i++)
				days[i] = (i == 2) ? (year % 4 == 0 && year % 100 != 0 && year % 400 == 0) ? 29 : 28
						: d30.contains(i) ? d30.get(i) : d31.get(i);
		return days;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int year = Integer.parseInt(in.nextLine().trim());
		in.close();
		System.out.println(solve(year));
	}
}