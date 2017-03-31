package nonCTCI;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ShapeDetector {

	public static void main(String[] args) {
		HashMap<Character, HashMap<Character, Double>> edges = edgeCalculations(getPoints());
		detectSquares(edges);
	}

	public static void detectSquares(HashMap<Character, HashMap<Character, Double>> edges) {
		for (Character x : edges.keySet()) {
			HashMap<Character, Double> xMap = edges.get(x);
			HashSet<Character> xKeys = new HashSet<Character>();
			for (Character y : xMap.keySet()) {
				xKeys.add(y);
				for (Character z : xMap.keySet())
					if (xMap.get(z).equals(xMap.get(y)) && !y.equals(z))
						xKeys.add(z);
				if (xKeys.size() >= 2) {
					
				}
			}
		}
		return;
	}

	private static HashMap<Character, HashMap<Character, Double>> edgeCalculations(
			HashMap<double[], Character> namedPoints) {
		HashMap<Character, HashMap<Character, Double>> edges = new HashMap<Character, HashMap<Character, Double>>();
		for (double[] x : namedPoints.keySet()) {
			HashMap<Character, Double> hm;
			Character pX = namedPoints.get(x);
			for (double[] y : namedPoints.keySet())
				if (!Arrays.equals(x, y)) {
					Character pY = namedPoints.get(y);
					hm = edges.containsKey(pX) ? edges.get(pX) : new HashMap<Character, Double>();
					hm.put(pY,
							edges.containsKey(pY)
									? edges.get(pY).containsKey(pX) ? edges.get(pY).get(pX) : calcLength(x, y)
									: calcLength(x, y));
					edges.put(pX, hm);
				}
		}
		print(displayE(edges));
		return edges;
	}

	private static Double calcLength(double[] x, double[] y) {
		return Math.sqrt(Math.pow(Math.abs(x[0] - y[0]), 2) + Math.pow(Math.abs(x[1] - y[1]), 2));
	}

	public static HashMap<double[], Character> getPoints() {
		HashMap<double[], Character> namedPoints = new HashMap<double[], Character>();
		int x = 65;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the points:");
		s.nextLine();
		while (true) {
			String str = s.nextLine();
			if (str.equals(""))
				break;
			else {
				Scanner scan = new Scanner(str);
				scan.useDelimiter(",");
				double[] point = new double[2];
				point[0] = scan.nextInt();
				point[1] = scan.nextInt();
				namedPoints.put(point, (char) x++);
				scan.close();
			}
		}
		s.close();
		print(displayP(namedPoints));
		return namedPoints;
	}

	public static String displayP(HashMap<double[], Character> namedPoints) {
		StringBuffer sb = new StringBuffer();
		DecimalFormat df = new DecimalFormat("#.##");
		sb.append("Point - Name");
		sb.append(System.lineSeparator());
		for (double[] coordinate : namedPoints.keySet()) {
			sb.append("[" + df.format(coordinate[0]) + "," + df.format(coordinate[1]) + "]" + " - ");
			sb.append(namedPoints.get(coordinate) + System.lineSeparator());
		}
		return sb.toString();
	}

	public static String displayE(HashMap<Character, HashMap<Character, Double>> edges) {
		StringBuffer sb = new StringBuffer();
		DecimalFormat df = new DecimalFormat("0.00");
		sb.append("Pt - Length" + System.lineSeparator());
		for (Character p1 : edges.keySet())
			for (Character p2 : edges.get(p1).keySet())
				sb.append(p1 + "" + p2 + " - " + df.format(edges.get(p1).get(p2)) + System.lineSeparator());
		return sb.toString();
	}

	private static void print(String p) {
		System.out.println(p);
	}

}
