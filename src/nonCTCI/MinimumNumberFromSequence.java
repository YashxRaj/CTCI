package nonCTCI;

import java.util.Scanner;
import java.util.Stack;

public class MinimumNumberFromSequence {
	// M - Descending ; N - Ascending
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(generateHill(s.nextLine().trim()));
		s.close();
	}

	private static String generateHill(String input) {
		StringBuilder s = new StringBuilder();
		Stack<Integer> stk = new Stack<Integer>();
		for (int i = 0; i <= input.length(); i++) {
			stk.push(i + 1);
			if (i == input.length() || input.charAt(i) == 'N')
				while (!stk.empty())
					s.append(stk.pop());
		}
		return s.toString();
	}
}