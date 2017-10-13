package gfgMicrosoft;

import java.util.Scanner;

public class NumberOfCarries {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(countNumberOfCarries(s.nextInt(),s.nextInt()));
		s.close();
	}

	private static int countNumberOfCarries(int a, int b) {
		int ctr = 0, r = 0;
		while (a != 0 && b != 0) {
			r = (a % 10 + b % 10 + r) > 9 ? 1 : 0;
			ctr = r == 1 ? ctr + 1 : ctr;
			a /= 10;
			b /= 10;
		}
		return ctr;
	}

}
