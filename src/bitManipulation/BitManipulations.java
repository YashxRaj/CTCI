package bitManipulation;

import java.util.Scanner;

public class BitManipulations {
	/*
	 * long startTime = System.nanoTime();
	 * // functionToMeasure();
	 * long endTime = System.nanoTime();
	 * long durationInNano = (endTime - startTime);
	 * double durationInMicro = durationInNano / 1000;
	 * System.out.println("Duration: " + durationInMicro);
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// insertion(s);
		// binaryToString(s);
		// flipBitToWin((int) (Math.random() * 3000)); - incomplete
		nextNumber((int) (Math.random() * 3000));
	}

	private static void nextNumber(int num) {
		String binary = Integer.toBinaryString(num);
		int nextSmallest = nextSmallest(num, binary.length());
		int nextLargest = nextLargest(num, binary.length());
		System.out.println("The number   : " + num + " - " + binary);
		System.out.println("Next smallest: " + nextSmallest + " - " + Integer.toBinaryString(nextSmallest));
		System.out.println("Next largest : " + nextLargest + " - " + Integer.toBinaryString(nextLargest));
	}

	private static int nextLargest(int num, int length) {
		int n = clearBit(num, findFirst1(num, length));
		n = setBit(n, findFirst0(num, length));
		return n;
	}

	private static int nextSmallest(int num, int length) {
		int n = setBit(num, findFirst0(num, length));
		n = clearBit(n, findFirst1(num, length));
		return n;
	}

	private static int findFirst1(int num, int length) {
		for (int i = 0; i < length; i++)
			if (getBit(num, i))
				return i;
		return length;
	}

	private static int findFirst0(int num, int length) {
		for (int i = 0; i < length; i++)
			if (!getBit(num, i))
				return i;
		return length;
	}

	private static void flipBitToWin(int n) {
		System.out.println("The Int   : " + n);
		String binary = Integer.toBinaryString(n);
		System.out.println("In Binary : " + binary);
		System.out.println("Longest: ");
		/*
		 * This code will give you the longest set of 1's in the binary.
		 * int longer = 0, longest = 0;
		 * for (int i = 0; i < binary.length(); i++) {
		 * longer = getBit(theInt, i) == 0 ? 0 : longer + 1;
		 * if (longer > longest)
		 * longest = longer;
		 * }
		 * System.out.println("Longest sequence of 1's: " + longest);
		 */
		/*
		 * private static ArrayList<Integer> getAlternatingSequences(int n) {
		 * ArrayList<Integer> sequences = new ArrayList<Integer>();
		 * int searchingFor = 0, counter = 0;
		 * for (int i = 0; i < Integer.toBinaryString(n).length(); i++) {
		 * if ((n & 1) != searchingFor) {
		 * sequences.add(counter);
		 * searchingFor = n & 1;
		 * counter = 0;
		 * }
		 * counter++;
		 * n >>>= 1;
		 * }
		 * sequences.add(counter);
		 * return sequences;
		 * }
		 * 
		 * private static int findLongestSequence(ArrayList<Integer> seq) {
		 * int seqMax = 1;
		 * for (int i = 0; i < seq.size(); i++) {
		 * int seq0 = seq.get(i), seqThis = 0;
		 * int seq1R = (i - 1) >= 0 ? seq.get(i - 1) : 0, seq1L = (i + 1) <
		 * seq.size() ? seq.get(i + 1) : 0;
		 * if (seq0 == 1)
		 * seqThis = seq1L + 1 + seq1R;
		 * if (seq0 > 1)
		 * seqThis = 1 + Math.max(seq1R, seq1L);
		 * else if (seq0 == 0)
		 * seqThis = Math.max(seq1R, seq1L);
		 * seqMax = Math.max(seqThis, seqMax);
		 * }
		 * return seqMax;
		 * }
		 */
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

	private static boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);
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