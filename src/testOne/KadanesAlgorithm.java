package testOne;

import java.util.ArrayList;
import java.util.Scanner;

public class KadanesAlgorithm {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int testCaseNum = Integer.parseInt(s.nextLine());
		ArrayList<ArrayList<Integer>> testCases = new ArrayList<ArrayList<Integer>>();
		int n = 0;
		while (testCaseNum > 0) {
			n = Integer.parseInt(s.nextLine().trim());
			String[] array = s.nextLine().trim().split(" ");
			ArrayList<Integer> a = new ArrayList<Integer>();
			for (int j = 0; j < n; j++)
				a.add(Integer.parseInt(array[j]));
			testCases.add(a);
			testCaseNum--;
		}
		s.close();
		print(allMaxConsecutiveSum(testCases));
	}

	private static void print(ArrayList<Integer> results) {
		for (Integer r : results)
			System.out.println(r);
	}

	private static ArrayList<Integer> allMaxConsecutiveSum(ArrayList<ArrayList<Integer>> testCases) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		for (ArrayList<Integer> testCase : testCases)
			results.add(maxConsecutiveSum(testCase));
		return results;
	}

	private static Integer maxConsecutiveSum(ArrayList<Integer> testCase) {
		int maxCurrent = testCase.get(0), maxGlobal = testCase.get(0);
		for (int i = 1; i < testCase.size(); i++) {
			maxCurrent = Math.max(testCase.get(i) + maxCurrent, testCase.get(i));
			maxGlobal = Math.max(maxCurrent, maxGlobal);
		}
		return maxGlobal;
	}
}