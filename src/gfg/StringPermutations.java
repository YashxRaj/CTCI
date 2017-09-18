package gfg;

import java.util.HashSet;
import java.util.Scanner;

public class StringPermutations {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the String: ");
		String str = s.nextLine().trim();
		s.close();
		System.out.println("Permutations:");
		HashSet<String> set = new HashSet<String>();
		permutations("", str, set);
		for (String s1 : set)
			System.out.println(s1);
	}

	private static void permutations(String prefix, String str, HashSet<String> set) {
		int n = str.length();
		if (n == 0)
			set.add(prefix);
		else
			for (int i = 0; i < n; i++)
				permutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
	}
}
