package nonCTCI;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

public class OptimalStrategyGame {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		HashSet<Integer> denomenations = getDenomenations(s);
		System.out.println(print(denomenations));
		Deque<Integer> coinPouch = fillCoins(denomenations, s);
		System.out.println(peekInto(coinPouch));
		
		s.close();
	}

	private static String peekInto(Deque<Integer> coinStack) {
		StringBuilder s = new StringBuilder();
		s.append("Coins in pouch:" + System.lineSeparator() + "|");
		for (Integer coin : coinStack)
			s.append(coin + "|");
		s.append(System.lineSeparator());
		return s.toString();
	}

	private static Deque<Integer> fillCoins(HashSet<Integer> denomenations, Scanner s) {
		System.out.print("Enter coins: ");
		Deque<Integer> coinPouch = new ArrayDeque<Integer>();
		String maybeCoin = s.nextLine();
		while (maybeCoin.matches("\\d+")) {
			if (isDenomenation(denomenations, Integer.parseInt(maybeCoin))) {
				coinPouch.add(Integer.parseInt(maybeCoin));
				System.out.print("Coin Added. Next Coin: ");
			} else
				System.out.print("Coins must be valid denomenation. Re-enter: ");
			maybeCoin = s.nextLine();
		}
		System.out.println("Coin pouch filled.");
		return coinPouch;
	}

	private static HashSet<Integer> getDenomenations(Scanner s) {
		System.out.println("Enter the denomenations of the coins:");
		HashSet<Integer> denomenations = new HashSet<Integer>();
		String coin = s.nextLine();
		while (coin.matches("\\d+")) {
			denomenations.add(Integer.parseInt(coin));
			coin = s.nextLine();
		}
		return denomenations;
	}

	private static String print(HashSet<Integer> denomenations) {
		StringBuilder s = new StringBuilder();
		s.append("Entered Denomenations:" + System.lineSeparator() + "|");
		for (Integer x : denomenations)
			s.append(x + "|");
		s.append(System.lineSeparator());
		return s.toString();
	}

	private static boolean isDenomenation(HashSet<Integer> denomenations, Integer coin) {
		for (Integer coinType : denomenations)
			if (coin.equals(coinType))
				return true;
		return false;
	}

}
