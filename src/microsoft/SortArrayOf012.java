package microsoft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SortArrayOf012 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] str = s.nextLine().trim().split(" ");
		s.close();
		int[] unsorted = new int[str.length];
		for (int i = 0; i < unsorted.length; i++)
			unsorted[i] = Integer.parseInt(str[i]);
		Arrays.sort(unsorted);
		for (int i = 0; i < unsorted.length; i++)
			System.out.print(unsorted[i] + " ");
	}
}
