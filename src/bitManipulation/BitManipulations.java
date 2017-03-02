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
		// flipBitToWin((int) (Math.random() * 3000)); - motherfucker.
		// nextNumber((int) (Math.random() * 3000));
		// (n&(n-1)==0) - Checks if n is a power of 2 or 0.
		// conversion((int) (Math.random() * 3000), (int) (Math.random() * 3000));
	}

	private static void conversion(int a, int b) {
		int ctr = 0;
		padAndPrint(a, b);
		for (int c = a ^ b; c != 0; c = c & (c - 1))
			ctr++;
		System.out.println("Number of bits needed to change a to b: " + ctr);
	}

	private static void padAndPrint(int a, int b) {
		String strA = Integer.toBinaryString(a), strB = Integer.toBinaryString(b);
		int l = strA.length() - strB.length();
		if (l != 0) {
			char zero = '0';
			StringBuilder s = new StringBuilder();
			for (int i = 0; i < Math.abs(l); i++)
				s.append(zero);
			if (l < 0)
				strA = s.toString() + strA;
			else
				strB = s.toString() + strB;
		}
		print(strA, strB,a,b);
	}

	private static void print(String strA, String strB, int a, int b) {
		System.out.print(strA + " - ");
		System.out.println(a);
		System.out.print(strB + " - ");
		System.out.println(b);
	}

	private static void nextNumber(int num) {
		int nextSmallest = 0, nextLargest = 0;
		for (int i = 0, j = 0; i < Integer.toBinaryString(num).length(); i++)
			if (getBit(num, i)) {
				nextLargest += (int) Math.pow(2, Integer.toBinaryString(num).length() - j);
				nextSmallest += (int) Math.pow(2, j++);
			}
		System.out.println("The number   : " + num + " - " + Integer.toBinaryString(num));
		System.out.println("Next largest : " + nextLargest + " - " + Integer.toBinaryString(nextLargest));
		System.out.println("Next smallest: " + nextSmallest + " - " + Integer.toBinaryString(nextSmallest));
	}

	private static void flipBitToWin(int n) {
		String binary = Integer.toBinaryString(n);
		System.out.println("The Int   : " + n);
		System.out.println("In Binary : " + binary);
		System.out.println("Longest: ");
		int[] seq = new int[binary.length()];

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
		/*
		 * System.out.print("Number to insert into: ");
		 * int n = Integer.parseInt(s.next(), 2);
		 * System.out.print("Number to insert: ");
		 * int m = Integer.parseInt(s.next(), 2);
		 * System.out.print("Enter the starting point: ");
		 * int j = s.nextInt();
		 * System.out.print("Enter the ending point: ");
		 * int i = s.nextInt();
		 */
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
/*
 * for (int i = 0, length = 0; i < binary.length(); i++)
 * seq[i] = (length = getBit(n, i) ? length + 1 : 0);
 * treesAndGraphs.TaG.printArray(seq);
 * for (int i = 0; i < binary.length(); i++)
 * if (seq[i] != 0) {
 * int k = i;
 * while (i < binary.length() && seq[i] != 0)
 * i++;
 * for (int j = k; j < i - 1; j++)
 * seq[j] = seq[i - 1];
 * }
 * // 333?
 * int max = 0;
 * for (int i = 0; i < binary.length() - 2; i++)
 * if (seq[i] != 0)
 * max = (seq[i + 2] != 0) && (seq[i] + seq[i + 2] + 1 > max) ? (seq[i]
 * + seq[i + 2] + 1) : max;
 * System.out.println(max);
 */
