package gfgMicrosoft;

import java.util.Scanner;

public class PrintLastTenLines {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		s.close();
		printLastTenLines(str);
	}

	// Reverse a string - inplace?
	public static String printLastTenLines(String str) {
		StringBuilder sb = new StringBuilder();
		int index = str.lastIndexOf("\n"), oldIndex = str.length();
		for (int i = 0; i < 10; i++) {
			System.out.println(str.substring(index));
			sb.append(str.substring(index, oldIndex));
			oldIndex = index;
			index = str.lastIndexOf("\n", index);
		}
		return sb.toString();
	}

}
