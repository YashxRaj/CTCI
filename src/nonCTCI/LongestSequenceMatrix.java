package nonCTCI;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

public class LongestSequenceMatrix {

	public static void main(String[] args) {
		System.out.println(longestPathMatrix(init()));
	}

	private static int[][] init() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = s.nextInt(), ul = (int) Math.pow(n, 2), ll = 1;
		System.out.println("Enter the integers ranging from " + ll + " to " + ul + " in any order.");
		int[][] m = new int[n][n];
		HashSet<Integer> unique = new HashSet<Integer>();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				System.out.print("[" + i + "," + j + "]" + ":");
				m[i][j] = validateEntry(i, j, ll, ul, s, m, unique);
			}
		s.close();
		return m;
	}

	private static int validateEntry(int i, int j, int ll, int ul, Scanner s, int[][] m, HashSet<Integer> unique) {
		int temp = entryInRange(i, j, ll, ul, s, m);
		if (!unique.contains(temp)) {
			unique.add(temp);
			return temp;
		} else {
			System.out.println(temp + " has already been entered. Enter unique values only.");
			System.out.print("[" + i + "," + j + "]" + ":");
			validateEntry(i, j, ll, ul, s, m, unique);
		}
		return 0;
	}

	private static int entryInRange(int i, int j, int ll, int ul, Scanner s, int[][] m) {
		int temp = s.nextInt();
		while (temp < ll || temp > ul) {
			System.out.print("Invalid entry for [" + i + "," + j + "]. ");
			System.out.println("Please enter unique values from " + ll + " to " + ul + " only.");
			System.out.print("[" + i + "," + j + "]" + ":");
			temp = s.nextInt();
		}
		return temp;
	}

	private static String print(Vector<Integer> path, HashMap<Integer, Integer> neighbor) {
		StringBuilder sb = new StringBuilder();
		sb.append("Longest Path:" + System.lineSeparator());
		sb.append(path.get(0));
		for (int i = 0; i < path.size(); i++)
			if (neighbor.get(path.get(i)) != null)
				sb.append(" -> " + neighbor.get(path.get(i)));
		sb.append(System.lineSeparator() + "The size of the longest path: " + path.size());
		return sb.toString();
	}

	private static Vector<Integer> longestPath(Vector<Vector<Integer>> paths) {
		Vector<Integer> maxPath = null;
		for (Vector<Integer> path : paths)
			maxPath = (path.size() > (maxPath == null ? 0 : maxPath.size())) ? path : maxPath;
		return maxPath;
	}

	private static void findPaths(int[][] m, int i, int j, HashMap<Integer, Integer> neighbor) {
		neighbor.put(m[i][j], null);
		if (j + 1 < m.length && m[i][j] + 1 == m[i][j + 1])
			neighbor.put(m[i][j], m[i][j + 1]);
		else if (j >= 1 && m[i][j] + 1 == m[i][j - 1])
			neighbor.put(m[i][j], m[i][j - 1]);
		else if (i + 1 < m.length && m[i][j] + 1 == m[i + 1][j])
			neighbor.put(m[i][j], m[i + 1][j]);
		else if (i >= 1 && m[i][j] + 1 == m[i - 1][j])
			neighbor.put(m[i][j], m[i - 1][j]);
	}

	public static String longestPathMatrix(int[][] m) {
		HashMap<Integer, Integer> neighbor = new HashMap<Integer, Integer>();
		Vector<Vector<Integer>> paths = new Vector<Vector<Integer>>();
		for (int i = 0; i < m.length; i++)
			for (int j = 0; j < m.length; j++)
				findPaths(m, i, j, neighbor);
		for (Integer n : neighbor.keySet())
			createPathsFor(n, paths, neighbor);
		return print(longestPath(paths), neighbor);
	}

	private static void createPathsFor(Integer n, Vector<Vector<Integer>> paths, HashMap<Integer, Integer> neighbor) {
		Vector<Integer> path = new Vector<Integer>();
		while (n != null) {
			if (!path.contains(n))
				path.add(n);
			if (neighbor.get(n) != null)
				path.add(neighbor.get(n));
			n = neighbor.get(n);
		}
		paths.add(path);
	}
}
