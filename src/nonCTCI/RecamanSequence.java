package nonCTCI;

import java.util.Scanner;
import java.util.Vector;

public class RecamanSequence {
	// http://www.geeksforgeeks.org/recamans-sequence/
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter n: ");
		Vector<Integer> rs = recamanSequence(s.nextInt());
		printVector(rs);
		s.close();
	}

	public static void printVector(Vector<Integer> rs) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < rs.size(); i++)
			s.append(rs.get(i) + " ");
		System.out.println(s.toString());
	}

	public static Vector<Integer> recamanSequence(int n) {
		Vector<Integer> rs = new Vector<Integer>();
		rs.add(0);
		for (int i = 1; i < n; i++)
			rs.add(rs.get(i - 1) - i >= 0 && !rs.contains(rs.get(i - 1) - i) ? rs.get(i - 1) - i : rs.get(i - 1) + i);
		return rs;
	}
}
/*
 * a(0) = 0,
 * if n > 0 and the number is not
 * already included in the sequence,
 * a(n) = a(n - 1) - n
 * else
 * a(n) = a(n-1) + n.
 */