package bitManipulation;

import java.util.Scanner;

public class bM {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// insertion(s);
		binaryToString(s);
	}

	private static void binaryToString(Scanner s) {
		
	}

	private static void insertion(Scanner s) {
		System.out.print("Number to insert into: ");
		int n = Integer.parseInt("10000000000", 2); //Integer.parseInt(s.next(), 2);
		System.out.print("Number to insert: ");
		int m = Integer.parseInt("10011", 2); //Integer.parseInt(s.next(), 2);
		System.out.print("Enter the starting point: ");
		int j = 6; //s.nextInt();
		System.out.print("Enter the ending point: ");
		int i = 2; //s.nextInt();
		System.out.println("Insertion: " + Integer.toBinaryString((n & ((~0 << (j + 1)) | ((1 << i) - 1))) | (m << i)));
	}
}