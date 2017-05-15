package ctci;

import java.util.Scanner;

public class test3 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] line1 = s.nextLine().trim().split(" ");
		int towns = Integer.parseInt(line1[0]), roads =Integer.parseInt(line1[1]);
		
		s.close();
	}

}
