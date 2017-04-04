package nonCTCI;

import java.util.Scanner;
import java.util.Vector;

public class SubStringsCount {
	// http://www.geeksforgeeks.org/count-substrings-with-same-first-and-last-characters/
	public static void main(String[] args) {
		// Driver Code
		Scanner s = new Scanner(System.in);
		System.out.print("Enter string: ");
		String str = s.nextLine();
		s.close();
		System.out.println(print(substringsGeneration(str), countSubstrings(str)));
	}

	private static int countSubstrings(String str) {
		char[] ch = str.toCharArray();
		int count = 0;
		for (int i = 0; i < str.length(); i++)
			for (int j = i; j < str.length(); j++)
				if (ch[i] == ch[j])
					count++;
		return count;
	}

	private static String print(Vector<String> list, int count) {
		StringBuilder s = new StringBuilder();
		s.append("Number of substrings: " + count + System.lineSeparator());
		for (String x : list)
			s.append(x + System.lineSeparator());
		return s.toString();
	}

	public static Vector<String> substringsGeneration(String str) {
		Vector<String> list = new Vector<String>();
		char[] ch = str.toCharArray();
		StringBuilder s;
		for (char x : ch)
			list.add(Character.toString(x));
		for (int i = 0; i < ch.length - 1; i++) {
			s = new StringBuilder();
			s.append(ch[i]);
			for (int j = i + 1; j < ch.length; j++) {
				s.append(ch[j]);
				if (i != j && ch[i] == ch[j])
					list.add(s.toString());
			}
		}
		return list;
	}
}
