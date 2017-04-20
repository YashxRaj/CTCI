package nonCTCI;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.regex.Pattern;

public class OptimalStrategyGame {
	// http://www.geeksforgeeks.org/dynamic-programming-set-31-optimal-strategy-for-a-game/
	// Determine the maximum amount of money AI can win if it moves first.
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		HashSet<Integer> denomenations = getDenomenations(s);
		System.out.println(print(denomenations));
		Deque<Integer> coinPouch = fillCoins(denomenations, s);
		s.close();
		if (coinPouch.size() % 2 != 0) {
			System.out.println(peekInto(coinPouch));
			System.out.println(optimalPath(coinPouch));
		}
	}

	/*
	 * F(i, j) = Max(Vi + min(F(i+2, j), F(i+1, j-1) ), Vj + min(F(i+1, j-1),
	 * F(i, j-2) ))
	 * Base Cases: F(i, j) = Vi If j == i , max(Vi, Vj) If j == i+1
	 */
	private static String optimalPath(Deque<Integer> coinPouch) {
		ArrayList<String> paths = new ArrayList<String>();
		paths.add("");
		for (int j = 0; j < Math.pow(2, coinPouch.size() / 2); j++) {
			int pSize = paths.size();
			for (int i = 0; i < pSize; i++) {
				String temp = paths.get(i);
				paths.add(temp + "," + coinPouch.removeLast());
				paths.add(temp + "," + coinPouch.removeFirst());
			}
		}
		printStrings(paths);
		return null;
	}

	private static void printStrings(ArrayList<String> paths) {
		StringBuilder s = new StringBuilder();
		for (String path : paths)
			s.append(path + System.lineSeparator());
		System.out.println(s.toString());
	}

	private static String peekInto(Deque<Integer> coinPouch) {
		StringBuilder s = new StringBuilder();
		s.append("Coins in pouch:" + System.lineSeparator() + "|");
		for (Integer coin : coinPouch)
			s.append(coin + "|");
		s.append(System.lineSeparator());
		return s.toString();
	}

	private static Deque<Integer> fillCoins(HashSet<Integer> denomenations, Scanner s) {
		System.out.print("Note: Enter even number of coins. Enter coins: ");
		Deque<Integer> coinPouch = new ArrayDeque<Integer>();
		String maybeCoin = s.nextLine();
		Pattern pattern = Pattern.compile("\\d+");
		while (pattern.matcher(maybeCoin).matches()) {
			if (denomenations.contains(Integer.parseInt(maybeCoin))) {
				coinPouch.add(Integer.parseInt(maybeCoin));
				System.out.print("Coin Added. Next Coin: ");
			} else
				System.out.print("Coins must be valid denomenation. Re-enter: ");
			maybeCoin = s.nextLine();
		}
		return coinPouch;
	}

	private static HashSet<Integer> getDenomenations(Scanner s) {
		System.out.println("Enter the denomenations of the coins:");
		HashSet<Integer> denomenations = new HashSet<Integer>();
		Pattern pattern = Pattern.compile("\\d+");
		String maybeCoin = s.nextLine();
		while (pattern.matcher(maybeCoin).matches()) {
			denomenations.add(Integer.parseInt(maybeCoin));
			maybeCoin = s.nextLine();
		}
		return denomenations;
	}

	private static String print(HashSet<Integer> denomenations) {
		StringBuilder s = new StringBuilder();
		s.append("Entered Denomenations:" + System.lineSeparator() + "|");
		for (Integer x : denomenations)
			s.append(x + "|");
		return s.toString();
	}

}
