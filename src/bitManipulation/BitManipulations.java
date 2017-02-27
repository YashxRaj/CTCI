package bitManipulation;

import java.util.Scanner;

public class BitManipulations {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// insertion(s);
		binaryToString(s);
	}

	private static void binaryToString(Scanner s) {
		System.out.println("Enter");
	}

	private static void insertion(Scanner s) {
		// System.out.print("Number to insert into: ");
		// int n = Integer.parseInt(s.next(), 2);
		// System.out.print("Number to insert: ");
		// int m = Integer.parseInt(s.next(), 2);
		// System.out.print("Enter the starting point: ");
		// int j = s.nextInt();
		// System.out.print("Enter the ending point: ");
		// int i = s.nextInt();
		int n = Integer.parseInt("10000000000", 2), m = Integer.parseInt("10011", 2), j = 6, i = 2;
		System.out.println("Insertion: " + Integer.toBinaryString((n & ((~0 << (j + 1)) | ((1 << i) - 1))) | (m << i)));
	}

	private static int getBit(int num, int i) {
		return ((num & (1 << i)) != 0) == false ? 0 : 1;
	}

	private static int setBit(int num, int i) {
		return num | (1 << i);
	}

	private static int clearBit(int num, int i) {
		return num & ~(1 << i);
	}

	private static int clearBitsMSBThroughI(int num, int i) {
		return num & ((1 << i) - 1);
	}

	private static int clearBitsIThrough0(int num, int i) {
		return num & (-1 << (i + 1));
	}

	private static int updateBit(int num, int i, boolean bitIs1) {
		return (num & ~(1 << i)) | ((bitIs1 ? 1 : 0) << i);
	}

}