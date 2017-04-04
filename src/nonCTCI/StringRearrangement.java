package nonCTCI;

import java.util.Scanner;

public class StringRearrangement {
	// http://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the string to rearrange: ");
		System.out.println(rearrange(s.nextLine()));
		s.close();
	}

	public static String rearrange(String str) {
		char[] c = str.toCharArray();
		for (int i = 1, k = i; i < c.length; i++)
			if (c[i] == c[i - 1]) {
				while (k < c.length && c[k] == c[i])
					k++;
				if (k >= c.length)
					return "Not Possible";
				char temp = c[i];
				c[i] = c[k];
				c[k] = temp;
			}
		return new String(c);
	}

}
