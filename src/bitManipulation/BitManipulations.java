package bitManipulation;

import java.util.Scanner;

public class BitManipulations {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// insertion(s);
		// binaryToString(s);
		// flipBitToWin((int) (Math.random() * 3000));
	}

	private static void flipBitToWin(int theInt) {
		System.out.println("The Int   : " + theInt);
		String binary = Integer.toBinaryString(theInt);
		System.out.println("In Binary : " + binary);
		int longer = 0, longest = 0;
		for (int i = 0; i < binary.length(); i++) {
			longer = getBit(theInt, i) == 0 ? 0 : longer + 1;
			if (longer > longest)
				longest = longer;
		}
		System.out.println("Longest sequence of 1's: " + longest);
	}

	private static void binaryToString(Scanner s) {
		double random = generateRandom((int) (Math.random() * 50));
		System.out.print("Random Number: " + random + " - " + convertDecimalToBinary(random));
	}

	private static double generateRandom(int count) {
		double random = 0.0, temp = 0.5;
		for (int i = 0; i < count; i++) {
			if (chance())
				random += temp;
			temp /= 2;
		}
		return random;
	}

	private static boolean chance() {
		return (Math.random()) > 0.5 ? false : true;
	}

	private static String convertDecimalToBinary(double random) {
		if (random > 1 || random <= 0)
			return "ERROR";
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (random > 0) {
			if (binary.length() >= 32)
				return "ERROR";
			double r = random * 2;
			binary.append(r < 1 ? 0 : 1);
			random = r < 1 ? r : r - 1;
		}
		return binary.toString();
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