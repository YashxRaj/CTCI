package ctli;

import java.util.Scanner;
// input hours - get time remaining.
public class Time {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Days: ");
		int d = Integer.parseInt(s.nextLine().trim());
		System.out.println("Format: HH:MM,");
		s.close();
	}
}
