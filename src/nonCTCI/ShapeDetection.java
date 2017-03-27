package nonCTCI;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class ShapeDetection {
	static double[][] lengths;
	static double[][] points;
	static HashMap<double[], Character> names;
	static HashMap<Character, double[]> revertNames;
	static HashMap<String, Double> mappedLengths;
	// Will require add points, remove points, update points functions.
	// Remove main.
	// Add constructor.

	public static void main(String[] args) {
		points = setNumberAndGetPoints();
		names = setNames();
		revertNames = setPoints();
		lengths = calculateLengths();
		printNames();
		printLengths();
		distanceBetween(revertNames.get('A'), revertNames.get('B'));
	}

	private static void distanceBetween(double[] x, double[] y) {

	}

	private static HashMap<Character, double[]> setPoints() {
		HashMap<Character, double[]> namedPoints = new HashMap<Character, double[]>();
		int x = 65;
		for (int i = 0; i < points.length; i++)
			namedPoints.put((char) x++, points[i]);
		return namedPoints;
	}

	private static void printNames() {
		StringBuffer s = new StringBuffer();
		s.append("Point - Name");
		s.append(System.lineSeparator());
		s.append(System.lineSeparator());
		for (int i = 0; i < points.length; i++) {
			s.append(points[i][0] + "," + points[i][1] + " - ");
			s.append(names.get(points[i]));
			s.append(System.lineSeparator());
		}
		System.out.println(s.toString());
	}

	private static HashMap<double[], Character> setNames() {
		HashMap<double[], Character> names = new HashMap<double[], Character>();
		int x = 65;
		for (int i = 0; i < points.length; i++)
			names.put(points[i], (char) x++);
		return names;
	}

	private static void printLengths() {
		StringBuffer s = new StringBuffer();
		DecimalFormat df = new DecimalFormat("0.00");
		s.append("Points and their lengths:");
		s.append(System.lineSeparator());
		s.append(System.lineSeparator());
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				if (i == j)
					continue;
				s.append(names.get(points[i]) + " : ");
				s.append(names.get(points[j]) + " - ");
				s.append(df.format(lengths[i][j]));
				s.append(System.lineSeparator());
			}
			s.append(System.lineSeparator());
		}
		System.out.println(s.toString());
	}

	private static double[][] calculateLengths() {
		double[][] lengths = new double[points.length][points.length];
		for (int i = 0; i < points.length; i++)
			for (int j = 0; j < points.length; j++) {
				if (i == j)
					continue;
				if (lengths[i][j] == 0.0) {
					lengths[i][j] = Math.sqrt(Math.pow(Math.abs(points[i][0] - points[j][0]), 2)
							+ Math.pow(Math.abs(points[i][1] - points[j][1]), 2));
					mappedLengths.put(names.get(points[i]) + "" + names.get(points[j]), lengths[i][j]);
					mappedLengths.put(names.get(points[j]) + "" + names.get(points[i]), lengths[i][j]);
				}
				lengths[j][i] = lengths[i][j];
			}
		return lengths;
	}

	private static double[][] setNumberAndGetPoints() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the number of points: ");
		int n = s.nextInt();
		double[][] points = new double[n][2];
		System.out.println("Enter the points:");
		s.nextLine();
		for (int i = 0; i < n; i++) {
			Scanner scan = new Scanner(s.nextLine());
			scan.useDelimiter(",");
			points[i][0] = scan.nextInt();
			points[i][1] = scan.nextInt();
			scan.close();
		}
		s.close();
		return points;
	}

}
