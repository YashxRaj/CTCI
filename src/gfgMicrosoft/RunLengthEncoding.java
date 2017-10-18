package gfgMicrosoft;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class RunLengthEncoding {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine().trim();
		runLengthEncoding(str);
		s.close();
	}

	private static void runLengthEncoding(String str) {
		HashMap<Character, Integer> hm = new HashMap<>();
		Vector<Character> vc = new Vector<Character>();
		char[] t = str.toCharArray();
		for (char x : t) {
			boolean tr = hm.containsKey(x);
			if (!tr)
				vc.add(x);
			hm.put(x, tr ? hm.get(x) + 1 : 1);
		}
		for (char x : vc)
			System.out.print(x+""+hm.get(x));
	}
}
