package testOne;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = Integer.parseInt(sc.nextLine().trim());
		int[][] res = new int[tc][2];
		for (int i = 0; i < tc; i++) {
			ArrayList<Integer> details = stringsToNumbers(sc.nextLine().trim().split(" "));
			res[i] = subArrayWithGivenSum(details.get(1), stringsToNumbers(sc.nextLine().trim().split(" ")));
		}
		sc.close();
		print(res);
	}

	private static void print(int[][] res) {
		for (int i = 0; i < res.length; i++)
			System.out.println(res[i][0] + " " + res[i][1]);
	}

	private static int[] subArrayWithGivenSum(Integer sum, ArrayList<Integer> numbers) {
		int[] r = new int[2];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < numbers.size(); i++) {
			if (sum(q) == sum)
				System.out.println("FOUND!");
			else if (sum(q) < sum)
				q.add(numbers.get(i));
			else if (sum(q) > sum)
				q.remove();
		}
		return r;
	}

	private static Integer sum(Queue<Integer> q) {
		int sum = 0;
		for (Integer x : q)
			sum += x;
		return sum;
	}

	private static ArrayList<Integer> stringsToNumbers(String[] strings) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (String m : strings)
			numbers.add(Integer.parseInt(m));
		return numbers;
	}
}
